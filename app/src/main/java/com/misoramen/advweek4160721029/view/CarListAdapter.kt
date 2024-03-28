package com.misoramen.advweek4160721029.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.misoramen.advweek4160721029.databinding.CarListItemBinding
import com.misoramen.advweek4160721029.model.Car
import com.squareup.picasso.Picasso

class CarListAdapter(val carList:ArrayList<Car>)
    : RecyclerView.Adapter<CarListAdapter.CarViewHolder>()
{
    class CarViewHolder(var binding: CarListItemBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListAdapter.CarViewHolder {
        val binding = CarListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return CarListAdapter.CarViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return carList.size
    }

    override fun onBindViewHolder(holder: CarListAdapter.CarViewHolder, position: Int) {
        val builder = Picasso.Builder(holder.itemView.context)
        builder.listener { picasso, uri, exception ->
            exception.printStackTrace() }
        builder.build().load(carList[position].image).into(holder.binding.imageView2)
        holder.binding.txtNameCar.setText(carList[position].name)
        holder.binding.txtYearCar.setText(carList[position].year.toString())
        holder.binding.txtManufacturer.setText(carList[position].manufacture?.name)
        holder.binding.txtCountry.setText(carList[position].manufacture?.country)
        holder.binding.txtColor.setText(carList[position].color?.joinToString(", ") ?: "")
    }
    fun updateCarList(newCarList: ArrayList<Car>) {
        carList.clear()
        carList.addAll(newCarList)
        notifyDataSetChanged()
    }
}