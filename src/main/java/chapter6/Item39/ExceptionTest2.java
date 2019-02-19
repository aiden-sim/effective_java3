package chapter6.Item39;

import java.lang.annotation.*;

// 배열 매개변수를 받는 애너테이션 타입
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest2 {
    Class<? extends Throwable>[] value();
}
