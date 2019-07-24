场景：config client 和 config server 都注册到注册中心，
在 config server 中配置 eureka client 的信息
在 config client 中配置 config client 和 eureka client 的信息

1.eureka-client 作为 config-server 和 eureka-server 的客户端时需要注意
a.在bootstrap.properties中配置 eureka cient 的信息
b.在bootstrap.properties中配置 config cient 的信息
    
2.配置 config client 的时候，要配置下面信息：
spring.cloud.config.discovery.enabled=true
spring.cloud.config.discovery.serviceId=${spring.application.name}
参考官方文档：10.2 Discovery First Bootstrap
说明：通过上述配置，从 Eureka 注册中心获取 config server 服务实例信息，然后获取
config server 中的配置信息，而不是绑死一个IP去处理。

3.高可用配置
application.properties、application-peer1.properties、application-peer2.properties
application.properties中配置公共的信息
application-peer1.properties和application-peer2.properties 交叉配置注册信息。
通过启动参数 --spring.active.profiles=peer1 启动服务1，会加载application.properties和application.peer1.propertie配置信息

