package framework;

import java.lang.annotation.*;

@Target(value=ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)

public @interface MethodAutorun {
	String run();
}
