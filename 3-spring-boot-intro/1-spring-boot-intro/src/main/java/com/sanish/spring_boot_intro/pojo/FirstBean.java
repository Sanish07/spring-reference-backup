package com.sanish.spring_boot_intro.pojo;

import java.util.Objects;

public class FirstBean {

    private String greetWord; //Mandatory Dependency - To be set by CI

    private String greetFileName; //Optional Dependency - To be set by SI

    public FirstBean(String greetWord) {
        this.greetWord = greetWord;
    }

    public String getGreetFileName() {
        return greetFileName;
    }

    public void setGreetFileName(String greetFileName) {
        this.greetFileName = greetFileName;
    }

    public String greet(){
        if(greetFileName == null) return greetWord;
        return greetWord+" from "+greetFileName;
    }
}
