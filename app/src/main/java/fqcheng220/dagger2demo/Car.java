package fqcheng220.dagger2demo;

import javax.inject.Inject;

import fqcheng220.dagger2demo.scope.RandomScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 17:50
 */

public class Car {
  private EngineGenerator mEngineGenerator;
  @Inject
  public Car(){
    System.out.println("this is a car");
  }

  /**
   * 如果car构造函数发生变更 所有需要car依赖的需求方 不用更改代码！！！
   * 只需要在提供car依赖项的module方法中修改即可
   * @param engineGenerator
   */
  public Car(EngineGenerator engineGenerator){
    mEngineGenerator = engineGenerator;
    System.out.println("this is a car that needs EngineGenerator");
  }
}
