//package com.annotation_config;
//
//import com.annotation_config.Brushes.Brush;
//import com.annotation_config.Brushes.FlatBrush;
//import com.annotation_config.Brushes.RoundBrush;
//import com.annotation_config.Colors.BlueColor;
//import com.annotation_config.Colors.Color;
//import com.annotation_config.Colors.YellowColor;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DrawAppJavaConfig {
//
//    @Bean
//    public BlueColor blueColor(){
//        return new BlueColor();
//    }
//
//    @Bean
//    public YellowColor yellowColor(){
//        return new YellowColor();
//    }
//
//    @Bean
//    public FlatBrush flatBrush(@Qualifier("blueColor") Color color){
//        return new FlatBrush(color);
//    }
//
//    @Bean
//    public RoundBrush roundBrush(@Qualifier("yellowColor") Color color){
//        RoundBrush roundBrush = new RoundBrush();
//        roundBrush.setColor(color);
//        return roundBrush;
//    }
//
//    @Bean
//    public Painter painter(@Qualifier("roundBrush") Brush brush){
//        return new Painter(brush);
//    }
//}
