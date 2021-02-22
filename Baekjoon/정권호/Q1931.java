import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 받는 객체
        StringTokenizer tokenizer; // 입력받을 객체를 쪼개줄 객체

        int N = Integer.parseInt(reader.readLine()); // 회의의 개수를 입력받는다.
        int[][] meetings = new int[N][2]; // 회의를 담을 배열
        for (int i = 0; i < N; i++) { // 회의의 시작시간과 끝시간을 받아서 배열에 저장
            tokenizer = new StringTokenizer(reader.readLine());
            meetings[i][0] = Integer.parseInt(tokenizer.nextToken());
            meetings[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(meetings, new Comparator<int[]>() { // 회의가 끝나는 순으로 정렬 만약 같다면 시작시간 순으로 정렬
            @Override                                   // 같으면 시작시간 순으로 정렬하는 이유는
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int result = 0; // 회의의 최대 개수
        int end = -1; // 회의가 가장 빨리 끝나는 시간

        for (int i = 0; i < N; i++) { // 회의가 끝내는 시간이 가장 빠른 시간부터 반복
            if (end <= meetings[i][0]) { // 회의가 가장 빨리 끝나는 시간보다 현재 회의가 시작하는 시간이 크거나 같으면 -> 가장 빨리 끝나는 시간 뒤에 현재 회의를 시작할 수 있다면
                result++; // 회의의 최대 개수 추가
                end = meetings[i][1]; // 가장 빨리 끝나는 시간을 현재 회의의 시작 시간으로 변경
            }
        }

        System.out.println(result); // 결과 출력
    }
}