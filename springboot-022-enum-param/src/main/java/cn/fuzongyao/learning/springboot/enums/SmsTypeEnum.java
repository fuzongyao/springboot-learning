package cn.fuzongyao.learning.springboot.enums;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-11-21 20:17
 * @since 1.0
 */
public enum SmsTypeEnum implements IEnum<Integer> {
    /**
     * 注册
     */
    REGISTER(1),
    LOGIN(2);
    private Integer value;

    SmsTypeEnum(Integer value) {
        this.value = value;
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
}
