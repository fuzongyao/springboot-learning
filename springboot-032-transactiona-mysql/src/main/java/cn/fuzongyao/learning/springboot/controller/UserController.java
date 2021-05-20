package cn.fuzongyao.learning.springboot.controller;

import cn.fuzongyao.learning.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuzongyao
 * @date 2021/4/30
 * @since 1.0.0
 */
@RestController
@RequestMapping("/transactional")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/test")
    public String test() {
        userService.testTransactional();
        return "success";
    }

}
