package fqcheng220.dagger2demo.lesson3.di.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.lesson3.di.bean.DemoPresenter;
import fqcheng220.dagger2demo.lesson3.di.bean.IDemoPresenter;
import fqcheng220.dagger2demo.lesson3.di.bean.IDemoView;
import fqcheng220.dagger2demo.lesson3.di.scope.ActivityBScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:07
 */
@Module
public class Lesson3ActivityBModule {
  @ActivityBScope
  @Provides IDemoPresenter provideIDemoPresenter(IDemoView view){
    return new DemoPresenter(view);
  }
}
