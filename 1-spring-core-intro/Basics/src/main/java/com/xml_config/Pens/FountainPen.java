package com.xml_config.Pens;

import com.xml_config.Inks.Ink;

public class FountainPen implements Pen{

    private Ink ink;

    public FountainPen(Ink ink){
        this.ink = ink;
    }

    @Override
    public String write() {
        return "Writing via Fountain Pen. Color : "+ink.getColor()+". Brand : "+ink.getBrandName();
    }
}
