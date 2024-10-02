package com.java_config;

import com.xml_config.Inks.BlackInk;
import com.xml_config.Inks.Ink;
import com.xml_config.Inks.RedInk;
import com.xml_config.Pens.BallPen;
import com.xml_config.Pens.FountainPen;
import com.xml_config.Pens.GelPen;
import com.xml_config.Pens.Pen;
import com.xml_config.Writer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public BlackInk blackInk(){
        return new BlackInk();
    }

    @Bean
    public RedInk redInk(){
        return new RedInk();
    }

    @Bean
    public FountainPen fountainPen(@Qualifier("blackInk") Ink ink){ //Java config for Cons. Inj.
        return new FountainPen(ink);
    }

    @Bean
    public BallPen ballPen(@Qualifier("redInk") Ink ink){
        return new BallPen(ink);
    }

    @Bean
    public GelPen gelPen(@Qualifier("redInk") Ink ink){ //Java Config for Setter Inj.
        GelPen gelPen = new GelPen();
        gelPen.setInk(ink);
        return gelPen;
    }

    @Bean
    public Writer writer(@Qualifier("gelPen") Pen pen){
        return new Writer(pen);
    }
}
