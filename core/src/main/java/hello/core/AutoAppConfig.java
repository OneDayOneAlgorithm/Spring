package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 스캔할 페키지 설정
        basePackages = "hello.core.member",
        // 시작지점 패키지
        basePackageClasses = AutoAppConfig.class,
        // Configuration 어노테이션이 붙어있는 클래스는 스캔하지 않는다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = Configuration.class)
)
public class AutoAppConfig {
    // 수동으로 빈을 등록해주면 자동 빈보다 우선권을 가져서 이름 중복이 일어나지 않는다.
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
