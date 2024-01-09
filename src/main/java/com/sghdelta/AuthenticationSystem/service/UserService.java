package com.sghdelta.AuthenticationSystem.service;

import com.sghdelta.AuthenticationSystem.dto.LoginRequest;
import com.sghdelta.AuthenticationSystem.dto.Request;
import com.sghdelta.AuthenticationSystem.dto.Response;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Response> signup(Request request);
    ResponseEntity<Response> login(LoginRequest request);
    Response sendOtp();
    Response validateotp();
    Response resetPassword();
    Response changePassword();

}
