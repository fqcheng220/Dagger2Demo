package fqcheng220.dagger2demo.lesson1.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * @author fqcheng220
 * @version V1.0
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2019/3/8 20:32
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Scope
public @interface AnotherScope {
}
