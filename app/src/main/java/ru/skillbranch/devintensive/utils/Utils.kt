package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.models.User

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ")
//        var firstName=parts?.getOrNull(0)
//        var lastName=parts?.getOrNull(1)
        var firstName=if(parts?.getOrNull(0).isNullOrEmpty()) "null" else parts?.getOrNull(0)
        var lastName=if(parts?.getOrNull(1).isNullOrEmpty()) "null" else parts?.getOrNull(1)
//        return Pair(firstName,lastName)
        println("$firstName $lastName")
        return firstName to lastName

    }

    fun transliteration(payload: String, divider: String= " "): String {
        var string:String=if (payload.isNullOrEmpty()) "null" else payload

        string=string.replace("а","a",false)
        string=string.replace("А","A",false)
        string=string.replace("б","b",false)
        string=string.replace("Б","B",false)
        string=string.replace("в","v",false)
        string=string.replace("В","V",false)
        string=string.replace("г","g",false)
        string=string.replace("Г","G",false)
        string=string.replace("д","d",false)
        string=string.replace("Д","D",false)
        string=string.replace("е","e",false)
        string=string.replace("Е","E",false)
        string=string.replace("ё","e",false)
        string=string.replace("Ё","E",false)
        string=string.replace("ж","zh",false)
        string=string.replace("Ж","Zh",false)
        string=string.replace("з","z",false)
        string=string.replace("З","Z",false)
        string=string.replace("и","i",false)
        string=string.replace("И","I",false)
        string=string.replace("й","i",false)
        string=string.replace("Й","I",false)
        string=string.replace("к","k",false)
        string=string.replace("К","K",false)
        string=string.replace("л","l",false)
        string=string.replace("Л","L",false)
        string=string.replace("м","m",false)
        string=string.replace("М","M",false)
        string=string.replace("н","n",false)
        string=string.replace("Н","N",false)
        string=string.replace("о","o",false)
        string=string.replace("О","O",false)
        string=string.replace("п","p",false)
        string=string.replace("П","P",false)
        string=string.replace("р","r",false)
        string=string.replace("Р","R",false)
        string=string.replace("с","s",false)
        string=string.replace("С","S",false)
        string=string.replace("т","t",false)
        string=string.replace("Т","T",false)
        string=string.replace("у","u",false)
        string=string.replace("У","U",false)
        string=string.replace("ф","f",false)
        string=string.replace("Ф","F",false)
        string=string.replace("х","h",false)
        string=string.replace("Х","H",false)
        string=string.replace("ц","c",false)
        string=string.replace("Ц","C",false)
        string=string.replace("ч","ch",false)
        string=string.replace("Ч","Ch",false)
        string=string.replace("ш","sh",false)
        string=string.replace("Ш","Sh",false)
        string=string.replace("щ","sh",false)
        string=string.replace("Щ","Sh",false)
        string=string.replace("ъ","",false)
        string=string.replace("ы","i",false)
        string=string.replace("Ы","I",false)
        string=string.replace("ъ","",false)
        string=string.replace("э","e",false)
        string=string.replace("Э","E",false)
        string=string.replace("ю","yu",false)
        string=string.replace("Ю","Yu",false)
        string=string.replace("я","ya",false)
        string=string.replace("Я","Ya",false)


        return string
    }
    fun toInitials(firstName:String?, lastname:String?): String {
        val initials:String ="${if (firstName.isNullOrEmpty()) "" else firstName?.getOrNull(0)?.toUpperCase().toString()}"+"${if (lastname.isNullOrEmpty()) "" else lastname?.getOrNull(0)?.toUpperCase().toString()}"
        if (initials.isNullOrEmpty()) return "null" else
        return initials
    }
}