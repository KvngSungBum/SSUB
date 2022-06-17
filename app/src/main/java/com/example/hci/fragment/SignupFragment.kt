package com.example.hci.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hci.R
import com.example.hci.activity.MainActivity
import com.example.hci.databinding.FragmentLoginBinding
import com.example.hci.databinding.FragmentSignupBinding
import com.example.hci.shared.MyApplication

class SignupFragment : Fragment() {
    val TAG: String = "SignupActivity"
    private lateinit var binding: FragmentSignupBinding
    var mainActivity : MainActivity ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(inflater, container, false)
        initBtn()
        return binding.root
    }

    private fun initBtn() {
        val transaction = mainActivity!!.supportFragmentManager.beginTransaction()

        binding.signupBtn.setOnClickListener {
            val id = binding.singupId.text.toString()
            val pwd = binding.singupPwd.text.toString()
            val checkpwd = binding.checkPwd.text.toString()

            MyApplication.prefs.setString("id", id)
            MyApplication.prefs.setString("pwd", pwd)

            if (pwd.equals(checkpwd)) {
                Toast.makeText(this.context, "회원가입되었습니다", Toast.LENGTH_LONG).show()

                binding.singupId.text?.clear()
                binding.checkPwd.text?.clear()

                val homeFragment = HomeFragment()
                transaction.replace(R.id.fc_home, homeFragment).commit()
            } else {
                Toast.makeText(this.context, "입력한 두 비밀번호가 다릅니다. 확인해주세요",Toast.LENGTH_LONG).show()
                binding.checkPwd.text?.clear()
            }



        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mainActivity = context as MainActivity
    }


}