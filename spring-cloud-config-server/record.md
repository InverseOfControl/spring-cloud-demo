1.Environment Repository
{application}, which maps to spring.application.name on the client side.
{profile}, which maps to spring.profiles.active on the client (comma-separated list).
{label}, which is a server side feature labelling a "versioned" set of config files.
2.@RefreshScope-添加此注解，只能刷新@ConfigurationProperties的Bean。
3.Spring Profile 用于程序运行时，Maven Profile 用于程序编译时。
4.ConfigurableEnvironment、AbstractApplicationContext、BeanDefinitionRegistry
