fun main() {
    val meetingCount = readLine()!!.toInt()
    val meetingArr = mutableListOf<Pair<Int, Int>>()
    var result = 0

    // 회의 시간 배열 초기화
    for (i in 0 until meetingCount) {
        val time = readLine()!!.split(" ")
        meetingArr.add(Pair(time[0].toInt(), time[1].toInt()))
    }

    // 종료시간 기준 정렬(같다면 시작시간 기준 정렬) NLog(N)
    meetingArr.sortWith(compareBy ({ it.second }, { it.first }))
    // meetingArr.sortWith(Comparator { pre, next ->
    //     if (pre.second == next.second) {
    //         pre.first - next.first
    //     } else {
    //         pre.second - next.second
    //     }
    // })

    // endTime = 최초회의 끝나는 시간
    var endTime = meetingArr[0].second
    // 최초회의 카운팅
    result++

    for (i in 1 until meetingCount) {
        if (meetingArr[i].first >= endTime) {
            result++
            endTime = meetingArr[i].second
        }
    }

    print(result)
}