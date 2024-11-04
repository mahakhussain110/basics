package com.example.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.test.model.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {

}
