package com.hasd.ewoodfishserverboot.controller;

import com.hasd.ewoodfishserverboot.common.NormalException;
import com.hasd.ewoodfishserverboot.common.Result;
import com.hasd.ewoodfishserverboot.entity.Logs;
import com.hasd.ewoodfishserverboot.mapper.LogsMapper;
import com.hasd.ewoodfishserverboot.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hasd
 * @since 2023-01-11
 */
@RestController
@RequestMapping("/api/logs")
public class LogsController {
    @Resource
    LogsMapper logsMapper;
    @Resource
    UserMapper userMapper;

    //添加数据
    @GetMapping("/swear")
    public Result getLogs(@RequestParam("username") String userName, @RequestParam("score") Integer score, HttpServletRequest request) {
        if (score != 1) {
            throw new NormalException(666, "非法参数");
        }
        Logs logs = new Logs();
        logs.setScore(score);
        logs.setUsername(userName);
        logs.setCreateTime(LocalDateTime.now());
        logs.setIp(request.getRemoteAddr());
        logsMapper.insert(logs);
        userMapper.addScore(userName, score);
        int s = userMapper.selectScore(userName);
        HashMap<String, Object> map = new HashMap<>();
        map.put("score", s);
        map.put("username", userName);
        return Result.success("请求成功", map);
    }
}
