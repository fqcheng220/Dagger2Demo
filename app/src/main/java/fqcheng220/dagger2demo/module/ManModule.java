package fqcheng220.dagger2demo.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.Bike;
import fqcheng220.dagger2demo.Car;
import fqcheng220.dagger2demo.EngineGenerator;
import fqcheng220.dagger2demo.component.FriendComponent;
import fqcheng220.dagger2demo.scope.RandomScope;
import javax.inject.Singleton;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 18:01
 */
@Module(subcomponents = FriendComponent.class)
public class ManModule {
  /**
   * 根据实际情况 决定是否需要提供EngineGenerator返回方法
   * @return
   */
  @Provides
  @RandomScope
  Car provideCar(EngineGenerator engineGenerator){
    return new Car(engineGenerator);
  }

  @Provides
  Bike provideBike(){
    return new Bike("this is a bike from ManModule");
  }
}
