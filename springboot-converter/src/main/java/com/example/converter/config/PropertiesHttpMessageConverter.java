package com.example.converter.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName PropertiesHttpMessageConverter
 * @Description
 * @create 2019/8/22/0022 10:08
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
public class PropertiesHttpMessageConverter  extends AbstractGenericHttpMessageConverter<Properties>{

    /**
     * 序列化过程
     * @param properties
     * @param type
     * @param httpOutputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Properties properties, @Nullable Type type, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
        /*获取请求头*/
        HttpHeaders headers = httpOutputMessage.getHeaders();
        /*获取Content-type*/
        MediaType contentType = headers.getContentType();
        /*获取编码*/
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }
        charset = charset == null?Charset.forName("UTF-8"):charset;

        /*获取请求头*/
        OutputStream body = httpOutputMessage.getBody();
        OutputStreamWriter out = new OutputStreamWriter(body, charset);

        properties.store(out, "Serialized by PropertieseHttpMessageConverter#writerInternal");


    }

    /**
     * 反序列化过程
     * @param aClass
     * @param httpInputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Properties readInternal(Class<? extends Properties> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        Properties properties = new Properties();
        /*获取请求头*/
        HttpHeaders headers = httpInputMessage.getHeaders();
        /*获取content-type*/
        MediaType contentType = headers.getContentType();
        /*获取编码*/
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }
        charset = charset == null? Charset.forName("UTF-8") :charset;
        /*获取请求提*/
        InputStream body = httpInputMessage.getBody();
        InputStreamReader reader = new InputStreamReader(body, charset);

        properties.load(reader);
        return properties;
    }

    @Override
    public Properties read(Type type, @Nullable Class<?> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, httpInputMessage);
    }
}
