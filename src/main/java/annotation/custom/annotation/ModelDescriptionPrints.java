package annotation.custom.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // Method 타입 타겟
public @interface ModelDescriptionPrints {

    ModelDescriptionPrint[] value();

}
