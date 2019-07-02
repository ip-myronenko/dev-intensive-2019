package ru.skillbranch.devintensive.models

class UserView (
    val id:String,
    var fullName:String?,
    var avatar:String?=null,
    var nickName:String?,
    val initials: String?,
    var status: String?= "offline"
) {
    fun printMe(){
        println("""
 id: $id
 fullName: $fullName
 avatar: $avatar
 nickName: $nickName
 initials: $initials
 status: $status
        """.trimIndent()
        )

    }
}
