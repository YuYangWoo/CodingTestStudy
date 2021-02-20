struct Meeting { // Meeting 구조체 정의
    var start: Int // 시작 시간
    var end: Int // 끝나는 시간
}

let N = Int(readLine()!)! // 회의의 수 N
var meeting = [Meeting](repeating: Meeting(start: 0, end: 0), count: N) // 회의의 정보 배열
for i in 0..<N {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    meeting[i].start = input[0]
    meeting[i].end = input[1]
}

meeting.sort(by: { // 끝나는 시간 기준 오름차순 정렬(같으면 시작 시간 기준 오름차순 정렬)
    if $0.end == $1.end {
        return $0.start < $1.start
    }
    return $0.end < $1.end
})

var endTime = -1 // 끝나는 시간의 max 값을 저장하는 변수(line 24 for에서 사용)
var result = 0 // 회의의 최대 개수

for i in 0..<N {
    if endTime <= meeting[i].start { // 시작 시간이 endTime의 값보다 크면 회의 개수 증가
        endTime = meeting[i].end // endTime 변수 갱신
        result += 1
    }
}

print(result) // 정답 출력
