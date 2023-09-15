package com.sbi.userdetails.service.UserDetailsService.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {

    @GetMapping("index")
    public String getMassage(){
        return "finding";
    }

}
