- [Spring在代码中获取bean的几种方式](http://www.dexcoder.com/selfly/article/326)
- [spring 几种获得bean的方法](http://jitaguizhao.iteye.com/blog/223832)



- [Spring 表达式语言之 SpEL 语法](http://www.importnew.com/17724.html)
- [Spring 表达式语言(SpEL)](http://sxlkk.iteye.com/blog/2168423)
- [解决 @ResponseBody返回中文字符串乱码以及生僻字被强制以unicode方式显示问题](http://blog.csdn.net/psu_vjd/article/details/52453404)
- []()
- []()
- []()
- []()
- []()
- []()
- []()


- 过滤返回是null的字段：一，二两种方式会导致入参必须是请求类中定义的字段 不能多
  - 第一种方式
```
<mvc:annotation-driven>
        <!-- 强化参数接收 -->
        <mvc:argument-resolvers>
            <bean class="org.durcframework.common.form.FormModelMethodArgumentResolver" />
        </mvc:argument-resolvers>

        <mvc:message-converters>  
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">  
                <property name="objectMapper">  
                    <bean class="com.fasterxml.jackson.databind.ObjectMapper">
                        <!-- 处理responseBody 里面日期类型 -->
                        <property name="dateFormat">  
                            <bean class="java.text.SimpleDateFormat">  
                                <constructor-arg type="java.lang.String" value="yyyy-MM-dd HH:mm:ss" />  
                            </bean>  
                        </property>
                        <!-- 为null字段时不显示 -->
                        <property name="serializationInclusion">
                            <value type="com.fasterxml.jackson.annotation.JsonInclude.Include">NON_NULL</value>
                        </property>
                    </bean>  
                </property>  
            </bean>  
        </mvc:message-converters>  
    </mvc:annotation-driven>

```
- 第二种
```
@Configuration
public class SpringMVCConf {

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // 去掉返回时 null 的字段 节省流量
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }
}

```
- 第三种方式
```
返回对象上加
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
```
