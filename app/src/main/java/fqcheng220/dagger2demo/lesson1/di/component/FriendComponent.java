package fqcheng220.dagger2demo.lesson1.di.component;

import dagger.Subcomponent;
import fqcheng220.dagger2demo.lesson1.di.module.FriendModule;
import fqcheng220.dagger2demo.lesson1.di.test.Friend;
import fqcheng220.dagger2demo.lesson1.di.scope.FriendScope;
import javax.inject.Singleton;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 21:13
 */
@FriendScope
@Singleton
@Subcomponent(modules = FriendModule.class)
public interface FriendComponent {
  void inject(Friend friend);
  @Subcomponent.Builder
  interface Builder{
    FriendComponent build();
    Builder setFriendModule(FriendModule friendModule);
  }
}
