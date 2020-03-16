package com.example.recipebook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.recipebook.adapters.ModulesAdapter
import com.example.recipebook.adapters.NotificationsAdapter
import com.example.recipebook.data.Module
import com.example.recipebook.data.Notifications
import com.example.recipebook.databinding.ActivityMainBinding
val moduleModelList =ArrayList<Module>()
val notificationsModelList =ArrayList<Notifications>()
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        moduleModelList.add(Module("Recipes",R.drawable.vector_recipes))
        moduleModelList.add(Module("Chats",R.drawable.icon_chat))
        moduleModelList.add(Module("Networks",R.drawable.icon_networks))
        moduleModelList.add(Module("Friends",R.drawable.icon_friends))
        moduleModelList.add(Module("Favourites",R.drawable.icon_fav))
        moduleModelList.add(Module("Uploads",R.drawable.vector_uploads))

        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message","Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message","Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message","Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message","Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message","Yesterday"))
        notificationsModelList.add(Notifications("Adebayo Apercu sent you a message","Yesterday"))

        var adapter = NotificationsAdapter(notificationsModelList)
        var module = ModulesAdapter(
            moduleModelList,
            this
        )
        binding.includeView.listModules.adapter=module
        binding.includeView.notificationList.adapter=adapter

        adapter.addHeaderAndSubmitList(notificationsModelList)

    }
}

