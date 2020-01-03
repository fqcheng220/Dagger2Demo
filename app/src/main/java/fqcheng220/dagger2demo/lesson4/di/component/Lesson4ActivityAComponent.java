package fqcheng220.dagger2demo.lesson4.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson4.di.module.Lesson4ActivityAModule;
import fqcheng220.dagger2demo.lesson4.di.scope.ActivityAScope;
import fqcheng220.dagger2demo.lesson4.ui.Lesson4ActivityA;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:05
 */
@ActivityAScope
@Subcomponent(modules = Lesson4ActivityAModule.class)
public interface Lesson4ActivityAComponent {
  void inject(Lesson4ActivityA lesson2ActivityA);

  Lesson4FragmentAAComponent getLesson2FragmentAAComponent();
  Lesson4FragmentABComponent getLesson2FragmentABComponent();
}
