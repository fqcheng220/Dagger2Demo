package fqcheng220.dagger2demo.lesson3.di.bean;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:21
 */
public class FragmentABBean {
  private AppBean mAppBean;
  private ActivityABean mActivityABean;

  public FragmentABBean(AppBean appBean, ActivityABean activityABean){
    mAppBean = appBean;
    mActivityABean = activityABean;
  }
}
