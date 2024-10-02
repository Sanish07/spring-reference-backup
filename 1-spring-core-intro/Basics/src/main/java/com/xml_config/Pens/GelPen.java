package com.xml_config.Pens;

import com.xml_config.Inks.Ink;

public class GelPen implements Pen{

    private Ink ink;

    public void setInk(Ink ink) { //Using Setter Injection for this class
        this.ink = ink;
    }

    @Override
    public String write() {
        return "Writing via Gel Pen. Color : "+ink.getColor()+". Brand : "+ink.getBrandName();
    }
}
