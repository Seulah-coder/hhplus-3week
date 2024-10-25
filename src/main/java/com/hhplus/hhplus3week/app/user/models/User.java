package com.hhplus.hhplus3week.app.user.models;

import com.hhplus.hhplus3week.app.booking.models.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=30)
    private Long id;

    @Column(length=100)
    private String name;

    @Column(length=30)
    private String mobile;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    List<Booking> bookingList;
}
