




# 1.三大组成部分
 - @inject  成员属性上 不能为private（依赖需求方）
   - @Component 只能标注接口或抽象类（依赖桥接器）
     - @Module （依赖提供方）
     - @Provides  只能标注方法，必须在 Module 中（依赖提供方）
     - @inject  构造函数上 优先级低于@Module（依赖提供方）

2.依赖需求方 （1，1） 依赖桥接器 （1，n）依赖提供方

# 2.依赖生命周期管理

## 1. 依赖实例生命周期绑定之  @Scope
其实是让生成的依赖实例的生命周期与 Component 绑定，Component不消亡则依赖实例一直存在

 1. 使用元注解@Scope自定义任意名字新注解RandomScope
 2. 在Component类名上标注@RandomScope在Module的Provider方法上加注解@RandomScope
             ////3.如果需要注入依赖类成员上 则也要加注解@RandomScope(不需要)
    跟javax包中@Sington注解功能一致

## 2. 依赖实例共享之 @SubComponent
使用方式一：

 1. 在子Component类名上加注解@Subcomponent，定义内部接口，提供返回类型为子Component类的方法

 2. 在父Component接口里加方法
                   子Component类名.Builder 方法名();

 3. 在父Component关联的提供依赖的Module类上加注解
                @Module(subcomponents = 子Component类名.class)
   调用方式

```
ManComponent manComponent = DaggerManComponent.builder().build();
FriendComponent friendComponent = manComponent.friendComponent().build();
friendComponent.inject(friend);·
```

使用方式二（个人推荐）：

 1. 在子Component类名上加注解@Subcomponent

 2. 在父Component接口里加方法
                   子Component 任意方法名(需要的Module入参)   
                   入参是可选项 如果子Component没有指定Module注解或者Module类有默认构造函数 则不需指定入参，否则需要指定
                   如`SonComponent getSonComponent(SonModule sonModule);`
```
ManComponent manComponent = DaggerManComponent.builder().build();
SonComponent  sonComponent = manComponent.getSonComponent(new SonModule("test"));
sonComponent.inject(son);·
```

## 3. 依赖实例共享之 Component 中的dependencies声明
功能与@SubComponent一致 
用法差异点：
1.**父Component必须显式暴露子Component需要的依赖**（虽然module已经有提供依赖）
2.子Component需要跟父Component标注不同的scope（如果父Component声明了scope的话，子Component必须声明）
3.子Component的Scope 不能是 @Singleton

使用方式：
1.子Component类名加注解@Component(dependecies=父组件.class)
2.父Component提供暴露子Component需要的依赖的方法
   如Car exposureCar();//专为SonDepComponent添加

    Son another = new Son();
    SonDepComponent sonDepComponent = DaggerSonDepComponent.builder().sonDepModule(new SonDepModule("test")).manComponent(mManComponet).build();
    sonDepComponent.inject(another);

# 3.依赖对象图构建
依赖实例往往是需要依赖其他依赖实例的
构建过程：

 1. 查询component所有接口方法的返回出参   依次按照module provide返回类型、inject构造函数匹配的优先顺序去递归寻找依赖实例之间的依赖关系
 2. 查询component所有接口方法中所有入参 去入参类中寻找inject标注的成员 根据成员类型   依次按照module provide返回类型、inject构造函数匹配的优先顺序去递归寻找依赖实例之间的依赖关系
 3. 1和2的顺序不是串行

# isssue

 1. 同一个module不同的方法 是否可以用不同的scope标注？（可以，同一个module中的不同方法可以添加不同的scope标注 但是要求相应的component也必须包含所有scope标注，否则编译错误）  
    component是否可以加多种scope标注支持？（可以）
 2. 不相干的component可以分别拥有相同类型的module实例 所以同一个module相同的方法
    是否可以用不同的scope标注？（测试不能，每个module方法只能有一个scope标注，否则编译错误）
 3. depenencies 父子component为什么需要两个不同的scope标注？从源码角度解答
 4. 自定义scope注解不能添加在@Inject标注的构造函数上？？？？？（测试是不能！但是可以加在类上
    不可以加在构造函数上，否则编译错误）
 5. module复用 component拆分的最佳实践？？？

参考
https://github.com/google/dagger  （官网）
https://www.jianshu.com/p/9703a931c7e7
https://github.com/xitu/gold-miner/blob/master/TODO/Dependency-Injection-with-Dagger-2.md