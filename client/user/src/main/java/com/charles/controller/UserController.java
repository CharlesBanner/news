package com.charles.controller;

import com.charles.model.request.LoginRequest;
import com.charles.model.request.RegisterRequest;
import com.charles.model.response.TokenResponse;
import com.charles.result.SingleResult;
import com.charles.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public SingleResult<TokenResponse> login(@Valid @RequestBody LoginRequest request, BindingResult result){
        validate(result);
        return userService.login(request);
    }

    @RequestMapping("/register")
    public SingleResult<TokenResponse> register(@Valid @RequestBody RegisterRequest request, BindingResult result){
        validate(result);
        return userService.register(request);
    }

}
