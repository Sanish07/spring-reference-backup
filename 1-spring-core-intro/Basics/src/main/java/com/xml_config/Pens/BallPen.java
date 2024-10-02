package com.xml_config.Pens;

import com.xml_config.Inks.Ink;
import org.springframework.context.annotation.Primary;

public class BallPen implements Pen{

    private Ink ink;

    public BallPen(Ink ink){
        this.ink = ink;
    }

    @Override
    public String write() {
        return "Writing via Ball Pen. Color : "+ink.getColor()+". Brand : "+ink.getBrandName();
    }
}
