package test05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test05 {
    public static void main(String[] args) {
        /**
         * [Stream API의 특징]
         * 어떠한 입력 데이터(생성된 스트림)를 가지고 필요한 과정을 거치면서 아웃풋 데이터를 생성해낸다.
         * 원본을 변경하지는 않고 원하는 데이터를 생성해내는 과정.
         * 여러번 재사용 하지 않는 일회용
         * 내부 반복으로 작업을 처리한다.
         */
        String[] names = {"yangyu", "yechan", "hyunsub", "minwoo"};
        List<String> list = Arrays.asList(names);

        Stream<String> arrStream = Arrays.stream(names); // 배열에서 스트림 생성해내기
        Stream<String> listStream  = list.stream(); // 컬렉션들은 내부에서 자연스럽게 스트림 뽑아내는 메소드를 제공함.

        arrStream. sorted().forEach(System.out::println);
    }
}
