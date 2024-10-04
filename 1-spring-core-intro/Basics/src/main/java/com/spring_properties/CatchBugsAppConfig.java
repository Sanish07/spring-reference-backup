package com.spring_properties;

import com.spring_properties.Bugs.Bug;
import com.spring_properties.Bugs.Cicada;
import com.spring_properties.Tools.Net;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:bug_catcher_app.properties")
public class CatchBugsAppConfig {

    @Autowired
    private Environment environment; //Autowiring environment object to fetch values from properties file.

    @Value("${tool.name_1}")
    private String toolName;

    @Bean
    public Cicada cicada(){
        Cicada cicada = new Cicada();
        cicada.setBugName(environment.getProperty("bug.name_1")); //First way of fetching values from property file.
        return cicada;
    }

    @Bean
    public Net net(Bug bug){
        Net net = new Net(bug);
        net.setToolName(toolName);
        return net;
    }

    @Bean
    public BugCatcher bugCatcher(Net net){
        return new BugCatcher(net);
    }
}
