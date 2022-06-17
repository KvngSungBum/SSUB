package com.example.hci.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.hci.R
import com.example.hci.databinding.ActivityMainBinding
import com.example.hci.fragment.HomeFragment
import com.example.hci.fragment.MapFragment
import com.example.hci.fragment.SettingFragment
import com.example.hci.shared.MyApplication

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
//        setContentView(R.layout.activity_main)
    }

    private fun init() {
        MyApplication.prefs.setString("id", "")
        MyApplication.prefs.setString("pwd", "")

        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        transFragment(HomeFragment)

        binding.bnvHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home ->{
                    transFragment(HomeFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.menu_map ->{
                    transFragment(MapFragment)
                    return@setOnItemSelectedListener true
                }
                R.id.menu_setting ->{
                    transFragment(ScrollSetting)
                    return@setOnItemSelectedListener true
                }
                else ->{
                    transFragment(HomeFragment)
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    private fun transFragment(frgament: Int) {
        supportFragmentManager.popBackStack()

        val transaction = supportFragmentManager.beginTransaction()

        when (frgament) {
            HomeFragment -> {
                val homeFragment = HomeFragment()
                transaction.replace(R.id.fc_home, homeFragment).commit()

            }
            MapFragment -> {
                val mapFragment = MapFragment()
                transaction.replace(R.id.fc_home, mapFragment).commit()
            }
            ScrollSetting -> {
                val settingFragment = SettingFragment()
                transaction.replace(R.id.fc_home, settingFragment).commit()
            }
        }
    }

    companion object {
        const val HomeFragment = 0
        const val MapFragment = 1
        const val ScrollSetting = 2
    }
}

