package com.example.recipebook.friends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.recipebook.R

class UnfollowFriendFragment : Fragment() {

    companion object {
        fun newInstance() = UnfollowFriendFragment()
    }

    private lateinit var viewModel: UnfollowFriendViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.unfollow_friend_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(UnfollowFriendViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
