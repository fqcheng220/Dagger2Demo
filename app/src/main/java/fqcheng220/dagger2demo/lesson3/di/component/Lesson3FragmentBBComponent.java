package fqcheng220.dagger2demo.lesson3.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson3.di.module.Lesson3FragmentBBModule;
import fqcheng220.dagger2demo.lesson3.ui.Lesson3FragmentBB;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:06
 */
@Subcomponent(modules = Lesson3FragmentBBModule.class)
public interface Lesson3FragmentBBComponent {
  void inject(Lesson3FragmentBB lesson2FragmentBB);

  @Subcomponent.Builder
  interface Builder{
    Lesson3FragmentBBComponent build();
  }
}
