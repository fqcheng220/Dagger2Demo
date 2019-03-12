package fqcheng220.dagger2demo.component;

import dagger.Component;
import dagger.Subcomponent;
import fqcheng220.dagger2demo.Friend;
import fqcheng220.dagger2demo.scope.FriendScope;
import javax.inject.Singleton;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 21:13
 */
@Singleton
@Subcomponent
public interface FriendComponent {
  void inject(Friend friend);
  @Subcomponent.Builder
  interface Builder{
    FriendComponent build();
  }
}
