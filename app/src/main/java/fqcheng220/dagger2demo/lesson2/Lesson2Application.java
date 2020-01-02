package fqcheng220.dagger2demo.lesson2;

import android.app.Application;
import fqcheng220.dagger2demo.lesson2.di.component.DaggerLesson2AppComponent;
import fqcheng220.dagger2demo.lesson2.di.component.Lesson2AppComponent;
import fqcheng220.dagger2demo.lesson2.di.module.Lesson2AppModule;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:08
 */
public class Lesson2Application extends Application implements HasComponent<Lesson2AppComponent> {
  Lesson2AppComponent mDaggerLesson2AppComponent;

  @Override public void onCreate() {
    super.onCreate();
    mDaggerLesson2AppComponent = DaggerLesson2AppComponent.builder().lesson2AppModule(new Lesson2AppModule(this)).build();
  }

  @Override public Lesson2AppComponent getComponent() {
    return mDaggerLesson2AppComponent;
  }
}
