package com.hasd.ewoodfishserverboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hasd.ewoodfishserverboot.common.NormalException;
import com.hasd.ewoodfishserverboot.common.Result;
import com.hasd.ewoodfishserverboot.entity.User;
import com.hasd.ewoodfishserverboot.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author hasd
 * @since 2023-01-08
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;

    //注册
    @PostMapping("/reg")
    public Result RegisterAccount(@RequestBody User user, HttpServletRequest request) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        if (userMapper.selectCount(wrapper) != 0) {
            throw new NormalException(500, "用户名已存在");
        }
        user.setRegIp(request.getRemoteAddr()); //获取ip
        user.setCreateTime(LocalDateTime.now());//日期
        int i = userMapper.insert(user);
        return Result.success("注册成功");
    }

    //登录
    @PostMapping("/login")
    public Result Login(@RequestBody User user) {
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("username", user.getUsername());
        User Quser = userMapper.selectOne(userWrapper);
        if (Quser == null) {
            throw new NormalException(500, "账号不存在");
        }
        if (Objects.equals(Quser.getPassword(), user.getPassword())) {
            Quser.setRegIp("");
            Quser.setPassword("");
            return Result.success("登录成功", Quser);
        } else {
            return Result.error("登录失败，密码错误");
        }
    }

    //排行榜
    @GetMapping("/top")
    public Result TopList() {
        List<User> users = userMapper.selectTop();
        return Result.success(users);
    }

}
