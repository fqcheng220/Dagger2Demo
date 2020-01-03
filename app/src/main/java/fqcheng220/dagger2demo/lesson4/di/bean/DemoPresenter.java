package fqcheng220.dagger2demo.lesson4.di.bean;

import fqcheng220.dagger2demo.utils.Logger;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 16:39
 */
public class DemoPresenter implements IDemoPresenter {
  private final String TAG = getClass().getSimpleName();
  private IDemoView mView;

  public DemoPresenter(IDemoView view) {
    mView = view;
  }

  @Override public void doSomething(String input) {
    Logger.d(TAG, "doSomething input=" + input + ",mView=" + mView);
  }
}
