package com.example.recipebook.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.recipebook.R
import com.example.recipebook.adapters.ModulesAdapter
import com.example.recipebook.adapters.NotificationsAdapter
import com.example.recipebook.data.Module
import com.example.recipebook.data.Notifications
import com.example.recipebook.databinding.HomeScreenBinding
import com.example.recipebook.utils.Constants

val moduleModelList = ArrayList<Module>()

class HomeFragment : Fragment() {
    private lateinit var binding: HomeScreenBinding
    val notificationsModelList = ArrayList<Notifications>()

    companion object {
        fun newInstance() = HomeFragment()

    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_screen, container, false)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel

//        moduleModelList.add(Module("Recipes", R.drawable.vector_recipes))
//        moduleModelList.add(Module("Chats", R.drawable.icon_chat))
//        moduleModelList.add(Module("Networks", R.drawable.icon_networks))
//        moduleModelList.add(Module("Friends", R.drawable.icon_friends))
//        moduleModelList.add(Module("Favourites", R.drawable.icon_fav))
//        moduleModelList.add(Module("Uploads", R.drawable.vector_uploads))


        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message", "Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message", "Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message", "Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message", "Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message", "Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message", "Yesterday"))

        var adapter = NotificationsAdapter(notificationsModelList)
        var module = ModulesAdapter(
            moduleModelList,
            context,
            ModulesAdapter.ModulesListener{

                when {
                    moduleModelList[0].moduleTitle == Constants.MAIN_DASHBOARD_CARD_RECIPES -> {
                        view?.findNavController()
                            ?.navigate(R.id.action_homeFragment_to_chatsFragment )
                    }
                    moduleModelList[1].moduleTitle == Constants.MAIN_DASHBOARD_CARD_CHATS -> {
                        view?.findNavController()
                            ?.navigate(R.id.action_homeFragment_to_chatsFragment)

                    }
                    moduleModelList[2].moduleTitle == Constants.MAIN_DASHBOARD_CARD_NETWORKS -> {
                        view?.findNavController()
                            ?.navigate(R.id.action_homeFragment_to_networkFragment)

                    }
                    moduleModelList[3].moduleTitle == Constants.MAIN_DASHBOARD_CARD_FRIENDS -> {
                        view?.findNavController()
                            ?.navigate(R.id.action_homeFragment_to_friendsFragment)

                    }
                    moduleModelList[4].moduleTitle == Constants.MAIN_DASHBOARD_CARD_FAVOURITES -> {
                        view?.findNavController()
                            ?.navigate(R.id.action_homeFragment_to_favouritesFragment)

                    }
                    else -> {
                        view?.findNavController()
                            ?.navigate(R.id.action_homeFragment_to_favouritesFragment)

                    }
                }

            })
//        { position: Int ->
//            val modules = moduleModelList[position]
//            when (modules.moduleTitle) {
//                Constants.MAIN_DASHBOARD_CARD_RECIPES -> {
//
//                }
//                Constants.MAIN_DASHBOARD_CARD_CHATS -> {
//                    view?.findNavController()
//                        ?.navigate(R.id.action_homeFragment_to_chatsFragment)
//
//                }
//                Constants.MAIN_DASHBOARD_CARD_NETWORKS -> {
//                    view?.findNavController()
//                        ?.navigate(R.id.action_homeFragment_to_networkFragment)
//
//                }
//                Constants.MAIN_DASHBOARD_CARD_FRIENDS -> {
//                    view?.findNavController()
//                        ?.navigate(R.id.action_homeFragment_to_friendsFragment)
//
//                }
//                Constants.MAIN_DASHBOARD_CARD_FAVOURITES -> {
//                    view?.findNavController()
//                        ?.navigate(R.id.action_homeFragment_to_favouritesFragment)
//
//                }
//                Constants.MAIN_DASHBOARD_CARD_UPLOADS -> {
//                    view?.findNavController()
//                        ?.navigate(R.id.action_homeFragment_to_favouritesFragment)
//
//                }
//
//                else -> Toast.makeText(context,"Hey there",Toast.LENGTH_SHORT).show()
//            }
//        }

//        binding.includeView.listModules.adapter = module
        binding.includeView.notificationList.adapter = adapter

        adapter.addHeaderAndSubmitList(notificationsModelList)
//
//        binding.includeView.listModules.setOnClickListener {
//
//        }
        binding.includeView.chatsCardView.setOnClickListener {
            view?.findNavController()
                        ?.navigate(R.id.action_homeFragment_to_chatsFragment)
        }
        binding.includeView.recipesCardView.setOnClickListener {
            view?.findNavController()
                        ?.navigate(R.id.action_homeFragment_to_recipeFragment)
        }
        binding.includeView.networksCardView.setOnClickListener {
            view?.findNavController()
                        ?.navigate(R.id.action_homeFragment_to_networkFragment)
        }
        binding.includeView.friendsCardView.setOnClickListener {
            view?.findNavController()
                        ?.navigate(R.id.action_homeFragment_to_friendsFragment)
        }
        binding.includeView.favouritesCardView.setOnClickListener {
            view?.findNavController()
                        ?.navigate(R.id.action_homeFragment_to_favouritesFragment)
        }
        binding.includeView.uploadsCardView.setOnClickListener {
            view?.findNavController()
                        ?.navigate(R.id.action_homeFragment_to_favouritesFragment)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
