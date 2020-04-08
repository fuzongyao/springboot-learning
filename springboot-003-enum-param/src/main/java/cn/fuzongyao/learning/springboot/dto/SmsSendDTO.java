package cn.fuzongyao.learning.springboot.dto;

import cn.fuzongyao.learning.springboot.enums.SmsTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-11-21 20:19
 * @since 1.0
 */
@ApiModel(description = "账号/密码登录入参")
public class SmsSendDTO {
    @ApiModelProperty(name = "phone", required = true, dataType = "string", value = "<b>必填</b>，手机号", example = "15626469708")
    @NotEmpty(message = "手机号不能为空")
    private String phone;
    @ApiModelProperty(name = "type", required = true, dataType = "string", value = "<b>必填</b>，类型", example = "2")
    @NotNull
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SmsSendDTO{");
        sb.append("phone='").append(phone).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
