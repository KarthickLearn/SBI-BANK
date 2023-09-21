package com.sbi.userdetails.service.UserDetailsService.userdto;

import com.sbi.userdetails.service.UserDetailsService.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UpdateRequestResponse {

    private User beforeUpdating;
    private User AfterUpdating;

}
