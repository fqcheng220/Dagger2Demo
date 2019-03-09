package fqcheng220.dagger2demo.module;

import dagger.Module;
import dagger.Provides;
import fqcheng220.dagger2demo.EngineGenerator;
import fqcheng220.dagger2demo.scope.RandomScope;

/**
 * Created by Administrator on 2019/3/9 0009.
 */
@Module
public class EngineGeneratorModule {
    @RandomScope
    @Provides
    EngineGenerator provideEngineGenerator(){
        return new EngineGenerator("this is a EngineGenerator from EngineGeneratorModule");
    }
}
