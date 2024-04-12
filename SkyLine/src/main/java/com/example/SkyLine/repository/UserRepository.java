package com.example.SkyLine.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SkyLine.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}