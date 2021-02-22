fun main() {
    val classCount = readLine()!!.toLong()
    val classPerson = readLine()!!.split(" ")

// 감독관(supervisor)
    val sup = readLine()!!.split(" ")
    val mainSup = sup[0].toInt()
    val subSup = sup[1].toInt()

// 시험장에 총감독관은 1명
// 시험장의 개수가 1 <= N <= 1,000,000 이고 감독관들이 감시할 수 있는 최소 명수는 1 이므로 Long 타입으로 선언
    var supervisor: Long = classCount

    for (i in classPerson.indices) {
// 부감독관이 필요한 경우
        if ((classPerson[i].toInt() - mainSup) > 0) {
            supervisor += ((classPerson[i].toInt() - mainSup) / subSup)
// 남는 응시생이 있다면 부감독관 추가
            if (((classPerson[i].toInt() - mainSup) % subSup) > 0) {
                supervisor++
            }
        }
    }

    print(supervisor)
}