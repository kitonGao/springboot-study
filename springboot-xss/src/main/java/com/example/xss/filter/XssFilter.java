package com.example.xss.filter;

import com.example.xss.util.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈Xss 攻击拦截器〉
 *
 * @author Administrator
 * @ClassName XssFilter
 * @Description
 * @create 2019/8/21/0021 15:30
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class XssFilter  implements Filter{

    private static Logger logger = LoggerFactory.getLogger(XssFilter.class);
    /*是否过滤富文本内容*/
    private static boolean IS_INCLUDE_RICH_TEXT = false;

    public List<String > excludes = new ArrayList<>();


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("---------xss filter init--------------");
        String isIncludeRichText = filterConfig.getInitParameter("isIncludeRichText");
        if (StringUtils.hasText(isIncludeRichText)) {
            IS_INCLUDE_RICH_TEXT = BooleanUtils.toBoolean(isIncludeRichText);
        }

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }



}
