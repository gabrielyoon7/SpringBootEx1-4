package com.example.springboot_ex02_javacodedi.bean;

public class PrinterA implements Printer{
    @Override
    public void print(String message) {
        System.out.println("Printer A : "+message);
    }
}