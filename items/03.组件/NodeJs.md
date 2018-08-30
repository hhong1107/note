

[中文API网站](https://github.com/swagger-api/swagger-codegen)

-[ECMAScript 6 入门](http://es6.ruanyifeng.com/)

[在 Express 中提供静态文件](http://expressjs.com/zh-cn/starter/static-files.html)

-[基于Swagger接口，使用nodejs开发微服务的步骤](https://blog.csdn.net/sd2131512/article/details/53765971)



> 方法一：使用swagger-node组件
>
> 参考https://scotch.io/tutorials/speed-up-your-restful-api-development-in-node-js-with-swagger
> https://github.com/swagger-api/swagger-node
>
> 
>
> 优点：可以使用express或其他框架自动生成代码，修改代码后不重启也直接生效。
> 问题：好像只能生成标准的代码框架，也就是写自己的接口时，代码不能重新生成？
>
> 
>
> 方法二：使用codegen生成代码
> https://github.com/swagger-api/swagger-codegen
>
> 优点：可以使用编写好的swagger yaml直接生成代码
> 缺点：不能选择express等框架，此外需要额外使用Node Supervisor实现不重启代码自动生效
> http://blog.sina.com.cn/s/blog_6f72ff900102wm37.html