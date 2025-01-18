package com.postandpost_details.telebeler3.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTelebeRequest {
    private String name;
    private String surname;
    private Integer age;
}
