package fqcheng220.dagger2demo.lesson3.di.moduleExtra;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import fqcheng220.dagger2demo.lesson3.di.module.Lesson3ActivityAModule;
import fqcheng220.dagger2demo.lesson3.ui.Lesson3ActivityA;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 17:07
 */
@Module
public abstract class Lesson3ActivityBindModule {
  @ContributesAndroidInjector(modules={Lesson3FragmentBindModule.class, Lesson3ActivityAModule.class})
  abstract Lesson3ActivityA getComponentLesson3ActivityA();

  //@ContributesAndroidInjector(modules={Lesson3FragmentBindModule.class,Lesson3ActivityBModule.class})
  //Lesson3ActivityB getComponentLesson3ActivityB();
}
