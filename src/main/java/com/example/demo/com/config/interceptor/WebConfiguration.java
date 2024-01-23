package com.example.demo.com.config.interceptor;

import com.example.demo.com.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**");
        //위의 코드는 addPathPatterns을 통해 어디에 해당 인터셉터를 적용 시킬지 설정
        //addPathPatterns("/board/**");
        //제외시키고 싶은게 있다면 excludePathPatterns()메서드를 사용
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET","POST","DELETE","PUT")
                .allowCredentials(true);
//        (Cross-Origin Resource Sharing,CORS)란
//        다른 출처의 자원을 공유할 수 있도록 설정하는 권한 체제
//        즉, CORS 를 설정하지 않거나 잘못 설정하는 경우, 리소스를 공유하지 못한다.
    }
}
