package test06;

import test02.Student;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // 데이터에 번호 붙여놓고 그걸 이름처럼 식별용도에 쓰는 자료구조.
        int[] array = new int[10];

        // 배열은 사이즈 고정이고 빠름. 사이즈가 유동적이려면 리스트 자료구조 필요함.
//        ArrayList<Integer> list1 = new ArrayList<>();
//        LinkedList<Integer> list2 = new LinkedList<>();
        // List 인터페이스는 구현 내용은 없지만 리스트가 자료구조가 갖춰야 하는 기능들을 나열해 놓았음.
        // ex) add, remove, get, ...
        List<Integer> list1 = new ArrayList<>(); // 실제 데이터를 배열로 관리함(배열의 장단점을 계승->데이터 변경 없이 읽기만 많이 하는 경우 좋음.)
        List<Integer> list2 = new LinkedList<>(); // 내부 데이터끼리 서로 주소를 기억하는 연결구조.
//        list2.add(2, 100);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 들어간 순서대로 나오기만 하면 되는 자료구조
        Queue <Integer> queue = new LinkedList<>(); // 링크드리스트에 있는 기능을 다 안쓰고 제한적으로 사용하게 됩니다.
//        queue.add(2, 100);  // 큐는 인덱스 지정해서 추가하는 기능 필요 없는 상황에서 쓰는거임. 즉, 실제 객체에 있는 기능이라도 안쓰고 제한적으로 활용함. (목적 확실히)
        Queue<Integer> queue1 = new ArrayDeque<>();
        // 코딩테스트 과정에서 중간 데이터 삽입 삭제 없고, 맨앞 맨 뒤로만 추가삭제 할때는 링크드 보다 얘가 조금 효율적일 때가 많으니 참고하세요.
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // 한쪽이 막혀있는 자료구조라 들어간 순서 역순으로 나옴.
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        // 만약 코테에서 되돌아가는 기능이 필요하면... new Stack 안하고 그냥 배열 만들어서 스택처럼 인덱스 ++, -- 하는게 나을 때가 많음.
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        Map<String, Student> map1 = new HashMap<>(); // 넣을 때의 키를 해시해서 나중에 그 해시 결과로 데이터 구분함.(순서없고, 정렬없고)
        Map<String, Student> map2 = new LinkedHashMap<>(); // 들어가는 순서 유지해줌.
        Map<String, Student> map3 = new TreeMap<>(); // 키의 정렬 기준으로 순서 맞춰줌.
    }
}















