package com.annotation_config.Brushes;

import com.annotation_config.Colors.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("roundBrush")
public class RoundBrush implements Brush{

    private Color color;

    @Autowired
    public void setColor(@Qualifier("blueColor") Color color) { //For Setter Injection
        this.color = color;
    }

    @Override
    public String useBrush() {
        return "Using Round brush. With color : "+color.getColorName();
    }
}
