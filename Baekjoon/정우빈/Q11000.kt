import java.util.*

fun main() {
    // 강의실 수
    val classCount = readLine()!!.toInt()
    // 강의실 시작시간과 끝시간
    val classArr = mutableListOf<Pair<Int, Int>>()
    // 우선순위큐를 사용하여 우선순위가 작은 숫자 순
    val priorityQueue = PriorityQueue<Int>()

    // 강의실 시간 배열 초기화
    for (i in 0 until classCount) {
        val time = readLine()!!.split(" ")
        classArr.add(Pair(time[0].toInt(), time[1].toInt()))
    }

    // 시작시간 기준으로 정렬 후 시작시간이 같다면 끝시간으로 정렬
    classArr.sortWith(compareBy ({ it.first }, { it.second }))

    // 처음 강의 끝시간을 우선순위 큐에 추가
    priorityQueue.offer(classArr[0].second)
    for (i in 1 until classCount) {
        // 우선순위 큐 최상위 값과 비교하여 기존 강의실과 시간이 겹치지 않으면 최상위 삭제
        if (priorityQueue.peek() <= classArr[i].first) {
            priorityQueue.poll()
        }
        // 다음 강의 끝시간 추가
        priorityQueue.offer(classArr[i].second)
    }

    print(priorityQueue.size)
}