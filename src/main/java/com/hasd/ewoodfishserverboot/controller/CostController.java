package com.hasd.ewoodfishserverboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hasd.ewoodfishserverboot.common.NormalException;
import com.hasd.ewoodfishserverboot.common.Result;
import com.hasd.ewoodfishserverboot.entity.Cost;
import com.hasd.ewoodfishserverboot.entity.User;
import com.hasd.ewoodfishserverboot.mapper.CostMapper;
import com.hasd.ewoodfishserverboot.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 消费记录 前端控制器
 * </p>
 *
 * @author hasd
 * @since 2023-01-08
 */
@RestController
@RequestMapping("/api/cost")
public class CostController {
    @Resource
    CostMapper costMapper;
    @Resource
    UserMapper userMapper;

    //用户花费
    @GetMapping("/one")
    public Result CostScore(@RequestParam("username") String userName, @RequestParam("cost") Integer costNum, @RequestParam("itemid") Integer itemId, @RequestParam("palt") Integer palt) {
        Cost cost = new Cost();
        cost.setCost(costNum);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userName);
        User user = userMapper.selectOne(wrapper);
        if (user == null) {
            throw new NormalException("用户不存在");
        }
        if (user.getScore() < costNum) {
            throw new NormalException(500, "分数不足");
        } else {
            userMapper.costScore(user.getId(), costNum);
        }
        cost.setUserId(user.getId());
        cost.setItemId(itemId);
        cost.setCreateTime(LocalDateTime.now());
        cost.setPlatformId(palt);
        costMapper.insert(cost);
        return Result.success();
    }
}
