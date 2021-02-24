// Course type 정의
typealias Course = (S: Int, T: Int)

// 강의의 개수 입력받기
let N = Int(readLine()!)!

// 강의정보(시작시간, 끝나는시간) 입력받기
var courses = [Course]()
for _ in 0..<N {
    let input = readLine()!.split(separator: " ").map { Int(String($0))! }
    courses.append((S: input[0], T: input[1]))
}

// 시작 시간이 빠른 순으로 정렬
courses.sort(by: { $0.S < $1.S })

// 끝나는 시간 기준 우선순위 큐 선언
var queue = [courses[0].T]
var count = 1

// 전체 강의 loop
for i in 1..<N {
    if courses[i].S >= queue.first! { // 시작 시간이 top 노드보다 크거나 같을 경우(비어있는 강의실이 있을 경우)
        // top 노드에 현재 강의 배치
        queue[0] = courses[i].T
        
        // heap 조건을 충족하기 위해 정렬
        var index = 0
        while true {
            // 자식 노드의 인덱스(left, right)
            let leftChildIndex = (index * 2) + 1
            let rightChildIndex = leftChildIndex + 1
            
            /* IndexOutOfRange 오류를 피하기 위해
             자식 노드가 0개, 1개, 2개인 경우를 나누어 로직 구현함 */
            if leftChildIndex > count - 1 { // 자식 노드가 0개인 경우 loop break
                break
            } else if rightChildIndex > count - 1 { // 자식 노드가 left만 있는 경우
                if queue[index] > queue[leftChildIndex] { // left보다 클 경우 swap
                    queue.swapAt(index, leftChildIndex)
                    index = leftChildIndex
                } else { // 아닐 경우 Heap 조건을 충족하므로 break
                    break
                }
            } else { // 자식 노드가 2개인 경우
                // left와 right 중 더 작은 값 선택
                let minIndex = queue[leftChildIndex] < queue[rightChildIndex] ? leftChildIndex : rightChildIndex
                
                if queue[index] > queue[minIndex] { // 자식 노드보다 클 경우 swap
                    queue.swapAt(index, minIndex)
                    index = minIndex
                } else { // 아닐 경우 Heap 조건을 충족하므로 break
                    break
                }
            }
        }
    } else { // 시작 시간이 top 노드보다 직을 경우(비어있는 강의실이 없을 경우)
        // 새로운 강의실에 강의 배치
        queue.append(courses[i].T)
        count += 1
        
        // heap 조건을 충족하기 위해 정렬
        var index = count - 1
        while true {
            // index가 top인 경우 break
            if index == 0 {
                break
            }
            
            // 부모 노드의 인덱스
            let parentIndex = index % 2 == 0 ? index / 2 - 1 : index / 2
            
            if queue[index] < queue[parentIndex] { // 부모 노드가 더 클 경우 swap
                queue.swapAt(index, parentIndex)
                index = parentIndex
            } else { // 아닐 경우 Heap 조건을 충족하므로 break
                break
            }
        }
    }
}

// 최소 강의실 개수 출력
print(count)
