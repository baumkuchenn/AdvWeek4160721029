package com.misoramen.advweek4160721029.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.misoramen.advweek4160721029.databinding.StudentListItemBinding
import com.misoramen.advweek4160721029.model.Student
import com.squareup.picasso.Picasso

class StudentListAdapter(val studentList:ArrayList<Student>)
    : RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>()
{
    class StudentViewHolder(var binding: StudentListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = StudentListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val builder = Picasso.Builder(holder.itemView.context)
        builder.listener { picasso, uri, exception ->
            exception.printStackTrace() }
        builder.build().load(studentList[position].photoUrl).into(holder.binding.imageView)
        holder.binding.txtID.setText(studentList[position].id)
        holder.binding.txtName.setText(studentList[position].name)
        holder.binding.btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }
    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}