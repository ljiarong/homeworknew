package cn.edu.xmu.oomall.alipay.service;

import static cn.edu.xmu.privilegegateway.annotation.util.Common.cloneVo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.xmu.oomall.alipay.dao.PaymentDao;
import cn.edu.xmu.oomall.alipay.dao.RefundDao;
import cn.edu.xmu.oomall.alipay.mapper.AlipayPaymentPoMapper;
import cn.edu.xmu.oomall.alipay.mapper.RoyaltyRelationMapper;
import cn.edu.xmu.oomall.alipay.mapper.RoyaltySettleMapper;
import cn.edu.xmu.oomall.alipay.microservice.PaymentFeightService;
import cn.edu.xmu.oomall.alipay.model.bo.NotifyBody;
import cn.edu.xmu.oomall.alipay.model.bo.Payment;
import cn.edu.xmu.oomall.alipay.model.bo.Refund;
import cn.edu.xmu.oomall.alipay.model.po.AlipayPaymentPo;
import cn.edu.xmu.oomall.alipay.model.po.AlipayRefundPo;
import cn.edu.xmu.oomall.alipay.model.vo.CloseRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.CloseVo;
import cn.edu.xmu.oomall.alipay.model.vo.DownloadUrlQueryRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.PayQueryRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.PayQueryVo;
import cn.edu.xmu.oomall.alipay.model.vo.PayRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.PayVo;
import cn.edu.xmu.oomall.alipay.model.vo.RefundQueryRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.RefundQueryVo;
import cn.edu.xmu.oomall.alipay.model.vo.RefundRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.RefundVo;
import cn.edu.xmu.oomall.alipay.model.vo.RoyaltyRelationQueryRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.RoyaltyRelationRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.RoyaltyRelationSettleRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.RoyaltyRelationUnBindRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.RoyaltyRelationVo;
import cn.edu.xmu.oomall.alipay.model.vo.RoyaltySettleQueryDetailRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.RoyaltySettleQueryRetVo;
import cn.edu.xmu.oomall.alipay.model.vo.RoyaltySettleVo;
import cn.edu.xmu.oomall.alipay.util.AlipayReturnNo;
import cn.edu.xmu.oomall.alipay.util.GetJsonInstance;

/**
 * @author xucangbai
 * @date 2021/11/20
 */
@Service
public class AlipayService {

	private Logger logger = LoggerFactory.getLogger(AlipayService.class);

	@Resource
	PaymentFeightService paymentFeightService;

	@Value("${oomall.alipay.downloadurl}")
	private String bill_download_url;

	@Autowired
	private PaymentDao paymentDao;

	@Autowired
	private RefundDao refundDao;

	@Autowired
	private RoyaltyRelationMapper relationMapper;

	@Autowired
	private AlipayPaymentPoMapper paymentMapper;

	@Autowired
	private RoyaltySettleMapper settleMapper;

	@Autowired
	private RocketMQTemplate rocketMQTemplate;

	private void paySuccess(Payment payment) {
		payment.setSendPayDate(LocalDateTime.now());
		payment.setTradeStatus(Payment.TradeStatus.TRADE_SUCCESS);
		// ?????????????????????????????????????????????????????????????????????
		paymentDao.insertPayment(payment);
	}

	private void payFailed(Payment payment) {
		payment.setTradeStatus(Payment.TradeStatus.WAIT_BUYER_PAY);
		// ?????????????????????????????????????????????????????????????????????
		paymentDao.insertPayment(payment);
	}

	@Transactional(rollbackFor = Exception.class)
	public PayRetVo pay(String biz_content) {
		PayVo payVo = (PayVo) GetJsonInstance.getInstance(biz_content, PayVo.class);
		Payment payment = cloneVo(payVo, Payment.class);
		Payment existingPayment = paymentDao.selectPaymentByOutTradeNo(payment.getOutTradeNo());
		// ????????????????????????????????????????????????
		if (existingPayment != null) {
			// ???????????????
			// ??????????????????
			if (existingPayment.getTradeStatus().equals(Payment.TradeStatus.TRADE_CLOSED)) {
				return new PayRetVo(AlipayReturnNo.TRADE_HAS_CLOSE);
			}
			// ????????????????????????????????????????????????(???????????????????????????????????????Payment)?????????????????????????????????????????????????????????
			else if (existingPayment.getTradeStatus().equals(Payment.TradeStatus.TRADE_SUCCESS)
					|| existingPayment.getTradeStatus().equals(Payment.TradeStatus.WAIT_BUYER_PAY)) {
				return new PayRetVo(AlipayReturnNo.TRADE_HAS_SUCCESS);
			}
		}
		Random r = new Random();
		// ??????????????????4?????????
		Integer integer = r.nextInt(4);
		switch (integer) {
		// ??????????????????
		case 0:
			// ????????????????????????
			payment.setBuyerPayAmount(payment.getTotalAmount().subtract(new BigDecimal(r.nextInt(2))));
			paySuccess(payment);
			NotifyBody notifyBody1 = new NotifyBody(LocalDateTime.now(), payment.getOutTradeNo(), "TRADE_SUCCESS",
					null);
			notifyBody1.setBuyer_pay_amount(payment.getBuyerPayAmount());
			notifyBody1.setTotal_amount(payment.getTotalAmount());
			notifyBody1.setGmt_payment(LocalDateTime.now());
			rocketMQTemplate.sendOneWay("alipay-notify-topic", MessageBuilder.withPayload(notifyBody1).build());
			break;
		// ?????????????????????
		case 1:
			// ????????????????????????
			payment.setBuyerPayAmount(payment.getTotalAmount().subtract(new BigDecimal(r.nextInt(2))));
			paySuccess(payment);
			break;
		// ??????????????????
		case 2:
			payFailed(payment);
			NotifyBody notifyBody2 = new NotifyBody(LocalDateTime.now(), payment.getOutTradeNo(), "WAIT_BUYER_PAY",
					null);
//                paymentFeightService.notify(notifyBody2);
			rocketMQTemplate.sendOneWay("alipay-notify-topic", MessageBuilder.withPayload(notifyBody2).build());
			break;
		// ?????????????????????
		case 3:
			payFailed(payment);
			break;
		default:
			break;
		}
		PayRetVo payRetVo = cloneVo(payment, PayRetVo.class);
		payRetVo.setDefault();
		return payRetVo;
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public PayQueryRetVo payQuery(String biz_content) {
		PayQueryVo payQueryVo = (PayQueryVo) GetJsonInstance.getInstance(biz_content, PayQueryVo.class);
		Payment payment = paymentDao.selectPaymentByOutTradeNo(payQueryVo.getOutTradeNo());
		// ??????????????????????????????
		if (payment != null) {
			PayQueryRetVo payQueryRetVo = cloneVo(payment, PayQueryRetVo.class);
			payQueryRetVo.setTradeStatus(payment.getTradeStatus().getDescription());
			payQueryRetVo.setDefault();
			return payQueryRetVo;
		} else {
			// ??????????????????
			return new PayQueryRetVo(AlipayReturnNo.TRADE_NOT_EXIST);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public CloseRetVo close(String biz_content) {
		CloseVo closeVo = (CloseVo) GetJsonInstance.getInstance(biz_content, CloseVo.class);
		// ?????????????????????????????????
		Payment payment = paymentDao.selectPaymentByOutTradeNo(closeVo.getOutTradeNo());
		if (payment == null) {
			return new CloseRetVo(AlipayReturnNo.TRADE_NOT_EXIST);
		} else {
			if (!payment.getTradeStatus().equals(Payment.TradeStatus.WAIT_BUYER_PAY)) {
				// ????????????????????????????????????
				return new CloseRetVo(AlipayReturnNo.REASON_TRADE_STATUS_INVALID);
			}
			// ??????????????????,?????????
			else {
				payment.setTradeStatus(Payment.TradeStatus.TRADE_CLOSED);
				// ??????
				paymentDao.updatePayment(payment);

				CloseRetVo closeRetVo = cloneVo(closeVo, CloseRetVo.class);
				closeRetVo.setDefault();
				return closeRetVo;
			}
		}
	}

	private void refundSuccess(Refund refund) {
		refund.setGmtRefundPay(LocalDateTime.now());
		refund.setRefundStatus(Refund.RefundStatus.REFUND_SUCCESS);
		// ?????????????????????????????????????????????????????????????????????
		refundDao.insertRefund(refund);
	}

	private void refundFailed(Refund refund) {
		refund.setGmtRefundPay(null);
		// ?????????????????????????????????????????????????????????????????????
		refundDao.insertRefund(refund);
	}

	@Transactional(rollbackFor = Exception.class)
	public RefundRetVo refund(String biz_content) {
		RefundVo refundVo = (RefundVo) GetJsonInstance.getInstance(biz_content, RefundVo.class);
		Refund refund = cloneVo(refundVo, Refund.class);

		// ????????????????????????
		Payment payment = paymentDao.selectPaymentByOutTradeNo(refund.getOutTradeNo());
		if (payment == null) {
			return new RefundRetVo(AlipayReturnNo.TRADE_NOT_EXIST);
		}
		// ??????????????????
		refund.setTotalAmount(payment.getTotalAmount());

		// ???????????????????????????????????????,????????????
		BigDecimal totalRefund = new BigDecimal(0);
		List<AlipayRefundPo> alipayRefundPoList = refundDao.selectRefundByOutTradeNo(payment.getOutTradeNo());
		for (AlipayRefundPo alipayRefundPo : alipayRefundPoList) {
			totalRefund = totalRefund.add(alipayRefundPo.getRefundAmount());
		}
		// ?????????????????????
		totalRefund = totalRefund.add(refund.getRefundAmount());
		// ??????????????????
		if (totalRefund.compareTo(payment.getBuyerPayAmount()) > 0) {
			return new RefundRetVo(AlipayReturnNo.REFUND_AMT_NOT_EQUAL_TOTAL);
		}
		// ??????????????????????????????
		else if (payment.getTradeStatus().equals(Payment.TradeStatus.TRADE_SUCCESS)) {
			Random r = new Random();
			// ??????????????????2?????????
			Integer integer = r.nextInt(4);
			switch (integer) {
			// ???????????????
			case 0:
				refundSuccess(refund);
				break;
			// ????????????
			case 1:
				refundSuccess(refund);
				NotifyBody notifyBody1 = new NotifyBody(LocalDateTime.now(), payment.getOutTradeNo(), "TRADE_SUCCESS",
						refund.getOutRequestNo());
				notifyBody1.setBuyer_pay_amount(payment.getBuyerPayAmount());
				notifyBody1.setTotal_amount(payment.getTotalAmount());
				notifyBody1.setGmt_payment(payment.getSendPayDate());
				notifyBody1.setGmt_refund(LocalDateTime.now());
				notifyBody1.setRefund_fee(totalRefund);
				rocketMQTemplate.sendOneWay("alipay-notify-topic", MessageBuilder.withPayload(notifyBody1).build());
				break;
			// ????????????
			case 2:
				NotifyBody notifyBody2 = new NotifyBody(LocalDateTime.now(), payment.getOutTradeNo(), "TRADE_SUCCESS",
						refund.getOutRequestNo());
				notifyBody2.setBuyer_pay_amount(payment.getBuyerPayAmount());
				notifyBody2.setTotal_amount(payment.getTotalAmount());
				notifyBody2.setGmt_payment(payment.getSendPayDate());
				refundFailed(refund);
				rocketMQTemplate.sendOneWay("alipay-notify-topic", MessageBuilder.withPayload(notifyBody2).build());
				break;
			// ???????????????
			case 3:
				refundFailed(refund);
				break;
			default:
				break;
			}
			RefundRetVo refundRetVo = cloneVo(refund, RefundRetVo.class);
			// ?????????????????????????????????
			refundRetVo.setRefundFee(totalRefund);
			refundRetVo.setDefault();
			return refundRetVo;
		}
		// ?????????????????????????????????
		else {
			return new RefundRetVo(AlipayReturnNo.TRADE_NOT_ALLOW_REFUND);
		}
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public RefundQueryRetVo refundQuery(String biz_content) {
		RefundQueryVo refundQueryVo = (RefundQueryVo) GetJsonInstance.getInstance(biz_content, RefundQueryVo.class);
		Refund refund = refundDao.selectRefundByOutRequestNo(refundQueryVo.getOutRequestNo());
		// ??????????????????
		if (refund == null) {
			return new RefundQueryRetVo(AlipayReturnNo.TRADE_NOT_EXIST);
		}

		else {
			RefundQueryRetVo refundQueryRetVo = cloneVo(refund, RefundQueryRetVo.class);
			refundQueryRetVo.setRefundStatus(refund.getRefundStatus().getDescription());
			refundQueryRetVo.setDefault();
			return refundQueryRetVo;
		}
	}

	public DownloadUrlQueryRetVo downloadUrlQuery() {
		DownloadUrlQueryRetVo downloadUrlQueryRetVo = new DownloadUrlQueryRetVo(bill_download_url);
		return downloadUrlQueryRetVo;
	}

	public RoyaltyRelationRetVo royaltyRelationBind(String app_id, String biz_content) {
		JSONObject contentJo = JSONObject.parseObject(biz_content);
		String outRequestNo = contentJo.getString("out_request_no");
		JSONArray array = contentJo.getJSONArray("receiver_list");
		if (array.size() == 0) {
			return new RoyaltyRelationRetVo(AlipayReturnNo.RECEIVER_LIST_EMPTY);
		}
		for (int i = 0; i < array.size(); i++) {
			JSONObject jo = array.getJSONObject(i);
			RoyaltyRelationVo vo = (RoyaltyRelationVo) GetJsonInstance.getInstance(jo.toJSONString(),
					RoyaltyRelationVo.class);
			vo.setOutRequestNo(outRequestNo);
			vo.setAppId(app_id);
			relationMapper.bindRoyaltyRelation(vo);
		}
		return new RoyaltyRelationRetVo();
	}

	public RoyaltyRelationUnBindRetVo royaltyRelationUnBind(String app_id, String biz_content) {
		JSONObject contentJo = JSONObject.parseObject(biz_content);
		String outRequestNo = contentJo.getString("out_request_no");
		JSONArray array = contentJo.getJSONArray("receiver_list");
		if (array.size() == 0) {
			return new RoyaltyRelationUnBindRetVo(AlipayReturnNo.RECEIVER_LIST_EMPTY);
		}
		for (int i = 0; i < array.size(); i++) {
			JSONObject jo = array.getJSONObject(i);
			relationMapper.unbindRoyaltyRelation(app_id, jo.getString("type"), jo.getString("account"));
		}
		return new RoyaltyRelationUnBindRetVo();
	}

	public RoyaltyRelationQueryRetVo royaltyRelationQuery(String app_id, String biz_content) {
		JSONObject contentJo = JSONObject.parseObject(biz_content);
		int pageNum = contentJo.getInteger("page_num");
		int pageSize = contentJo.getInteger("page_size");
		int startnum = (pageNum - 1) * pageSize;
		int count = relationMapper.coutRoyaltyRelation(app_id);
		int allPage = (int) (count % pageSize == 0 ? count / pageSize : count / pageSize + 1);
		List<RoyaltyRelationVo> list = relationMapper.queryRoyaltyRelationQuery(app_id, startnum, pageSize);

		return new RoyaltyRelationQueryRetVo(list, allPage, count, pageNum, pageSize);
	}

	public RoyaltyRelationSettleRetVo settleOrder(String app_id, String biz_content) {
		JSONObject contentJo = JSONObject.parseObject(biz_content);
		String tradeNo = contentJo.getString("trade_no");
		// ???????????????????????????????????????
		AlipayPaymentPo payment = paymentMapper.queryPaymentByTradeNo(tradeNo);
		if (payment == null) {
			return new RoyaltyRelationSettleRetVo(AlipayReturnNo.TRADE_NOT_EXIST);
		}
		// ?????????????????????????????????????????????
		JSONArray array = contentJo.getJSONArray("royalty_parameters");
		BigDecimal amount = new BigDecimal(0);
		for (int i = 0; i < array.size(); i++) {
			amount = amount.add(array.getJSONObject(i).getBigDecimal("amount"));
			// ?????????????????????????????????
			String transOut = array.getJSONObject(i).getString("trans_out");
			String transOutType = array.getJSONObject(i).getString("trans_out_type");
			RoyaltyRelationVo rela = relationMapper.existRelation(app_id, transOutType, transOut);
			if (rela == null) {
				return new RoyaltyRelationSettleRetVo(AlipayReturnNo.ROYALTY_RECEIVER_INVALID);
			}
		}
		BigDecimal maxAmount = new BigDecimal(payment.getTotalAmount()).multiply(new BigDecimal(0.3));
		if (amount.compareTo(maxAmount) >= 0) {
			return new RoyaltyRelationSettleRetVo(AlipayReturnNo.ALLOC_AMOUNT_VALIDATE_ERROR);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		settleMapper.saveSettle(contentJo.getString("out_request_no"), contentJo.getString("trade_no"),
				contentJo.getJSONArray("royalty_parameters").toJSONString(), sdf.format(new Date()));
		return new RoyaltyRelationSettleRetVo(tradeNo, new Date().getTime() + "");
	}

	public RoyaltySettleQueryRetVo querySettle(String biz_content) {
		JSONObject contentJo = JSONObject.parseObject(biz_content);
		String trade_no = contentJo.getString("trade_no");
		String out_request_no = contentJo.getString("out_request_no");
		RoyaltySettleVo vo = settleMapper.querySettle(out_request_no, trade_no);
		if (vo == null) {
			return new RoyaltySettleQueryRetVo(AlipayReturnNo.TRADE_NOT_EXIST);
		}
		List<RoyaltySettleQueryDetailRetVo> royalty_detail_list = new ArrayList<RoyaltySettleQueryDetailRetVo>();
		JSONArray array = (JSONArray) JSONArray.parse(vo.getRoyalty());
		for (int i = 0; i < array.size(); i++) {
			JSONObject jo = array.getJSONObject(i);
			RoyaltySettleQueryDetailRetVo detail = new RoyaltySettleQueryDetailRetVo();
			detail.setOperation_type("transfer");
			detail.setExecute_dt(vo.getCapturetime());
			detail.setTrans_out(jo.getString("tans_out"));
			detail.setTrans_out_type(jo.getString("tans_out_type"));
			detail.setTrans_in(jo.getString("tans_in"));
			detail.setTrans_in_type(jo.getString("tans_in_type"));
			detail.setAmount(jo.getBigDecimal("amount"));
			detail.setState("SUCCESS");
			royalty_detail_list.add(detail);
		}
		return new RoyaltySettleQueryRetVo(out_request_no, vo.getCapturetime(), royalty_detail_list);
	}
}
