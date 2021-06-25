package com.reofixy.reobb.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRegistrationRequest implements RegistrationRequest {
    private String username;
    private String email;
    private String password;
}
