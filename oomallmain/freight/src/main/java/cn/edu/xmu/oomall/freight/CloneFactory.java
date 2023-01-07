package cn.edu.xmu.oomall.freight;

import cn.edu.xmu.oomall.freight.controller.vo.WarehouseVo;
import cn.edu.xmu.oomall.freight.dao.bo.*;
import cn.edu.xmu.oomall.freight.mapper.generator.po.*;
import cn.edu.xmu.oomall.freight.service.dto.*;

public final class CloneFactory {
  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static Express copy(Express target, ExpressPo source) {
    target.setId(source.getId());
    target.setBillCode(source.getBillCode());
    target.setShopLogisticsId(source.getShopLogisticsId());
    target.setSenderRegionId(source.getSenderRegionId());
    target.setSenderAddress(source.getSenderAddress());
    target.setDeliveryRegionId(source.getDeliveryRegionId());
    target.setDeliverAddress(source.getDeliverAddress());
    target.setSenderName(source.getSenderName());
    target.setSenderMobile(source.getSenderMobile());
    target.setDeliveryName(source.getDeliveryName());
    target.setStatus(source.getStatus());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static Logistics copy(Logistics target, LogisticsPo source) {
    target.setId(source.getId());
    target.setName(source.getName());
    target.setAppId(source.getAppId());
    target.setSnPattern(source.getSnPattern());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static Region copy(Region target, RegionPo source) {
    target.setId(source.getId());
    target.setPid(source.getPid());
    target.setName(source.getName());
    target.setStatus(source.getStatus());
    target.setLevel(source.getLevel());
    target.setShortName(source.getShortName());
    target.setAreaCode(source.getAreaCode());
    target.setZipCode(source.getZipCode());
    target.setCityCode(source.getCityCode());
    target.setMergerName(source.getMergerName());
    target.setPinyin(source.getPinyin());
    target.setLng(source.getLng());
    target.setLat(source.getLat());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static ShopLogistics copy(ShopLogistics target, ShopLogisticsPo source) {
    target.setSecret(source.getSecret());
    target.setId(source.getId());
    target.setInvalid(source.getInvalid());
    target.setPriority(source.getPriority());
    target.setLogisticsId(source.getLogisticsId());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static Undeliverable copy(Undeliverable target, UndeliverablePo source) {
    target.setId(source.getId());
    target.setRegionId(source.getRegionId());
    target.setShopLogisticsId(source.getShopLogisticsId());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static Warehouse copy(Warehouse target, WarehousePo source) {
    target.setId(source.getId());
    target.setName(source.getName());
    target.setAddress(source.getAddress());
    target.setSenderMobile(source.getSenderMobile());
    target.setSenderName(source.getSenderName());
    target.setPriority(source.getPriority());
    target.setInvalid(source.getInvalid());
    target.setRegionId(source.getRegionId());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static Warehouse copy(Warehouse target, WarehouseVo source) {
    target.setName(source.getName());
    target.setAddress(source.getAddress());
    target.setSenderMobile(source.getSenderMobile());
    target.setSenderName(source.getSenderName());
    target.setPriority(source.getPriority());
    target.setRegionId(source.getRegionId());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static WarehouseLogistics copy(WarehouseLogistics target, WarehouseLogisticsPo source) {
    target.setId(source.getId());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setInvalid(source.getInvalid());
    target.setShopLogisticsId(source.getShopLogisticsId());
    target.setWarehouseId(source.getWarehouseId());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static WarehouseRegion copy(WarehouseRegion target, WarehouseRegionPo source) {
    target.setId(source.getId());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setRegionId(source.getRegionId());
    target.setWarehouseId(source.getWarehouseId());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static ExpressPo copy(ExpressPo target, Express source) {
    target.setId(source.getId());
    target.setBillCode(source.getBillCode());
    target.setShopLogisticsId(source.getShopLogisticsId());
    target.setSenderRegionId(source.getSenderRegionId());
    target.setSenderAddress(source.getSenderAddress());
    target.setDeliveryRegionId(source.getDeliveryRegionId());
    target.setSenderName(source.getSenderName());
    target.setSenderMobile(source.getSenderMobile());
    target.setDeliveryName(source.getDeliveryName());
    target.setStatus(source.getStatus());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static LogisticsPo copy(LogisticsPo target, Logistics source) {
    target.setId(source.getId());
    target.setName(source.getName());
    target.setAppId(source.getAppId());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    target.setSnPattern(source.getSnPattern());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static RegionPo copy(RegionPo target, Region source) {
    target.setId(source.getId());
    target.setPid(source.getPid());
    target.setLevel(source.getLevel());
    target.setAreaCode(source.getAreaCode());
    target.setZipCode(source.getZipCode());
    target.setCityCode(source.getCityCode());
    target.setName(source.getName());
    target.setShortName(source.getShortName());
    target.setMergerName(source.getMergerName());
    target.setPinyin(source.getPinyin());
    target.setLng(source.getLng());
    target.setLat(source.getLat());
    target.setStatus(source.getStatus());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static ShopLogisticsPo copy(ShopLogisticsPo target, ShopLogistics source) {
    target.setId(source.getId());
    target.setLogisticsId(source.getLogisticsId());
    target.setSecret(source.getSecret());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    target.setInvalid(source.getInvalid());
    target.setPriority(source.getPriority());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static UndeliverablePo copy(UndeliverablePo target, Undeliverable source) {
    target.setId(source.getId());
    target.setRegionId(source.getRegionId());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    target.setShopLogisticsId(source.getShopLogisticsId());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static WarehouseLogisticsPo copy(WarehouseLogisticsPo target, WarehouseLogistics source) {
    target.setId(source.getId());
    target.setWarehouseId(source.getWarehouseId());
    target.setShopLogisticsId(source.getShopLogisticsId());
    target.setBeginTime(source.getBeginTime());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    target.setEndTime(source.getEndTime());
    target.setInvalid(source.getInvalid());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static WarehousePo copy(WarehousePo target, cn.edu.xmu.oomall.freight.service.dto.dao.bo.Warehouse source) {
    target.setId(source.getId());
    target.setAddress(source.getAddress());
    target.setName(source.getName());
    target.setSenderName(source.getSenderName());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    target.setRegionId(source.getRegionId());
    target.setSenderMobile(source.getSenderMobile());
    target.setPriority(source.getPriority());
    target.setInvalid(source.getInvalid());
    return target;
  }

  public static WarehousePo copy(WarehousePo target, Warehouse source) {
    target.setId(source.getId());
    target.setAddress(source.getAddress());
    target.setName(source.getName());
    target.setSenderName(source.getSenderName());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    target.setRegionId(source.getRegionId());
    target.setSenderMobile(source.getSenderMobile());
    target.setPriority(source.getPriority());
    target.setInvalid(source.getInvalid());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static WarehouseRegionPo copy(WarehouseRegionPo target, cn.edu.xmu.oomall.freight.service.dto.dao.bo.WarehouseRegion source) {
    target.setId(source.getId());
    target.setWarehouseId(source.getWarehouseId());
    target.setRegionId(source.getRegionId());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  public static WarehouseRegionPo copy(WarehouseRegionPo target, WarehouseRegion source) {
    target.setId(source.getId());
    target.setWarehouseId(source.getWarehouseId());
    target.setRegionId(source.getRegionId());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static CreateWarehouseDto copy(CreateWarehouseDto target, Warehouse source) {
    target.setPriority(source.getPriority());
    target.setInvalid(source.getInvalid());
    target.setId(source.getId());
    target.setName(source.getName());
    target.setAddress(source.getAddress());
    target.setRegion(source.getRegion());
    target.setSenderMobile(source.getSenderMobile());
    target.setSenderName(source.getSenderName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static cn.edu.xmu.oomall.freight.service.dto.dao.bo.Express copy(
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.Express target, ExpressPo source) {
    target.setId(source.getId());
    target.setBillCode(source.getBillCode());
    target.setShopLogisticsId(source.getShopLogisticsId());
    target.setSenderRegionId(source.getSenderRegionId());
    target.setSenderAddress(source.getSenderAddress());
    target.setDeliveryRegionId(source.getDeliveryRegionId());
    target.setDeliverAddress(source.getDeliverAddress());
    target.setSenderName(source.getSenderName());
    target.setSenderMobile(source.getSenderMobile());
    target.setDeliveryName(source.getDeliveryName());
    target.setStatus(source.getStatus());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static cn.edu.xmu.oomall.freight.service.dto.dao.bo.Logistics copy(
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.Logistics target, LogisticsPo source) {
    target.setId(source.getId());
    target.setName(source.getName());
    target.setAppId(source.getAppId());
    target.setSnPattern(source.getSnPattern());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static cn.edu.xmu.oomall.freight.service.dto.dao.bo.Region copy(
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.Region target, RegionPo source) {
    target.setId(source.getId());
    target.setPid(source.getPid());
    target.setName(source.getName());
    target.setStatus(source.getStatus());
    target.setLevel(source.getLevel());
    target.setShortName(source.getShortName());
    target.setAreaCode(source.getAreaCode());
    target.setZipCode(source.getZipCode());
    target.setCityCode(source.getCityCode());
    target.setMergerName(source.getMergerName());
    target.setPinyin(source.getPinyin());
    target.setLng(source.getLng());
    target.setLat(source.getLat());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static cn.edu.xmu.oomall.freight.service.dto.dao.bo.ShopLogistics copy(
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.ShopLogistics target, ShopLogisticsPo source) {
    target.setSecret(source.getSecret());
    target.setId(source.getId());
    target.setInvalid(source.getInvalid());
    target.setPriority(source.getPriority());
    target.setLogisticsId(source.getLogisticsId());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static cn.edu.xmu.oomall.freight.service.dto.dao.bo.Undeliverable copy(
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.Undeliverable target, UndeliverablePo source) {
    target.setId(source.getId());
    target.setRegionId(source.getRegionId());
    target.setShopLogisticsId(source.getShopLogisticsId());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static cn.edu.xmu.oomall.freight.service.dto.dao.bo.Warehouse copy(
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.Warehouse target, WarehousePo source) {
    target.setId(source.getId());
    target.setName(source.getName());
    target.setAddress(source.getAddress());
    target.setSenderMobile(source.getSenderMobile());
    target.setSenderName(source.getSenderName());
    target.setPriority(source.getPriority());
    target.setInvalid(source.getInvalid());
    target.setRegionId(source.getRegionId());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static cn.edu.xmu.oomall.freight.service.dto.dao.bo.Warehouse copy(
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.Warehouse target, WarehouseVo source) {
    target.setName(source.getName());
    target.setAddress(source.getAddress());
    target.setSenderMobile(source.getSenderMobile());
    target.setSenderName(source.getSenderName());
    target.setPriority(source.getPriority());
    target.setRegionId(source.getRegionId());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static cn.edu.xmu.oomall.freight.service.dto.dao.bo.WarehouseLogistics copy(
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.WarehouseLogistics target,
      WarehouseLogisticsPo source) {
    target.setId(source.getId());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setInvalid(source.getInvalid());
    target.setShopLogisticsId(source.getShopLogisticsId());
    target.setWarehouseId(source.getWarehouseId());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static cn.edu.xmu.oomall.freight.service.dto.dao.bo.WarehouseRegion copy(
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.WarehouseRegion target,
      WarehouseRegionPo source) {
    target.setId(source.getId());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setRegionId(source.getRegionId());
    target.setWarehouseId(source.getWarehouseId());
    target.setCreatorId(source.getCreatorId());
    target.setCreatorName(source.getCreatorName());
    target.setModifierId(source.getModifierId());
    target.setModifierName(source.getModifierName());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static ExpressDto copy(ExpressDto target,
      cn.edu.xmu.oomall.freight.service.dto.dao.bo.Express source) {
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static FullWarehouseDto copy(FullWarehouseDto target, WarehouseRegion source) {
    target.setWarehouse(source.getWarehouse());
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static SimpleShopLogisticsDto copy(SimpleShopLogisticsDto target, ShopLogistics source) {
    target.setInvalid(source.getInvalid());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    target.setPriority(source.getPriority());
    target.setId(source.getId());
    target.setLogistics(source.getLogistics());
    target.setSecret(source.getSecret());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static SimpleShopLogisticsDto copy(SimpleShopLogisticsDto target,
      SimpleShopLogisticsDto source) {
    target.setCreator(source.getCreator());
    target.setModifier(source.getModifier());
    target.setInvalid(source.getInvalid());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    target.setPriority(source.getPriority());
    target.setId(source.getId());
    target.setLogistics(source.getLogistics());
    target.setSecret(source.getSecret());
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static UndeliverableDto copy(UndeliverableDto target, Undeliverable source) {
    return target;
  }

  /**
   * Copy all fields from source to target
   * @param target the target object
   * @param source the source object
   * @return the copied target object
   */
  public static WarehouseRegionDto copy(WarehouseRegionDto target, WarehouseRegion source) {
    target.setBeginTime(source.getBeginTime());
    target.setEndTime(source.getEndTime());
    target.setRegion(source.getRegion());
    target.setGmtCreate(source.getGmtCreate());
    target.setGmtModified(source.getGmtModified());
    return target;
  }
}
