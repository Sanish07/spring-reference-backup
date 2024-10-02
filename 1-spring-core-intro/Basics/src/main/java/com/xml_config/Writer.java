package com.xml_config;

import com.xml_config.Pens.Pen;

public class Writer {

    private Pen pen;

    public Writer(Pen pen){
        this.pen = pen;
    }

    public String write(){
        return pen.write();
    }
}
