package fqcheng220.dagger2demo.lesson4.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import fqcheng220.dagger2demo.R;
import fqcheng220.dagger2demo.lesson4.HasComponent;
import fqcheng220.dagger2demo.lesson4.di.bean.ActivityBBean;
import fqcheng220.dagger2demo.lesson4.di.bean.AppBean;
import fqcheng220.dagger2demo.lesson4.di.bean.AppBean2;
import fqcheng220.dagger2demo.lesson4.di.bean.AppBean3;
import fqcheng220.dagger2demo.lesson4.di.bean.IDemoPresenter;
import fqcheng220.dagger2demo.lesson4.di.bean.IDemoView;
import fqcheng220.dagger2demo.lesson4.di.component.Lesson4ActivityBComponent;
import fqcheng220.dagger2demo.lesson4.di.component.Lesson4AppComponent;
import fqcheng220.dagger2demo.lesson4.di.module.Lesson4ActivityBModule;
import fqcheng220.dagger2demo.utils.Logger;
import javax.inject.Inject;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:09
 */
public class Lesson4ActivityB extends Lesson4BaseActivity implements HasComponent<Lesson4ActivityBComponent>, IDemoView {
  @Inject public AppBean mAppBean;
  @Inject public AppBean2 mAppBean2;
  @Inject public AppBean3 mAppBean3;
  @Inject public ActivityBBean mActivityBBean;
  @Inject public IDemoPresenter mIDemoPresenter;

  private Lesson4ActivityBComponent mLesson2ActivityBComponent;
  private int mCurFragClzIndex = -1;
  private final Class[] clzArr = new Class[] {
      Lesson4FragmentBA.class, Lesson4FragmentBB.class
  };

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_lesson4_b);

    if (getApplication() instanceof HasComponent) {
      mLesson2ActivityBComponent = ((HasComponent<Lesson4AppComponent>) getApplication()).getComponent().getLesson2ActivityBComponent(new Lesson4ActivityBModule(this));
    }
    if (mLesson2ActivityBComponent != null) {
      mLesson2ActivityBComponent.inject(this);
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
    Logger.d(TAG, "checkInjectResult " + ",mActivityBBean=" + mActivityBBean);
    mIDemoPresenter.doSomething("");
  }

  @Override public Lesson4ActivityBComponent getComponent() {
    return mLesson2ActivityBComponent;
  }

  @Override public void callback(int code) {

  }
}
