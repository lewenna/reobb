package com.reofixy.reobb.model.dto;

import com.reofixy.reobb.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String username;
    private String avatar;
    private List<Role> roles;
}
