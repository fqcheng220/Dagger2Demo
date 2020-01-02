package fqcheng220.dagger2demo.lesson1.di.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.lesson1.di.test.Bike;
import fqcheng220.dagger2demo.lesson1.di.test.Car;
import fqcheng220.dagger2demo.lesson1.di.test.EngineGenerator;
import fqcheng220.dagger2demo.lesson1.di.component.FriendComponent;
import fqcheng220.dagger2demo.lesson1.di.scope.AnotherScope;
import fqcheng220.dagger2demo.lesson1.di.scope.RandomScope;

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

  @AnotherScope
  @Provides
  Bike provideBike(){
    return new Bike("this is a bike from ManModule");
  }
}
