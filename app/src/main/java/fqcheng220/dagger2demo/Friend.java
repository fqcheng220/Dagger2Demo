package fqcheng220.dagger2demo;

import fqcheng220.dagger2demo.component.FriendComponent;
import fqcheng220.dagger2demo.component.ManComponent;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 19:49
 */

public class Friend {

  public Vehicle mVehicle;

  private FriendComponent mFriendComponent;

  public Friend(){
    System.out.println("Friend constructor:this is a Friend");
  }

  public Friend(ManComponent manComponent){
    System.out.println("Friend constructor:this is a Friend from manComponent");
    mFriendComponent = manComponent.friendComponent().build();
    mFriendComponent.inject(this);
    System.out.println("Friend constructor:this is a Friend from manComponent mCar="+mCar);
  }

  @Inject
  public Car mCar;
}
