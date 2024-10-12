package com.sanish.spring_boot_intro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.sanish.spring_boot_intro.pojo.FirstBean;
import org.springframework.context.annotation.Profile;

@Configuration
public class BeanConfig {

    //Modifying same class 2 beans for different profiles
    @Bean
    @Profile("test")
    public FirstBean firstBean(){
        FirstBean fs = new FirstBean("Hello");
        fs.setGreetFileName("First Bean file.");
        return fs;
    }

    @Bean
    @Profile("dev")
    public FirstBean devBean(){ //Making the bean available for dev profile
        return new FirstBean("Hello Dev.");
    }
}
