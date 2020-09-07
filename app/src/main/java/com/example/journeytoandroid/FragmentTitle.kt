package com.example.journeytoandroid

import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_first_project.*
import kotlinx.android.synthetic.main.fragment_title.*


class FragmentTitle : Fragment() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnStart.setOnClickListener {
            var navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_fragmentTitle_to_fragmentMain)
            //Navigation.findNavController(it).navigate(R.id.action_fragmentTitle_to_fragmentStart)
            //start(start)

        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_title, container, false)
    }

    private fun start(fragment: Fragment){

        // go to the Start fragment
        //fragment.findNavController().navigate(R.id.action_fragmentTitle_to_fragmentStart)
    }

}