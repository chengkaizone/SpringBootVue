package com.smile;

import com.smile.config.GlobalConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//@EnableAutoConfiguration(exclude = {GlobalConfig.class})
public class AppContext extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AppContext.class, args);
    }

    /**
     * 打包成war文件到应用容器运行必须声明一个SpringBootServletInitializer的子类
     * 并覆盖configure方法
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(AppContext.class);
    }
}
