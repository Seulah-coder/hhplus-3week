package com.hhplus.hhplus3week.app.domain.user.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_data")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=30)
    private Long id;

    @Column(length=100)
    private String name;

    @Column(length=30)
    private String mobile;
}
