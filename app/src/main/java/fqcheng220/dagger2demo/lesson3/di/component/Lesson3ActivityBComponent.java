package fqcheng220.dagger2demo.lesson3.di.component;

import dagger.BindsInstance;
import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson3.di.bean.IDemoView;
import fqcheng220.dagger2demo.lesson3.di.module.Lesson3ActivityBModule;
import fqcheng220.dagger2demo.lesson3.di.scope.ActivityBScope;
import fqcheng220.dagger2demo.lesson3.ui.Lesson3ActivityB;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:05
 */
@ActivityBScope
@Subcomponent(modules = Lesson3ActivityBModule.class)
public interface Lesson3ActivityBComponent {
  void inject(Lesson3ActivityB lesson2ActivityB);

  Lesson3FragmentBAComponent.Builder getLesson2FragmentBAComponent();
  Lesson3FragmentBBComponent.Builder getLesson2FragmentBBComponent();

  @Subcomponent.Builder
  interface Builder{
    @BindsInstance
    Builder view(IDemoView view);
    Lesson3ActivityBComponent build();
  }
}
