package fqcheng220.dagger2demo.lesson4.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson4.di.module.Lesson4FragmentAAModule;
import fqcheng220.dagger2demo.lesson4.ui.Lesson4FragmentAA;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:06
 */
@Subcomponent(modules = Lesson4FragmentAAModule.class)
public interface Lesson4FragmentAAComponent {
  void inject(Lesson4FragmentAA lesson2FragmentA);
}
