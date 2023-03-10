package cn.edu.xmu.oomall.goods.service;

import cn.edu.xmu.javaee.core.exception.BusinessException;
import cn.edu.xmu.javaee.core.model.BloomFilter;
import cn.edu.xmu.javaee.core.model.Constants;
import cn.edu.xmu.javaee.core.model.ReturnNo;
import cn.edu.xmu.javaee.core.model.dto.PageDto;
import cn.edu.xmu.javaee.core.model.dto.UserDto;
import cn.edu.xmu.javaee.core.util.RedisUtil;
import cn.edu.xmu.oomall.goods.controller.vo.CreateCategoryVo;
import cn.edu.xmu.oomall.goods.controller.vo.ProductModVo;
import cn.edu.xmu.oomall.goods.controller.vo.UpdateCategoryVo;
import cn.edu.xmu.oomall.goods.dao.CategoryDao;
import cn.edu.xmu.oomall.goods.dao.ProductDao;
import cn.edu.xmu.oomall.goods.dao.ProductDraftDao;
import cn.edu.xmu.oomall.goods.dao.bo.*;
import cn.edu.xmu.oomall.goods.dao.bo.SimpleProductDto;
import cn.edu.xmu.oomall.goods.mapper.po.GoodsPo;
import cn.edu.xmu.oomall.goods.service.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static cn.edu.xmu.javaee.core.util.Common.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static cn.edu.xmu.javaee.core.util.Common.cloneObj;

@Service
@Transactional
public class ProductService {

    private static final  Logger logger = LoggerFactory.getLogger(ProductService.class);

    private static final Long NO_RELATE = 0L;

    private static final Long PUBLIC_PID = 0L;

    private CategoryDao categoryDao;

    private ProductDao productDao;

    private ProductDraftDao productDraftDao;

    private RedisUtil redisUtil;

    @Autowired
    public ProductService(ProductDao productDao, RedisUtil redisUtil, CategoryDao categoryDao, ProductDraftDao productDraftDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
        this.redisUtil = redisUtil;
        this.productDraftDao = productDraftDao;
    }

    /**
     * ????????????????????????????????????????????????
     *
     * @param id ??????id
     * @return ????????????
     */
    @Transactional
    public ProductDto findProductById(Long id) throws BusinessException {
        logger.debug("findProductById: id = {}", id);
        /*
        String key = BloomFilter.PRETECT_FILTERS.get("ProductId");
        if (redisUtil.bfExist(key, id)){
            throw new BusinessException(ReturnNo.RESOURCE_ID_NOTEXIST, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(),"??????", id));
        }
        */
        ProductDto dto = null;
        try {
            Product bo = productDao.findProductById(id);
            List<Product> other = bo.getOtherProduct();
            Shop shop = bo.getShop();
            dto = ProductDto.builder().id(bo.getId()).barcode(bo.getBarcode()).beginTime(bo.getBeginTime()).endTime(bo.getEndTime())
                    .maxQuantity(bo.getMaxQuantity()).quantity(bo.getQuantity()).name(bo.getName()).weight(bo.getWeight()).unit(bo.getUnit())
                    .originalPrice(bo.getOriginalPrice()).price(bo.getPrice()).originPlace(bo.getOriginPlace()).skuSn(bo.getSkuSn()).status(bo.getStatus())
                    .otherProduct(other.stream().map(product -> SimpleProductDto.builder().id(product.getId()).status(product.getStatus()).price(product.getPrice()).quantity(product.getQuantity()).name(product.getName()).build()).collect(Collectors.toList()))
                    .shop(Shop.builder().id(shop.getId()).name(shop.getName()).type(shop.getType()).build()).build();
            logger.debug("findProductById: dto = {}", dto);
        }catch (BusinessException e){
            if (ReturnNo.RESOURCE_ID_NOTEXIST == e.getErrno()){
                //redisUtil.bfAdd(key, id);
            }
            throw e;
        }
        return dto;
    }

    /**

     * ??????????????????
     * @author wuzhicheng
     * @param shopId
     * @param barCode
     * @param page
     * @param pageSize
     * @return
     */
    public PageDto<SimpleProductDto> getSkuList(Long shopId, String barCode, Integer page, Integer pageSize) {
        logger.debug("getSkuList: shopId = {}, barCode = {}", shopId, barCode);
        PageDto<Product> products=this.productDao.retrieveByShopIdAndBarCode(shopId, barCode, page, pageSize);
        List<Product> list = products.getList();
        List<SimpleProductDto> ret = new ArrayList<>();
        list.forEach(o->{
            //?????????????????????
            if(!Objects.equals(o.getStatus(), Product.BANNED)){
                ret.add(cloneObj(o, SimpleProductDto.class));
            }
        });
        return new PageDto<>(ret, page, pageSize);
    }

    /**
     * ???????????????????????????
     * @return
     */
    public List<StateDto> getStates() {
        logger.debug("getStates");
        Map<Byte, String> statusnames = Product.STATUSNAMES;
        List<StateDto> stateDtos=new ArrayList<>();
        statusnames.forEach((k, v)->{
            StateDto stateDto = new StateDto();
            stateDto.setName(v);
            stateDto.setCode(k);
            stateDtos.add(stateDto);
        });
        return stateDtos;
    }

    /**
     * ??????????????????????????????
     * @param shopId
     * @param id
     * @return
     */
    public FullProductDto getProductById(Long shopId, Long id) {
        logger.debug("getProduct: productId = {}", id);
        //??????Product
        Product productById = this.productDao.findProductById(id);

        if(!Objects.equals(productById.getShopId(), shopId) && shopId != Constants.PLATFORM){
            throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "??????", id, shopId));
        }
        //??????????????????
        FullProductDto fullProductDto = cloneObj(productById, FullProductDto.class);

        //????????????????????????
        fullProductDto.setShop(cloneObj(productById.getShop(), IdNameTypeDto.class));

        fullProductDto.setOtherProducts(productById.getOtherProduct().stream().map(o->{
            return cloneObj(o, IdNameDto.class);
        }).collect(Collectors.toList()));

        fullProductDto.setCategory(cloneObj(productById.getCategory(), IdNameDto.class));

        fullProductDto.setTemplate(cloneObj(productById.getTemplate(), IdNameDto.class));

        fullProductDto.setCreator(new IdNameDto(productById.getCreatorId(), productById.getCreatorName()));
        fullProductDto.setModifier(new IdNameDto(productById.getModifierId(), productById.getModifierName()));
        return fullProductDto;
    }

    /**
     * ????????????????????????
     * @author wuzhicheng
     * @param shopId
     * @param id
     * @param user
     * @param productModVo
     */
    public void updateProduct(Long shopId, Long id, UserDto user, ProductModVo productModVo) {
        logger.debug("updateProduct: productId = {}", id);
        //??????Product
        Product productById = this.productDao.findProductById(id);

        if(productById.getShopId() != shopId && shopId != Constants.PLATFORM){
            throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "??????", id, shopId));
        }

        if(productModVo.getCommissionRatio()!=null && shopId != Constants.PLATFORM){
            //?????????commissionratio
            throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "??????", id, shopId));
        }

        //?????????????????????
        if(productModVo.getCategoryId()!=null){
            Long categoryId = productModVo.getCategoryId();
            Category category = this.categoryDao.findById(categoryId);

            if(category.getParent()==null || category.getParent().getId()==PUBLIC_PID){
                throw new BusinessException(ReturnNo.CATEGORY_NOTALLOW, String.format(ReturnNo.CATEGORY_NOTALLOW.getMessage(), categoryId));
            }
            productById.setCategoryId(categoryId);
        }

        if(productModVo.getName()!=null || productModVo.getOriginPlace()!=null || productModVo.getOriginalPrice() !=null || productModVo.getCategoryId()!=null){
            //??????????????????
            ProductDraft productDraft = cloneObj(productModVo, ProductDraft.class);
            productDraft.setProductId(id);
            productDraftDao.insert(productDraft, user);
            return;
        }


        Product build = Product.builder().id(id).skuSn(productModVo.getSkuSn()).name(productModVo.getName()).originalPrice(productModVo.getOriginalPrice()).weight(productModVo.getWeight())
                .barcode(productModVo.getBarcode()).unit(productModVo.getUnit()).originalPrice(productModVo.getOriginalPrice()).shopLogisticId(productModVo.getShopLogisticsId())
                .templateId(productModVo.getTemplateId()).commissionRatio(productModVo.getCommissionRatio()).build();

        String key = this.productDao.save(build, user);
        redisUtil.del(key);
    }

    /**
     * ???????????????????????????
     * @author wuzhicheng
     * @param shopId
     * @param id
     * @return
     */
    public Template getProductTemplate(Long shopId, Long id) {
        logger.debug("getProductTemplate: productId = {}", id);
        Product productById = this.productDao.findProductById(id);

        if(!Objects.equals(productById.getShopId(), shopId) && shopId != Constants.PLATFORM){
            throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "??????", id, shopId));
        }
        return productById.getTemplate();
    }

    /**
     * ??????????????????????????????????????????
     * @author wuzhicheng
     * @param shopId
     * @param id
     * @param page
     * @param pageSize
     * @return
     */
    public PageDto<IdNameDto> getTemplateProduct(Long shopId, Long id, Integer page, Integer pageSize) {
        logger.debug("getTemplateProduct: templateId = {}", id);
        if(shopId!=Constants.PLATFORM){
            throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "????????????", id, shopId));
        }
        PageDto<Product> list=this.productDao.retrieveProductByTemplateId(id, page, pageSize);
        List<Product> products = list.getList();
        List<IdNameDto> collect = products.stream().map(o -> {
            return cloneObj(o, IdNameDto.class);
        }).collect(Collectors.toList());
        PageDto<IdNameDto> idNameDtoPageDto = new PageDto<>(collect, page, pageSize);
        return idNameDtoPageDto;
    }


    /**
     * ?????????????????????
     * @param shopId
     * @param id
     * @param user
     * @return
     */
    public void allowGoods(Long shopId, Long id, UserDto user) {
        logger.debug("allowGoods: productId = {}", id);
        if(shopId!=Constants.PLATFORM){
            throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "????????????", id, shopId));
        }
        Product productById = this.productDao.findProductById(id);
        if(Objects.equals(productById.getStatus(), Product.BANNED)){
            productById.setStatus(Product.OFFSHELF);
            String key = this.productDao.save(productById, user);
            redisUtil.del(key);
        } else{
            throw new BusinessException(ReturnNo.STATENOTALLOW, String.format(ReturnNo.STATENOTALLOW.getMessage(), "??????", id, "???????????????"));
        }
    }

    /**
     * ?????????????????????
     * @param shopId
     * @param id
     * @param user
     * @return
     */
    public void prohibitGoods(Long shopId, Long id, UserDto user) {
        logger.debug("prohibitGoods: productId = {}", id);
        if(shopId!=Constants.PLATFORM){
            throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "????????????", id, shopId));
        }
        Product productById = this.productDao.findProductById(id);
        if(!Objects.equals(productById.getStatus(), Product.BANNED)){
            productById.setStatus(Product.BANNED);
            String key = this.productDao.save(productById, user);
            redisUtil.del(key);
        } else{
            throw new BusinessException(ReturnNo.STATENOTALLOW, String.format(ReturnNo.STATENOTALLOW.getMessage(), "??????", id, "????????????"));
        }
    }

    /**
     * ??????????????????????????????
     * @param shopId
     * @param id
     * @param productId
     * @return
     */
    public void relateProductId(Long shopId, Long id, Long productId, UserDto user) {
        Product product1 = this.productDao.findProductById(id);
        Product product2 = this.productDao.findProductById(productId);

        if(shopId!=Constants.PLATFORM){
            if(product1.getShopId()!=shopId) throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "??????", product1.getId(), shopId));
            if(product2.getShopId()!=shopId) throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "??????", product2.getId(), shopId));
        }
        String key1=null;
        String key2=null;
        if(product1.getGoodsId()==NO_RELATE&&product2.getGoodsId()==NO_RELATE){
            //?????????????????????
            GoodsPo save = productDao.insertGoods();
            product1.setGoodsId(save.getId());
            product2.setGoodsId(save.getId());
            key1 = this.productDao.save(product1, user);
            key2 = this.productDao.save(product2, user);
        } else if(product1.getGoodsId()==NO_RELATE){
            //???????????????
            product1.setGoodsId(product2.getGoodsId());
            key1 = this.productDao.save(product1, user);
        } else{
            //???????????????
            product2.setGoodsId(product1.getGoodsId());
            key2 = this.productDao.save(product2, user);
        }
        if (key1!=null){
            redisUtil.del(key1);
        }
        if (key2!=null){
            redisUtil.del(key2);
        }
    }

    /**
     * ???????????????????????????
     * @param shopId
     * @param id
     * @param productId
     * @return
     */
    public void delRelateProduct(Long shopId, Long id, Long productId, UserDto user) {
        Product product1 = this.productDao.findProductById(id);
        Product product2 = this.productDao.findProductById(productId);

        if(shopId!=Constants.PLATFORM){
            if(product1.getShopId()!=shopId) throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "??????", product1.getId(), shopId));
            if(product2.getShopId()!=shopId) throw new BusinessException(ReturnNo.RESOURCE_ID_OUTSCOPE, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(), "??????", product2.getId(), shopId));
        }

        product2.setGoodsId(NO_RELATE);
        String key2 = this.productDao.save(product2, user);
        if (redisUtil.hasKey(key2)){
            redisUtil.del(key2);
        }
    }


    /**
     * ???????????????????????????
     * @param templateId
     */
    public void deleteTemplateByTemplateId(Long templateId, UserDto userDto) {
        List<Product> productList = this.productDao.findProductByTemplateId(templateId);
        List<String> keys=new ArrayList<>();
        productList.stream().peek(o-> o.setTemplateId(null)).forEach(o->{
            String save = this.productDao.save(o, userDto);
            keys.add(save);
        });
        keys.forEach(redisUtil::del);
    }

    /**
     * ???????????????????????????????????????
     * @param id onsaleid
     * @return ????????????
     */
    @Transactional
    public ProductDto findOnsaleById(Long id) throws BusinessException {
        logger.debug("findOnsaleById: id = {}", id);
        String key = BloomFilter.PRETECT_FILTERS.get("OnsaleId");
        if (redisUtil.bfExist(key, id)){
            throw new BusinessException(ReturnNo.RESOURCE_ID_NOTEXIST, String.format(ReturnNo.RESOURCE_ID_OUTSCOPE.getMessage(),"??????", id));
        }
        ProductDto dto = null;
        try {
            Product bo = productDao.findProductByOnsaleId(id);
            List<Product> other = bo.getOtherProduct();
            dto = ProductDto.builder().id(bo.getId()).barcode(bo.getBarcode()).beginTime(bo.getBeginTime()).endTime(bo.getEndTime())
                    .maxQuantity(bo.getMaxQuantity()).quantity(bo.getQuantity()).name(bo.getName()).weight(bo.getWeight()).unit(bo.getUnit())
                    .originalPrice(bo.getOriginalPrice()).price(bo.getPrice()).originPlace(bo.getOriginPlace()).skuSn(bo.getSkuSn()).status(bo.getStatus())
                    .otherProduct(other.stream().map(product -> SimpleProductDto.builder().id(product.getId()).status(product.getStatus()).price(product.getPrice()).quantity(product.getQuantity()).name(product.getName()).build()).collect(Collectors.toList())).build();
            logger.debug("findOnsaleById: dto = {}", dto);
        }catch (BusinessException e){
            if (ReturnNo.RESOURCE_ID_NOTEXIST == e.getErrno()){
                redisUtil.bfAdd(key, id);
            }
            throw e;
        }
        return dto;
    }
}
