package cn.fuzongyao.learning.springboot.service;

import cn.fuzongyao.learning.springboot.entity.UserDO;
import cn.fuzongyao.learning.springboot.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author fuzongyao
 * @date 2019-10-29 23:21
 * @since 1.0
 */
@Service
public class UserService extends ServiceImpl<UserMapper, UserDO> {
}
