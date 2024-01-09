package com.sghdelta.AuthenticationSystem.service.Impl;

import com.sghdelta.AuthenticationSystem.dto.LoginRequest;
import com.sghdelta.AuthenticationSystem.dto.Request;
import com.sghdelta.AuthenticationSystem.dto.Response;
import com.sghdelta.AuthenticationSystem.entity.User;
import com.sghdelta.AuthenticationSystem.repository.UserRepository;
import com.sghdelta.AuthenticationSystem.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private ModelMapper modelMapper;
    //private PasswordEncoder passwordEncoder;
    @Override
    public ResponseEntity<Response> signup(Request request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body(Response.builder()
                    .statusCode(400)
                    .responseMessage("Attempt to save duplicate user Record")
                    .build());
        }
        User user = User.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .build();
        User saveduser = userRepository.save(user);
        return ResponseEntity.ok(Response.builder()
                        .statusCode(200)
                        .responseMessage("Success")
                        .userInfo(modelMapper.map(saveduser, Request.class))
                .build());
    }


    @Override
    public ResponseEntity<Response> login(LoginRequest request) {
        return null;
    }

    @Override
    public Response sendOtp() {
        return null;
    }

    @Override
    public Response validateotp() {
        return null;
    }

    @Override
    public Response resetPassword() {
        return null;
    }

    @Override
    public Response changePassword() {
        return null;
    }
}
