package com.service.impl;

import com.entity.SysLog;
import com.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName SysLogServiceImpl
 * @Description
 * @create 2019/8/20/0020 18:14
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public SysLog saveSysLog(SysLog sysLog) {
        StringBuffer sql = new StringBuffer("insert into sys_log ");
        sql.append("(id, username, operation, time, method,params, ip, create_time)");
        sql.append("values(seq_sys_log.nextval,:username,:operation,:method,");
        sql.append(":params,:ip,:createTime)");

        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        npjt.update(sql.toString(), new BeanPropertySqlParameterSource(sysLog));
        return sysLog;
    }


}
