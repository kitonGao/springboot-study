package com.example.xss.config;

import com.example.xss.util.JsonpUtil;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 〈一句话功能简述〉<br>
 * 〈Jsoup过滤http请求，防止Xss攻击〉
 *
 * @author Administrator
 * @ClassName XssHttpServletRequestWrapper
 * @Description
 * @create 2019/8/21/0021 15:19
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper{

    HttpServletRequest orgRequest = null;

    private boolean isIncludeRichText = false;

    public XssHttpServletRequestWrapper(HttpServletRequest request, boolean isIncludeRichText) {
        super(request);
        orgRequest = request;
        this.isIncludeRichText = isIncludeRichText;
    }


    /**
     * 覆盖getParameter方法， 将参数名和参数值都做xss过滤如果需要获得原始的值，则通过super.getParameterValues(name)获取
     *
     * @param name
     * @return
     */
    @Override
    public String getParameter(String name) {
        if(("context".equals(name) || name.endsWith("WithHtml")) && !isIncludeRichText) {
            return super.getParameter(name);
        }
        name = JsonpUtil.clean(name);
        String value =super.getParameter(name);
        if (StringUtils.hasText(value)) {
            value = JsonpUtil.clean(value);
        }
        return value;
    }


    @Override
    public String[] getParameterValues(String name) {
        String[] arr = super.getParameterValues(name);
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = JsonpUtil.clean(arr[i]);
            }
        }
        return arr;
    }

    /**
     * 覆盖getHeader方法，将参数名和参数值都做xss过滤如果需要获得原始的值，则通过super.getHeaders(name)来获取
     * getHeaderNames 也可能需要覆盖
     */
    @Override
    public String getHeader(String name) {
        name = JsonpUtil.clean(name);
        String value = super.getHeader(name);
        if (StringUtils.hasText(value)) {
            value = JsonpUtil.clean(value);
        }
        return value;
    }

    /**
     * 获取原始的request
     */
    public HttpServletRequest getOrgRequest() {
        return orgRequest;
    }

    /**
     * 获取原始的request的静态方法
     */
    public static HttpServletRequest getOrgRequest(HttpServletRequest req) {
        if (req instanceof XssHttpServletRequestWrapper) {
            return ((XssHttpServletRequestWrapper) req).getOrgRequest();
        }
        return req;
    }


}
