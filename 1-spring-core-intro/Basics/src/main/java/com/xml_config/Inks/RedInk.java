package com.xml_config.Inks;

import org.springframework.context.annotation.Primary;

public class RedInk implements Ink{

    @Override
    public String getBrandName() {
        return "Liskov";
    }

    @Override
    public String getColor() {
        return "Red";
    }
}
