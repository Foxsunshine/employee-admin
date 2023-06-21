# 👩‍💻mysql + springboot3 + vue3 实现 CRUD

这个项目主要的学习重点为以下：
1,通过前端向后端发送请求实现基础 CRUD（新增，读取，更新，删除）功能。
2,实现分页功能
3,实现邮箱验证功能
4,实现图片上传，读取服务器图片功能。

## 项目运行方式

1. 运行 employees-springboot-server 文件夹下 employee-reset.sql,初始化测试数据
2. 改变运行 employees-springboot-server/src/main/resources 的配置

`````spring.datasource.url=jdbc:mysql://localhost:3306/[你的 database 名字]
spring.datasource.username=[你的用户名]
spring.datasource.password=[你的密码]```

3. 通过 maven 启动服务器，在终端(terminal)输入`mvn spring-boot:run`
4. 打开 employees-admin 文件在，通过终端(terminal)启动前端服务器

````npm install
npm run dev```

## ❤️❤️
`````
