package fqcheng220.dagger2demo.lesson4.di.bean;

import fqcheng220.dagger2demo.lesson4.di.scope.ActivityBScope;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (对于构造函数提供依赖的如果限定作用域 只能在类名上加scope，这是跟方法提供依赖的区别)
 * @date 2020/1/2 13:21
 */
@ActivityBScope
public class ActivityBBean {
  private AppBean mAppBean;

  @Inject
  public ActivityBBean(AppBean appBean){
    mAppBean = appBean;
  }
}
