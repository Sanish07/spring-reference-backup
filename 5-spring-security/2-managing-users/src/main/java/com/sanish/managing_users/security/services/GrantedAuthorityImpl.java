package com.sanish.managing_users.security.services;

import com.sanish.managing_users.entity.Authority;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

public class GrantedAuthorityImpl implements GrantedAuthority {

    private final Authority authority;

    @Autowired
    public GrantedAuthorityImpl(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
