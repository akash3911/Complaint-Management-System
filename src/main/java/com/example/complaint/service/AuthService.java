package com.example.complaint.service;

import com.example.complaint.dto.auth.AuthResponse;
import com.example.complaint.dto.auth.LoginRequest;
import com.example.complaint.dto.auth.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
