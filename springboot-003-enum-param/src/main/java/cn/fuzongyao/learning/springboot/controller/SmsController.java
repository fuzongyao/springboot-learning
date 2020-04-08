package cn.fuzongyao.learning.springboot.controller;

import cn.fuzongyao.learning.springboot.dto.SmsSendDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-11-21 20:20
 * @since 1.0
 */
@RestController
@RequestMapping("/sms")
public class SmsController {
    @PostMapping("/send")
    public SmsSendDTO send(@RequestBody SmsSendDTO smsSendDTO) {
        System.out.println(smsSendDTO);
        return smsSendDTO;
    }
}
