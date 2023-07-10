package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        // AnnotationConfigApplicationContext은 어노테이션 설정을 사용하여 ApplicationContext를 생성하고 구성하는 클래스이다.
        // ApplicationContext는 Bean이라는 개체의 인스턴스와 설정 정보를 담고 있는 스프링 컨테이너의 인스턴스이다.
        // AnnotationConfigApplicationContext을 사용하면 @Configuration 어노테이션이 붙은 Java클래스를 인수로 전달하여 ApplicationContext를 생성하고 구성할 수 있다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        // MemberService 타입의 스프링 빈을 가져온다.
        MemberService memberService = ac.getBean(MemberService.class);
        // memberService가 MemberService 클래스의 인스턴스인지 검증한다.
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
