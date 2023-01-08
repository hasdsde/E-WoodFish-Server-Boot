package com.hasd.ewoodfishserverboot.service.impl;

import com.hasd.ewoodfishserverboot.entity.Item;
import com.hasd.ewoodfishserverboot.mapper.ItemMapper;
import com.hasd.ewoodfishserverboot.service.IItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消费品 服务实现类
 * </p>
 *
 * @author hasd
 * @since 2023-01-08
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements IItemService {

}
