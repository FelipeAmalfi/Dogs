package com.example.course2.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.course2.R
import com.example.course2.view.adapters.DogListAdapter
import com.example.course2.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*


class ListFragment : Fragment() {

    private lateinit var viewModel: ListViewModel
    private val dogsListAdapter = DogListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
    viewModel.refresh()

    dogsList.apply {
        layoutManager = LinearLayoutManager(context)
        adapter = dogsListAdapter;
    }

    observeViewModel()
}

private fun observeViewModel() {
    viewModel.dogs.observe(viewLifecycleOwner, Observer {dogs ->
        dogsList.visibility = View.VISIBLE
        dogsListAdapter.updateDogsList(dogs)
    })

    viewModel.dogsLoadError.observe(viewLifecycleOwner, Observer { isError ->
        isError.let { listError.visibility = if(it) View.VISIBLE else View.GONE}
    } )

    viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
        isLoading.let {
            loadingView.visibility = if(it) View.VISIBLE  else View.GONE
            if(it){
                listError.visibility = View.GONE
                dogsList.visibility = View.GONE
            }
        }
    } )
}

}