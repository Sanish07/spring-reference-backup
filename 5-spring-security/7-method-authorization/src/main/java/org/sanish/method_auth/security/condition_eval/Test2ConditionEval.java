package org.sanish.method_auth.security.condition_eval;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Test2ConditionEval {


    public boolean conditionForAuthorization() {
        return true;
    }
}
