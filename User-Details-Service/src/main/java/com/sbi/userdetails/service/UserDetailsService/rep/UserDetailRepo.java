package com.sbi.userdetails.service.UserDetailsService.rep;

import com.sbi.userdetails.service.UserDetailsService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailRepo extends JpaRepository<User, Long> {

    Optional<User> findByuserName(String userName);



}
