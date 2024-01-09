package com.sghdelta.AuthenticationSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Response {
    private int statusCode;
    private String responseMessage;
    private Request userInfo;

}
