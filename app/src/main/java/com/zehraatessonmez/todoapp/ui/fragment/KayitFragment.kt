package com.zehraatessonmez.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.zehraatessonmez.todoapp.R
import com.zehraatessonmez.todoapp.databinding.FragmentKayitBinding
import com.zehraatessonmez.todoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {

    private lateinit var tasarim:FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit, container, false)
        tasarim.kayitFragment = this
        tasarim.kayitToolbarBaslik = "Yapılacak Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KayitViewModel by viewModels()
        viewModel = tempViewModel
    }


    fun buttonKaydet(yapilacak_is:String){
        viewModel.kaydet(yapilacak_is)
    }


}
