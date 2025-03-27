package annotation.custom.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // Method 타입 타겟
@Repeatable(ModelDescriptionPrints.class)
public @interface ModelDescriptionPrint {

    String model();
    String description();

}
