package com.annotation_config.Colors;

import org.springframework.stereotype.Component;

@Component
public class YellowColor implements Color{

    @Override
    public String getColorName() {
        return "Yellow";
    }
}
