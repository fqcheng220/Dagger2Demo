package fqcheng220.dagger2demo.lesson2.di.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.lesson2.di.bean.ActivityABean;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson2.di.bean.FragmentAABean;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:07
 */
@Module
public class Lesson2FragmentAAModule {
  @Provides FragmentAABean provideFragmentABean(AppBean appBean, ActivityABean activityABean){
    return new FragmentAABean(appBean,activityABean);
  }
}
