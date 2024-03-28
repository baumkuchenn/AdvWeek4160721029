package com.misoramen.advweek4160721029.model

import com.google.gson.annotations.SerializedName

data class Student(
    var id:String?,
    @SerializedName("student_name")
    var name:String?,
    @SerializedName("birth_of_date")
    var dob:String?,
    var phone:String?,
    @SerializedName("photo_url")
    var photoUrl:String?
)

data class Car(
    val id:String?,
    val name:String?,
    val year:Int?,
    val color:List<String>?,
    val image:String?,
    val manufacture:CarManufacturer?
)

data class CarManufacturer(
    val name:String?,
    val country:String?
)