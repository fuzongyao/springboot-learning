package cn.fuzongyao.learning.springboot.controller;

import cn.fuzongyao.learning.springboot.dto.PostDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author fuzongyao
 * @date 2020/05/18
 * @since 1.0.0
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/api/aopLog")
public class AopLogController {

    @GetMapping("list")
    public String list(Integer id, String name) throws InterruptedException {
        log.info("AopLogController.list");
        return "list";
    }

    @PostMapping("save")
    public PostDTO save(@Valid @RequestBody PostDTO postDTO) {
        return postDTO;
    }

}
