package fqcheng220.dagger2demo.lesson3.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: (用一句话描述该文件做什么)
 * @date 2020/1/2 14:34
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Scope
public @interface AppScope {
}
