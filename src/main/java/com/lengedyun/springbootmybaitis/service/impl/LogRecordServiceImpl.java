package com.lengedyun.springbootmybaitis.service.impl;

import com.lengedyun.springbootmybaitis.annotation.LogRecord;
import com.lengedyun.springbootmybaitis.service.LogRecordService;
import org.springframework.stereotype.Service;

/**
 * @author zjy
 * @title: LogRecordServiceImpl
 * @projectName springbootmybatis
 * @description: TODO
 * @date 2019/6/29 10:45
 */

@Service
public class LogRecordServiceImpl implements LogRecordService {

    @Override
    @LogRecord(tableName = "t_user")
    public String recordLog(String username, Integer age) {
        StringBuilder logContent = new StringBuilder();
        logContent.append("info[");
        logContent.append("user:"+username);
        logContent.append(",age:"+age);
        logContent.append("],come in");
        return logContent.toString();
    }
}
