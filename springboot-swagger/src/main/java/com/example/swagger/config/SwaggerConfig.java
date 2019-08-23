package com.example.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author Administrator
 * @ClassName SwaggerConfig
 * @Description
 * @create 2019/8/21/0021 14:00
 * @since 1.0.0
 * 备注:写这段代码的时候，只有上帝和我知道它是干嘛的。现在，只有上帝知道。
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket buildDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buidApiInfo())
                .select()
                /*定义了扫描的包路径*/
                .apis(RequestHandlerSelectors.basePackage("com.example.swagger.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buidApiInfo() {
        return new ApiInfoBuilder()
                .title("系统RESTFul API文档")
                .contact(new Contact("mri", "http://baidu.com", "11.com"))
                .version("1.0")
                .build();
    }


}
