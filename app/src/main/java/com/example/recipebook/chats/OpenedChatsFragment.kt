package com.example.recipebook.chats

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.recipebook.R

class OpenedChatsFragment : Fragment() {

    companion object {
        fun newInstance() = OpenedChatsFragment()
    }

    private lateinit var viewModel: OpenedChatsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.opened_chats_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(OpenedChatsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
