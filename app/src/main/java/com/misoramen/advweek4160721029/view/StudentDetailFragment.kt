package com.misoramen.advweek4160721029.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.misoramen.advweek4160721029.R
import com.misoramen.advweek4160721029.databinding.FragmentStudentDetailBinding
import com.misoramen.advweek4160721029.model.Student
import com.misoramen.advweek4160721029.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentStudentDetailBinding
    private val studentLiveData = MutableLiveData<Student>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentDetailBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
            studentLiveData.value = student
        })

        studentLiveData.observe(viewLifecycleOwner, Observer { student ->
            if (student != null) {
                val builder = Picasso.Builder(context)
                builder.listener { picasso, uri, exception ->
                    exception.printStackTrace() }
                builder.build().load(student.photoUrl).into(binding.imageView)
                binding.txtID.setText(student.id)
                binding.txtName.setText(student.name)
                binding.txtBod.setText(student.dob)
                binding.txtPhone.setText(student.phone)
            }
        })

        viewModel.fetch(id)
    }
    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            var student = it
            binding.btnUpdate?.setOnClickListener {
                Observable.timer(5, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d("Messages", "five seconds")
                        MainActivity.showNotification(student.name.toString(),
                            "A new notification created",
                            R.drawable.baseline_person_add_24)
                    }
            }
        })

    }
}