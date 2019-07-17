1.SpringCloud上下文和SpringBoot的上下文的关系
结论：SpringCloud的上下文优先于Spring的上下文加载，所有跟SpringCloud相关的配置应该配置在bootstrap.properties文件中
比如 spring.cloud.bootstrap.enabled 配置在application.properties文件中是无效的。
如果想覆盖bootstrap.properties，需要更高的优先级，比如启动参数。
证明：
SpringCloud上下文
通过BootstrapApplicationListener创建bootstrap上下文，加载顺序为 Ordered.HIGHEST_PRECEDENCE + 5 
SpringBoot上下文
通过ConfigFileApplicationListener加载配置文件，加载顺序为 Ordered.HIGHEST_PRECEDENCE + 10

2.SpringBoot加载机制
通过EventPublishingRunListener发布事件，通过ConfigFileApplicationListener监听，进行环境和上下文的装载。

3.配置文件 
官方文档：https://cloud.spring.io/spring-cloud-static/Greenwich.SR2/single/spring-cloud.html#customizing-bootstrap-properties
2.3 Changing the Location of Bootstrap Properties
2.4 Overriding the Values of Remote Properties
2.5 Customizing the Bootstrap Configuration
2.6 Customizing the Bootstrap Property Sources

4.Environment、PropertySources、PropertySources的关系



