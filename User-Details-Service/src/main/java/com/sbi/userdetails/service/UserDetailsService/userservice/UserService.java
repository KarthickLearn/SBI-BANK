package com.sbi.userdetails.service.UserDetailsService.userservice;

import com.sbi.userdetails.service.UserDetailsService.Entity.User;
import com.sbi.userdetails.service.UserDetailsService.expectionHandling.UserNameAlreadyTaken;
import com.sbi.userdetails.service.UserDetailsService.rep.UserDetailRepo;
import com.sbi.userdetails.service.UserDetailsService.userdto.UpdateRequestResponse;
import com.sbi.userdetails.service.UserDetailsService.userdto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserDetailRepo userDetailRepo;

    public  String deleteAllUserFromDB() {

        userDetailRepo.deleteAll();

    return "Deleted All Users from DB!!!";
    }


    public String saveUserInfoToDataBase(UserRequest userRequest){


          if(userDetailRepo.findByuserName(userRequest.getUserName()).isPresent()){
              throw new UserNameAlreadyTaken("The Given User Name already Taken!!");
          }

        User user
                = User.builder()
                .userName(userRequest.getUserName())
                .debit(BigDecimal.valueOf(0.00))
                .balanceAmount(BigDecimal.valueOf(0.00))
                .credit(BigDecimal.valueOf(0.00))
                .totalAmount(BigDecimal.valueOf(0.00))
                .city(userRequest.getCity())
                .country(userRequest.getCountry())
                .emailId(userRequest.getEmailId())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .state(userRequest.getState())
                .doorNumber(userRequest.getDoorNumber())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .middleName(userRequest.getMiddleName())
                .pinCode(userRequest.getPinCode())
                .password(userRequest.getPassword())
                .streetName(userRequest.getStreetName())
                .phoneNumber(userRequest.getPhoneNumber())
                .createdAt(Instant.now())
                .updatedAt(Instant.now()).build();


        userDetailRepo.save(user);


        return "The Given User saved Successfully!!!";
    }


    public Optional<User> getUserInfoFormDBByusername(String username) {


            if (!userDetailRepo.findByuserName(username).isPresent()) {
                throw new UserNameAlreadyTaken("The Given User Name Not Found!!");
            }
        return userDetailRepo.findByuserName(username);




        }


    public List<User> getAllUserinfoFromDB() {

        return userDetailRepo.findAll();

    }

    public String deleteUserFromDB(String username) {


        if (!userDetailRepo.findByuserName(username).isPresent()) {
            throw new UserNameAlreadyTaken("The Given User Name  Not Stored in DB!!");
        }

        User user = userDetailRepo.findByuserName(username).get();
        userDetailRepo.delete(user);

        return "The given user successfully deleted from database!!!";
    }

    public UpdateRequestResponse updateUserInfoToDataBase(UserRequest userRequest) {

        if (!userDetailRepo.findByuserName(userRequest.getUserName()).isPresent()) {
            throw new UserNameAlreadyTaken("The Given User Name  Not Stored in DB!!, Kindly do the save call!!");
        }

        User exuser = mapToUser(userRequest.getUserName());
        UpdateRequestResponse updateRequestResponse = new UpdateRequestResponse(exuser,null);

        User user
                = User.builder()
                .id(exuser.getId())
                .userName(userRequest.getUserName())
                .debit(BigDecimal.valueOf(0.00))
                .balanceAmount(BigDecimal.valueOf(0.00))
                .credit(BigDecimal.valueOf(0.00))
                .totalAmount(BigDecimal.valueOf(0.00))
                .city(userRequest.getCity())
                .country(userRequest.getCountry())
                .emailId(userRequest.getEmailId())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .state(userRequest.getState())
                .doorNumber(userRequest.getDoorNumber())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .middleName(userRequest.getMiddleName())
                .pinCode(userRequest.getPinCode())
                .password(userRequest.getPassword())
                .streetName(userRequest.getStreetName())
                .phoneNumber(userRequest.getPhoneNumber())
                .createdAt(exuser.getCreatedAt())
                .updatedAt(Instant.now()).build();



       userDetailRepo.save(user);
        updateRequestResponse.setAfterUpdating(user);

        return updateRequestResponse;
    }

    public User mapToUser(String userName) {
     User userRequest = userDetailRepo.findByuserName(userName).get();

                User user
                = User.builder()
                .id(userRequest.getId())
                .userName(userRequest.getUserName())
                .debit(BigDecimal.valueOf(0.00))
                .balanceAmount(BigDecimal.valueOf(0.00))
                .credit(BigDecimal.valueOf(0.00))
                .totalAmount(BigDecimal.valueOf(0.00))
                .city(userRequest.getCity())
                .country(userRequest.getCountry())
                .emailId(userRequest.getEmailId())
                .alternativePhoneNumber(userRequest.getAlternativePhoneNumber())
                .state(userRequest.getState())
                .doorNumber(userRequest.getDoorNumber())
                .firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .middleName(userRequest.getMiddleName())
                .pinCode(userRequest.getPinCode())
                .password(userRequest.getPassword())
                .streetName(userRequest.getStreetName())
                .phoneNumber(userRequest.getPhoneNumber())
                .createdAt(userRequest.getCreatedAt())
                .updatedAt(userRequest.getUpdatedAt()).build();



        return user;

    }
}
