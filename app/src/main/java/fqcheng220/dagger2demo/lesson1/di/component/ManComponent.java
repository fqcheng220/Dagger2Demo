package fqcheng220.dagger2demo.lesson1.di.component;

import dagger.Component;
import fqcheng220.dagger2demo.lesson1.di.module.EngineGeneratorModule;
import fqcheng220.dagger2demo.lesson1.di.module.ManModule;
import fqcheng220.dagger2demo.lesson1.di.module.SonModule;
import fqcheng220.dagger2demo.lesson1.di.test.Bike;
import fqcheng220.dagger2demo.lesson1.di.test.Car;
import fqcheng220.dagger2demo.lesson1.di.test.Man;
import fqcheng220.dagger2demo.lesson1.di.scope.AnotherScope;
import fqcheng220.dagger2demo.lesson1.di.scope.RandomScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 17:51
 */
@RandomScope
@AnotherScope
@Component(modules = {ManModule.class,EngineGeneratorModule.class})
public interface ManComponent {
  void randomNameSetCar(Man man);

  //专为SonDepComponent添加
  Car exposureCar();

  Bike exposureBike();

  FriendComponent.Builder friendComponent();

  SonComponent getSonComponent(SonModule sonModule);
}
