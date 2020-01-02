package fqcheng220.dagger2demo.lesson1.di.test;

import fqcheng220.dagger2demo.utils.Logger;

/**
 * Created by Administrator on 2019/3/9 0009.
 */

public class EngineGenerator {
    private final String TAG = getClass().getSimpleName();
    public EngineGenerator(){
        Logger.d(TAG,"constructor:this is a EngineGenerator");
    }

    public EngineGenerator(String msg){
        Logger.d(TAG,"constructor:"+msg);
    }
}
