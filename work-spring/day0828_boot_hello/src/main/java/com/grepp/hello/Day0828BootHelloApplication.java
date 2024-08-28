package com.grepp.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day0828BootHelloApplication {
    // 이 main 함수를 실행시키면 내장 톰캣이 실행되면서 현재 프로젝트의 리소스를 넣고 돌려줍니다.
    // 그 말은 이 컴퓨터에 아예 톰캣이 없어도 이 main은 웹서버로 돌아간다는 이야기죠.
    public static void main(String[] args) {
        SpringApplication.run(Day0828BootHelloApplication.class, args);
    }

}
