package com.Lablaida.Ecommerce.Ecosystem.Multiseller.Entities;

import com.Lablaida.Ecommerce.Ecosystem.Multiseller.Enums.Role_User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private String email;

    private String fullName;
    private String mobile;

    private Role_User role=Role_User.ROLE_CUSTUMER;
    @OneToMany
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany
    @JsonIgnore
     private Set<Coupon> usedCoupoun= new HashSet<>();

}
