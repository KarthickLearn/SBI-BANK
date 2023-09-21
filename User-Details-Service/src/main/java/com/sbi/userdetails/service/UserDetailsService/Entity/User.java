package com.sbi.userdetails.service.UserDetailsService.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="firstname")
    private String firstName;
    @Column(name="lastname")
    private String lastName;
    @Column(name="middleman")
    private String middleName;
    @Column(name = "username")
    @NotBlank(message = "username can not be blank")
    private String userName;
    @Column(name="email_id")
    @Email(message = "given Email id is incorrect")
    private String emailId;
    @Column(name = "password")
    @NotBlank(message = "password can not be blank")
    private String password;
    private BigDecimal debit;
    private BigDecimal credit;
    @Column(name = "balance_amount")
    private BigDecimal balanceAmount;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "alternative_phone_number")
    private Long alternativePhoneNumber;
    @Column(name = "door_number")
    private Long doorNumber;
    @Column(name = "street_name")
    private String streetName;
   @NotBlank(message = "city can not be blank")
    private String city;
   @NotBlank(message = "state can not be blank")
    private String state;
   @NotBlank(message = "country can not be blank")
    private String country;

    @Column(name = "pin_code")
    @NotBlank(message = "pin code can not blank")

    private String pinCode;


    @Column(name = "created_at")
    private Instant createdAt;
    @Column(name = "updated_at")
    private Instant updatedAt;

    public User(long l, String karthick, String b, String s, String karthick1, String mail, String asdfasdf) {
    }
}
