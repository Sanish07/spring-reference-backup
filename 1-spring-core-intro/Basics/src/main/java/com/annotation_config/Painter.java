package com.annotation_config;

import com.annotation_config.Brushes.Brush;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Painter {

    private Brush brush;

    @Autowired
    public Painter(@Qualifier("flatBrush") Brush brush){
        this.brush = brush;
    }

    public String paint(){
        return brush.useBrush();
    }
}
