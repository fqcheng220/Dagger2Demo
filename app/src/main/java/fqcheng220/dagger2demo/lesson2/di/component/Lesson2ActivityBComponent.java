package fqcheng220.dagger2demo.lesson2.di.component;

import dagger.BindsInstance;
import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson2.di.bean.IDemoView;
import fqcheng220.dagger2demo.lesson2.di.module.Lesson2ActivityBModule;
import fqcheng220.dagger2demo.lesson2.di.scope.ActivityBScope;
import fqcheng220.dagger2demo.lesson2.ui.Lesson2ActivityB;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:05
 */
@ActivityBScope
@Subcomponent(modules = Lesson2ActivityBModule.class)
public interface Lesson2ActivityBComponent {
  void inject(Lesson2ActivityB lesson2ActivityB);

  Lesson2FragmentBAComponent.Builder getLesson2FragmentBAComponent();
  Lesson2FragmentBBComponent.Builder getLesson2FragmentBBComponent();

  @Subcomponent.Builder
  interface Builder{
    @BindsInstance
    Builder view(IDemoView view);
    Lesson2ActivityBComponent build();
  }
}
