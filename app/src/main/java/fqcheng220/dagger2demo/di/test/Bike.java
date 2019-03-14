package fqcheng220.dagger2demo.di.test;

import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 17:58
 */

public class Bike {
  private final String TAG = getClass().getSimpleName();
  @Inject
  public Bike(){
    Logger.d(TAG,"constructor:this is a bike from constructor");
  }

  public Bike(String msg){
    Logger.d(TAG,"constructor:"+msg);
  }
}
