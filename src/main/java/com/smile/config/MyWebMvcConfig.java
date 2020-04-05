package com.smile.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.smile.interceptor.MyInterceptor1;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd HH:mm:ss");
        config.setCharset(Charset.forName("UTF-8"));
        config.setSerializerFeatures(
                //SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty
        );
        converter.setFastJsonConfig(config);
        converters.add(converter);
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**")
//            .addResourceLocations("classpath:/static/")
//        ;
//        // 添加classpath:/static/ # 多一种访问路径方式:/static/*.png
//    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/book/**")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .maxAge(1800)
//                .allowedOrigins("http://localhost:8081");
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new MyInterceptor1())
          //      .addPathPatterns("/*")
            //    .excludePathPatterns("/hello");
    }

    @Override // 未看到实际效果
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/static/index").setViewName("index");
        registry.addViewController("/uploadp").setViewName("upload");
        registry.addViewController("/uploadsp").setViewName("uploads");
        registry.addViewController("/static/login").setViewName("login");
    }
}
