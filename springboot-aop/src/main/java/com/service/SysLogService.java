package com.service;

import com.entity.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName SysLogService
 * @Description
 * @create 2019/8/20/0020 18:14
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public interface SysLogService {


   SysLog saveSysLog(SysLog sysLog);
}
