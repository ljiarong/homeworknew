package cn.edu.xmu.oomall.freight.mapper.generator.po;

import cn.edu.xmu.javaee.core.aop.CopyFrom;
import cn.edu.xmu.oomall.freight.dao.bo.WarehouseLogistics;

import java.time.LocalDateTime;
import java.util.Date;
@CopyFrom(WarehouseLogistics.class)
public class WarehouseLogisticsPo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.warehouse_id
     *
     * @mbggenerated
     */
    private Long warehouseId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.shop_logistics_id
     *
     * @mbggenerated
     */
    private Long shopLogisticsId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.begin_time
     *
     * @mbggenerated
     */
    private LocalDateTime beginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.creator_id
     *
     * @mbggenerated
     */
    private Long creatorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.creator_name
     *
     * @mbggenerated
     */
    private String creatorName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.modifier_id
     *
     * @mbggenerated
     */
    private Long modifierId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.modifier_name
     *
     * @mbggenerated
     */
    private String modifierName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.gmt_create
     *
     * @mbggenerated
     */
    private LocalDateTime gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.gmt_modified
     *
     * @mbggenerated
     */
    private LocalDateTime gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.end_time
     *
     * @mbggenerated
     */
    private LocalDateTime endTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column freight_warehouse_logistics.invalid
     *
     * @mbggenerated
     */
    private Byte invalid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.id
     *
     * @return the value of freight_warehouse_logistics.id
     *
     * @mbggenerated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.id
     *
     * @param id the value for freight_warehouse_logistics.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.warehouse_id
     *
     * @return the value of freight_warehouse_logistics.warehouse_id
     *
     * @mbggenerated
     */
    public Long getWarehouseId() {
        return warehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.warehouse_id
     *
     * @param warehouseId the value for freight_warehouse_logistics.warehouse_id
     *
     * @mbggenerated
     */
    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.shop_logistics_id
     *
     * @return the value of freight_warehouse_logistics.shop_logistics_id
     *
     * @mbggenerated
     */
    public Long getShopLogisticsId() {
        return shopLogisticsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.shop_logistics_id
     *
     * @param shopLogisticsId the value for freight_warehouse_logistics.shop_logistics_id
     *
     * @mbggenerated
     */
    public void setShopLogisticsId(Long shopLogisticsId) {
        this.shopLogisticsId = shopLogisticsId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.begin_time
     *
     * @return the value of freight_warehouse_logistics.begin_time
     *
     * @mbggenerated
     */
    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.begin_time
     *
     * @param beginTime the value for freight_warehouse_logistics.begin_time
     *
     * @mbggenerated
     */
    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.creator_id
     *
     * @return the value of freight_warehouse_logistics.creator_id
     *
     * @mbggenerated
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.creator_id
     *
     * @param creatorId the value for freight_warehouse_logistics.creator_id
     *
     * @mbggenerated
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.creator_name
     *
     * @return the value of freight_warehouse_logistics.creator_name
     *
     * @mbggenerated
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.creator_name
     *
     * @param creatorName the value for freight_warehouse_logistics.creator_name
     *
     * @mbggenerated
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.modifier_id
     *
     * @return the value of freight_warehouse_logistics.modifier_id
     *
     * @mbggenerated
     */
    public Long getModifierId() {
        return modifierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.modifier_id
     *
     * @param modifierId the value for freight_warehouse_logistics.modifier_id
     *
     * @mbggenerated
     */
    public void setModifierId(Long modifierId) {
        this.modifierId = modifierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.modifier_name
     *
     * @return the value of freight_warehouse_logistics.modifier_name
     *
     * @mbggenerated
     */
    public String getModifierName() {
        return modifierName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.modifier_name
     *
     * @param modifierName the value for freight_warehouse_logistics.modifier_name
     *
     * @mbggenerated
     */
    public void setModifierName(String modifierName) {
        this.modifierName = modifierName == null ? null : modifierName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.gmt_create
     *
     * @return the value of freight_warehouse_logistics.gmt_create
     *
     * @mbggenerated
     */
    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.gmt_create
     *
     * @param gmtCreate the value for freight_warehouse_logistics.gmt_create
     *
     * @mbggenerated
     */
    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.gmt_modified
     *
     * @return the value of freight_warehouse_logistics.gmt_modified
     *
     * @mbggenerated
     */
    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.gmt_modified
     *
     * @param gmtModified the value for freight_warehouse_logistics.gmt_modified
     *
     * @mbggenerated
     */
    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.end_time
     *
     * @return the value of freight_warehouse_logistics.end_time
     *
     * @mbggenerated
     */
    public LocalDateTime getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.end_time
     *
     * @param endTime the value for freight_warehouse_logistics.end_time
     *
     * @mbggenerated
     */
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column freight_warehouse_logistics.invalid
     *
     * @return the value of freight_warehouse_logistics.invalid
     *
     * @mbggenerated
     */
    public Byte getInvalid() {
        return invalid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column freight_warehouse_logistics.invalid
     *
     * @param invalid the value for freight_warehouse_logistics.invalid
     *
     * @mbggenerated
     */
    public void setInvalid(Byte invalid) {
        this.invalid = invalid;
    }
}