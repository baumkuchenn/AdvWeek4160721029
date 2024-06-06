package com.misoramen.advweek4160721029.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.misoramen.advweek4160721029.R
import com.misoramen.advweek4160721029.databinding.StudentListItemBinding
import com.misoramen.advweek4160721029.model.Student
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class StudentListAdapter(val studentList:ArrayList<Student>)
    : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener
{
    class StudentViewHolder(var view: StudentListItemBinding)
        : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
//        val binding = StudentListItemBinding.inflate(
//            LayoutInflater.from(parent.context), parent, false)
//        return StudentViewHolder(binding)
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
//        val picasso = Picasso.Builder(holder.itemView.context)
//        picasso.listener { picasso, uri, exception ->
//            exception.printStackTrace() }
//        picasso.build().load(studentList[position].photoUrl).into(holder.binding.imageView, object:Callback{
//            override fun onSuccess() {
//                holder.binding.progressImage.visibility = View.INVISIBLE
//                holder.binding.imageView.visibility = View.VISIBLE
//            }
//
//            override fun onError() {
//                Log.e("picasso_error", "Error")
//            }
//        })
//
//        holder.binding.txtID.setText(studentList[position].id)
//        holder.binding.txtName.setText(studentList[position].name)
//        holder.binding.btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionStudentDetail(studentList[position].id.toString())
//            Navigation.findNavController(it).navigate(action)
//        }

        holder.view.student = studentList[position]
        holder.view.listener = this
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}