package fqcheng220.dagger2demo.lesson2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import fqcheng220.dagger2demo.R;
import fqcheng220.dagger2demo.lesson2.HasComponent;
import fqcheng220.dagger2demo.lesson2.di.bean.ActivityABean;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean2;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean3;
import fqcheng220.dagger2demo.lesson2.di.bean.FragmentAABean;
import fqcheng220.dagger2demo.lesson2.di.component.Lesson2ActivityAComponent;
import fqcheng220.dagger2demo.lesson2.di.component.Lesson2FragmentAAComponent;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:09
 */
public class Lesson2FragmentAA extends Lesson2BaseFragment {
  @Inject
  public AppBean mAppBean;
  @Inject
  public AppBean2 mAppBean2;
  @Inject
  public AppBean3 mAppBean3;
  @Inject
  public ActivityABean mActivityABean;
  @Inject
  public FragmentAABean mFragmentAABean;

  private Lesson2FragmentAAComponent mLesson2FragmentAComponent;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_lesson2_aa;
  }

  @Override public void onResume() {
    super.onResume();
    if(mActivity instanceof HasComponent){
      mLesson2FragmentAComponent = ((HasComponent<Lesson2ActivityAComponent>)mActivity).getComponent()
          .getLesson2FragmentAAComponent()
          .build();
    }
    if(mLesson2FragmentAComponent != null){
      mLesson2FragmentAComponent.inject(this);
    }
    checkInjectResult();
  }

  @Override protected void checkInjectResult() {
    Logger.d(TAG, "checkInjectResult " + "mAppBean=" + mAppBean);
    Logger.d(TAG, "checkInjectResult " + ",mAppBean2=" + mAppBean2);
    Logger.d(TAG, "checkInjectResult " + ",mAppBean3=" + mAppBean3);
    Logger.d(TAG, "checkInjectResult " + ",mActivityABean=" + mActivityABean);
    Logger.d(TAG, "checkInjectResult " + ",mFragmentAABean=" + mFragmentAABean);
  }
}
