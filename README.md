
# 1.三大组成部分
@inject  成员属性上 不能为private（依赖需求方）
       @Component 只能标注接口或抽象类（依赖桥接器）
                @Module （依赖提供方）
                @Provides  只能标注方法，必须在 Module 中（依赖提供方）
                @inject  构造函数上 优先级低于@Module（依赖提供方）

2.依赖需求方 （1，1） 依赖桥接器 （1，n）依赖提供方

# 2.依赖生命周期管理

## 1. 依赖实例生命周期绑定之  @Scope
其实是让生成的依赖实例的生命周期与 Component 绑定，Component不消亡则依赖实例一直存在

 1. 使用元注解@Scope自定义任意名字新注解RandomScope
 2. 在Component类名上标注@RandomScope在Module的Provider方法上加注解@RandomScope
             ////3.如果需要注入依赖类成员上 则也要加注解@RandomScope(不需要)
    跟javax包中@Sington注解功能一致

## 2. 依赖实例共享之 @SubComponent
   

父组件跟子组件scope不能相同

 1. 使用元注解@Scope自定义任意名字新注解FriendScope跟父组件scope注解不同

 2. 在子Component类名上加注解@Subcomponent

 3. 在父Component接口里加方法
                   子Component类名.Builder 方法名();

 4. 在父Component关联的提供依赖的Module类上加注解
                @Module(subcomponents = 子Component类名.class)
 5. 调用方式
 ManComponent manComponent = DaggerManComponent.builder().build();
    FriendComponent friendComponent = manComponent.friendComponent().build();
    friendComponent.inject(friend);·

## 3. 依赖实例共享之 Component 中的dependencies声明
功能与@SubComponent一致 子组件也是需要跟父组件标注不同的scope
只是用法不同
# 3.依赖对象图构建
依赖实例往往是需要依赖其他依赖实例的
构建过程：

 1. 查询component所有接口方法的返回出参   依次按照module provide返回类型、inject构造函数匹配的优先顺序去递归寻找依赖实例之间的依赖关系
 2. 查询component所有接口方法中所有入参 去入参类中寻找inject标注的成员 根据成员类型   依次按照module provide返回类型、inject构造函数匹配的优先顺序去递归寻找依赖实例之间的依赖关系
 3. 1和2的顺序不是串行

# isssue
1.同一个module不同的方法 是否可以用不同的scope标注？
  component是否可以加多种scope标注支持？（可以）
2.不相干的component可以分别拥有相同类型的module实例 所以同一个module相同的方法 是否可以用不同的scope标注？
3.父子component为什么需要两个不同的scope标注？从源码角度解答
4.自定义scope注解不能添加在@Inject标注的构造函数上？？？？？（测试是不能！）
