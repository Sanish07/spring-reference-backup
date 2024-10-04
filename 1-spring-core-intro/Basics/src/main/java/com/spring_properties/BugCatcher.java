package com.spring_properties;

import com.spring_properties.Tools.Tool;

public class BugCatcher {
    private Tool tool;

    public BugCatcher(Tool tool){
        this.tool = tool;
    }

    public String catchBug(){
        return tool.useTool();
    }
}
