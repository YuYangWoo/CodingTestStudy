import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // 입력 받을 객체
        StringTokenizer tokenizer; // 입력 받은 값을 쪼개줄 객체
        int num = Integer.parseInt(reader.readLine()); // 강의 수
        int[][] lecture = new int[num][2]; // 강의 시작과 끝나는 시간 담을 배열

        for (int i = 0; i < num; i++) { // 강의가 시작되는 시간과 끝나는 시간을 입력 받는열다
            tokenizer = new StringTokenizer(reader.readLine());
            lecture[i][0] = Integer.parseInt(tokenizer.nextToken());
            lecture[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(lecture, new Comparator<int[]>() { // 강의 시간이 담겨 있는 배열을 강의 시작 시간 기준으로 오름차순으로 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        TreeSet<Double> roomEndTime = new TreeSet<>(); // 이진 검색 트리형태로 데이터를 저장하는 자료구조 (객체를 담을 시 바로바로 정렬을 해서 담아줌), 강의가 끝나는 시간을 담아줄 객체
        roomEndTime.add((double) lecture[0][1]); // 시작시간이 가장 빠른 강의의 끝나는 시간을 먼저 담아주고 시작

        for (int i = 1; i < num; i++) { // 그다음으로 시작시간이 빠른 강의시간 부터 반복
            if (roomEndTime.first() <= lecture[i][0]) { // roomEndTime 에 들어있는 강의가 끝나는 시간중에 가장 빠른 시간보다 현재 강의의 시작시간이 더 느리면 roomEndTime 에서 가장 빠른 시간을 제거
                roomEndTime.pollFirst();                // -> 사람말로 풀면 현재 lecture 의 시작 시간이 앞에서 있던 강의의 끝나는 시간 뒤임으로 앞의 강의를 빼주는것...
            }
            boolean isAdded = roomEndTime.add((double) lecture[i][1]); // 현재 강의의 끝나는 시간을 담아준다
            if (!isAdded) { // TreeSet 은 중복되는 값을 허용하지 않음으로 로직에 영향이 안가는 만큼 값을 수정해서 저장 -> 이부분은 다른 자료구조를 찾아볼것...
                roomEndTime.add((double) lecture[i][1] - 0.000001 * i);
            }
        }

        System.out.println(roomEndTime.size()); // 이 객체의 크기가 곧 강의실 수와 같으므로 출력
    }
}

