import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력받을 객체
        StringTokenizer tokenizer; // 입력받을 객체를 쪼개줄 객체

        int N = Integer.parseInt(reader.readLine()); // 시험장의 수를 입력받는다
        int[] A = new int[N]; // 각 시험자의 응시자 수를 담을 배열
        tokenizer = new StringTokenizer(reader.readLine()); // 각 시험장의 응시자 수를 입력받는다

        for (int i = 0; i < N; i++) { // 입력받은 응시자 수들을 " " 으로 쪼개서 A 에 담아준다
            A[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine()); // 총 감독관과 부 감독관이 감시 할 수 있는 학생의 수를 입력받는다.
        int B = Integer.parseInt(tokenizer.nextToken()); // 총 감독관이 감시 할 수 있는 학생의 수
        int C = Integer.parseInt(tokenizer.nextToken()); // 부 감독관이 감시 할 수 있는 학생의 수
        long result = 0; // 필요한 총 인원

        for (int i = 0; i < N; i++) { // 시험장을 처음부터 끝까지 조회
            result++; // 총 감독관이 무조건 1명이어야 함으로 어느 시험장이든 1명 추가
            if (A[i] <= B) { // 총 감독관이 감시 할 수 있는 인원보다 시험자으이 응시자 수가 더 작거나 같으면 필요한 인원은 1명임으로 1명만 추가하고 다음 시험장으로
                continue;
            }

            int remainingPeople = A[i] - B; // 총 감독관이 감시할 수 있는 인원을 제외한 나머지 인원
            result += remainingPeople / C; // 부 감독관이 필요한 수 만큼 총 인원에 추가

            if (remainingPeople % C != 0) { // 나머지 인원이 있으면 1명 추가
                result++;
            }
        }

        System.out.println(result); // 총 인원수 출력
    }
}

