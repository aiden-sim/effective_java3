package chapter6.Item39;

import java.lang.annotation.*;

// 매개변수 하나를 받는 애너테이션 타입
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}