package com.semika.demo.user.repository;

import com.semika.demo.user.model.entity.User;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepositoryImplementation<User, Long> {

    //Method query example
    User findUserEntityByFirstName(String firstName);

    //Named query example
    User findByLastName(String lastName);

    //JPQL example
    @Query("SELECT user FROM User user WHERE user.firstName = :firstName AND user.lastName = :lastName")
    User findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<User> findById(Long aLong);
}
