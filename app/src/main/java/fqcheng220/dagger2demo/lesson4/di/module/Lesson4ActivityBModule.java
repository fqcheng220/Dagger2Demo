package fqcheng220.dagger2demo.lesson4.di.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.lesson4.di.bean.DemoPresenter;
import fqcheng220.dagger2demo.lesson4.di.bean.IDemoPresenter;
import fqcheng220.dagger2demo.lesson4.di.bean.IDemoView;
import fqcheng220.dagger2demo.lesson4.di.scope.ActivityBScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:07
 */
@Module
public class Lesson4ActivityBModule {
  @ActivityBScope
  @Provides IDemoPresenter provideIDemoPresenter(IDemoView view){
    return new DemoPresenter(view);
  }

  private IDemoView mView;
  public Lesson4ActivityBModule(IDemoView view){
    mView = view;
  }

  @ActivityBScope
  @Provides IDemoView provideIDemoView(){
    return mView;
  }
}
