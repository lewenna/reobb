package com.reofixy.reobb.service;

import com.reofixy.reobb.model.dto.SecurityToken;
import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityTokenService {
    SecurityToken createSecurityToken(UserDetails userDetails);
    boolean isSecurityTokenValid(SecurityToken securityToken);
    UserDetails getUserDetailsFromToken(SecurityToken securityToken);
}
