package com.misoramen.advweek4160721029.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.misoramen.advweek4160721029.model.Student

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch() {
        val student1 = Student("16055","Nonie","1998/03/28","5718444778",
            "https://picsum.photos/200")
        studentLD.value = student1
    }
}