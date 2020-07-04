package cn.fuzongyao.learning.springboot.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-11-21 20:52
 * @since 1.0
 */
public interface IEnum<T> {
    /**
     * value
     *
     * @return
     */
    @JsonValue
    T getValue();
}
