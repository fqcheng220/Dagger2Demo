package fqcheng220.dagger2demo.lesson2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import fqcheng220.dagger2demo.R;
import fqcheng220.dagger2demo.lesson2.HasComponent;
import fqcheng220.dagger2demo.lesson2.di.bean.ActivityBBean;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean2;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean3;
import fqcheng220.dagger2demo.lesson2.di.bean.FragmentBBBean;
import fqcheng220.dagger2demo.lesson2.di.component.Lesson2ActivityBComponent;
import fqcheng220.dagger2demo.lesson2.di.component.Lesson2FragmentBBComponent;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:09
 */
public class Lesson2FragmentBB extends Lesson2BaseFragment {
  @Inject
  public AppBean mAppBean;
  @Inject
  public AppBean2 mAppBean2;
  @Inject
  public AppBean3 mAppBean3;
  @Inject
  public ActivityBBean mActivityBBean;
  //@Inject
  //public FragmentAABean mFragmentABean;
  @Inject
  public FragmentBBBean mFragmentBBBean;

  private Lesson2FragmentBBComponent mLesson2FragmentBBComponent;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_lesson2_bb;
  }

  @Override public void onResume() {
    super.onResume();
    if(mActivity instanceof HasComponent){
      mLesson2FragmentBBComponent = ((HasComponent<Lesson2ActivityBComponent>)mActivity).getComponent()
          .getLesson2FragmentBBComponent()
          .build();
    }
    if(mLesson2FragmentBBComponent != null){
      mLesson2FragmentBBComponent.inject(this);
    }
    checkInjectResult();
  }

  @Override protected void checkInjectResult() {
    Logger.d(TAG, "checkInjectResult " + "mAppBean=" + mAppBean);
    Logger.d(TAG, "checkInjectResult " + ",mAppBean2=" + mAppBean2);
    Logger.d(TAG, "checkInjectResult " + ",mAppBean3=" + mAppBean3);
    Logger.d(TAG, "checkInjectResult " + ",mActivityBBean=" + mActivityBBean);
    //Logger.d(TAG, "checkInjectResult " + ",mFragmentABean=" + mFragmentABean);
    Logger.d(TAG, "checkInjectResult " + ",mFragmentBBBean=" + mFragmentBBBean);
  }
}
