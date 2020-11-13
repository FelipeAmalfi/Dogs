package com.example.course2.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.course2.R
import com.example.course2.databinding.FragmentDetailsBinding
import com.example.course2.databinding.ItemDogBinding
import com.example.course2.util.getProgressDrawable
import com.example.course2.util.loadImage
import com.example.course2.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    private lateinit var  viewModel: DetailsViewModel
    private lateinit var dataBinding: FragmentDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_details, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)

        arguments?.let {
            viewModel.setDog( DetailsFragmentArgs.fromBundle(it).dogUuid)
            observeViewModel()
        }
    }

    fun observeViewModel() {
        viewModel.selectedDog.observe(viewLifecycleOwner, Observer {dog ->
            dog.let {
                dataBinding.dog = dog
            }
        })
    }


}