package com.example.recipebook.chats

import  android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.recipebook.R
import com.example.recipebook.adapters.OpenedChatsAdapter
import com.example.recipebook.databinding.OpenedChatsFragmentBinding

class OpenedChatsFragment : Fragment() {
    private lateinit var binding: OpenedChatsFragmentBinding

    companion object {
        fun newInstance() = OpenedChatsFragment()
    }

    private lateinit var viewModel: OpenedChatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.opened_chats_fragment, container, false)
        binding.recyclerView.adapter = OpenedChatsAdapter()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OpenedChatsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
