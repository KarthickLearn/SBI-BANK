package com.sbi.userdetails.service.UserDetailsService.Controller;

import com.sbi.userdetails.service.UserDetailsService.userdto.UserRequest;
import com.sbi.userdetails.service.UserDetailsService.userservice.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/user")
public class UserServiceController {

    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity saveUserToDB(@RequestBody @Valid  UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(userService.saveUserInfoToDataBase(userRequest));
    }


    @GetMapping("/userinfo")
    public ResponseEntity getUserInfoFromBD(@RequestParam String username){

        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserInfoFormDBByusername(username));
    }


    @GetMapping("/usersinfo")
    public ResponseEntity getAllUserInfo(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUserinfoFromDB());
    }


    @DeleteMapping("/deleteuser/{username}")
    public ResponseEntity deleteUserInfo(@PathVariable  String username){

        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUserFromDB(username));
    }



    @DeleteMapping("/deletealluser")
    public ResponseEntity deleteAllUser(){

        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteAllUserFromDB());
    }



    @PutMapping("/usersinfo")
    public ResponseEntity updateUserInfoToDB(@RequestBody UserRequest userRequest){

       return ResponseEntity.status(HttpStatus.OK).body(userService.updateUserInfoToDataBase(userRequest));
    }



}
