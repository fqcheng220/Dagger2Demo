package fqcheng220.dagger2demo;

import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 17:58
 */

public class Bike {
  @Inject
  public Bike(){
    this("Bike constructor:this is a bike from constructor");
  }

  public Bike(String msg){
    System.out.println("Bike constructor:"+msg);
  }
}
