package cn.fuzongyao.learning.springboot.service;

import cn.fuzongyao.learning.springboot.entity.AddressDO;
import cn.fuzongyao.learning.springboot.mapper.AddressMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends ServiceImpl<AddressMapper, AddressDO> {
}
