package com.example.springboot_ex03_annotationdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  다음으로 나오는 @SpringBootApplication 어노테이션은 다음 세 가지 기능을 수행함.
 *
 * @Configuration
 * Bean을 생성할 때 Singletone으로 한번만 생성함.
 *
 * @EnableAutoConfiguration
 * 스프링 어플리케이션 컨텍스트 (Application Context)를 만들 때 자동으로 설정하는 기능을 켬.
 * 사용자가 필요할 것 같은 빈을 추측해서 ApplicationContext를 만들 때 필요한 설정을 함.
 * 클래스패스(Class Path)를 기준으로 클래스를 찾아 설정함.
 * ex) 클래스패스에 tomcat-embeded.jar이 있으면 TomcatEmbeddedServletContainerFactory가 있을 것이라고 추측해서 설정함.
 *
 * @ComponentScan
 * 지정한 위치 이하에 있는 @Component와 @Configuration이 붙은 클래스를 스캔해서 빈으로 등록함.
 *
 * */

@SpringBootApplication //자동으로 빈 검색
public class Ex03AnnotationDiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ex03AnnotationDiApplication.class, args); //내장 톰캣을 실행한 다음 Web Application Context를 생성함. (기본 포트 8080)
        /**
         * 기본 포트를 8080에서 다른 것으로 바꾸고 싶으면 resources 폴더의 application.properties에 server.port=숫자 로 입력해주면 포트번호 변경 가능.
         * */
    }

}