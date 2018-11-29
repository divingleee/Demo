package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.utils.BeanUtils;
import com.example.demo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 * @author: divingLee
 * @date: 2018/11/29 10:21
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyPropertiesIgnoreNullValue(userDTO, user);
        return userRepository.save(user);
    }

    @Override
    public void update(Long id, UserDTO userDTO) {
        userRepository
                .findById(id)
                .ifPresent(user -> {
                    BeanUtils.copyPropertiesIgnoreNullValue(userDTO, user);
                    userRepository.save(user);
                });
    }


    @Override
    public void delete(List<Long> ids) {
        ids
                .stream()
                .filter(aLong -> aLong != null)
                .forEach(aLong -> {
                    try {
                        userRepository.deleteById(aLong);
                    } catch (Exception e) {
                        throw new NotFoundException("删除失败，不存在 id 为 " + aLong + " 的用户");
                    }
                });
    }

    @Override
    public Page<User> findAll(PageRequest pageRequest) {
        return userRepository.findAll(pageRequest);
    }

    @Override
    public UserVO findById(Long id) {
        return userRepository
                .findById(id)
                .map(user -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyPropertiesIgnoreNullValue(user, userVO);
                    return userVO;
                })
                .orElse(null);
    }
}
