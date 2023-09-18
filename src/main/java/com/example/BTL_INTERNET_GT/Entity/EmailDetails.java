package com.example.BTL_INTERNET_GT.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetails {
    private  String cc;
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
