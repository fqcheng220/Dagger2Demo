package fqcheng220.dagger2demo.lesson2.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson2.di.module.Lesson2FragmentAAModule;
import fqcheng220.dagger2demo.lesson2.ui.Lesson2FragmentAA;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:06
 */
@Subcomponent(modules = Lesson2FragmentAAModule.class)
public interface Lesson2FragmentAAComponent {
  void inject(Lesson2FragmentAA lesson2FragmentA);

  @Subcomponent.Builder
  interface Builder{
    Lesson2FragmentAAComponent build();
  }
}
