package cn.fuzongyao.learning.springboot.dto;

import cn.fuzongyao.learning.springboot.enums.SmsTypeEnum;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-11-21 20:19
 * @since 1.0
 */
public class SmsSendDTO {
    private String phone;
    @ApiModelProperty(value = "1:注册，2：登录")
    private SmsTypeEnum type;

    public String getPhone() {
        return phone;
    }

    public SmsSendDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public SmsTypeEnum getType() {
        return type;
    }

    public SmsSendDTO setType(SmsTypeEnum type) {
        this.type = type;
        return this;
    }
}
