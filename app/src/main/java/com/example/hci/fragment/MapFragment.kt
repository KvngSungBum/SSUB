package com.example.hci.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hci.R
import com.example.hci.databinding.FragmentMapBinding
import com.example.hci.databinding.FragmentSettingBinding

class MapFragment : Fragment() {
    private lateinit var binding : FragmentMapBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBinding.inflate(inflater, container, false)

        initBtn()

        return binding.root
    }

    private fun initBtn() {
        var startStation : String = binding.startSearchInput.text.toString()
        var destStation : String = binding.destSearchInput.text.toString()

        binding.buttona.setOnClickListener{
            //api 호출

            Toast.makeText(this.context, "Search", Toast.LENGTH_SHORT).show()
//            Toast.makeText(this.context, destStation, Toast.LENGTH_SHORT).show()
        }
    }
}