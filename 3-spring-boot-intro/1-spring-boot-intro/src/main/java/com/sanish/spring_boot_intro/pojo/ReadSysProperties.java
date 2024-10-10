package com.sanish.spring_boot_intro.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom_app.properties")
public class ReadSysProperties {

    private Environment env;

    @Value("${project.version}")
    private String projectVersion;

    public Environment getEnv() {
        return env;
    }

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    public String getOSVersion(){ //From System
        return env.getProperty("os.name");
    }

    public String getJavaVersion(){ //From System
        return env.getProperty("java.version");
    }

    public String getProjectName(){ //From application.properties
        return env.getProperty("project.name");
    }

    public String getProjectVersionFromCustomFile(){
        return projectVersion;
    }
}
