package com.example.course2.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.course2.R
import com.example.course2.databinding.ItemDogBinding
import com.example.course2.model.DogBreed
import com.example.course2.util.getProgressDrawable
import com.example.course2.util.loadImage
import com.example.course2.view.fragments.ListFragmentDirections
import com.example.course2.view.viewUtil.DogClickListener
import kotlinx.android.synthetic.main.item_dog.view.*

class DogListAdapter(val dogList: ArrayList<DogBreed>): RecyclerView.Adapter<DogListAdapter.DogViewHolder>(), DogClickListener{

    class DogViewHolder( var view: ItemDogBinding): RecyclerView.ViewHolder(view.root)

    fun updateDogsList(newDogsList: List<DogBreed>){
        dogList.clear()
        dogList.addAll(newDogsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemDogBinding>(inflater,R.layout.item_dog, parent, false )
        return DogViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.view.dog = dogList[position]
        holder.view.listener = this
    }

    override fun getItemCount() = dogList.size

    override fun onDogClicked(v: View, uuid: Int) {
        val action = ListFragmentDirections.actionListToDetails(uuid)
            Navigation.findNavController(v).navigate(action)
    }
}