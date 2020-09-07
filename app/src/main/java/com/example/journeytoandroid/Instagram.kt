package com.example.journeytoandroid

import java.util.*

class Instagram(
    val id: String = "0",
    val full_name: String = "Full Name",
    val biography: String = "Bio",
    val username: String = "Username",
    var is_private: Boolean = true,
    val external_url: String = "external url",
    val is_verified: Boolean = false,
    val profile_pic_url: String = "profile pic url",
    val stored_profile_pic_url: String = "stored profile pic url",
    val following: String = "0",
    val follower: String = "0",
    val like: String = "0",
    val comment: String = "0",
    val video_view: String = "0",
    val total_post: String = "0",
    val average_like: String ="0",
    val average_comment: String = "0",
    val average_video_view: String = "0",
    val last_post: List<Post>
                ) {}

class Post(
    val id: String = "0",
    val timestamp_taken: String = "0",
    val shortcode: String = "0",
    val caption: String = "0",
    val display_url: String = "0",
    val comment: String = "0",
    val like: String = "0",
    val video_view: String = "0",
    val video_url: String = "0",
    val username: String = "0",
    val user_id: String = "0",
    val profile_pic_url: String = "0",
    val last_update: String = "0",
    val is_video: Boolean = false,
    val store_display_url: String = "0",
    val ai_category: String = "0"
) {}


/*
POSTS
"id":"2380392762036888421"
"timestamp_taken":1597984951
"shortcode":"CEI2prvHqNl"
"caption":"Another look at the one-man engine kayak"
"display_url":"https://scontent-atl3-2.cdninstagram.com/v/t51.2885-15/e35/s1080x1080/118169319_195591961918824_6643033488250605609_n.jpg?_nc_ht=scontent-atl3-2.cdninstagram.com&_nc_cat=100&_nc_ohc=6huQuVFmlDoAX-HBOB5&oh=5ab6c4c47e40be3d486a8d5221c75667&oe=5F77BAA5"
"comment":2
"like":60
"video_view":0
"video_url":""
"username":"hoang.luuuuuu"
"user_id":"301422834"
"profile_pic_url":""
"last_update":"2020-09-01T17:44:57Z"
"is_video":false
"store_display_url":""
"ai_category":NULL



INSTAGRAM
"id":"301422834"
"full_name":"Hoang Luu"
"biography":"• 📷 • 🎶 • 🏐 •"
"username":"hoang.luuuuuu"
"is_private":false
"external_url":""
"is_verified":false
"profile_pic_url":"https://scontent-atl3-2.cdninstagram.com/v/t51.2885-19/s150x150/95442544_330571397907441_1970429251924525056_n.jpg?_nc_ht=scontent-atl3-2.cdninstagram.com&_nc_ohc=W3VA4nWeHhIAX-FwGUR&oh=4a386fa9cb57b03cffea8478cfd8a2e1&oe=5F785103"
"stored_profile_pic_url":""
"following":127
"follower":328
"like":465
"comment":14
"video_view":0
"total_post":9
"average_like":51
"average_comment":1
"average_video_view":0
"last_post" LIST
 */