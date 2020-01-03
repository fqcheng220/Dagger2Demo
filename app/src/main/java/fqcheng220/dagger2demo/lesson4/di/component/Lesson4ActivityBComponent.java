package fqcheng220.dagger2demo.lesson4.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson4.di.module.Lesson4ActivityBModule;
import fqcheng220.dagger2demo.lesson4.di.scope.ActivityBScope;
import fqcheng220.dagger2demo.lesson4.ui.Lesson4ActivityB;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:05
 */
@ActivityBScope
@Subcomponent(modules = Lesson4ActivityBModule.class)
public interface Lesson4ActivityBComponent {
  void inject(Lesson4ActivityB lesson2ActivityB);

  Lesson4FragmentBAComponent getLesson2FragmentBAComponent();
  Lesson4FragmentBBComponent getLesson2FragmentBBComponent();
}
