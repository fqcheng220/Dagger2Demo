package fqcheng220.dagger2demo.lesson3;

import android.app.Activity;
import android.app.Application;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import fqcheng220.dagger2demo.lesson3.di.component.DaggerLesson3AppComponent;
import fqcheng220.dagger2demo.lesson3.di.component.Lesson3AppComponent;
import fqcheng220.dagger2demo.lesson3.di.module.Lesson3AppModule;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:08
 */
public class Lesson3Application extends Application implements HasComponent<Lesson3AppComponent>, HasAndroidInjector {
  Lesson3AppComponent mDaggerLesson2AppComponent;
  DispatchingAndroidInjector<Activity> mDispatchingAndroidInjector;

  @Override public void onCreate() {
    super.onCreate();
    //mDaggerLesson2AppComponent = DaggerLesson3AppComponent.builder().lesson3AppModule(new Lesson3AppModule(this)).build();

    mDaggerLesson2AppComponent = DaggerLesson3AppComponent.builder().lesson3AppModule(new Lesson3AppModule(this)).build();
    mDaggerLesson2AppComponent.inject(this);
  }

  @Override public Lesson3AppComponent getComponent() {
    return mDaggerLesson2AppComponent;
  }

  @Override public AndroidInjector androidInjector() {
    return mDispatchingAndroidInjector;
  }
}
