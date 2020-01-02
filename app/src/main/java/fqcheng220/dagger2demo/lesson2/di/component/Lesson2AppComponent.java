package fqcheng220.dagger2demo.lesson2.di.component;

import android.app.Application;
import dagger.Component;
import fqcheng220.dagger2demo.lesson2.di.module.Lesson2AppModule;
import fqcheng220.dagger2demo.lesson2.di.scope.AppScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:05
 */
@AppScope
@Component(modules = Lesson2AppModule.class)
public interface Lesson2AppComponent {
  void inject(Application application);

  Lesson2ActivityAComponent.Builder getLesson2ActivityAComponent();
  Lesson2ActivityBComponent.Builder getLesson2ActivityBComponent();
}
