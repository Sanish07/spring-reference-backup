package com.spring.profiles;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProjectPhase {

    @Value("${phase.name}")
    private String activePhase;

    @Value("${phase.id}")
    private String phaseId;

    @Override
    public String toString() {
        return "ProjectPhase{" +
                "activePhase='" + activePhase + '\'' +
                ", phaseId=" + phaseId +
                '}';
    }
}
