package com.zehraatessonmez.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.zehraatessonmez.todoapp.R
import com.zehraatessonmez.todoapp.data.entity.Yapilacaklar
import com.zehraatessonmez.todoapp.databinding.CardTasarimBinding
import com.zehraatessonmez.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.zehraatessonmez.todoapp.ui.viewmodel.AnasayfaViewModel
import com.zehraatessonmez.todoapp.utils.gecisYap


class YapilacaklarAdapter(var mContext:Context,
                          var yapilacaklarListesi:List<Yapilacaklar>,
                          var viewModel:AnasayfaViewModel)
    :  RecyclerView.Adapter<YapilacaklarAdapter.CardTasarimTutucu>(){


        inner class CardTasarimTutucu(tasarim:CardTasarimBinding) :RecyclerView.ViewHolder(tasarim.root){
            var tasarim:CardTasarimBinding
            init {
                this.tasarim = tasarim
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
            R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacak = yapilacaklarListesi.get(position)
        val t = holder.tasarim
        t.yapilacakNesnesi = yapilacak

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.isDetayGecis(yapilacak = yapilacak)
            Navigation.gecisYap(it,gecis)
        }


        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${yapilacak.yapilacak_is} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(yapilacak.yapilacak_id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return yapilacaklarListesi.size
    }

}