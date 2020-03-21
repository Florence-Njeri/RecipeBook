package com.example.recipebook.favourites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.recipebook.R
import com.example.recipebook.adapters.NetworksAdapter
import com.example.recipebook.data.NetworkModules
import com.example.recipebook.databinding.FavouritesFragmentBinding

class FavouritesFragment : Fragment() {
    val moduleModelList = ArrayList<NetworkModules>()
    private lateinit var binding: FavouritesFragmentBinding
    companion object {
        fun newInstance() = FavouritesFragment()
    }

    private lateinit var viewModel: FavouritesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.favourites_fragment, container, false)
        moduleModelList.add(NetworkModules("Sausage & Peppers Group", R.drawable.sausage_and_peppers))
        moduleModelList.add(NetworkModules("Pro-bros", R.drawable.avipro_bos))
        moduleModelList.add(NetworkModules("Pro-bros", R.drawable.avipro_bos))
        moduleModelList.add(NetworkModules("Food fitfam", R.drawable.fitfam))
        moduleModelList.add(NetworkModules("Food fitfam", R.drawable.fitfam))
        moduleModelList.add(NetworkModules("Strawberry Wonders", R.drawable.strawberry_wonders))
        moduleModelList.add(NetworkModules("Colours of Strawberry", R.drawable.colors_of_strawberry))
        moduleModelList.add(NetworkModules("Colours of Strawberry", R.drawable.colors_of_strawberry))
        moduleModelList.add(NetworkModules("Veges Gang", R.drawable.veges))
        moduleModelList.add(NetworkModules("Veges Gang", R.drawable.veges))

        var module = context?.let { NetworksAdapter(moduleModelList, it) }

        binding.listModules.adapter=module

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FavouritesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
