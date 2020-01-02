package fqcheng220.dagger2demo.lesson2.di.bean;

import fqcheng220.dagger2demo.lesson2.di.scope.ActivityAScope;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (对于构造函数提供依赖的如果限定作用域 只能在类名上加scope，这是跟方法提供依赖的区别)
 * @date 2020/1/2 13:21
 */
@ActivityAScope
public class ActivityABean {
  private AppBean mAppBean;

  @Inject
  public ActivityABean(AppBean appBean){
    mAppBean = appBean;
  }
}
