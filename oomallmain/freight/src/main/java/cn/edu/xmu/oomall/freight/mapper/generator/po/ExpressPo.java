package cn.edu.xmu.oomall.freight.mapper.generator.po;

import cn.edu.xmu.javaee.core.aop.CopyFrom;
import cn.edu.xmu.oomall.freight.dao.bo.Express;


import java.time.LocalDateTime;

@CopyFrom(Express.class)
public class ExpressPo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.bill_code
     *
     * @mbggenerated
     */
    private String billCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.shop_logistics_id
     *
     * @mbggenerated
     */
    private Long shopLogisticsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.sender_region_id
     *
     * @mbggenerated
     */
    private Long senderRegionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.sender_address
     *
     * @mbggenerated
     */
    private String senderAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.delivery_region_id
     *
     * @mbggenerated
     */
    private Long deliveryRegionId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.deliver_address
     *
     * @mbggenerated
     */
    private String deliverAddress;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.sender_name
     *
     * @mbggenerated
     */
    private String senderName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.sender_mobile
     *
     * @mbggenerated
     */
    private String senderMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.delivery_name
     *
     * @mbggenerated
     */
    private String deliveryName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.status
     *
     * @mbggenerated
     */
    private Byte status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.shop_id
     *
     * @mbggenerated
     */
    private Long shopId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.creator_id
     *
     * @mbggenerated
     */
    private Long creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.creator_name
     *
     * @mbggenerated
     */
    private String creatorName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.modifier_id
     *
     * @mbggenerated
     */
    private Long modifierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.modifier_name
     *
     * @mbggenerated
     */
    private String modifierName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.gmt_create
     *
     * @mbggenerated
     */
    private LocalDateTime gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_express.gmt_modified
     *
     * @mbggenerated
     */
    private LocalDateTime gmtModified;
    private String deliveryMobile;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.id
     *
     * @return the value of freight_express.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.id
     *
     * @param id the value for freight_express.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.bill_code
     *
     * @return the value of freight_express.bill_code
     *
     * @mbggenerated
     */
    public String getBillCode() {
        return billCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.bill_code
     *
     * @param billCode the value for freight_express.bill_code
     *
     * @mbggenerated
     */
    public void setBillCode(String billCode) {
        this.billCode = billCode == null ? null : billCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.shop_logistics_id
     *
     * @return the value of freight_express.shop_logistics_id
     *
     * @mbggenerated
     */
    public Long getShopLogisticsId() {
        return shopLogisticsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.shop_logistics_id
     *
     * @param shopLogisticsId the value for freight_express.shop_logistics_id
     *
     * @mbggenerated
     */
    public void setShopLogisticsId(Long shopLogisticsId) {
        this.shopLogisticsId = shopLogisticsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.sender_region_id
     *
     * @return the value of freight_express.sender_region_id
     * @mbggenerated
     */
    public Long getSenderRegionId() {
        return senderRegionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.sender_region_id
     *
     * @param senderRegionId the value for freight_express.sender_region_id
     *
     * @mbggenerated
     */
    public void setSenderRegionId(Long senderRegionId) {
        this.senderRegionId = senderRegionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.sender_address
     *
     * @return the value of freight_express.sender_address
     *
     * @mbggenerated
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.sender_address
     *
     * @param senderAddress the value for freight_express.sender_address
     *
     * @mbggenerated
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress == null ? null : senderAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.delivery_region_id
     *
     * @return the value of freight_express.delivery_region_id
     *
     * @mbggenerated
     */
    public Long getDeliveryRegionId() {
        return deliveryRegionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.delivery_region_id
     *
     * @param deliveryRegionId the value for freight_express.delivery_region_id
     *
     * @mbggenerated
     */
    public void setDeliveryRegionId(Long deliveryRegionId) {
        this.deliveryRegionId = deliveryRegionId;
    }
    public void setDeliveryMobile(String deliveryMobile) {
        this.deliveryMobile =deliveryMobile == null ? null : senderMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.deliver_address
     *
     * @return the value of freight_express.deliver_address
     *
     * @mbggenerated
     */
    public String getDeliverAddress() {
        return deliverAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.deliver_address
     *
     * @param deliverAddress the value for freight_express.deliver_address
     *
     * @mbggenerated
     */
    public void setDeliveryAddress(String deliverAddress) {
        this.deliverAddress = deliverAddress == null ? null : deliverAddress.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.sender_name
     *
     * @return the value of freight_express.sender_name
     *
     * @mbggenerated
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.sender_name
     *
     * @param senderName the value for freight_express.sender_name
     *
     * @mbggenerated
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.sender_mobile
     *
     * @return the value of freight_express.sender_mobile
     *
     * @mbggenerated
     */
    public String getSenderMobile() {
        return senderMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.sender_mobile
     *
     * @param senderMobile the value for freight_express.sender_mobile
     *
     * @mbggenerated
     */
    public void setSenderMobile(String senderMobile) {
        this.senderMobile = senderMobile == null ? null : senderMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.delivery_name
     *
     * @return the value of freight_express.delivery_name
     *
     * @mbggenerated
     */
    public String getDeliveryName() {
        return deliveryName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.delivery_name
     *
     * @param deliveryName the value for freight_express.delivery_name
     *
     * @mbggenerated
     */
    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName == null ? null : deliveryName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.status
     *
     * @return the value of freight_express.status
     *
     * @mbggenerated
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.status
     *
     * @param status the value for freight_express.status
     *
     * @mbggenerated
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.shop_id
     *
     * @return the value of freight_express.shop_id
     *
     * @mbggenerated
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.shop_id
     *
     * @param shopId the value for freight_express.shop_id
     *
     * @mbggenerated
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.creator_id
     *
     * @return the value of freight_express.creator_id
     *
     * @mbggenerated
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.creator_id
     *
     * @param creatorId the value for freight_express.creator_id
     *
     * @mbggenerated
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.creator_name
     *
     * @return the value of freight_express.creator_name
     *
     * @mbggenerated
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.creator_name
     *
     * @param creatorName the value for freight_express.creator_name
     *
     * @mbggenerated
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.modifier_id
     *
     * @return the value of freight_express.modifier_id
     *
     * @mbggenerated
     */
    public Long getModifierId() {
        return modifierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.modifier_id
     *
     * @param modifierId the value for freight_express.modifier_id
     *
     * @mbggenerated
     */
    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.modifier_name
     *
     * @return the value of freight_express.modifier_name
     *
     * @mbggenerated
     */
    public String getModifierName() {
        return modifierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.modifier_name
     *
     * @param modifierName the value for freight_express.modifier_name
     *
     * @mbggenerated
     */
    public void setModifierName(String modifierName) {
        this.modifierName = modifierName == null ? null : modifierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.gmt_create
     *
     * @return the value of freight_express.gmt_create
     *
     * @mbggenerated
     */
    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.gmt_create
     *
     * @param gmtCreate the value for freight_express.gmt_create
     *
     * @mbggenerated
     */
    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_express.gmt_modified
     *
     * @return the value of freight_express.gmt_modified
     *
     * @mbggenerated
     */
    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_express.gmt_modified
     *
     * @param gmtModified the value for freight_express.gmt_modified
     *
     * @mbggenerated
     */
    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }
}