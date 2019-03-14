package fqcheng220.dagger2demo.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.di.module.SonModule;
import fqcheng220.dagger2demo.di.test.Son;

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
