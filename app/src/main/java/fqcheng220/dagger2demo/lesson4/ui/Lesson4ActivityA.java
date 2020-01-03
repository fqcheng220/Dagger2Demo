package fqcheng220.dagger2demo.lesson4.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import fqcheng220.dagger2demo.R;
import fqcheng220.dagger2demo.lesson4.HasComponent;
import fqcheng220.dagger2demo.lesson4.di.bean.ActivityABean;
import fqcheng220.dagger2demo.lesson4.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson4.di.bean.AppBean2;
import fqcheng220.dagger2demo.lesson4.di.bean.AppBean3;
import fqcheng220.dagger2demo.lesson4.di.component.Lesson4ActivityAComponent;
import fqcheng220.dagger2demo.lesson4.di.component.Lesson4AppComponent;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:09
 */
public class Lesson4ActivityA extends Lesson4BaseActivity implements HasComponent<Lesson4ActivityAComponent> {
  @Inject public AppBean mAppBean;
  @Inject public AppBean2 mAppBean2;
  @Inject public AppBean3 mAppBean3;
  @Inject public ActivityABean mActivityABean;

  private Lesson4ActivityAComponent mLesson2ActivityAComponent;
  private int mCurFragClzIndex = -1;
  private final Class[] clzArr = new Class[] {
      Lesson4FragmentAA.class, Lesson4FragmentAB.class
  };

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lesson4_a);

    if (getApplication() instanceof HasComponent) {
      mLesson2ActivityAComponent = ((HasComponent<Lesson4AppComponent>) getApplication()).getComponent().getLesson2ActivityAComponent();
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
    findViewById(R.id.btn_to_activityB).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(Lesson4ActivityA.this, Lesson4ActivityB.class);
        startActivity(intent);
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

  @Override public Lesson4ActivityAComponent getComponent() {
    return mLesson2ActivityAComponent;
  }
}
