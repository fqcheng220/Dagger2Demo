package fqcheng220.dagger2demo.component;

import dagger.Component;
import dagger.Subcomponent;
import fqcheng220.dagger2demo.Friend;
import fqcheng220.dagger2demo.Son;
import fqcheng220.dagger2demo.module.SonModule;
import fqcheng220.dagger2demo.scope.RandomScope;
import javax.inject.Singleton;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/12 11:03
 */
//@Singleton
@Subcomponent(modules = SonModule.class)
public interface SonComponent {
  void inject(Son son);
}
