package com.hasd.ewoodfishserverboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hasd.ewoodfishserverboot.entity.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 消费品 Mapper 接口
 * </p>
 *
 * @author hasd
 * @since 2023-01-08
 */
@Mapper
public interface ItemMapper extends BaseMapper<Item> {

    List<Item> selectAll();

}
