package com.ahkam.start.viewpager.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ahkam.start.ItemAdapter
import com.ahkam.start.R
import com.ahkam.start.databinding.FragmentDrinksBinding
import com.ahkam.start.presentation.di.Injector
import com.ahkam.start.presentation.item.ItemViewModel
import com.ahkam.start.presentation.item.ItemViewModelFactory
import javax.inject.Inject

class DrinksFragment : Fragment() {


    @Inject
    lateinit var factory: ItemViewModelFactory
    private lateinit var itemViewModel: ItemViewModel
    private lateinit var adapter: ItemAdapter
    private lateinit var binding: FragmentDrinksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_drinks, container, false)

        (activity?.application as Injector).createDrinkComponent().inject(this)

        itemViewModel = ViewModelProvider(this,factory).get(ItemViewModel::class.java)

        initRecyclerView()




        return binding.root
    }

    private fun initRecyclerView(){
        binding.DrinkList.layoutManager = LinearLayoutManager(activity)
        adapter = ItemAdapter()
        binding.DrinkList.adapter = adapter
        showItem()

    }

    private fun showItem(){
        val responseLiveData = itemViewModel.getItems()
        responseLiveData.observe(viewLifecycleOwner, Observer {
            if(it!=null)
            {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
        })
    }


}