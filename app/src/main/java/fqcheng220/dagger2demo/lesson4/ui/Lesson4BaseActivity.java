package fqcheng220.dagger2demo.lesson4.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 13:53
 */
public class Lesson4BaseActivity extends AppCompatActivity {
  protected final String TAG = getClass().getSimpleName();

  protected void checkInjectResult(){
  }

  protected Fragment showOrCreateFragment(
      FragmentManager fragmentManager,
      int containerLayoutId,
      Class<? extends Fragment> fragmentClass,
      String tag){
    return showOrCreateFragment(fragmentManager,containerLayoutId,fragmentClass,tag,-1,-1,false,null);
  }

  protected Fragment showOrCreateFragment(
      FragmentManager fragmentManager,
      int containerLayoutId,
      Class<? extends Fragment> fragmentClass,
      String tag,
      int left,
      int right,
      boolean bAddToBackStack,
      Bundle args) {
    List<Fragment> all = fragmentManager.getFragments();
    List<Fragment> sameContainer = new ArrayList<Fragment>();
    Fragment targetFragment = null;
    if (all == null) {
      all = new ArrayList<Fragment>();
    }
    for (Fragment frag : all) {
      //寻找同一容器中的fragment
      if (frag != null && frag.getView() != null && frag.getView().getParent() != null && ((ViewGroup) frag.getView().getParent()).getId() == containerLayoutId) {
        if (frag.getClass() == fragmentClass && tag.equals(frag.getTag())) {
          targetFragment = frag; //找到本尊
        } else {
          sameContainer.add(frag); //找到同窗
        }
      }
    }
    //如果指定的fragment不存在，创建并显示出来，隐藏同容器中的其他fragment
    boolean isNew = false;
    if (targetFragment == null) {
      if (args == null) {
        targetFragment = Fragment.instantiate(this, fragmentClass.getCanonicalName());
      } else {
        targetFragment = Fragment.instantiate(this, fragmentClass.getCanonicalName(), args);
      }
      isNew = true;
    }
    //
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    if (left != -1 && right != -1) {
      transaction.setCustomAnimations(left, right, left, right);
    }
    for (Fragment frag : sameContainer) {
      transaction.hide(frag);
    }
    if (isNew) {
      transaction.add(containerLayoutId, targetFragment, tag);
    } else {
      transaction.show(targetFragment);
    }
    if (bAddToBackStack) {
      transaction.addToBackStack(null);
      //fix bug: java.lang.IllegalStateException: Can not perform this action after onSaveInstanceState
      //            transaction.commit();
    }
    transaction.commitAllowingStateLoss();
    return targetFragment;
  }
}
