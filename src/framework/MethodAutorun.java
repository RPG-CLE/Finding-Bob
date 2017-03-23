package framework;

import java.lang.annotation.*;

@Target(value=ElementType.TYPE)
@Documented
@Retention(RetentionPolicy.RUNTIME)

/**
 * Annotation qui indique qu'une classe est autorun
 * 
 * @author Araya, Boutahlil, Delavergne, Donnart, Pineau, Vallée
 *
 */

public @interface MethodAutorun {
	String run();
}
