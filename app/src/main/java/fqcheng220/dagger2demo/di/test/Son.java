package fqcheng220.dagger2demo.di.test;

import fqcheng220.dagger2demo.di.component.DaggerSonDepComponent;
import fqcheng220.dagger2demo.di.component.ManComponent;
import fqcheng220.dagger2demo.di.component.SonComponent;
import fqcheng220.dagger2demo.di.component.SonDepComponent;
import fqcheng220.dagger2demo.di.module.SonDepModule;
import fqcheng220.dagger2demo.di.module.SonModule;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/12 11:04
 */

public class Son {
  private final String TAG = getClass().getSimpleName();
  private SonComponent mSonComponent;
  @Inject
  public Car mCar;

  @Inject
  public String mExclusiveGift;

  public Son(){
    System.out.println("constructor:default");
  }

  public Son(ManComponent manComponent){
    Logger.d(TAG,"constructor");
    SonComponent sonComponent= manComponent.getSonComponent(new SonModule("test"));
    sonComponent.inject(this);
    Logger.d(TAG,"mCar="+this.mCar);
    sonComponent.inject(this);
    Logger.d(TAG,"inject twice mCar="+this.mCar);
  }

  public Son(ManComponent manComponent,boolean bDep){
    Logger.d(TAG,"constructor dep");
    SonDepComponent sonDepComponent = DaggerSonDepComponent.builder().sonDepModule(new SonDepModule("test")).manComponent(manComponent).build();
    sonDepComponent.inject(this);
    Logger.d(TAG,"mCar=" + this.mCar);
  }
}
