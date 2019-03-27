/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.you.springboot.jwt.controller;


import com.you.springboot.jwt.annotation.Login;
import com.you.springboot.jwt.annotation.LoginUser;
import com.you.springboot.jwt.modules.R;
import com.you.springboot.jwt.modules.UserEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * APP测试接口
 *
 * @author Mark sunlightcs@gmail.com
 */
@RestController
@RequestMapping("/app")
//@Api("APP测试接口")
public class AppTestController {

    @Login
    @GetMapping("userInfo")
   // @ApiOperation("获取用户信息")
    public R userInfo( UserEntity user){
        return R.ok().put("user", user);
    }

    @Login
    @GetMapping("userId")
   // @ApiOperation("获取用户ID")
    public R userInfo(@RequestAttribute("userId") Integer userId){
        return R.ok().put("userId", userId);
    }

    @GetMapping("notToken")
    //@ApiOperation("忽略Token验证测试")
    public R notToken(){
        return R.ok().put("msg", "无需token也能访问。。。");
    }

}
