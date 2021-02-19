let N = Int(readLine()!)! // 시험장의 개수 N
var A = readLine()!.split(separator: " ").map { Int(String($0))! } // 응시자의 수 배열 A
let temp = readLine()!.split(separator: " ").map { Int(String($0))! }
let B = temp[0] // 총감독관이 감시할 수 있는 응시자 수 B
let C = temp[1] // 부감독관이 감시할 수 있는 응시자 수 C
var result = N // 최소 감독관 수. 총감독관은 시험장에 1명씩 꼭 필요하므로 N을 대입하고 시작.

for i in 0..<N { // 시험장 개수만큼 loop
    let num = A[i] - B // 총감독관은 반드시 1명씩이므로 B를 뺀 값으로 부감독관 수 계산
    
    if num > 0 { // 음수라면 부감독관이 필요없는 경우이므로 제외
        let hasMod = num % C != 0 ? 1 : 0 // 나머지가 존재하면 부감독관 1명이 더 필요함
        result += num / C + hasMod // 응시생 num을 C로 나눈 값 + hasMod가 필요한 부감독관의 수
    }
}

print(result) // 최소 감독관 수 출력
