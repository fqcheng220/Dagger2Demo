package fqcheng220.dagger2demo.lesson4.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson4.di.module.Lesson4FragmentABModule;
import fqcheng220.dagger2demo.lesson4.ui.Lesson4FragmentAB;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:06
 */
@Subcomponent(modules = Lesson4FragmentABModule.class)
public interface Lesson4FragmentABComponent {
  void inject(Lesson4FragmentAB lesson2FragmentB);
}
