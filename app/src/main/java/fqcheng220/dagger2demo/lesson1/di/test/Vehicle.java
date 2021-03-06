package fqcheng220.dagger2demo.lesson1.di.test;

import fqcheng220.dagger2demo.lesson1.di.scope.FriendScope;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 19:46
 */
@FriendScope
public class Vehicle {
  private final String TAG = getClass().getSimpleName();
  @Inject
  public Vehicle(){
    Logger.d(TAG,"constructor:this is a Vehicle"+this);
  }
}
