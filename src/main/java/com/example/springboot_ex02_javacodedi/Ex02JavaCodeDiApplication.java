package com.example.springboot_ex02_javacodedi;

import com.example.springboot_ex02_javacodedi.bean.Config;
import com.example.springboot_ex02_javacodedi.bean.Member;
import com.example.springboot_ex02_javacodedi.bean.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


//@SpringBootApplication
/**
 * 스프링 부트는 @SpringBootApplication 어노테이션에 의해 자동으로 설정이 이루어지고 컴포넌트가 등록이 되기 때문에 먼저 주석처리하여 자동 등록을 막는다.
 * */
public class Ex02JavaCodeDiApplication {
    public static void main(String[] args) {

        //1. IoC 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        /**
         * 여기에서 수작업으로 어플리케이션 컨텍스트를 만들고 Config.java를 AnnotationConfigApplicationContext에 파라미터로 넘겨서
         * 어플리케이션 컨텍스트를 만들어  ApplicationContext 클래스 타입의 context 변수에 할당한다.
         * AnnotationConfigApplicationContext 클래스 타입으로 객체를 생성하고 ApplicationContext 클래스 타입의 변수에 할당 하는 것은
         * 객체 지향 프로그램에서 전형적으로 사용되는 자식 객체(AnnotationConfigApplicationContext)를 부모 객체(ApplicationContext)에 대입할 수 있다는 디자인 패턴이 적용된 모습이다.
         * */

        //2. Member Bean 가져오기
        Member member1 = (Member) context.getBean("member1");
        member1.print();
        /**
         * 빈을 가져올 때 스프링 컨테이너로부터 빈을 리턴받아 형변환하여 사용하고 있다.
         * */

        //3. Member Bean 가져오기
        Member member2 = context.getBean("hello", Member.class);
        member2.print();
        /**
         * Config.java에서 빈 어노테이션을 지정할 때 별도의 이름을 지정하였으므로, 그 이름으로 빈을 요청하고 리턴받는 방법으로 사용하고 있다.
         * */

        //4. PrinterB bean 가져오기
        Printer printer = context.getBean("printerB", Printer.class);
        member1.setPrinter(printer);
        member1.print();
        /**
         * 미리 형을 지정하여 빈을 리턴받는 방법을 보여주고 있다.
         * 세터(setPrinter)를 통해 빈에 등록된 값을 나중에 변경할 수 있음을 보여준다.
         * */

        //5. 싱글톤인지 확인
        if(member1==member2){
            System.out.println("동일한 객체입니다.");
        }
        else {
            System.out.println("서로 다른 객체입니다.");
        }
        /**
         * member1과 member2는 같은 클래스 타입의 변수지만 서로 다른 메서드에서 각각 new를 통해 생성되었으므로 같은 객체가 아니다.
         * */

    }
}