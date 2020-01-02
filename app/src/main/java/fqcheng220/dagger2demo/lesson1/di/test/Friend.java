package fqcheng220.dagger2demo.lesson1.di.test;

import fqcheng220.dagger2demo.lesson1.di.component.FriendComponent;
import fqcheng220.dagger2demo.lesson1.di.component.ManComponent;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 19:49
 */

public class Friend {

  private final String TAG = getClass().getSimpleName();
  @Inject
  public Vehicle mVehicle;

  private FriendComponent mFriendComponent;

  public Friend(){
    Logger.d(TAG,"constructor:this is a Friend");
  }

  public Friend(ManComponent manComponent){
    Logger.d(TAG,"constructor");
    FriendComponent friendComponent = manComponent.friendComponent()/*.setFriendModule(new FriendModule(""))*/.build();
    friendComponent.inject(this);
    Logger.d(TAG,"mCar="+this.mCar+",mVehicle="+this.mVehicle);
    friendComponent.inject(this);
    Logger.d(TAG,"inject twice friend.mCar="+this.mCar+",mVehicle="+this.mVehicle);
  }

  @Inject
  public Car mCar;
}
