package com.example.xss.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName JsonpUtil
 * @Description
 * @create 2019/8/21/0021 15:25
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class JsonpUtil {

    private static final Whitelist whitelist = Whitelist.basicWithImages();
    /*
    * 配置过滤化参数,不对代码进行格式化
    */
    private static final Document.OutputSettings outputSettings = new Document.OutputSettings().prettyPrint(false);


    static {
        /*
         * 富文本编辑时一些样式是使用style来进行实现的 比如红色字体 style="color:red;" 所以需要给所有标签添加style属性
         */
        whitelist.addAttributes(":all", "style");
    }

    public static String clean(String content) {
        return Jsoup.clean(content, "", whitelist, outputSettings);
    }
}
