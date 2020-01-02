package fqcheng220.dagger2demo.lesson3.di.moduleExtra;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import fqcheng220.dagger2demo.lesson3.di.module.Lesson3FragmentAAModule;
import fqcheng220.dagger2demo.lesson3.di.module.Lesson3FragmentABModule;
import fqcheng220.dagger2demo.lesson3.ui.Lesson3FragmentAA;
import fqcheng220.dagger2demo.lesson3.ui.Lesson3FragmentAB;
import fqcheng220.dagger2demo.lesson3.ui.Lesson3FragmentBA;
import fqcheng220.dagger2demo.lesson3.ui.Lesson3FragmentBB;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 17:20
 */
@Module
public interface Lesson3FragmentBindModule {
  @ContributesAndroidInjector(modules = Lesson3FragmentAAModule.class)
  Lesson3FragmentAA getComponentLesson3FragmentAA();

  @ContributesAndroidInjector(modules = Lesson3FragmentABModule.class)
  Lesson3FragmentAB getComponentLesson3FragmentAB();

  //@ContributesAndroidInjector(modules = Lesson3FragmentBAModule.class)
  //Lesson3FragmentBA getComponentLesson3FragmentBA();
  //
  //@ContributesAndroidInjector(modules = Lesson3FragmentBBModule.class)
  //Lesson3FragmentBB getComponentLesson3FragmentBB();
}
