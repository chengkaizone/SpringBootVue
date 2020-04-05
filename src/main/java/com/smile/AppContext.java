package com.smile;

import com.smile.config.GlobalConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {GlobalConfig.class})
public class AppContext {

    public static void main(String[] args) {
        SpringApplication.run(AppContext.class, args);
        //SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
        //builder.bannerMode(Banner.Mode.OFF).run(args);
    }

}
