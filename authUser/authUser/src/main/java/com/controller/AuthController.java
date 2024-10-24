package src.main.java.com.controller;


import com.auth.dto.AuthRequest;
import com.auth.dto.AuthResponse;
import com.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest authRequest) {
        userService.registerUser(authRequest.getUsername(), authRequest.getPassword());
        return "User registered successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        // Implémentation de la logique de génération de JWT
        return new AuthResponse("tokenJWT");
    }
}
