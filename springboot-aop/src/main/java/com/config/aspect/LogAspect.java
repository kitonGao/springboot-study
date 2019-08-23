package com.config.aspect;

import com.config.aop.Log;
import com.dao.SysLogDao;
import com.entity.SysLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈切面〉
 *
 * @author Administrator
 * @ClassName LogAspect
 * @Description
 * @create 2019/8/20/0020 18:19
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogDao sysLogDao;

    @Pointcut("@annotation(com.config.aop.Log)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            /*执行方法*/
            result = point.proceed();
        }catch (Throwable e ) {
            e.printStackTrace();
        }

        /*执行时长*/
        long time = System.currentTimeMillis() - beginTime;
        /*保存日志*/
       saveSysLog(point, time);
        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log log = method.getAnnotation(Log.class);
        if (log != null) {
            /*注解上的描述*/
            sysLog.setOperation(log.value());
        }
        /*请求方法名称*/
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();

        sysLog.setMethod(className+"."+methodName+"()");
        /*请求的方法参数*/
        Object[] args = joinPoint.getArgs();
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i =0; i< args.length; i++) {
                params += " " + paramNames[i] +":"+ args[i];
            }
            sysLog.setParams(params);
        }

//        // 获取request
//        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
//        // 设置IP地址
//        sysLog.setIp(IPUtils.getIpAddr(request));
        // 模拟一个用户名
        sysLog.setUsername("mrbird");
        sysLog.setTime((int) time);
        sysLog.setCreateTime(new Date());
        // 保存系统日志
        sysLogDao.saveSysLog(sysLog);



    }


}
