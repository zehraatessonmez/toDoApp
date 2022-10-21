package com.zehraatessonmez.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.zehraatessonmez.todoapp.R
import com.zehraatessonmez.todoapp.databinding.FragmentDetayBinding
import com.zehraatessonmez.todoapp.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var tasarim: FragmentDetayBinding
    private lateinit var viewModel: DetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_detay,container,false)
        tasarim.detayFragment = this
        tasarim.detayToolbarBaslik = "Yapılacak İş"

        val bundle:DetayFragmentArgs by navArgs()
        val gelenIs = bundle.yapilacak
        tasarim.yapilacakNesnesi = gelenIs


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:DetayViewModel by viewModels()
        viewModel = tempViewModel
    }



    fun buttonGuncelle(yapilacak_id:Int,yapilacak_is:String){
        viewModel.guncelle(yapilacak_id,yapilacak_is)
    }

}