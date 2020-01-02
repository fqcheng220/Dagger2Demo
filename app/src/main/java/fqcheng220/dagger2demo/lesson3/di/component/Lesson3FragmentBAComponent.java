package fqcheng220.dagger2demo.lesson3.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson3.di.module.Lesson3FragmentBAModule;
import fqcheng220.dagger2demo.lesson3.ui.Lesson3FragmentBA;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:06
 */
@Subcomponent(modules = Lesson3FragmentBAModule.class)
public interface Lesson3FragmentBAComponent {
  void inject(Lesson3FragmentBA lesson2FragmentA);

  @Subcomponent.Builder
  interface Builder{
    Lesson3FragmentBAComponent build();
  }
}
