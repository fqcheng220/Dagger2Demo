package fqcheng220.dagger2demo.lesson1.di.component;

import dagger.Component;
import fqcheng220.dagger2demo.lesson1.di.module.SonDepModule;
import fqcheng220.dagger2demo.lesson1.di.test.Son;
import fqcheng220.dagger2demo.lesson1.di.scope.SonDepScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/12 13:58
 */
@SonDepScope
//  @RandomScope
@Component(modules = SonDepModule.class,dependencies = ManComponent.class)
public interface SonDepComponent {
  void inject(Son son);
}
