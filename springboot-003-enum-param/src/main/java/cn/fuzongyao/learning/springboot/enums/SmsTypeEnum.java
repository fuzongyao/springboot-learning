package cn.fuzongyao.learning.springboot.enums;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-11-21 20:17
 * @since 1.0
 */
public enum SmsTypeEnum implements IEnum<Integer, String> {
    /**
     *
     */
    REGISTER(1, "注册"), LOGIN(2, "登录");
    private Integer value;
    private String key;

    SmsTypeEnum(Integer value, String key) {
        this.value = value;
        this.key = key;
    }

    /**
     * value
     *
     * @return
     */
    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getKey() {
        return this.key;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SmsTypeEnum{");
        sb.append("value=").append(value);
        sb.append(", key='").append(key).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
