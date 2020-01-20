package com.san.springbootreact.repository;

import org.springframework.data.repository.CrudRepository;

import com.san.springbootreact.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
