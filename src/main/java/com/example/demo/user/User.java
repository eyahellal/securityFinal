package com.example.demo.user;

import com.example.demo.role.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "app_user")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false, unique = true)
        private  String username;
        @Column(nullable = false)
        private String firstName;
        @Column(nullable = false)
        private String lastName;
        @Column(nullable = false, unique = true)
        private Integer phoneNumber;
        @Column(nullable = false, unique = true)
        private String email;
        @Column(nullable = false)
        private String password;

        @CreatedDate
        private Date creationDate;
        @LastModifiedDate
        private Date lastModifiedDate;
        public User(String email, String password) {
                this.email = email;
                this.password = password;
        }
        @Enumerated(EnumType.STRING)
        @Column(nullable = true)
        private Role role;


        }

