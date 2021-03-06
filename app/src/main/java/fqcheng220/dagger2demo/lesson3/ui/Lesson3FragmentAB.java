package fqcheng220.dagger2demo.lesson3.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import dagger.android.support.AndroidSupportInjection;
import fqcheng220.dagger2demo.R;
import fqcheng220.dagger2demo.lesson3.di.bean.ActivityABean;
import fqcheng220.dagger2demo.lesson3.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson3.di.bean.AppBean2;
import fqcheng220.dagger2demo.lesson3.di.bean.AppBean3;
import fqcheng220.dagger2demo.lesson3.di.bean.FragmentABBean;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:09
 */
public class Lesson3FragmentAB extends Lesson3BaseFragment {
  @Inject
  public AppBean mAppBean;
  @Inject
  public AppBean2 mAppBean2;
  @Inject
  public AppBean3 mAppBean3;
  @Inject
  public ActivityABean mActivityABean;
  //@Inject
  //public FragmentAABean mFragmentABean;
  @Inject
  public FragmentABBean mFragmentABBean;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidSupportInjection.inject(this);
    checkInjectResult();
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_lesson3_ab;
  }

  @Override public void onResume() {
    super.onResume();
  }

  @Override protected void checkInjectResult() {
    Logger.d(TAG, "checkInjectResult " + "mAppBean=" + mAppBean);
    Logger.d(TAG, "checkInjectResult " + ",mAppBean2=" + mAppBean2);
    Logger.d(TAG, "checkInjectResult " + ",mAppBean3=" + mAppBean3);
    Logger.d(TAG, "checkInjectResult " + ",mActivityABean=" + mActivityABean);
    //Logger.d(TAG, "checkInjectResult " + ",mFragmentABean=" + mFragmentABean);
    Logger.d(TAG, "checkInjectResult " + ",mFragmentABBean=" + mFragmentABBean);
  }
}
