package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.vo.UserVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @description:
 * @author: divingLee
 * @date: 2018/11/29 10:21
 */
public interface UserService {

    User save(UserDTO userDTO);

    void delete(List<Long> ids);

    void update(Long id, UserDTO userDTO);

    UserVO findById(Long id);

    Page<User> findAll(PageRequest pageRequest);
}
