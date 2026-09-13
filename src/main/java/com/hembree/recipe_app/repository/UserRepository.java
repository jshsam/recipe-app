package com.hembree.recipe_app.repository;


import com.hembree.recipe_app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}