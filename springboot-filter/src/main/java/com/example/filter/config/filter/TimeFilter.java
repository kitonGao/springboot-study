package com.example.filter.config.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br>
 * 〈过滤器〉
 *
 * @author Administrator
 * @ClassName TimeFilter
 * @Description
 * @create 2019/8/21/0021 16:21
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */

/*加上下面的两句可以使其生效*/
//@Component   //让其成为spring上下文中的一个Bean
//@WebFilter(urlPatterns = {"/*"})      //配置了哪些请求可以进入该过滤器， /*表示所有的请求
public class TimeFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("开始执行过滤器");
        Long start =System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("【过滤器】耗时 " + (System.currentTimeMillis() - start));
        System.out.println("结束执行过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }



}
