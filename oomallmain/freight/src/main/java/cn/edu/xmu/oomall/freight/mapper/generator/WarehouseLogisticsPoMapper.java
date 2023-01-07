package cn.edu.xmu.oomall.freight.mapper.generator;

import cn.edu.xmu.oomall.freight.mapper.generator.po.WarehouseLogisticsPo;
import cn.edu.xmu.oomall.freight.mapper.generator.po.WarehouseLogisticsPoExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
@Mapper
public interface WarehouseLogisticsPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freight_warehouse_logistics
     *
     * @mbggenerated
     */
    @Delete({
        "delete from freight_warehouse_logistics",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freight_warehouse_logistics
     *
     * @mbggenerated
     */
    @Insert({
        "insert into freight_warehouse_logistics (`warehouse_id`, `shop_logistics_id`, ",
        "`begin_time`, `creator_id`, ",
        "`creator_name`, `modifier_id`, ",
        "`modifier_name`, `gmt_create`, ",
        "`gmt_modified`, `end_time`, ",
        "`invalid`)",
        "values (#{warehouseId,jdbcType=BIGINT}, #{shopLogisticsId,jdbcType=BIGINT}, ",
        "#{beginTime,jdbcType=TIMESTAMP}, #{creatorId,jdbcType=BIGINT}, ",
        "#{creatorName,jdbcType=VARCHAR}, #{modifierId,jdbcType=BIGINT}, ",
        "#{modifierName,jdbcType=VARCHAR}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModified,jdbcType=TIMESTAMP}, #{endTime,jdbcType=TIMESTAMP}, ",
        "#{invalid,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(WarehouseLogisticsPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freight_warehouse_logistics
     *
     * @mbggenerated
     */
    @InsertProvider(type=WarehouseLogisticsPoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(WarehouseLogisticsPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freight_warehouse_logistics
     *
     * @mbggenerated
     */
    @SelectProvider(type=WarehouseLogisticsPoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_logistics_id", property="shopLogisticsId", jdbcType=JdbcType.BIGINT),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="creator_name", property="creatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_id", property="modifierId", jdbcType=JdbcType.BIGINT),
        @Result(column="modifier_name", property="modifierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.TINYINT)
    })
    List<WarehouseLogisticsPo> selectByExample(WarehouseLogisticsPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freight_warehouse_logistics
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "`id`, `warehouse_id`, `shop_logistics_id`, `begin_time`, `creator_id`, `creator_name`, ",
        "`modifier_id`, `modifier_name`, `gmt_create`, `gmt_modified`, `end_time`, `invalid`",
        "from freight_warehouse_logistics",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="warehouse_id", property="warehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_logistics_id", property="shopLogisticsId", jdbcType=JdbcType.BIGINT),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_id", property="creatorId", jdbcType=JdbcType.BIGINT),
        @Result(column="creator_name", property="creatorName", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_id", property="modifierId", jdbcType=JdbcType.BIGINT),
        @Result(column="modifier_name", property="modifierName", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modified", property="gmtModified", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="invalid", property="invalid", jdbcType=JdbcType.TINYINT)
    })
    WarehouseLogisticsPo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freight_warehouse_logistics
     *
     * @mbggenerated
     */
    @UpdateProvider(type=WarehouseLogisticsPoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") WarehouseLogisticsPo record, @Param("example") WarehouseLogisticsPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freight_warehouse_logistics
     *
     * @mbggenerated
     */
    @UpdateProvider(type=WarehouseLogisticsPoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") WarehouseLogisticsPo record, @Param("example") WarehouseLogisticsPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freight_warehouse_logistics
     *
     * @mbggenerated
     */
    @UpdateProvider(type=WarehouseLogisticsPoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(WarehouseLogisticsPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table freight_warehouse_logistics
     *
     * @mbggenerated
     */
    @Update({
        "update freight_warehouse_logistics",
        "set `warehouse_id` = #{warehouseId,jdbcType=BIGINT},",
          "`shop_logistics_id` = #{shopLogisticsId,jdbcType=BIGINT},",
          "`begin_time` = #{beginTime,jdbcType=TIMESTAMP},",
          "`creator_id` = #{creatorId,jdbcType=BIGINT},",
          "`creator_name` = #{creatorName,jdbcType=VARCHAR},",
          "`modifier_id` = #{modifierId,jdbcType=BIGINT},",
          "`modifier_name` = #{modifierName,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmtCreate,jdbcType=TIMESTAMP},",
          "`gmt_modified` = #{gmtModified,jdbcType=TIMESTAMP},",
          "`end_time` = #{endTime,jdbcType=TIMESTAMP},",
          "`invalid` = #{invalid,jdbcType=TINYINT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(WarehouseLogisticsPo record);
}