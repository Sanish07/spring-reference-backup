package com.annotation_config.Colors;

import org.springframework.stereotype.Component;

@Component
public class BlueColor implements Color{

    @Override
    public String getColorName() {
        return "Blue";
    }
}
