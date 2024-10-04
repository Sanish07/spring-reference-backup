package com.spring_properties.Tools;

import com.spring_properties.Bugs.Bug;
import org.springframework.beans.factory.annotation.Value;

public class Net implements Tool{

    private Bug bug;

    private String toolName;

    public Net(Bug bug){
        this.bug = bug;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    @Override
    public String useTool() {
        return "Catching "+bug.getBugName()+" with "+toolName+".";
    }
}
