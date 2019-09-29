# springboot-001-helloworld
开发您的第一个Spring Boot应用程序

# 目标
展示如何使用Spring Boot构建web应用程序

# 概述
相对于传统的spring mvc项目，基于Spring Boot构建web应用程序，简单、快速，可以说只需一个main方法，一句Java代码，
即可启动一个web应用程序，省去了spring mvc很多繁琐的配置。

# 步骤
1. 引入 spring-boot-starter-web 的 maven 坐标
2. 创建一个类 HelloWorldApplication 和 main 方法，方法体里只有一句代码 SpringApplication.run(HelloWorldApplication.class, args);
3. 使用 @EnableAutoConfiguration 注释开启自动配置
4. 使用 @RestController 和 @RequestMapping 注释提供“路由”的信息

# 启动
在idea中直接对类 HelloWorldApplication 右击 > run / debug，即可启动Spring Boot，默认是8080端口，直接在浏览器中访问 http://localhost:8080/ 即可看到效果。