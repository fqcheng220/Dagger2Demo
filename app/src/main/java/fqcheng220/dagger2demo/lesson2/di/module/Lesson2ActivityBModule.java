package fqcheng220.dagger2demo.lesson2.di.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.lesson2.di.bean.DemoPresenter;
import fqcheng220.dagger2demo.lesson2.di.bean.IDemoPresenter;
import fqcheng220.dagger2demo.lesson2.di.bean.IDemoView;
import fqcheng220.dagger2demo.lesson2.di.scope.ActivityBScope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:07
 */
@Module
public class Lesson2ActivityBModule {
  @ActivityBScope
  @Provides IDemoPresenter provideIDemoPresenter(IDemoView view){
    return new DemoPresenter(view);
  }
}
