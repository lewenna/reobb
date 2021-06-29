package com.reofixy.reobb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    private String subject;
    private String recipient;
    private String body;
}
