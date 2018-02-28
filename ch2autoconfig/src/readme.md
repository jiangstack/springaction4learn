## Ch2-装配Bean

spring容器负责创建应用对象(Bean)并负责之间的协作管理,谓之装配(**Wiring**),
依赖注入(DI)的本质.spring提供了3种Wiring机制

- 组件扫描&自动装配
- Java代码手动装配
- Xml代码手动装配

### 2.1自动装配

#### 2.1.1创建Bean
Bean是普通Java对象(POJO),首先我们定义一个接口MediaPlayer,然后创建的Bean来实现
这个接口(CDPlayer implements MediaPlayer)达到去耦合的效果(面向接口编程),然后为
这个实现类添加 **@Component** 注解,向spring表明这个类是组件类.

> spring会为组件给定一个ID,为类名第一字母小写,如果想自定义可以使用 `@Component("xxxx")`
> 指定,另外一种是使用 `@Named("xxxx")`,这是基于Java依赖注入规范的注解

#### 2.1.2 Java Config
使用java代码配置自动扫描(CDPlayerConfig).@Configuration表明这是一个spring配置
类.@ComponentScan表明spring会自动扫描组件(当前配置类所在包及其子包),作用与xml配置
中`context:component-scan`类似

> 如果要指定扫描位置可以使用 `@ComponentScan(basePackages={"x1","x2",..})`
> 或者使用包下的类和接口 `@ComponentScan(basePackageClasses={X1.class,X2.class,..})` 建议使用
> 空标记接口

#### 2.1.3 注入
spring会在初始化bean尽可能的满足其依赖. `@AutoWired`可以使用在其类任何方法上(set方法,构造方法,自定义的方法)

> `@AutoWired` 标定的实现只能有一个
> `@AutoWired(required=false)` 标定的实现可以为不必须
> 可以与 `@Inject` 呼唤


#### 2.1.4 测试

`CDPlayerTest` 使用 `@RunWith(SpringJUnit4ClassRunner.class)` 在测试时创建使用spring
上下文, `@ContextConfiguration(classes=CDPlayerConfig.class)` 指定配置文件


### 2.2Java代码手动装配

在一些情况如想把第三方的类库中组件装配到应用中,无法在其类上添加自动装配所需要的 `@Component`注解和 `@Autowired`
注解,这时候就需要手动装配.
移除 `CDPlayerConfig`的 `@ComponentScan`注解不再自动扫描

#### 2.2.1 注册bean

> 在`@Configuration` 注解的spring配置类中,@Bean注解的方法表示该方法会返回一个对象,spring会将
> 此方法注册到spring上下文中.默认的ID为该方法名,可以在注解中自定义名字

#### 2.2.2 注入bean

装配cdPlayer使用 `@bean`注解,该方法调用了 `sgtPeppers()` 方法,因为@Bean注解的缘故,sgtPeppers()在
调用时总会被拦截,保持单例

2.3 xml配置
略
2.4 混合配置
略
