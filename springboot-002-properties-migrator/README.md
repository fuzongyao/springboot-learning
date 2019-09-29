# springboot-001-helloworld
从较早版本的Spring Boot升级

# 目标
展示在升级Spring Boot 2.0+新版本过程中，如何使用spring-boot-properties-migrator为项目临时迁移属性

# 概述
升级到新功能版本时，某些属性可能已被重命名或删除。Spring Boot提供了一种在启动时分析应用程序环境并打印诊断的方法，而且还可以在运行时为您临时迁移属性。

# 步骤
1. 引入 spring-boot-properties-migrator 的maven坐标
2. 创建一个Spring Boot启动类
3. 创建配置文件application.yml，使用旧版Spring Boot的属性配置写法

# 启动
启动 Spring Boot，查看启动窗口的输出