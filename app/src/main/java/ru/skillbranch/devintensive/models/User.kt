package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User(
    val id:String,
    var firstName:String?,
    var lastName:String?,
    var avatar:String?,
    var rating:Int=0,
    var respect:Int=0,
    val lastVisit:Date?=null,
    val isOnline:Boolean=false
) {


    constructor(id:String, firstName:String?, lastName:String?) : this (id=id, firstName=firstName, lastName=lastName, avatar=null)
    constructor(id:String) : this (id, "John", "Doe")

    init {
        println("I am Alive!!! ${if (lastName==="Doe") "My name is $firstName $lastName" else "His name is $firstName $lastName!"}")
    }
    companion object Factory{
        private var lastId=-1
        fun makeUser (fullName:String?):User{
            lastId++

            var (firstName, lastName)= Utils.parseFullName(fullName)
            return User(id= "$lastId", firstName = firstName, lastName = lastName)
        }
    }



}