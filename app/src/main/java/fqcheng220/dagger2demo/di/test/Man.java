package fqcheng220.dagger2demo.di.test;

import fqcheng220.dagger2demo.di.component.DaggerManComponent;
import fqcheng220.dagger2demo.di.component.ManComponent;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 17:50
 */
public class Man {
  private final String TAG = getClass().getSimpleName();

  @Inject
  public Car mCar;

  private ManComponent mManComponet;

  public Man() {
    Logger.d(TAG,"constructor");
    mManComponet = DaggerManComponent.builder().build();
    mManComponet.randomNameSetCar(this);
    Logger.d(TAG,"mCar=" + mCar);
    mManComponet.randomNameSetCar(this);
    Logger.d(TAG,"mCar=" + mCar);

    Bike bike1 = mManComponet.exposureBike();
    Logger.d(TAG,"bike1=" + bike1);
    Bike bike2 = mManComponet.exposureBike();
    Logger.d(TAG,"bike2=" + bike2);
    Logger.d(TAG,"(bike2==bike1)=" + (bike2 == bike1));
    //
    ////Friend friend = new Friend();
    ////mManComponet.inject(friend);
    //Friend friend = new Friend();
    //FriendComponent friendComponent = mManComponet.friendComponent()/*.setFriendModule(new FriendModule(""))*/.build();
    //friendComponent.inject(friend);
    //System.out.println("friend.mCar="+friend.mCar+",mVehicle="+friend.mVehicle);
    //friendComponent.inject(friend);
    //System.out.println("inject twice friend.mCar="+friend.mCar+",mVehicle="+friend.mVehicle);
    //
    //Son son = new Son();
    //SonComponent sonComponent= mManComponet.getSonComponent(new SonModule("test"));
    //sonComponent.inject(son);
    //System.out.println("son.mCar="+son.mCar);
    //sonComponent.inject(son);
    //System.out.println("inject twice son.mCar="+son.mCar);
    //
    //Son another = new Son();
    //SonDepComponent sonDepComponent = DaggerSonDepComponent.builder().sonDepModule(new SonDepModule("test")).manComponent(mManComponet).build();
    //sonDepComponent.inject(another);
    //System.out.println("another.mCar=" + another.mCar);
  }

  public ManComponent getmManComponet() {
    return mManComponet;
  }
}
