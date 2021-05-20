package cn.fuzongyao.learning.springboot.service.impl;

import cn.fuzongyao.learning.springboot.repository.IUserRepository;
import cn.fuzongyao.learning.springboot.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author fuzongyao
 * @date 2021/4/30
 * @since 1.0.0
 */
@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    @Override
    public void testTransactional() {
        testPropagation();
    }

    private void testPropagation() {
        log.info("测试spring的事务传播");
        // 手动开启事务
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        // 事务传播-REQUIRED，spring默认。如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        // 事务隔离-DEFAULT，使用数据库本身使用的隔离级别，ORACLE（读已提交），MySQL（可重复读）
        transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
        transactionDefinition.setName("test-propagation");
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        log.info("有事务的时候");
        userRepository.propagationRequired();
        userRepository.propagationSupports();
        userRepository.propagationMandatory();
        userRepository.propagationRequiresNew();
        userRepository.propagationNotSupported();
        try {
            userRepository.propagationNever();
        } catch (Exception e) {
            log.info("捕获异常，Propagation.NEVER，以非事务方式执行，如果当前存在事务，则抛出异常。");
        }
        userRepository.propagationNested();
        platformTransactionManager.commit(transactionStatus);

        log.info("没有事务的时候");
        userRepository.propagationRequired();
        userRepository.propagationSupports();
        try {
            userRepository.propagationMandatory();
        } catch (Exception e) {
            log.info("捕获异常，Propagation.MANDATORY，使用当前的事务，如果当前没有事务，就抛出异常。");
        }
        userRepository.propagationRequiresNew();
        userRepository.propagationNotSupported();
        userRepository.propagationNever();
        userRepository.propagationNested();
    }

}
