package com.example.hci.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hci.R
import com.example.hci.activity.MainActivity
import com.example.hci.databinding.FragmentSettingBinding
import com.example.hci.shared.MyApplication

class SettingFragment : Fragment() {

     private lateinit var binding: FragmentSettingBinding
     var mainActivity : MainActivity ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSettingBinding.inflate(inflater, container, false)
        if (!MyApplication.prefs.getString("id", "").equals("")) {
            binding.loginTextBtn.setText("로그아웃")
            MyApplication.prefs.setString("id","")
            MyApplication.prefs.setString("pwd","")
        }
        initBtn()
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    private fun initBtn() {
        val transaction = mainActivity!!.supportFragmentManager.beginTransaction()

        binding.loginTextBtn.setOnClickListener {
            val loginFragment = LoginFragment()
            transaction.replace(R.id.fc_home, loginFragment).commit()

        }
    }

}