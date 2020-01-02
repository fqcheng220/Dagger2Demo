package fqcheng220.dagger2demo.lesson3.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 14:05
 */
public class Lesson3BaseFragment extends Fragment {
  protected final String TAG = getClass().getSimpleName();
  protected Activity mActivity;

  @Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    int layoutId = getLayoutId();
    if(layoutId != -1){
      return inflater.inflate(layoutId,null,false);
    }
    return super.onCreateView(inflater, container, savedInstanceState);
  }

  @Override public void onAttach(Activity activity) {
    super.onAttach(activity);
    mActivity = activity;
  }

  protected int getLayoutId(){
    return -1;
  }

  protected void checkInjectResult(){
  }
}
