package com.ograeset.talkbackend.Auth;

import com.ograeset.talkbackend.config.JWTService;
import com.ograeset.talkbackend.model.User;
import com.ograeset.talkbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 JWTService jwtService,
                                 AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegisterRequest request) {
        Optional<User> userOptional = userRepository.findUserByUsername(request.getUsername());
        if (userOptional.isPresent()){
            throw new IllegalStateException("username taken");
        }

        User newUser = new User();
        newUser.setUserName(request.getUsername());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setCredentialsNonExpired(true);
        newUser.setAccountNonLocked(true);
        newUser.setEnabled(true);
        newUser.setAccountNonExpired(true);

        userRepository.save(newUser);
        var jwtToken = jwtService.generateToken((UserDetails) newUser);
        return new AuthResponse(jwtToken, newUser.toString());
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findUserByUserName(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Bad credentials"));
        var jwtToken = jwtService.generateToken((UserDetails) user);
        return new AuthResponse(jwtToken, user.toString());
    }
}