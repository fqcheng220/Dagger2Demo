package fqcheng220.dagger2demo.lesson2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import fqcheng220.dagger2demo.R;
import fqcheng220.dagger2demo.lesson2.HasComponent;
import fqcheng220.dagger2demo.lesson2.di.bean.ActivityABean;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean2;
import fqcheng220.dagger2demo.lesson2.di.bean.AppBean3;
import fqcheng220.dagger2demo.lesson2.di.component.Lesson2ActivityAComponent;
import fqcheng220.dagger2demo.lesson2.di.component.Lesson2AppComponent;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:09
 */
public class Lesson2ActivityA extends Lesson2BaseActivity implements HasComponent<Lesson2ActivityAComponent> {
  @Inject public AppBean mAppBean;
  @Inject public AppBean2 mAppBean2;
  @Inject public AppBean3 mAppBean3;
  @Inject public ActivityABean mActivityABean;

  private Lesson2ActivityAComponent mLesson2ActivityAComponent;
  private int mCurFragClzIndex = -1;
  private final Class[] clzArr = new Class[] {
      Lesson2FragmentAA.class, Lesson2FragmentAB.class
  };

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lesson2_a);

    if (getApplication() instanceof HasComponent) {
      mLesson2ActivityAComponent = ((HasComponent<Lesson2AppComponent>) getApplication()).getComponent().getLesson2ActivityAComponent().build();
    }
    if (mLesson2ActivityAComponent != null) {
      mLesson2ActivityAComponent.inject(this);
    }
    checkInjectResult();

    switchFragment();
    findViewById(R.id.btn_switch).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        switchFragment();
      }
    });
  }

  private void switchFragment() {
    if (clzArr != null && clzArr.length > 0) {
      mCurFragClzIndex = ++mCurFragClzIndex % clzArr.length;
      if (mCurFragClzIndex >= 0 && mCurFragClzIndex < clzArr.length) {
        Logger.d(TAG, "switchFragment mCurFragClzIndex=" + mCurFragClzIndex);
        showOrCreateFragment(getSupportFragmentManager(), R.id.container, clzArr[mCurFragClzIndex],
            clzArr[mCurFragClzIndex] != null ? clzArr[mCurFragClzIndex].getSimpleName() : "");
      }
    }
  }

  @Override protected void checkInjectResult() {
    Logger.d(TAG, "checkInjectResult " + "mAppBean=" + mAppBean);
    Logger.d(TAG, "checkInjectResult " + ",mAppBean2=" + mAppBean2);
    Logger.d(TAG, "checkInjectResult " + ",mAppBean3=" + mAppBean3);
    Logger.d(TAG, "checkInjectResult " + ",mActivityABean=" + mActivityABean);
  }

  @Override public Lesson2ActivityAComponent getComponent() {
    return mLesson2ActivityAComponent;
  }
}
