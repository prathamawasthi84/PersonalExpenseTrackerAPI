package com.example.PersonalExpenseTrackerAPI.repository;

import com.example.PersonalExpenseTrackerAPI.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.PersonalExpenseTrackerAPI.entity.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findByEmail(String email);
}
