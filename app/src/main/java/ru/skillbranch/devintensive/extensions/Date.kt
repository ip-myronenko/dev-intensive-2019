package ru.skillbranch.devintensive.extensions
import ru.skillbranch.devintensive.utils.Utils
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR
const val MONTH = 30 * DAY
const val YEAR = 12 * MONTH

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat (pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add (value:Int, units: TimeUnits=TimeUnits.SECOND) : Date {
    var time=this.time
    time+=when (units){
        TimeUnits.SECOND-> value * SECOND
        TimeUnits.MINUTE-> value * MINUTE
        TimeUnits.HOUR-> value * HOUR
        TimeUnits.DAY-> value * DAY
        TimeUnits.MONTH-> value * MONTH
        TimeUnits.YEAR-> value * YEAR
    }
    this.time = time
    return this
}

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY,
    MONTH,
    YEAR
}

fun Date.humanizeDiff(date:Date = Date()): String {

    var output:String=" "
    var result=date.time - this.time
    if (result<0) output="опережая время" else {
    when (result) {
        in 0..1200 -> output="только что"
        in 1201..45200 -> output="несколько секунд назад"
        in 45201..75200 -> output="минуту назад"
        in 75201..2700200 -> {var n:Long=result/60000
            var nI=n.toDouble().toInt()
            when (nI) {
                1 -> output="$nI минуту назад"
                in 5..20 -> output="$nI минут назад"
                else -> if (nI.toString().endsWith("1")) {output="$nI минуту назад"}
                        else if ((nI.toString().endsWith("2")) or (nI.toString().endsWith("3")) or (nI.toString().endsWith("4"))) {output="$nI минуты назад"}
                        else output="$nI минут назад"}
            }
        in 2700201..4500200 -> output="час назад"
        in 4500201..79200200 -> {var n:Long=result/60000/60
            var nI=n.toDouble().toInt()
            when (nI) {
                1 -> output="$nI час назад"
                in 5..20 -> output="$nI часов назад"
                else -> if (nI.toString().endsWith("1")) {output="$nI час назад"}
                else if ((nI.toString().endsWith("2")) or (nI.toString().endsWith("3")) or (nI.toString().endsWith("4"))) {output="$nI часа назад"}
                else output="$nI часов назад"}
        }
        in 79200201..93600200 -> output="день назад"
        in 93600201..31104000054 -> {var n:Long=result/60000/60/24
            var nI=n.toDouble().toInt()
            when (nI) {
                1 -> output="$nI день назад"
                in 5..20 -> output="$nI дней назад"
                else -> if (nI.toString().endsWith("1")) {output="$nI день назад"}
                else if ((nI.toString().endsWith("2")) or (nI.toString().endsWith("3")) or (nI.toString().endsWith("4"))) {output="$nI дня назад"}
                else output="$nI дней назад"}}
        else -> output="более года назад"
    }
    }

    return output
}