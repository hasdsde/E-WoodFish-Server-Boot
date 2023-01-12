package com.hasd.ewoodfishserverboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 消费品
 * </p>
 *
 * @author hasd
 * @since 2023-01-08
 */
@Getter
@Setter
@ApiModel(value = "Item对象", description = "消费品")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("描述")
    private String description;
    private Integer cost;

    @ApiModelProperty("创建日期")
    private LocalDateTime createTime;


}
