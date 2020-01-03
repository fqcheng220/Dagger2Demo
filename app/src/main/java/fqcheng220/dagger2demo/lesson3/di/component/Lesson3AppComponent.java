package fqcheng220.dagger2demo.lesson3.di.component;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import fqcheng220.dagger2demo.lesson3.Lesson3Application;
import fqcheng220.dagger2demo.lesson3.di.moduleExtra.Lesson3ActivityBindModule;
import fqcheng220.dagger2demo.lesson3.di.module.Lesson3AppModule;
import fqcheng220.dagger2demo.lesson3.di.scope.AppScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:05
 */
@AppScope
@Component(modules = {Lesson3AppModule.class, Lesson3ActivityBindModule.class, AndroidInjectionModule.class })
public interface Lesson3AppComponent {
  /**
   * 注意
   * @param application 不能是父类类型
   */
  void inject(Lesson3Application application);

  Lesson3ActivityBComponent.Builder getLesson3ActivityBComponent();
}
