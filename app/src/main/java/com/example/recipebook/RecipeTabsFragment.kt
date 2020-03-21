package com.example.recipebook

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.recipebook.adapters.RecipeTabsAdapter
import com.example.recipebook.databinding.FragmentRecipeTabsBinding

/**
 * A simple [Fragment] subclass.
 */
class RecipeTabsFragment : Fragment() {

    lateinit var tabAdapter: RecipeTabsAdapter
private lateinit var binding:FragmentRecipeTabsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_recipe_tabs, container, false)

        tabAdapter = RecipeTabsAdapter(childFragmentManager, activity)
       binding.pager.adapter = tabAdapter
//       binding.tabLayout.setupWithViewPager(binding.pager)
        return binding.root
    }

}
