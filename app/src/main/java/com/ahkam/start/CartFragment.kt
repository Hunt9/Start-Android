package com.ahkam.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.ahkam.start.databinding.FragmentCartBinding
import com.ahkam.start.databinding.FragmentInfoBinding

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cart, container, false)

        binding.textView.setOnClickListener{
            this.findNavController().navigate(R.id.action_cartFragment_to_homeFragment)

        }

        return binding.root
    }

}