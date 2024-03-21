package com.misoramen.advweek4160721029.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.misoramen.advweek4160721029.databinding.FragmentStudentDetailBinding
import com.misoramen.advweek4160721029.model.Student
import com.misoramen.advweek4160721029.viewmodel.DetailViewModel
import com.squareup.picasso.Picasso

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

        viewModel.fetch()
    }
}