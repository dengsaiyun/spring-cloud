package com.dsy.provider.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsy.provider.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
