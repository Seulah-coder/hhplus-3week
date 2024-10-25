package com.hhplus.hhplus3week.app.user.repositories;

import com.hhplus.hhplus3week.app.user.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u LEFT JOIN FETCH u.bookingList WHERE u.id = :id")
    User findUserByIdWithBookingList(Long id);
}
