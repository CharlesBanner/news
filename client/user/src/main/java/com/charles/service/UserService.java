package com.charles.service;

import com.charles.result.Code;
import com.charles.result.SingleResult;
import com.charles.mapper.UserMapper;
import com.charles.model.bean.UserBean;
import com.charles.model.request.LoginRequest;
import com.charles.model.request.RegisterRequest;
import com.charles.model.response.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(rollbackFor = Exception.class)
@Service
public class UserService extends BaseService{

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public SingleResult<TokenResponse> login(LoginRequest request){
        List<UserBean> userList = userMapper.selectUser(request.getMobile(),request.getPassword());
        if(null != userList && userList.size() > 0){
            String token = getToken(request.getMobile(),request.getPassword());
            return responseDetail(token);
        }else {
            return SingleResult.buildFailure(Code.ERROR,"手机号或密码输入不正确！");
        }
    }

    public SingleResult<TokenResponse> register(RegisterRequest request){
        List<UserBean> userList = userMapper.selectUser(request.getMobile());
        if(null != userList && userList.size() > 0){
            String token = getToken(request.getMobile(),request.getPassword());
            return responseDetail(token);
        }else {
            return SingleResult.buildFailure(Code.ERROR,"手机号或密码输入不正确！");
        }
    }
    private SingleResult<TokenResponse> responseDetail(String token){
        TokenResponse response = new TokenResponse();
        response.setToken(token);
        return SingleResult.buildSuccess(response);
    }
}
