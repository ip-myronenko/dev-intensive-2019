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
    SECOND{override fun plural (x:Int): String?{
        var output:String=" "
        var temp:String="секунд"
        if (x==null){return null} else {
        when (x) {
            1 -> output="$x ${temp}у"
            in 5..20 -> output="$x ${temp}"
            else -> if (x.toString().endsWith("1")) {output="$x ${temp}у"}
            else if ((x.toString().endsWith("2")) or (x.toString().endsWith("3")) or (x.toString().endsWith("4"))) {output="$x ${temp}ы"}
            else output="$x ${temp}"}
        return output}
    }},
    MINUTE{override fun plural (x:Int): String?{
        var output:String=" "
        var temp:String="минут"
        if (x==null){return null} else {
        when (x) {
            1 -> output="$x ${temp}у"
            in 5..20 -> output="$x ${temp}"
            else -> if (x.toString().endsWith("1")) {output="$x ${temp}у"}
            else if ((x.toString().endsWith("2")) or (x.toString().endsWith("3")) or (x.toString().endsWith("4"))) {output="$x ${temp}ы"}
            else output="$x ${temp}"}
        return output}
    }},
    HOUR{override fun plural (x:Int): String?{
        var output:String=" "
        var temp:String="час"
        if (x==null){return null} else {
        when (x) {
            1 -> output="$x ${temp}"
            in 5..20 -> output="$x ${temp}ов"
            else -> if (x.toString().endsWith("1")) {output="$x ${temp}"}
            else if ((x.toString().endsWith("2")) or (x.toString().endsWith("3")) or (x.toString().endsWith("4"))) {output="$x ${temp}а"}
            else output="$x ${temp}ов"}
        return output}
    }},
    DAY{override fun plural (x:Int): String?{
        var output:String=" "
        if (x==null){return null} else {
        when (x) {
            1 -> output="$x день"
            in 5..20 -> output="$x дней"
            else -> if (x.toString().endsWith("1")) {output="$x день"}
            else if ((x.toString().endsWith("2")) or (x.toString().endsWith("3")) or (x.toString().endsWith("4"))) {output="$x дня"}
            else output="$x дней"}
        return output}
    }},
    MONTH{override fun plural (x:Int): String?{
        var output:String=" "
        var temp:String="месяц"
        if (x==null){return null} else {
        when (x) {
            1 -> output="$x ${temp}"
            in 5..20 -> output="$x ${temp}ев"
            else -> if (x.toString().endsWith("1")) {output="$x ${temp}"}
            else if ((x.toString().endsWith("2")) or (x.toString().endsWith("3")) or (x.toString().endsWith("4"))) {output="$x ${temp}а"}
            else output="$x ${temp}ев"}
        return output}
    }},
    YEAR{override fun plural (x:Int): String?{
        var output:String=" "
        var temp:String="год"
        if (x==null){return null} else {
        when (x) {
            1 -> output="$x ${temp}"
            in 5..20 -> output="$x лет"
            else -> if (x.toString().endsWith("1")) {output="$x ${temp}"}
            else if ((x.toString().endsWith("2")) or (x.toString().endsWith("3")) or (x.toString().endsWith("4"))) {output="$x ${temp}а"}
            else output="$x лет"}
        return output}
    }};

    abstract fun plural (x:Int): String?
}



fun Date.humanizeDiff(date:Date = Date()): String? {
    var output:String=" "
    var result=date.time - this.time
    println("после вычисления результат: $result")
    if (result<0) {
        println("результат определился отрицательным")
        result=result*-1
        when (result) {
            in 0..1200 -> output="только что"
            in 1201..45200 -> output="через несколько секунд"
            in 45201..75200 -> output="через минуту"
            in 75201..2700200 -> {var n:Long=result/60000
                var nI=n.toDouble().toInt()
                when (nI) {
                    1 -> output="через $nI минуту"
                    in 5..20 -> output="через $nI минут"
                    else -> if (nI.toString().endsWith("1")) {output="через $nI минуту"}
                    else if ((nI.toString().endsWith("2")) or (nI.toString().endsWith("3")) or (nI.toString().endsWith("4"))) {output="через $nI минуты"}
                    else output="через $nI минут"}
            }
            in 2700201..4500200 -> output="через час"
            in 4500201..79200200 -> {var n:Long=result/60000/60
                var nI=n.toDouble().toInt()
                when (nI) {
                    1 -> output="через $nI час"
                    in 5..20 -> output="через $nI часов"
                    else -> if (nI.toString().endsWith("1")) {output="через $nI час"}
                    else if ((nI.toString().endsWith("2")) or (nI.toString().endsWith("3")) or (nI.toString().endsWith("4"))) {output="через $nI часа"}
                    else output="через $nI часов"}
            }
            in 79200201..93600200 -> output="через день"
            in 93600201..31104000054 -> {var n:Long=result/60000/60/24
                var nI=n.toDouble().toInt()
                when (nI) {
                    1 -> output="через $nI день"
                    in 5..20 -> output="через $nI дней"
                    else -> if (nI.toString().endsWith("1")) {output="через $nI день"}
                    else if ((nI.toString().endsWith("2")) or (nI.toString().endsWith("3")) or (nI.toString().endsWith("4"))) {output="через $nI дня"}
                    else output="через $nI дней"}}
            else -> output="через более года"
        }
    } else {
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