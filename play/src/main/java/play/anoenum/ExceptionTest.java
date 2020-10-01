package play.anoenum;

import java.lang.annotation.*;

/**
 * アノテーションが付けられたメソッドは、成功するには指定された例外を
 * スローしなければならないテストメソッドであることを示す。
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
