package com.example.journeytoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment__dice.*
import java.util.*

class Fragment_Dice : Fragment(R.layout.fragment__dice) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnRoll.setOnClickListener{
            val randomInt = Random().nextInt(6)+1
            val drawableResource = when (randomInt){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }
            ivDice.setImageResource(drawableResource)
        }

        btnNext.setOnClickListener {
            view.findNavController().navigate(R.id.action_fragment_Dice_to_fragmentStart)
        }
    }


    private fun rollDice() {
        //val diceImage: ImageView = findViewById(R.id.dice_image)


    }
}