package com.reofixy.reobb.model.dto;

import com.reofixy.reobb.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserUpdateRequest {
    private String username;
    private String password;
    private String email;
    private String avatar;
    private List<Role> roles;
}
