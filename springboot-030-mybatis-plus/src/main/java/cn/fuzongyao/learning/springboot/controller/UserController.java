package cn.fuzongyao.learning.springboot.controller;

import cn.fuzongyao.learning.springboot.entity.UserDO;
import cn.fuzongyao.learning.springboot.mapper.UserMapper;
import cn.fuzongyao.learning.springboot.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-10-29 23:17
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("list")
    public List<UserDO> list() {
        return userService.list();
    }

    @GetMapping("page")
    public IPage<UserDO> page() {
        return userService.page(new Page<>(1, 10));
    }

    @PostMapping("insert")
    public UserDO insert(UserDO userDO) {
        userService.save(userDO);
        return userDO;
    }

    @PostMapping("delete")
    public String delete(Long id) {
        userService.removeById(id);
        return "success";
    }

    @PostMapping("deleteByMapper")
    public String deleteByMapper(Long id) {
        userMapper.deleteById(id);
        return "success";
    }
}
