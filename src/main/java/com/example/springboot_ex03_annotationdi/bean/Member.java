package com.example.springboot_ex03_annotationdi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Member 클래스는 생성자를 통한 값 주입과 생성 이후 세터를 통한 값의 주입이 가능하도록 코딩되어 있음.
 * @Value 어노테이션은 세터의 역할을 수행하기에, 객체가 생성될 때 값을 가지고 만들 수 있도록 값의 지정이 가능함.
 * 생성 후 값을 바꿀 일이 없으면 하단 세터 부분(setName, setNickname, ...)의 코드는 필요 없지만, 프로그램 수행 중에 내용이 바뀌어야 한다면 하단의 세터 부분을 이용해 값을 바꿀 수 있음.
 * */

@Component //다음에 나오는 클래스인 Memeber 클래스를 빈으로 등록하겠다는 의미
public class Member {
    @Value("홍길동") //빈이 생성될 때 name의 변수의 기본값으로 "홍길동"을 지정
    private String name;

    @Value("도사") //빈이 생성될 때 nickname의 변수의 기본값으로 "도사"를 지정W
    private String nickname;

    @Autowired //빈이 생성될 때 printer 변수가 참조할 객체를 자동으로 찾아옴.
    @Qualifier("printerA") //유사한 객체가 여러개 일때 빈의 이름으로 정확하게 지정함.
    private Printer printer;
    public Member(){}

    public Member(String name, String nickname, Printer printer){
        this.name =name;
        this.nickname = nickname;
        this.printer = printer;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void print(){
        printer.print("Hello "+name+" : "+nickname);
    }
}