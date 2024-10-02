package com.annotation_config.Brushes;

import com.annotation_config.Colors.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("flatBrush")
public class FlatBrush implements Brush{

    private Color color;

    @Autowired
    public FlatBrush(@Qualifier("yellowColor") Color color){ //For Constructor Injection
        this.color = color;
    }

    @Override
    public String useBrush() {
        return "Using Flat Brush. With color : "+color.getColorName();
    }
}
