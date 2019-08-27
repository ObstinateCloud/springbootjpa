package com.lengedyun.springbootjpa.service.impl;

import com.lengedyun.springbootjpa.annotation.LogRecord;
import com.lengedyun.springbootjpa.service.LogRecordService;
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
