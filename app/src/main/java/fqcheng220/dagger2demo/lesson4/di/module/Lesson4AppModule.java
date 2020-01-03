package fqcheng220.dagger2demo.lesson4.di.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.lesson4.di.bean.AppBean2;
import fqcheng220.dagger2demo.lesson4.di.bean.AppBean3;
import fqcheng220.dagger2demo.lesson4.di.scope.AppScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:06
 */
@Module
public class Lesson4AppModule {
  private Application mApplication;
  public Lesson4AppModule(Application application){
    mApplication = application;
  }
  @AppScope
  @Provides AppBean2 provideAppBean2(){
    return new AppBean2();
  }

  @AppScope
  @Provides
  Application provideApplication(){
    return mApplication;
  }

  @Provides AppBean3 provideAppBean3(){
    return new AppBean3();
  }
}
