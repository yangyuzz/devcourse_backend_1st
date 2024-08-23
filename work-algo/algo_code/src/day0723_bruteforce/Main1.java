import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) throws IOException {
        // 원재의 메모리 복구하기 문제 풀이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine()); // 테스트 횟수

        for (int tc = 1; tc <= TC; tc++) {
            char[] input = br.readLine().toCharArray(); // 만들어야 하는 목적 비트
            char[] result = new char[input.length];
            Arrays.fill(result, '0'); // 문제의 시나리오 그대로 코딩해보자

            int ans = 0; // 최소한의 비트를 선택하는 횟수
            for (int i = 0; i < input.length; i++) { // 비트는 왼쪽에서 오른쪽으로 이동하면서

                if (input[i] != result[i]) { // i번 비트는 일단 바꾸긴 해야되네.. 오른쪽이 다 바뀌더라도 ㅠㅠ
                    for (int j = i; j < input.length; j++) { // j는 i비트에서 출발해서 오른쪽 쭉 밀리
                        result[j] = input[i]; //해당 비트로 오른쪾 쭉 밀어버리기
                    }
                    ans++;
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
