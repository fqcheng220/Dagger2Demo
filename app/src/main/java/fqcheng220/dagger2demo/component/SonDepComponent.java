package fqcheng220.dagger2demo.component;

import dagger.Component;
import fqcheng220.dagger2demo.Son;
import fqcheng220.dagger2demo.module.SonDepModule;
import fqcheng220.dagger2demo.scope.SonDepScope;
import javax.inject.Singleton;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/12 13:58
 */
@SonDepScope
@Component(modules = SonDepModule.class,dependencies = ManComponent.class)
public interface SonDepComponent {
  void inject(Son son);
}
