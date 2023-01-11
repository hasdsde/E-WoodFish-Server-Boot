package com.hasd.ewoodfishserverboot.service.impl;

import com.hasd.ewoodfishserverboot.entity.Logs;
import com.hasd.ewoodfishserverboot.mapper.LogsMapper;
import com.hasd.ewoodfishserverboot.service.ILogsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hasd
 * @since 2023-01-11
 */
@Service
public class LogsServiceImpl extends ServiceImpl<LogsMapper, Logs> implements ILogsService {

}
