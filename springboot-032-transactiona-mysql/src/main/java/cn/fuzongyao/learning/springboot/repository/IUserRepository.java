package cn.fuzongyao.learning.springboot.repository;

import cn.fuzongyao.learning.springboot.entity.UserDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author fuzongyao
 * @date 2021/4/30
 * @since 1.0.0
 */
public interface IUserRepository extends IService<UserDO> {

    /**
     * 事务传播-REQUIRED，spring默认。如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。
     */
    void propagationRequired();

    /**
     * 事务传播-SUPPORTS，支持当前事务，如果当前没有事务，就以非事务方式执行。
     */
    void propagationSupports();

    /**
     * 事务传播-MANDATORY，使用当前的事务，如果当前没有事务，就抛出异常。
     */
    void propagationMandatory();

    /**
     * 事务传播-REQUIRES_NEW，新建事务，如果当前存在事务，把当前事务挂起。
     */
    void propagationRequiresNew();

    /**
     * 事务传播-NOT_SUPPORTED，以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。
     */
    void propagationNotSupported();

    /**
     * 事务传播-NEVER，以非事务方式执行，如果当前存在事务，则抛出异常。
     */
    void propagationNever();

    /**
     * 事务传播-NESTED，如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。
     */
    void propagationNested();
    /*
     *//**
     * 事务隔离-DEFAULT，使用数据库本身使用的隔离级别，ORACLE（读已提交），MySQL（可重复读）
     *//*
    UserDO isolationDefault(Long id);

    *//**
     * 事务隔离-READ_UNCOMMITTED，读未提交（脏读）最低的隔离级别，一切皆有可能。
     *//*
    UserDO isolationReadUncommitted(Long id);

    *//**
     * 事务隔离-READ_COMMITTED，读已提交，ORACLE默认隔离级别，有幻读以及不可重复读风险。
     *//*
    UserDO isolationReadCommitted(Long id);

    *//**
     * 事务隔离-REPEATABLE_READ，可重复读，解决不可重复读的隔离级别，但还是有幻读风险。
     *//*
    UserDO isolationRepeatableRead(Long id);

    *//**
     * 事务隔离-SERIALIZABLE，串行化，最高的事务隔离级别，不管多少事务，挨个运行完一个事务的所有子事务之后
     * 才可以执行另外一个事务里面的所有子事务，这样就解决了脏读、不可重复读和幻读的问题了。
     *//*
    UserDO isolationSerializable(Long id);*/

}
