package com.example.recipebook.networks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.recipebook.R
import com.example.recipebook.adapters.ModulesAdapter
import com.example.recipebook.adapters.NetworksAdapter
import com.example.recipebook.data.Module
import com.example.recipebook.data.NetworkModules
import com.example.recipebook.databinding.NetworkFragmentBinding

class NetworkFragment : Fragment() {
    val moduleModelList = ArrayList<NetworkModules>()
    private lateinit var binding: NetworkFragmentBinding

    companion object {
        fun newInstance() = NetworkFragment()
    }

    private lateinit var viewModel: NetworkViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.network_fragment, container, false)

        moduleModelList.add(NetworkModules("Sausage & Peppers Group", R.drawable.sausage_and_peppers))
        moduleModelList.add(NetworkModules("Pro-bros", R.drawable.avipro_bos))
        moduleModelList.add(NetworkModules("Food fitfam", R.drawable.fitfam))
        moduleModelList.add(NetworkModules("Strawberry Wonders", R.drawable.strawberry_wonders))
        moduleModelList.add(NetworkModules("Colours of Strawberry", R.drawable.colors_of_strawberry))
        moduleModelList.add(NetworkModules("Veges Gang", R.drawable.veges))
        var module = context?.let { NetworksAdapter(moduleModelList, it) }

        binding.networkList.adapter=module
        return binding.root
    }

    private fun setDummyData() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NetworkViewModel::class.java)
        // TODO: Use the ViewModel
    }


}
