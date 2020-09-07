package com.example.journeytoandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.Navigation
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_first_project.*
import okhttp3.*
import java.io.File
import java.io.IOException

class FragmentFirstProject : Fragment(R.layout.fragment_first_project) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)





    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

/*
//API REQUEST

        val url = "https://easy-instagram-service.p.rapidapi.com/username?random=x8n3nsj2&username=hoang.luuuuuu"
        val request = Request.Builder()
            .url("https://instagramdimashirokovv1.p.rapidapi.com/user/hoang.luuuuuu")
            .get()
            .addHeader("x-rapidapi-host", "InstagramdimashirokovV1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "bab4daa44bmsh18b17731b36f94ep13f6a7jsn7ebb4e4b1230")
            .build()
        val client = OkHttpClient()
        println(request)
        client.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response.body()?.string()

                println(body)

                val gson = GsonBuilder().create()
                val temp = gson.fromJson(body, Instagram::class.java)
                println(temp.full_name + " TESTTT ")

                Picasso.with(context).load(temp.last_post[0].display_url).into(iv1)

                println(temp)

            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to load API")
            }
        })


 */






        val imageURL = listOf("https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/118015192_3379000205496872_8586752924225143154_o.jpg?_nc_cat=107&_nc_sid=85a577&_nc_ohc=v8xd4Ogb50QAX9AudLB&_nc_oc=AQlChEpfdPztPJWQvQdzg3wG-0wvbDZhbRWAkB4uRY-y0Gogks5gWjgpMrRkQRC23h0&_nc_ht=scontent-dfw5-2.xx&oh=079fc8f1cd40f9a8938f7193eaaba487&oe=5F707C83",
            "https://scontent-dfw5-1.xx.fbcdn.net/v/t1.0-9/117228384_3126337014147188_2989799072926529305_o.jpg?_nc_cat=105&_nc_sid=8024bb&_nc_ohc=6_BfDdaiXvoAX-fACA8&_nc_ht=scontent-dfw5-1.xx&oh=d6c6e8dc516cf843e713b787f2d1a152&oe=5F707E29",
            "https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/100662120_3138731019523793_1496057342511284224_n.jpg?_nc_cat=102&_nc_sid=0be424&_nc_ohc=XjfQy9y--lwAX9hovJn&_nc_ht=scontent-dfw5-2.xx&oh=9651744011fda7a91c1ccf71454553d2&oe=5F71290F",
            "https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/107045719_3031718773609013_4816319570612799482_o.jpg?_nc_cat=106&_nc_sid=8024bb&_nc_ohc=uoE23i3vHSsAX9b1jpf&_nc_ht=scontent-dfw5-2.xx&oh=fc2a783574b9016c9e21f5fc8d12b8c3&oe=5F71EE32",
            "https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/10985036_803856216395291_1837498847291386127_n.jpg?_nc_cat=104&_nc_sid=7aed08&_nc_ohc=pM9W1k6LJoYAX8CV1S2&_nc_ht=scontent-dfw5-2.xx&oh=f8ba780e73cfa7913dce2a729974819b&oe=5F6FE415",
            "https://scontent-dfw5-1.xx.fbcdn.net/v/t1.0-9/103999375_3188865114510383_5009368495520881215_n.jpg?_nc_cat=111&_nc_sid=0be424&_nc_ohc=cwKB-thfOnMAX9fP3U6&_nc_ht=scontent-dfw5-1.xx&oh=4bbbfc55f83849c6d799ca71281986e6&oe=5F6FEAD8",
            "https://scontent-dfw5-1.xx.fbcdn.net/v/t1.0-9/92131397_3029196207143942_8862032774635192320_o.jpg?_nc_cat=110&_nc_sid=05277f&_nc_ohc=5ZuUF6rNMiYAX_wx3vQ&_nc_ht=scontent-dfw5-1.xx&oh=d81dfde9549373fa281f894823c66299&oe=5F7089BB",
            "https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/83996548_2880334272030137_2824961090507505664_o.jpg?_nc_cat=104&_nc_sid=05277f&_nc_ohc=JBoztPguvwMAX-fyF9y&_nc_ht=scontent-dfw5-2.xx&oh=a8398b8ee50a65402c1ff85bc14c6368&oe=5F6FF4A6",
            "https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/100087556_3138730392857189_2148770312827699200_n.jpg?_nc_cat=102&_nc_sid=0be424&_nc_ohc=sYrm0xjNR6cAX995LhU&_nc_oc=AQl0TS6be3VEdKF1w4ahRm4x879qs9Vf3EQpR9OnDVS5JOkxtMSh-SolpjXPv-vPEbQ&_nc_ht=scontent-dfw5-2.xx&oh=ee57a3aa49e23252e0f88bbf7b695b29&oe=5F7242D5")

        Picasso.with(context).load(imageURL[0]).into(iv1)
        Picasso.with(context).load(imageURL[1]).into(iv2)
        Picasso.with(context).load(imageURL[2]).into(iv3)
        Picasso.with(context).load(imageURL[3]).into(iv4)
        Picasso.with(context).load(imageURL[4]).into(iv5)
        Picasso.with(context).load(imageURL[5]).into(iv6)
        Picasso.with(context).load(imageURL[6]).into(iv7)
        Picasso.with(context).load(imageURL[7]).into(iv8)
        Picasso.with(context).load(imageURL[8]).into(iv9)


        tvUsername.setOnClickListener {
            usernameClicked(view)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    fun usernameClicked(view: View){
        val navController = Navigation.findNavController(view)
        navController.navigate(R.id.action_fragmentFirstProject_to_fragmentInstagram)

    }

}


