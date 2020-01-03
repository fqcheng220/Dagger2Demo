package fqcheng220.dagger2demo.lesson4.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson4.di.module.Lesson4FragmentBAModule;
import fqcheng220.dagger2demo.lesson4.ui.Lesson4FragmentBA;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:06
 */
@Subcomponent(modules = Lesson4FragmentBAModule.class)
public interface Lesson4FragmentBAComponent {
  void inject(Lesson4FragmentBA lesson2FragmentA);
}
