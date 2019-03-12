package fqcheng220.dagger2demo.module;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/12 11:16
 */
@Module
public class SonDepModule {
  private String mGift;
  public SonDepModule(String s){
    System.out.println("SonDepModule constructor:this is a SonDepModule "+s);
    mGift = s;
  }

  //public SonDepModule(){
  //  System.out.println("SonDepModule constructor:default");
  //}

  @Provides
  String provideGift(){
    return mGift;
  }
}
