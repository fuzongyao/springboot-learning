package cn.fuzongyao.learning.springboot.service;

import cn.fuzongyao.learning.springboot.entity.AddressDO;
import cn.fuzongyao.learning.springboot.mapper.AddressMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService extends ServiceImpl<AddressMapper, AddressDO> {

    @Autowired
    private PlatformTransactionManager platformTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @Transactional(rollbackFor = Exception.class)
    public void save() {
        // 手动开启事务
        TransactionStatus transaction = platformTransactionManager.getTransaction(transactionDefinition);
        AddressDO addressDO = new AddressDO().setId(1).setAreaId("12").setName("test12").setType(1);
        save(addressDO);
        // 提交事务
        platformTransactionManager.commit(transaction);
        int a = 1;
        int b = 0;
        int c = a / b;
    }
}
