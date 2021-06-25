package com.reofixy.reobb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsernamePasswordAuthenticationRequest implements AuthenticationRequest {
    //It can be email too.
    private String username;

    private String password;
}
