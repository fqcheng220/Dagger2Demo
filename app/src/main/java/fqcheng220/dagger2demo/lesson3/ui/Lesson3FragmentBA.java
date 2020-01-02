package fqcheng220.dagger2demo.lesson3.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import fqcheng220.dagger2demo.R;
import fqcheng220.dagger2demo.lesson3.HasComponent;
import fqcheng220.dagger2demo.lesson3.di.bean.ActivityBBean;
import fqcheng220.dagger2demo.lesson3.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson3.di.bean.AppBean2;
import fqcheng220.dagger2demo.lesson3.di.bean.AppBean3;
import fqcheng220.dagger2demo.lesson3.di.bean.FragmentBABean;
import fqcheng220.dagger2demo.lesson3.di.component.Lesson3ActivityBComponent;
import fqcheng220.dagger2demo.lesson3.di.component.Lesson3FragmentBAComponent;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:09
 */
public class Lesson3FragmentBA extends Lesson3BaseFragment {
  @Inject
  public AppBean mAppBean;
  @Inject
  public AppBean2 mAppBean2;
  @Inject
  public AppBean3 mAppBean3;
  @Inject
  public ActivityBBean mActivityBBean;
  @Inject
  public FragmentBABean mFragmentBABean;

  private Lesson3FragmentBAComponent mLesson2FragmentAComponent;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override protected int getLayoutId() {
    return R.layout.fragment_lesson2_ba;
  }

  @Override public void onResume() {
    super.onResume();
    if(mActivity instanceof HasComponent){
      mLesson2FragmentAComponent = ((HasComponent<Lesson3ActivityBComponent>)mActivity).getComponent()
          .getLesson2FragmentBAComponent()
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
    Logger.d(TAG, "checkInjectResult " + ",mActivityBBean=" + mActivityBBean);
    Logger.d(TAG, "checkInjectResult " + ",mFragmentBABean=" + mFragmentBABean);
  }
}
