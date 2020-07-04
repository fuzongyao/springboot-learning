package cn.fuzongyao.learning.springboot.enums;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-11-21 20:57
 * @since 1.0
 */
@Component
public class EnumConvertFactory implements ConverterFactory<String, IEnum> {
    @Override
    public <T extends IEnum> Converter<String, T> getConverter(Class<T> aClass) {
        return new StringToIEnum<>(aClass);
    }

    public static <T extends IEnum> Object getIEnum(Class<T> targerType, String source) {
        for (T enumObj : targerType.getEnumConstants()) {
            if (source.equals(String.valueOf(enumObj.getValue()))) {
                return enumObj;
            }
        }
        return null;
    }

    private static class StringToIEnum<T extends IEnum> implements Converter<String, T> {
        private Class<T> targerType;

        public StringToIEnum(Class<T> targerType) {
            this.targerType = targerType;
        }

        @Override
        public T convert(String source) {
            if (StringUtils.isEmpty(source)) {
                return null;
            }
            return (T) EnumConvertFactory.getIEnum(this.targerType, source);
        }
    }
}
