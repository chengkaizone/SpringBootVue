package com.smile;

import com.smile.config.GlobalConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//@EnableAutoConfiguration(exclude = {GlobalConfig.class})
public class AppContext {

    public static void main(String[] args) {
        SpringApplication.run(AppContext.class, args);
    }

}
