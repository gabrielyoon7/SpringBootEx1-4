package com.example.springboot_ex03_annotationdi.bean;

import org.springframework.stereotype.Component;

@Component("printerA") //다음에 나오는 클래스인 PirnterA를 빈으로 등록하겠다는 의미. (이름도 지정한 것)
public class PrinterA implements Printer{
    @Override
    public void print(String message) {
        System.out.println("Printer A : "+message);
    }
}