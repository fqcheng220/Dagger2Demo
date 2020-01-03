package fqcheng220.dagger2demo.lesson4;

import android.app.Application;
import fqcheng220.dagger2demo.lesson4.di.component.DaggerLesson4AppComponent;
import fqcheng220.dagger2demo.lesson4.di.component.Lesson4AppComponent;
import fqcheng220.dagger2demo.lesson4.di.module.Lesson4AppModule;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:08
 */
public class Lesson4Application extends Application implements HasComponent<Lesson4AppComponent> {
  Lesson4AppComponent mDaggerLesson2AppComponent;

  @Override public void onCreate() {
    super.onCreate();
    mDaggerLesson2AppComponent = DaggerLesson4AppComponent.builder().lesson4AppModule(new Lesson4AppModule(this)).build();
  }

  @Override public Lesson4AppComponent getComponent() {
    return mDaggerLesson2AppComponent;
  }
}
