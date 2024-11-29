package org.sanish.multi_auth_prov_demo.security.managers;

import org.sanish.multi_auth_prov_demo.security.providers.ApiKeyProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

public class CustomAuthenticationManager implements AuthenticationManager {

    private final String key;

    public CustomAuthenticationManager(String key) {
        this.key = key;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var provider = new ApiKeyProvider(key);
        if(provider.supports(authentication.getClass())){
            return provider.authenticate(authentication);
        }

        return authentication;
    }
}
