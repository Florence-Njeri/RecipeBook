package com.example.recipebook.chats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.recipebook.R
import com.example.recipebook.adapters.ChatsAdapter
import com.example.recipebook.databinding.ChatsFragmentBinding

class ChatsFragment : Fragment() {
    private lateinit var binding: ChatsFragmentBinding

    companion object {
        fun newInstance() = ChatsFragment()
    }

    private lateinit var viewModel: ChatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.chats_fragment, container, false)
        binding.chatsList.adapter = ChatsAdapter()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChatsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
