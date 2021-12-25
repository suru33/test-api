package com.suru.usersapi.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "u_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "u_uuid", nullable = false)
    @org.hibernate.annotations.Type(type = "pg-uuid")
    private UUID uuid;

    @Column(name = "u_name", nullable = false)
    private String name;

    @Column(name = "u_email", nullable = false)
    private String email;

    @Column(name = "u_phone")
    private String phone;

    @Column(name = "u_active", nullable = false)
    private Boolean active = true;

    @Column(name = "u_deleted", nullable = false)
    private Boolean deleted = false;
}
