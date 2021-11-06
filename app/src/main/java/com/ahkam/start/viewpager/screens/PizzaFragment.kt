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
import com.ahkam.start.databinding.FragmentPizzaBinding
import com.ahkam.start.presentation.di.Injector
import com.ahkam.start.presentation.item.ItemViewModel
import com.ahkam.start.presentation.item.ItemViewModelFactory
import javax.inject.Inject

class PizzaFragment : Fragment() {

    @Inject
    lateinit var factory: ItemViewModelFactory
//    @Inject
//    lateinit var factory1: CartViewModelFactory
    private lateinit var itemViewModel: ItemViewModel
//    private lateinit var cartViewModel: CartViewModel
    private lateinit var binding: FragmentPizzaBinding
    private lateinit var adapter: ItemAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_pizza, container, false)

        (activity?.application as Injector).createPizzaComponent().inject(this)

        itemViewModel = ViewModelProvider(this,factory).get(ItemViewModel::class.java)

        initRecyclerView()


//        (activity?.application as Injector).createCartSubComponent().inject(this)
//
//        cartViewModel = ViewModelProvider(this,factory1).get(CartViewModel::class.java)
//
//        val responseLiveData = cartViewModel.updateCart()
//        responseLiveData.observe(viewLifecycleOwner, Observer {
//            if (it != null) {
//                Log.i("DEKHO",it.toString())
//            }
//        })



        return binding.root


    }

    private fun initRecyclerView(){
        binding.PizzaList.layoutManager = LinearLayoutManager(activity)
        adapter = ItemAdapter()
        binding.PizzaList.adapter = adapter
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