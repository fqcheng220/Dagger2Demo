package fqcheng220.dagger2demo;

import fqcheng220.dagger2demo.component.DaggerManComponent;
import fqcheng220.dagger2demo.component.DaggerSonDepComponent;
import fqcheng220.dagger2demo.component.FriendComponent;
import fqcheng220.dagger2demo.component.ManComponent;
import fqcheng220.dagger2demo.component.SonComponent;
import fqcheng220.dagger2demo.component.SonDepComponent;
import fqcheng220.dagger2demo.module.SonDepModule;
import fqcheng220.dagger2demo.module.SonModule;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 17:50
 */
public class Man {
  @Inject
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
    Friend friend = new Friend();
    FriendComponent friendComponent = mManComponet.friendComponent().build();
    friendComponent.inject(friend);
    System.out.println("friend.mCar="+friend.mCar);

    Son son = new Son();
    SonComponent sonComponent= mManComponet.getSonComponent(new SonModule("test"));
    sonComponent.inject(son);
    System.out.println("son.mCar="+son.mCar);

    Son another = new Son();
    SonDepComponent sonDepComponent = DaggerSonDepComponent.builder().sonDepModule(new SonDepModule("test")).manComponent(mManComponet).build();
    sonDepComponent.inject(another);
    System.out.println("another.mCar=" + another.mCar);
  }
}
