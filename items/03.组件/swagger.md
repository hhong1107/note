## API文档

- 依赖 要使用2.5.0 的  否则无法和feign共用

```

<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger2</artifactId>
    <version>2.5.0</version>
</dependency>
<dependency>
    <groupId>io.springfox</groupId>
    <artifactId>springfox-swagger-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```
- 启用
```
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.didispace.web"))
//                .paths(PathSelectors.any())
//                .paths(PathSelectors.regex("/common/.*"))//过滤的接口

                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("账户系统 API [v1.0]")
//                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
//                .termsOfServiceUrl("http://blog.didispace.com/")
//                .contact("程序猿DD")
                .version("1.0")
                .build();
    }

```
- [访问](http://localhost:3334/swagger-ui.html)
  = 类上也要加上 @RequestMapping(value="/account")
----
- [SpringBoot之springfox  Swagger](http://my.oschina.net/wangnian/blog/666017)

- [Spring Boot中使用Swagger2构建强大的RESTful API文档](http://blog.didispace.com/springbootswagger2/)

- [spring-boot-swagger2 使用手册](https://gumutianqi1.gitbooks.io/specification-doc/content/tools-doc/spring-boot-swagger2-guide.html)

- -[如何在生产环境禁用Swagger](https://blog.csdn.net/goldenfish1919/article/details/78280051)

  -[Swagger环境搭建之非依赖代码法](https://blog.csdn.net/wantnrun/article/details/52754252)

- []()

- []()
