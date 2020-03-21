package com.example.recipebook.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.recipebook.R
import com.example.recipebook.adapters.IngredientsAdapter
import com.example.recipebook.databinding.RecipeTwoFragmentBinding

class RecipeTwoFragment : Fragment() {
private lateinit var binding:RecipeTwoFragmentBinding
    companion object {
        fun newInstance() = RecipeTwoFragment()
    }

    private lateinit var viewModel: RecipeTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.recipe_two_fragment, container, false)
        binding.includeView.ingredientsList.adapter = IngredientsAdapter()

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipeTwoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
