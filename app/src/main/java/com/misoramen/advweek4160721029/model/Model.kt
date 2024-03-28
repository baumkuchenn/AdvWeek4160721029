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

//Model JSON
//[
//{
//    "id": 1,
//    "name": "Toyota Supra",
//    "year": 1998,
//    "manufacturer": {
//    "name": "Toyota",
//    "country": "Japan"
//},
//    "colors": ["red", "black", "white"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=1"]
//},
//{
//    "id": 2,
//    "name": "Nissan Skyline GT-R",
//    "year": 2000,
//    "manufacturer": {
//    "name": "Nissan",
//    "country": "Japan"
//},
//    "colors": ["blue", "silver", "black"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=2"]
//},
//{
//    "id": 3,
//    "name": "Honda NSX",
//    "year": 1995,
//    "manufacturer": {
//    "name": "Honda",
//    "country": "Japan"
//},
//    "colors": ["yellow", "red", "white"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=3"]
//},
//{
//    "id": 4,
//    "name": "Mazda RX-7",
//    "year": 1997,
//    "manufacturer": {
//    "name": "Mazda",
//    "country": "Japan"
//},
//    "colors": ["white", "blue", "black"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=4"]
//},
//{
//    "id": 5,
//    "name": "Subaru Impreza WRX STI",
//    "year": 2005,
//    "manufacturer": {
//    "name": "Subaru",
//    "country": "Japan"
//},
//    "colors": ["blue", "silver", "black"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=5"]
//},
//{
//    "id": 6,
//    "name": "Mitsubishi Lancer Evolution",
//    "year": 2003,
//    "manufacturer": {
//    "name": "Mitsubishi",
//    "country": "Japan"
//},
//    "colors": ["white", "red", "black"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=6"]
//},
//{
//    "id": 7,
//    "name": "Toyota AE86",
//    "year": 1986,
//    "manufacturer": {
//    "name": "Toyota",
//    "country": "Japan"
//},
//    "colors": ["white", "black", "red"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=7"]
//},
//{
//    "id": 8,
//    "name": "Nissan Silvia S13",
//    "year": 1991,
//    "manufacturer": {
//    "name": "Nissan",
//    "country": "Japan"
//},
//    "colors": ["black", "red", "white"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=8"]
//},
//{
//    "id": 9,
//    "name": "Honda Civic Type R",
//    "year": 2000,
//    "manufacturer": {
//    "name": "Honda",
//    "country": "Japan"
//},
//    "colors": ["red", "white", "blue"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=9"]
//},
//{
//    "id": 10,
//    "name": "Mazda MX-5 Miata",
//    "year": 1995,
//    "manufacturer": {
//    "name": "Mazda",
//    "country": "Japan"
//},
//    "colors": ["red", "blue", "white"],
//    "images": ["https://loremflickr.com/320/240/cars?lock=10"]
//}
//]
