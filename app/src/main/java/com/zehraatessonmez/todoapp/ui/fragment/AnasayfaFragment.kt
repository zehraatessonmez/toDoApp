package com.zehraatessonmez.todoapp.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.zehraatessonmez.todoapp.R
import com.zehraatessonmez.todoapp.databinding.FragmentAnasayfaBinding
import com.zehraatessonmez.todoapp.ui.adapter.YapilacaklarAdapter
import com.zehraatessonmez.todoapp.ui.viewmodel.AnasayfaViewModel
import com.zehraatessonmez.todoapp.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {


    private lateinit var tasarim:FragmentAnasayfaBinding
    private lateinit var viewModel:AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik = "Yapılacaklar"

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner){
            val adapter = YapilacaklarAdapter(requireContext(),it,viewModel)
            tasarim.yapilacaklarAdapter = adapter
        }

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)



        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(view:View){
        Navigation.gecisYap(view,R.id.kayitFragment)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }


}