package org.sanish.multi_auth_prov_demo.security.providers;

import org.sanish.multi_auth_prov_demo.security.pojos.ApiKeyAuthentication;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ApiKeyProvider implements AuthenticationProvider {

    private final String key;

    public ApiKeyProvider(String key) {
        this.key = key;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ApiKeyAuthentication auth = (ApiKeyAuthentication) authentication;
        if(key.equals(auth.getApiKey())) {
            auth.setAuthenticated(true);
            return auth;
        }
        throw new BadCredentialsException("Custom Key based Authentication Failed due to incorrect key");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(ApiKeyAuthentication.class);
    }
}
