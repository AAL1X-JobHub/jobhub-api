package com.al1x.jobhub.api;

import com.al1x.jobhub.dto.UserDetailsDTO;
import com.al1x.jobhub.dto.UserDTO;
import com.al1x.jobhub.dto.UserLoginDTO;
import com.al1x.jobhub.dto.UserLoginResponseDTO;
import com.al1x.jobhub.model.enums.ERole;
import com.al1x.jobhub.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    // Another Functions
    @GetMapping("/read")
    public ResponseEntity<List<UserDetailsDTO>> readUsers() {
        return new ResponseEntity<>(userService.readUsers(), HttpStatus.FOUND);
    }

    // CRUD
    // US 01
    @PostMapping("/create")
    public ResponseEntity<UserDetailsDTO> createUser(@RequestBody UserDTO userDto) {
        return new ResponseEntity<>(userService.createUser(userDto, ERole.USER), HttpStatus.CREATED);
    }
    @PostMapping("/create/company")
    public ResponseEntity<UserDetailsDTO> createUserCompany(@RequestBody UserDTO userDto) {
        return new ResponseEntity<>(userService.createUser(userDto, ERole.COMPANY), HttpStatus.CREATED);
    }
    @PostMapping("/create/admin")
    public ResponseEntity<UserDetailsDTO> createUserAdmin(@RequestBody UserDTO userDto) {
        return new ResponseEntity<>(userService.createUser(userDto, ERole.ADMIN), HttpStatus.CREATED);
    }
    @GetMapping("/read/{id}")
    public ResponseEntity<UserDetailsDTO> readUser(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(userService.readUser(id), HttpStatus.FOUND);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<UserDetailsDTO> updateUser(@PathVariable("id") Integer id, @RequestBody UserDTO userDto) {
        return new ResponseEntity<>(userService.updateUser(id, userDto), HttpStatus.ACCEPTED);
    }
    // US 05
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("El usuario fue eliminado correctamente", HttpStatus.OK);
    }

    // US 02
    @PostMapping("/login")
    public ResponseEntity<UserLoginResponseDTO> logIn(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return new ResponseEntity<>(userService.logIn(userLoginDTO), HttpStatus.ACCEPTED);
    }
    // US 04
    @PostMapping("/logout")
    public ResponseEntity<String> logOut(@RequestParam(name = "email", required = false) String email) {
        userService.logOut(email);
        return new ResponseEntity<>("El usuario cerró sesión corectamente", HttpStatus.ACCEPTED);
    }
}