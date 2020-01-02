package fqcheng220.dagger2demo.lesson2.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson2.di.module.Lesson2ActivityAModule;
import fqcheng220.dagger2demo.lesson2.di.scope.ActivityAScope;
import fqcheng220.dagger2demo.lesson2.ui.Lesson2ActivityA;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:05
 */
@ActivityAScope
@Subcomponent(modules = Lesson2ActivityAModule.class)
public interface Lesson2ActivityAComponent {
  void inject(Lesson2ActivityA lesson2ActivityA);

  Lesson2FragmentAAComponent.Builder getLesson2FragmentAAComponent();
  Lesson2FragmentABComponent.Builder getLesson2FragmentABComponent();

  @Subcomponent.Builder
  interface Builder{
    Lesson2ActivityAComponent build();
  }
}
