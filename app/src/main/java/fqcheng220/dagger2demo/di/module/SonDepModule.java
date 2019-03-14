package fqcheng220.dagger2demo.di.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.utils.Logger;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/12 11:16
 */
@Module
public class SonDepModule {
  private final String TAG = getClass().getSimpleName();
  private String mGift;
  public SonDepModule(String s){
    Logger.d(TAG,"constructor:this is a "+s);
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
