1.配置文件的命名规范：{applicaiton}/{profile}/{label}.properties，客户端配置的
时候要与之对应。application 是配置文件的名称，不是应用的名称。
2.配置源码类：ConfigClientProperties，看懂这个类，配置就解决了。
3.通过actuator/env 可知，配置客户端关联的配置信息优先于applicaiton.properties
4.注意配置信息放在bootstrap.properties中，由于Spring Cloud的上下文加载机制。
5.如果加载其它环境下的配置信息，默认的配置文件也会加载。如果指定加载prod环境的配置，
default环境下的配置文件也会加载。
6.动态配置Bean的属性：@ConfigurationProperties(prefix = "xxx.user")
如果要使用User配置类，通过@EnableConfigurationProperties(User.class)激活，然后在注入使用
7.查看单个属性
http://localhost:8080/actuator/env/xxx.user.id
8.动态改变属性值（单台服务可以这样，如果多台服务如果处理？）
通过postman：http://localhost:8080/actuator/env?xxx.user.id=002
9.通过postman调整配置信息，不会同步到配置服务器，因为 postman 提交的配置信息优先级是最高的。
如果修改配置服务器的信息，在客户端需要执行http://localhost:8080/actuator/env/refresh 重新连接
配置服务器获取最新配置信息。
10.自定义刷新配置方法
通过搜索RefreshEndpoint类，找到refresh方法，其实是通过ContextRefresher去实现的。我们只要注入这个
类，就可以实现。

