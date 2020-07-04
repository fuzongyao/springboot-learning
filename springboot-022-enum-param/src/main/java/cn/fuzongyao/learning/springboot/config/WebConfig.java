package cn.fuzongyao.learning.springboot.config;

import cn.fuzongyao.learning.springboot.enums.EnumConvertFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-11-21 21:05
 * @since 1.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private EnumConvertFactory enumConvertFactory;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(enumConvertFactory);
    }
}
