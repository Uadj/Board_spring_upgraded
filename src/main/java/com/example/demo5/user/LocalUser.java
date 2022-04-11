package com.example.demo5.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class LocalUser {
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public LocalUser(Long id, String name, Long password, String email, String picture){
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = Role.USER;
        this.password = password;
    }
    public LocalUser update(String name, String picture){
        this.name = name;
        this.picture = picture;
        return this;
    }
    public String getRoleKey(){
        return this.role.getKey();
    }

}
