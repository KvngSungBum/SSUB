package com.example.hci.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hci.adapter.MainPageAdapter
import com.example.hci.data.mainData
import com.example.hci.databinding.FragmentHomeBinding
import com.example.hci.shared.MyApplication

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var myAdapter: MainPageAdapter
    lateinit var recyclerView: RecyclerView
    var contentList: ArrayList<mainData> = ArrayList()
    var logged_out_list: ArrayList<mainData> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        if (MyApplication.prefs.getString("id", "").equals("")) {
            logged_out_list.add(mainData("로그인 필요","로그인 필요","---","---"))
            logged_out_initAdapter()
        } else {
            setData()
            logged_in_initAdapter()
        }
        return binding.root

    }

    private fun logged_out_initAdapter() {
        recyclerView = binding.recyclerView
        myAdapter = MainPageAdapter(logged_out_list)

        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
    }

    private fun logged_in_initAdapter() {
        recyclerView = binding.recyclerView
        myAdapter = MainPageAdapter(contentList)

        myAdapter.itemClickLister = object : MainPageAdapter.OnItemClickListener {
            override fun OnItemClick(
                holder: MainPageAdapter.SettingViewHolder,
                view: View,
                data: mainData,
                position: Int
            ) {
                binding.topStartStation.text = myAdapter.data.get(position).fromStation
                binding.recentStartStation.text = myAdapter.data.get(position).fromStation
                binding.topEndStation.text = myAdapter.data.get(position).toStation
                binding.recentEndStation.text = myAdapter.data.get(position).toStation
            }

        }

        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
    }

    private fun setData() {
        contentList.add(mainData("삼성","압구정 로데오","o행 3분 42초","x행 4분 13초"))
        contentList.add(mainData("건대입구","강남","o행 3분 42초","x행 4분 13초"))
        contentList.add(mainData("삼성","강남","o행 3분 42초","x행 4분 13초"))
        contentList.add(mainData("신촌","건대입구","o행 3분 42초","x행 4분 13초"))
        contentList.add(mainData("신촌","강남","o행 3분 42초","x행 4분 13초"))
        contentList.add(mainData("신촌","건대입구","o행 3분 42초","x행 4분 13초"))
        contentList.add(mainData("신촌","강남","o행 3분 42초","x행 4분 13초"))
        contentList.add(mainData("잠실","성수","o행 3분 42초","x행 4분 13초"))
        contentList.add(mainData("삼성","압구정 로데오","o행 3분 42초","x행 4분 13초"))
    }
}