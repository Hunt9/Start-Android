package com.ahkam.start.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ahkam.start.R
import com.ahkam.start.databinding.FragmentHomeBinding
import com.ahkam.start.viewpager.screens.DrinksFragment
import com.ahkam.start.viewpager.screens.PizzaFragment
import com.ahkam.start.viewpager.screens.SushiFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.synnapps.carouselview.ImageListener
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    var slideImages = intArrayOf(
            R.drawable.slideone,
            R.drawable.slidetwo,
            R.drawable.slidethree,
    )

    private val titles = arrayOf("Pizza", "Sushi", "Drink")

    var imageListener =
        ImageListener { position, imageView -> imageView.setImageResource(slideImages.get(position)) }


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        GlobalScope.launch {
            binding.carouselView.pageCount = slideImages.size
            binding.carouselView.setImageListener(imageListener)}

        val fragmentList = arrayListOf<Fragment>(
                PizzaFragment(),
                SushiFragment(),
                DrinksFragment()
        )


        val adapter = ViewPagerAdapter(fragmentList, requireActivity().supportFragmentManager, lifecycle)

        binding.viewpager.adapter = adapter



        TabLayoutMediator(binding.tabs, binding.viewpager)
        { tab: TabLayout.Tab, position: Int -> tab.setText(titles.get(position))
        }.attach()

        binding.fab.setOnClickListener{

            this.findNavController().navigate(R.id.action_homeFragment_to_cartFragment)

        }


        return binding.root
    }



}