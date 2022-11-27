package com.zehraatessonmez.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.zehraatessonmez.todoapp.R
import com.zehraatessonmez.todoapp.databinding.FragmentLoginBinding
import com.zehraatessonmez.todoapp.ui.viewmodel.KayitViewModel
import com.zehraatessonmez.todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var tasarim:FragmentLoginBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        tasarim = FragmentLoginBinding.inflate(inflater,container,false)


        var username: EditText = tasarim.etUserName
        var password: EditText = tasarim.etPassword

        tasarim.btnLogin.setOnClickListener {

            if(username.text.toString().equals("zehra") && password.text.toString().equals("1234")){
                Navigation.gecisYap(tasarim.root,R.id.action_loginFragment_to_anasayfaFragment)
            }else{
                Toast.makeText(context, "wrong user!", Toast.LENGTH_SHORT).show()
            }

        }


        return tasarim.root
    }


}