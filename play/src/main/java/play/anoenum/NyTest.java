package play.anoenum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * このアノテーションが付けられたメソッドがテストメソッドであることを示す。
 * パラメータなしのstaticのメソッドに対してだけ使うこと
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface NyTest {
}
