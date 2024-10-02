package com.annotation_config;

import com.annotation_config.Brushes.FlatBrush;
import com.annotation_config.Brushes.RoundBrush;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.annotation_config")
//@ComponentScan(basePackageClasses = {FlatBrush.class, RoundBrush.class})
public class DrawAppAnnoConfig {

    //@Bean will still work here to explicitly create a class as Bean if we don't have
    //write access to a class.
}
