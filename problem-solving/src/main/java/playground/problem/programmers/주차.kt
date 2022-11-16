package playground.problem.programmers
import java.time.*
import java.time.temporal.ChronoUnit

class Solution2 {

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        val fee = Fee(fees[0], fees[1], fees[2], fees[3])

        val traces = mutableListOf<InOutTrace>()

        for (record in records) {
            val split = record.split(" ")
            val time = split[0].split(":")
            val localTime = LocalTime.of(time[0].toInt(), time[1].toInt())
            val carNo = split[1]
            val inOut = split[2]

            if (inOut == "IN") {
                val trace = traces.find { it.carNo == carNo }

                if (trace == null) {
                    traces.add(InOutTrace(localTime, carNo))
                } else {
                    trace.inTime = localTime
                }

            } else {
                val trace = traces.find { it.carNo == carNo }!!
                trace.updateOutTime(localTime)
                fee.calcAccumulatedTime(trace)
            }
        }

        //출차 시간이 없는 차량 요금 계산
        traces.filter { it.inTime != null && it.outTime == null }
            .sortedBy { it.carNo }
            .forEach { fee.calcAccumulatedTime(it) }


        //
        return traces.map {
            it.fee = fee.finalCalc(it)
            it
        }.sortedBy { it.carNo }
            .map { it.fee }.toIntArray()
    }
}

data class InOutTrace(
    var inTime: LocalTime?,
    val carNo: String,
) {
    var outTime: LocalTime? = null
    var accumulateTime = 0
    var fee = 0

    fun updateOutTime(outTime: LocalTime) {
        this.outTime = outTime
    }

    fun accumulateTime(min: Int) {
        this.accumulateTime += min
        this.inTime = null
        this.outTime = null
    }
}

data class Fee(
    val defaultTime: Int,
    val defaultFee: Int,
    val unitTime: Int,
    val unitFee: Int
) {

    //주차 시간 누적
    fun calcAccumulatedTime(trace: InOutTrace) {
        val diffMin = ChronoUnit.MINUTES.between(trace.inTime!!, trace.outTime ?: LocalTime.of(23, 59))

        trace.accumulateTime(diffMin.toInt())
    }

    fun finalCalc(trace: InOutTrace): Int {
        return if (trace.accumulateTime <= defaultTime) {
            defaultFee
        } else {
            defaultFee + (Math.ceil(((trace.accumulateTime - defaultTime) / unitTime.toDouble())).toInt()) * unitFee
        }
    }
}