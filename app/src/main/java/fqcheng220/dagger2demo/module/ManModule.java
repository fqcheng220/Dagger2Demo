package fqcheng220.dagger2demo.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.Bike;
import fqcheng220.dagger2demo.Car;
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
  @Provides
  @RandomScope
  Car provideCar(){
    return new Car();
  }

  @Provides
  Bike provideBike(){
    return new Bike("this is a bike from ManModule");
  }
}
