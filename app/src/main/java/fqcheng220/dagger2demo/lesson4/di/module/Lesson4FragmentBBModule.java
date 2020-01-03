package fqcheng220.dagger2demo.lesson4.di.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.lesson4.di.bean.ActivityBBean;
import fqcheng220.dagger2demo.lesson4.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson4.di.bean.FragmentBBBean;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:07
 */
@Module
public class Lesson4FragmentBBModule {
  @Provides FragmentBBBean provideFragmentBBean(AppBean appBean, ActivityBBean activityBBean){
    return new FragmentBBBean(appBean,activityBBean);
  }
}
