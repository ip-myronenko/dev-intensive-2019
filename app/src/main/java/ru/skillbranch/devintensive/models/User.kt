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
    var lastVisit:Date?=Date(),
    var isOnline:Boolean=false
) {

    companion object Factory{
        private var lastId=-1
        fun makeUser (fullName:String?): User {
            lastId++
            var (firstName, lastName)= Utils.parseFullName(fullName)
            return User(id= "$lastId", firstName = firstName, lastName = lastName, avatar=null, rating=0,respect=0, lastVisit = Date(), isOnline = false)
        }
    }

    constructor (builder:Builder) : this (builder.id, builder.firstName, builder.lastName, builder.avatar, builder.rating, builder.respect, builder.lastVisit, builder.isOnline)

    class Builder {
        var id:String="someID"
        var firstName:String?=""
        var lastName:String?=""
        var avatar:String?=""
        var rating:Int=0
        var respect:Int=0
        var lastVisit:Date?=Date()
        var isOnline:Boolean=false

        fun id(s: String)= apply { this.id = s }
        fun firstName(s: String)= apply { this.firstName = s }
        fun lastName(s: String)= apply { this.lastName = s }
        fun avatar(s: String) = apply { this.avatar = s }
        fun rating(n: Int) = apply { this.rating = n }
        fun respect(n: Int) = apply { this.respect = n }
        fun lastVisit(d: Date) = apply { this.lastVisit = d }
        fun isOnline(b: Boolean) = apply { this.isOnline = b }
        fun build():User = User(this)
    }
}