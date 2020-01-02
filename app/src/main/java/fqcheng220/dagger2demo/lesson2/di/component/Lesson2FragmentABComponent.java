package fqcheng220.dagger2demo.lesson2.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson2.di.module.Lesson2FragmentABModule;
import fqcheng220.dagger2demo.lesson2.ui.Lesson2FragmentAB;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:06
 */
@Subcomponent(modules = Lesson2FragmentABModule.class)
public interface Lesson2FragmentABComponent {
  void inject(Lesson2FragmentAB lesson2FragmentB);

  @Subcomponent.Builder
  interface Builder{
    Lesson2FragmentABComponent build();
  }
}
