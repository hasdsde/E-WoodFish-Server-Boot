package com.hasd.ewoodfishserverboot.controller;

import com.hasd.ewoodfishserverboot.common.Result;
import com.hasd.ewoodfishserverboot.entity.Item;
import com.hasd.ewoodfishserverboot.mapper.ItemMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 消费品 前端控制器
 * </p>
 *
 * @author hasd
 * @since 2023-01-08
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    @Resource
    ItemMapper itemMapper;

    @GetMapping("/getAll")
    public Result getAllItem() {
        List<Item> items = itemMapper.selectAll();
        return Result.success(items);
    }
}
