package com.example.demo.controller;

import com.example.demo.dto.PageDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.UserService;
import com.example.demo.utils.BeanUtils;
import com.example.demo.vo.Result;
import com.example.demo.vo.Result4Page;
import com.example.demo.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description: 用户相关接口
 * @author: divingLee
 * @date: 2018/11/29 11:22
 */
@RestController
@Slf4j
@Api(value = "用户")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("user")
    @ApiOperation(value = "添加用户", httpMethod = "POST")
    @ResponseStatus(HttpStatus.CREATED)
    public Result addUser(@RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult.getFieldError().getDefaultMessage());
            throw new BusinessException(bindingResult.getFieldError().getDefaultMessage());
        }
        userService.save(userDTO);
        return Result.success();
    }

    @DeleteMapping("/user/{id}")
    @ApiOperation(value = "删除用户", httpMethod = "DELETE")
    //204 代表请求成功且没有返回值的
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@NotEmpty @PathVariable("id") Long id) {
        userService.delete(Arrays.asList(id));
    }

    @PutMapping("/user/{id}")
    @ApiOperation(value = "更新用户", httpMethod = "PUT")
    @ResponseStatus(HttpStatus.OK)
    public Result updateUser(@NotEmpty @PathVariable("id") Long id, @RequestBody @Valid UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult.getFieldError().getDefaultMessage());
            throw new BusinessException(bindingResult.getFieldError().getDefaultMessage());
        }
        userService.update(id, userDTO);
        return Result.success();
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "根据 id 查询用户", httpMethod = "GET")
    @ResponseStatus(HttpStatus.OK)
    public Result getUser(@NotEmpty @PathVariable("id") Long id) {
        UserVO user = userService.findById(id);
        if (user == null) {
            throw new NotFoundException("不存在 id 为 " + id + " 的用户");
        }
        return Result.successWithData(user);
    }

    @GetMapping("/users")
    @ApiOperation(value = "分页查询所有用户", httpMethod = "GET")
    @ResponseStatus(HttpStatus.OK)
    public Result4Page getUsers(@Valid PageDTO pageDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info(bindingResult.getFieldError().getDefaultMessage());
            throw new BusinessException(bindingResult.getFieldError().getDefaultMessage());
        }
        Page<User> page = userService.findAll(PageRequest.of(pageDTO.getPage(), pageDTO.getPageNum()));
        List<UserVO> userVOs = page.getContent()
                .stream()
                .map(user -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyPropertiesIgnoreNullValue(user, userVO);
                    return userVO;
                })
                .collect(Collectors.toList());
        return Result4Page.success(userVOs, page.getTotalElements());
    }
}
