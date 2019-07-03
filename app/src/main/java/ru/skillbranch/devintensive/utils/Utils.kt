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
        //TODO
        return " "
    }
    fun toInitials(firstName:String?, lastname:String?): String {
        val initials:String ="${if (firstName.isNullOrEmpty()) "" else firstName?.getOrNull(0)?.toUpperCase().toString()}"+"${if (lastname.isNullOrEmpty()) "" else lastname?.getOrNull(0)?.toUpperCase().toString()}"
        if (initials.isNullOrEmpty()) return "null" else
        return initials
    }
}