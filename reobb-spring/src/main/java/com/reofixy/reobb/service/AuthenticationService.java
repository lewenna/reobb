package com.reofixy.reobb.service;

import com.reofixy.reobb.model.dto.AuthenticationRequest;
import com.reofixy.reobb.model.dto.SecurityToken;

public interface AuthenticationService<T extends AuthenticationRequest> {
    SecurityToken authenticate(T authenticationRequest);
}
