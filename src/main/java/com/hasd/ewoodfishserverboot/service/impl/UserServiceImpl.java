package com.hasd.ewoodfishserverboot.service.impl;

import com.hasd.ewoodfishserverboot.entity.User;
import com.hasd.ewoodfishserverboot.mapper.UserMapper;
import com.hasd.ewoodfishserverboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author hasd
 * @since 2023-01-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
