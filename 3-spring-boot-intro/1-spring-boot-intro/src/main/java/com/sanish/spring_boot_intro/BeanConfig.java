package com.sanish.spring_boot_intro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sanish.spring_boot_intro.pojo.FirstBean;

@Configuration
public class BeanConfig {

    @Bean
    public FirstBean firstBean(){
        FirstBean fs = new FirstBean("Hello");
        fs.setGreetFileName("First Bean file.");
        return fs;
    }
}
