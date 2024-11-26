package com.sanish.custom_auth.security.providers;

import com.sanish.custom_auth.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Value("${authentication.secret-key}")
    private String key;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomAuthentication customAuthentication = (CustomAuthentication) authentication;

        String headerKey = customAuthentication.getKey(); //Get key from auth header

        if(key.equals(headerKey)) { //Compare original key with header key
            return new CustomAuthentication(true,null);
        }

        throw new BadCredentialsException("Validation through key failed"); //If auth failed, return exception
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //This method will check if authentication object is valid with our defined
        //CustomAuthentication class
        return CustomAuthentication.class.equals(authentication);
    }
}
