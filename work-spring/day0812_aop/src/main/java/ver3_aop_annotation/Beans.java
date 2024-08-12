package ver3_aop_annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ver3_aop_annotation")
@EnableAspectJAutoProxy
public class Beans {
    // 직접 작성한 java에는 @Component 붙이고 한꺼번에 스캔하는게 편함.
    // 다만 라이브러리 객체를 스프링에 등록해놓고 싶으면
    // <bean> 태그 쓰거나 아니면 자바에서 @Bean 애노테이션 써야지 뭐 별수있나..
}
