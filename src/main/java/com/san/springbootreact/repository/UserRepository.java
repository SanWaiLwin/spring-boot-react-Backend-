package com.san.springbootreact.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.san.springbootreact.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<?> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
