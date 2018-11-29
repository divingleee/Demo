package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: divingLee
 * @date: 2018/11/29 10:19
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
