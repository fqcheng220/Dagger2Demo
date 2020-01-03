package fqcheng220.dagger2demo.lesson3.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import fqcheng220.dagger2demo.R;
import fqcheng220.dagger2demo.lesson3.di.bean.ActivityABean;
import fqcheng220.dagger2demo.lesson3.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson3.di.bean.AppBean2;
import fqcheng220.dagger2demo.lesson3.di.bean.AppBean3;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:09
 */
public class Lesson3ActivityA extends Lesson3BaseActivity implements HasAndroidInjector {
  @Inject public AppBean mAppBean;
  @Inject public AppBean2 mAppBean2;
  @Inject public AppBean3 mAppBean3;
  @Inject public ActivityABean mActivityABean;

  @Inject public DispatchingAndroidInjector<Fragment> mDispatchingAndroidInjector;

  private int mCurFragClzIndex = -1;
  private final Class[] clzArr = new Class[] {
      Lesson3FragmentAA.class, Lesson3FragmentAB.class
  };

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lesson3_a);

    AndroidInjection.inject(this);
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
        intent.setClass(Lesson3ActivityA.this,Lesson3ActivityB.class);
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
    Logger.d(TAG, "checkInjectResult " + ",mDispatchingAndroidInjector=" + mDispatchingAndroidInjector);
  }

  @Override public AndroidInjector androidInjector() {
    return mDispatchingAndroidInjector;
  }
}
