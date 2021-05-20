package cn.fuzongyao.learning.springboot.repository.impl;

import cn.fuzongyao.learning.springboot.entity.UserDO;
import cn.fuzongyao.learning.springboot.mapper.UserMapper;
import cn.fuzongyao.learning.springboot.repository.IUserRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @author fuzongyao
 * @date 2021/4/30
 * @since 1.0.0
 */
@Slf4j
@Repository
public class UserRepositoryImpl extends ServiceImpl<UserMapper, UserDO> implements IUserRepository {

    /**
     * 事务传播-REQUIRED，spring默认。如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void propagationRequired() {
        logTransactionName("Propagation.REQUIRED");
    }

    /**
     * 事务传播-SUPPORTS，支持当前事务，如果当前没有事务，就以非事务方式执行。
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public void propagationSupports() {
        logTransactionName("Propagation.SUPPORTS");
    }

    /**
     * 事务传播-MANDATORY，使用当前的事务，如果当前没有事务，就抛出异常。
     */
    @Override
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void propagationMandatory() {
        logTransactionName("Propagation.MANDATORY");
    }

    /**
     * 事务传播-REQUIRES_NEW，新建事务，如果当前存在事务，把当前事务挂起。
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void propagationRequiresNew() {
        logTransactionName("Propagation.REQUIRES_NEW");
    }

    /**
     * 事务传播-NOT_SUPPORTED，以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public void propagationNotSupported() {
        logTransactionName("Propagation.NOT_SUPPORTED");
    }

    /**
     * 事务传播-NEVER，以非事务方式执行，如果当前存在事务，则抛出异常。
     */
    @Override
    @Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
    public void propagationNever() {
        logTransactionName("Propagation.NEVER");
    }

    /**
     * 事务传播-NESTED，如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
     */
    @Override
    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void propagationNested() {
        logTransactionName("Propagation.NESTED");
    }

    private void logTransactionName(String propagationName) {
        String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("{}:{}", propagationName, transactionName);
    }

}
