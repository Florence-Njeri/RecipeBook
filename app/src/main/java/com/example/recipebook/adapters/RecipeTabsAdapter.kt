package com.example.recipebook.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.recipebook.recipe.RecipeFragment
import com.example.recipebook.recipe.RecipeTwoFragment


class RecipeTabsAdapter(fm: FragmentManager, private val context: FragmentActivity?) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
      return when (position) {
            0 -> RecipeFragment()
//            1 -> return TeamsFrag()
            1 -> RecipeTwoFragment()

            else -> RecipeTwoFragment()
        }
//


    }
    /*
    Returns the number of pages the adapter will create
     */

    override fun getCount(): Int {
        return 2
    }


}
