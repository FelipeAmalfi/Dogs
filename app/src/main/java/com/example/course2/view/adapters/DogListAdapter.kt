package com.example.course2.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.course2.R
import com.example.course2.model.DogBreed
import com.example.course2.view.fragments.ListFragmentDirections
import kotlinx.android.synthetic.main.item_dog.view.*

class DogListAdapter(val dogList: ArrayList<DogBreed>): RecyclerView.Adapter<DogListAdapter.DogViewHolder>(){

    class DogViewHolder( var view: View): RecyclerView.ViewHolder(view)

    fun updateDogsList(newDogsList: List<DogBreed>){
        dogList.clear()
        dogList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.name.text = dogList[position].dogBreed
        holder.view.lifespan.text = dogList[position].lifeSpan
        holder.view.setOnClickListener {  Navigation.findNavController(it).navigate(ListFragmentDirections.actionListToDetails(dogList[position])) }
    }

    override fun getItemCount() = dogList.size
}