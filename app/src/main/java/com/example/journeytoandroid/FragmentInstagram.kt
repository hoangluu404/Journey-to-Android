package com.example.journeytoandroid

import AdapterImageRow
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.fragment_instagram.*
import okhttp3.*
import okhttp3.Request
import java.io.IOException
import java.lang.Exception
import java.lang.Thread.sleep
import kotlin.concurrent.timer


class FragmentInstagram : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.fragment_instagram, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var posts = mutableListOf<Post>()
        /*

        posts.add(Post(0,0,"shortcode", "caption", "display_url", 0, 0, 0, "video_url", "username",
        0, "profile_pic_url",
        "last_update",
        false,
        "store_display_url",
        "ai_category"))


         */
        val adapter = AdapterImageRow(posts)

        rvInstagram.adapter = adapter
        val layoutManager = LinearLayoutManager(this.getContext())
        rvInstagram?.layoutManager = layoutManager
        btnSearch.setOnClickListener {
            tvNumPosts.text = tvNumPosts.text
            val username = etUsername.text.toString()
            //etUsername.text.clear()
            if (username != "") {
                /*
                var profile = Instagram(
                    0,
                    "full name",
                    "bio string",
                    "username",
                    false,
                    "external_url",
                    false,
                    "profile_pic_url",
                    "stored profile pic url",
                    123,
                    321,
                    999,
                    29,
                    96,
                    9,
                    10,
                    20,
                    111,
                    posts
                    )
                */

                // API call


                val url =
                    "https://easy-instagram-service.p.rapidapi.com/username?random=x8n3nsj2&username=" + username
                val request = Request.Builder()
                    .url(url)
                    .get()
                    .addHeader("x-rapidapi-host", "easy-instagram-service.p.rapidapi.com")
                    .addHeader(
                        "x-rapidapi-key",
                        "bab4daa44bmsh18b17731b36f94ep13f6a7jsn7ebb4e4b1230"
                    )
                    .build()
                var exists = true
                var profile: Instagram? = null
                val client = OkHttpClient()
                println(request)
                client.newCall(request).enqueue(object : Callback {
                    override fun onResponse(call: Call, response: Response) {
                        val body = response.body()?.string()

                        println(body)

                        if (body != "{\"client_error\":\"Username not exist or deleted. Your RapidAPI quota still reduced.\"}") {
                            val gson = GsonBuilder().create()
                            val temp = gson.fromJson(body, Instagram::class.java)
                            println("Full Name = " + temp.full_name + "\nProfile URL = " + temp.profile_pic_url)

                            //Picasso.with(context).load(profile.profile_pic_url).into(ivProfilePic)

                            //tvBio.text = "Full Name: "+ profile.full_name + "\n" + profile.biography
                            //tvNumPosts.text = profile.total_post.toString()
                            //tvFollower.text = profile.follower.toString()
                            //tvFollowing.text = profile.following.toString()

                            println(body)
                            println(temp)
                            profile = temp
                            posts.clear()
                        } else
                            exists = false

                    }

                    override fun onFailure(call: Call, e: IOException) {
                        println("Failed to load API")

                    }
                })

                while (profile == null && exists)
                    sleep(500)
                if (exists) {
                    Picasso.with(context).load(profile?.profile_pic_url).into(ivProfilePic)
                    tvBio.text = profile?.full_name + "\n" + profile?.biography
                    tvNumPosts.text = profile?.total_post.toString()
                    tvFollower.text = profile?.follower.toString()
                    tvFollowing.text = profile?.following.toString()



                    if (profile?.is_private == true) {
                        var private_pic_url =
                            "https://media.guestofaguest.com/t_article_content/gofg-media/2017/04/1/48685/17437716_1631040163591034_4958829004984418304_n.jpg"
                        posts.clear()
                        posts.add(Post(id = "private",display_url = private_pic_url))
                        adapter.notifyDataSetChanged()
                        tvBio.text = username + " is private, content hidden!"

                    } else {
                        if(profile!!.last_post==null){}
                        else if (profile?.last_post!!.isNotEmpty())
                            for (temp in profile?.last_post!!)
                                posts.add(temp)
                    }

/*
                var post = Post(0,"0","shortcode", "long captionsssssssssss",

                    "https://scontent-dfw5-2.xx.fbcdn.net/v/t1.0-9/118015192_3379000205496872_8586752924225143154_o.jpg?_nc_cat=107&_nc_sid=85a577&_nc_ohc=v8xd4Ogb50QAX9AudLB&_nc_oc=AQlChEpfdPztPJWQvQdzg3wG-0wvbDZhbRWAkB4uRY-y0Gogks5gWjgpMrRkQRC23h0&_nc_ht=scontent-dfw5-2.xx&oh=079fc8f1cd40f9a8938f7193eaaba487&oe=5F707C83",

                    "0", "0", "0", "video_url", "username",
                    "0", "profile_pic_url",
                    "last_update",
                    false,
                    "store_display_url",
                    "ai_category")


                posts.add(post)


 */
                    adapter.notifyDataSetChanged()
                    //adapter.notifyItemInserted(posts.size - 1) // notify the RecyclerView that an item was added to the last position
                    //etUsername.hint = "Enter another Username"
                } else { // if user does not exists
                    val blank_profile_url = "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"
                    Picasso.with(context).load(blank_profile_url).into(ivProfilePic)
                    tvBio.text = username + " does not exist, enter another username!!"
                    tvNumPosts.text = "0"
                    tvFollower.text = "0"
                    tvFollowing.text = "0"
                    posts.clear()
                    adapter.notifyDataSetChanged()
                }
            } else {
                etUsername.hint = "enter username"
            }

        }
    }

    private fun setFragment(fragment: Fragment) {
        //supportFragmentManager.beginTransaction().apply {
        //    replace(R.id.flFragment, fragment)
        //addToBackStack(null)    // add the previous fragment to the stack


        //    commit()    // apply

    }
}