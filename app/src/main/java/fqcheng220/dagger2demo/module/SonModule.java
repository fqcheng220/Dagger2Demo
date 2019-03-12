package fqcheng220.dagger2demo.module;

import dagger.Module;
import dagger.Provides;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/12 11:16
 */
@Module
public class SonModule {
  private String mGift;
  public SonModule(String s){
    System.out.println("SonModule:this is a SonModule constructor "+s);
    mGift = s;
  }

  @Provides
  String provideGift(){
    return mGift;
  }
}
