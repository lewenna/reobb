package com.reofixy.reobb.service;

import com.reofixy.reobb.model.dto.RegistrationRequest;

public interface RegistrationService<T extends RegistrationRequest> {
    void register(T registrationRequest);
}
