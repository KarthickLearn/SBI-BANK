package com.sbi.userdetails.service.UserDetailsService.userservice;

import com.sbi.userdetails.service.UserDetailsService.Entity.User;
import com.sbi.userdetails.service.UserDetailsService.rep.UserDetailRepo;
import com.sbi.userdetails.service.UserDetailsService.userdto.UpdateRequestResponse;
import com.sbi.userdetails.service.UserDetailsService.userdto.UserRequest;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserDetailRepo userDetailRepo;

    @Captor
    ArgumentCaptor<User> argumentCaptor;
    @Test
    @DisplayName("Get user details info from database")
    void getUserInfoFormDBByUsername() {

        UserService userService = new UserService(userDetailRepo);
        User user = User.builder()
                .id(1L)
                .userName("karthick")
                .build();
        Mockito.when(userDetailRepo.findByuserName("karthick")).thenReturn(Optional.of(user));
        Assertions.assertEquals(userService.getUserInfoFormDBByusername("karthick").get().getId(), Optional.of(user).get().getId());

    }


    @Test
    @DisplayName("save user info to db")
    public void saveUserdataintoDB(){

        UserService userService = new UserService(userDetailRepo);
        UserRequest user = UserRequest.builder()
                            .userName("karthick")
                            .build();
        User saveduser = User.builder()
                        .userName(user.getUserName())
                         .build();


        userService.saveUserInfoToDataBase(user);
        Mockito.verify(userDetailRepo,Mockito.times(1)).save(argumentCaptor.capture());

        Assertions.assertEquals(argumentCaptor.getValue().getUserName(),"karthick");

    }

    @Test
    @DisplayName("map to user data based on username")
    public void mapTOUser(){


        UserService userService = new UserService(userDetailRepo);

        User user = User.builder().userName("karthick").build() ;
        Mockito.when(userDetailRepo.findByuserName("karthick")).thenReturn(Optional.of(user));
        Assertions.assertEquals(
        userService.mapToUser("karthick").getUserName(),user.getUserName() );
    }


    @Test
    @DisplayName("Test updating calls")
   public  void updateUserInfoToDataBase() {

        UserService userService = new UserService(userDetailRepo);

        UserRequest userRequest = UserRequest.builder()
                .userName("karthick")
                .city("chrompet")
                .build();
        User beforeUpdating = User.builder().userName("karthick").city("chrompet").build();
        User afterUpdating = User.builder().userName("karthick").city(userRequest.getCity()).build();

        UpdateRequestResponse updateRequestResponse = UpdateRequestResponse.builder()
                .beforeUpdating(beforeUpdating)
                .AfterUpdating(afterUpdating)
                .build();

        Mockito.when(userDetailRepo.findByuserName("karthick")).thenReturn(Optional.of(beforeUpdating));
        userService.updateUserInfoToDataBase(userRequest);
        Mockito.verify(userDetailRepo,Mockito.times(1)).save(argumentCaptor.capture());

        Assertions.assertTrue(

                argumentCaptor.getValue().getCity().equals(afterUpdating.getCity()));

    }

    @Test
    @DisplayName("get All User From Data base")
    void getAllUserinfoFromDB() {

        UserService userService = new UserService(userDetailRepo);

        Mockito.when(userDetailRepo.findAll())
                .thenReturn(Arrays.asList(User.builder().userName("karthick").build(), User.builder().userName("kanmani") .build()));


        Assertions.assertEquals(2,userDetailRepo.findAll().size());




    }

    @Test
    void deleteAllUserFromDB() {
    }

    @Test
    @DisplayName("Test case for deleting user form db by username")
    void deleteUserFromDB() {

        UserService userService = new UserService(userDetailRepo);

        Mockito.when(userDetailRepo.findByuserName("kartihck")).thenReturn(Optional.of(User.builder().userName("karthick").build()));

        userService.deleteUserFromDB("karthick");
        Mockito.verify(userDetailRepo,Mockito.times(1)).delete(ArgumentMatchers.any(User.class));


    }
}