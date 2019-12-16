package com.shipra.android.redditpopular

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.shipra.android.redditpopular.ui.ListItemClickListener
import com.shipra.android.redditpopular.ui.PopularListPojo
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.io.IOException


class MainActivity : AppCompatActivity(), ListItemClickListener {


    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWebPageContents()
    }


    fun getWebPageContents() {


        Thread(Runnable {

            try {
                val stringBuilder = StringBuilder()
                val doc = Jsoup.connect("https://www.reddit.com/subreddits/popular").get()
                val title = doc.title()
                val links = doc.select("a[href]")
                stringBuilder.append(title).append("\n")
                for (link in links as Elements) {

                    val title = link.attr("title");

                    Log.e(TAG, title)

                    stringBuilder.append("\n").append("Link : ").append(link.attr("href"))
                        .append("\n").append("Text : ").append(link.text());
                }
            } catch (e: IOException) {

                Log.e(TAG, e?.localizedMessage)
            }

        }).start()
    }


    override fun onListItemClickListener(v: View, position: Int, obj: Any) {


    }

    override fun onCommentsClicked(obj: PopularListPojo) {


    }

    override fun onFavouriteClicked(obj: PopularListPojo) {


    }

    override fun onUpvoteClicked(obj: PopularListPojo) {


    }

    override fun onDownVoteClicked(obj: PopularListPojo) {


    }

    override fun onShareClicked(obj: PopularListPojo) {


    }

    override fun onFrontListClick(url: String) {

        // start new activity with the given url
    }

}




























