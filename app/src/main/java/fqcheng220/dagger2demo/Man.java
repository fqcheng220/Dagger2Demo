package fqcheng220.dagger2demo;

import fqcheng220.dagger2demo.component.DaggerManComponent;
import fqcheng220.dagger2demo.component.ManComponent;
import fqcheng220.dagger2demo.scope.RandomScope;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 17:50
 */
public class Man {
  @Inject
  @RandomScope
  public Car mCar;

  private ManComponent mManComponet;

  public Man() {
    mManComponet = DaggerManComponent.builder().build();
    mManComponet.randomNameSetCar(this);
    System.out.println("mCar=" + mCar);
    mManComponet.randomNameSetCar(this);
    System.out.println("mCar=" + mCar);

    Bike bike1 = mManComponet.exposureBike();
    System.out.println("bike1=" + bike1);
    Bike bike2 = mManComponet.exposureBike();
    System.out.println("bike2=" + bike2);
    System.out.println("(bike2==bike1)=" + (bike2 == bike1));

    //Friend friend = new Friend();
    //mManComponet.inject(friend);
    Friend friend = new Friend(mManComponet);
  }
}
