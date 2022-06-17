package com.example.hci.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hci.R
import com.example.hci.activity.MainActivity
import com.example.hci.databinding.FragmentLoginBinding
import com.example.hci.shared.MyApplication

class LoginFragment : Fragment() {

    private lateinit var binding : FragmentLoginBinding
    var mainActivity : MainActivity ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        initBtn()

        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }

    private fun initBtn() {
        val transaction = mainActivity!!.supportFragmentManager.beginTransaction()

        binding.loginBtn.setOnClickListener {
            val id = binding.inputId.text.toString()
            val pwd = binding.inputPwd.text.toString()

            MyApplication.prefs.setString("id", id)
            MyApplication.prefs.setString("pwd", pwd)

            Toast.makeText(this.context, "로그인되었습니다", Toast.LENGTH_LONG).show()

            binding.inputId.text?.clear()
            binding.inputPwd.text?.clear()

            val homeFragment = HomeFragment()
            transaction.replace(R.id.fc_home, homeFragment).commit()
        }

        binding.transEnrollBtn.setOnClickListener {
            val enrollFragment = SignupFragment()
            transaction.replace(R.id.fc_home, enrollFragment).commit()
        }
    }

}