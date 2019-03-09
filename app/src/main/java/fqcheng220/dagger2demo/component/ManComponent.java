package fqcheng220.dagger2demo.component;

import dagger.Component;
import fqcheng220.dagger2demo.Bike;
import fqcheng220.dagger2demo.Car;
import fqcheng220.dagger2demo.Man;
import fqcheng220.dagger2demo.module.EngineGeneratorModule;
import fqcheng220.dagger2demo.module.ManModule;
import fqcheng220.dagger2demo.scope.RandomScope;
import javax.inject.Singleton;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 17:51
 */
@RandomScope
@Component(modules = {ManModule.class,EngineGeneratorModule.class})
public interface ManComponent {
  void randomNameSetCar(Man man);

//  Car exposureCar();

  Bike exposureBike();

  FriendComponent.Builder friendComponent();
}
