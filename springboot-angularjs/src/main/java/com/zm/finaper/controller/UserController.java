package com.zm.finaper.controller;

import com.zm.finaper.entity.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wzhang on 30/05/2017.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/session", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String isInSession() {

        return "ok";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public User isInSession(@RequestBody User user) {

        return user;
    }
}
