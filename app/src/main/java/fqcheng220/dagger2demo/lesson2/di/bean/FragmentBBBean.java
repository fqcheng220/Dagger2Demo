package fqcheng220.dagger2demo.lesson2.di.bean;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:21
 */
public class FragmentBBBean {
  private AppBean mAppBean;
  private ActivityBBean mActivityBBean;

  public FragmentBBBean(AppBean appBean,ActivityBBean activityBBean){
    mAppBean = appBean;
    mActivityBBean = activityBBean;
  }
}
