package ru.skillbranch.devintensive.extensions

fun String.truncate(x:Int=16):String{
    var s:String=this
    if (s.length>=x) {s=s.substring(0, x).trimEnd()+"..."}
    else {s=s.trimEnd()}
    return s
}

fun String.stripHtml():String{
    var s:String=this
    var output:String
//    println(s)
    while (s.contains("<", false)){
        s=s.removeRange(s.indexOf("<", 0, false), s.indexOf(">", 0, false) + 1)
    }
    s=s.replace("&", "", false)
    s=s.replace("<", "", false)
    s=s.replace(">", "", false)
    s=s.replace("'", "", false)
    s=s.replace(""""""", "", false)
    s=s.trim()
    while (s.contains("  ", false)){
        s=s.replace("  ", " ", false)
    }
    return s
}