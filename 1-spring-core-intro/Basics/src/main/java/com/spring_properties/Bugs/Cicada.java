package com.spring_properties.Bugs;

import org.springframework.context.annotation.PropertySource;

public class Cicada implements Bug{

    private String bugName;

    public void setBugName(String bugName) {
        this.bugName = bugName;
    }

    @Override
    public String getBugName() {
        return bugName;
    }
}
