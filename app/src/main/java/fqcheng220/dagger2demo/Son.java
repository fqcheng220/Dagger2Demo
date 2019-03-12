package fqcheng220.dagger2demo;

import fqcheng220.dagger2demo.component.ManComponent;
import fqcheng220.dagger2demo.component.SonComponent;
import fqcheng220.dagger2demo.module.ManModule;
import fqcheng220.dagger2demo.module.SonModule;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/12 11:04
 */

public class Son {
  private SonComponent mSonComponent;
  @Inject
  public Car mCar;

  @Inject
  public String mExclusiveGift;

  public Son(ManComponent manComponent){
    System.out.println("this is a Son from manComponent");
    mSonComponent = manComponent.getSonComponent(new SonModule("test"),new ManModule());
    mSonComponent.inject(this);
    System.out.println("this is a Son from manComponent mCar="+mCar+",mExclusiveGift="+mExclusiveGift);
  }
}
