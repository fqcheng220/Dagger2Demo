1.关系
@inject  成员属性上 不能为private（依赖需求方）
       @Component 只能标注接口或抽象类（依赖桥接器）
                @Module （依赖提供方）
                @Provides  只能标注方法，必须在 Module 中（依赖提供方）
                @inject  构造函数上 优先级低于@Module（依赖提供方）

2.依赖需求方 （1，1） 依赖桥接器 （1，n）依赖提供方

3.依赖生命周期管理

依赖实例生命周期绑定之
 @Scope 
       其实是让生成的依赖实例的生命周期与 Component 绑定，Componet不消亡则依赖实例一直存在
                 1.使用元注解@Scope自定义任意名字新注解RandomScope
                 2.在Component类名上标注@RandomScope
                   在Module的Provider方法上加注解@RandomScope
                 3.如果需要注入依赖类成员上 则也要加注解@RandomScope
        跟javax @Sington注解功能一致

依赖实例共享之
@SubComponent
       父组件跟子组件scope不能相同
                 1.使用元注解@Scope自定义任意名字新注解FriendScope跟父组件scope注解不同
                 2.在子Component类名上加注解@Subcomponent
                 3.在父Component接口里加方法
                   子Component类名.Builder 方法名();
                 4.在父Component关联的提供依赖的Module类上加注解
                    @Module(subcomponents = 子Component类名.class)
                 5.调用方式
·ManComponent manComponent = DaggerManComponent.builder().build();

FriendComponent friendComponent = manComponent.friendComponent().build();
friendComponent.inject(friend);·

依赖实例共享之
Component 中的dependencies声明
