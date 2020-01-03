package fqcheng220.dagger2demo.lesson4.di.component;

import android.app.Application;
import dagger.Component;
import fqcheng220.dagger2demo.lesson4.di.module.Lesson4ActivityBModule;
import fqcheng220.dagger2demo.lesson4.di.module.Lesson4AppModule;
import fqcheng220.dagger2demo.lesson4.di.scope.AppScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:05
 */
@AppScope
@Component(modules = Lesson4AppModule.class)
public interface Lesson4AppComponent {
  void inject(Application application);

  Lesson4ActivityAComponent getLesson2ActivityAComponent();
  Lesson4ActivityBComponent getLesson2ActivityBComponent(Lesson4ActivityBModule module);
}
