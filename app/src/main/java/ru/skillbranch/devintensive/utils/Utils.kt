package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.models.User

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        //TODO: fix
        val parts : List<String>? = fullName?.split(" ")
        var firstName=parts?.getOrNull(0)
        var lastName=parts?.getOrNull(1)
//        return Pair(firstName,lastName)
        return firstName to lastName

    }

    fun transliteration(payload: String, divider: String= " "): String {
        //TODO
        return " "
    }
    fun toInitials(firstName:String?, lastname:String?): String {
        //TODO
        return " "
    }
}