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
                val pageTitle = doc.title()

                val links = doc.select("div[class$=entry unvoted]")
                stringBuilder.append(pageTitle).append("\n")

                for (link in links as Elements) {

                    val childLink = link.select("a[href][class]")
                    val descriptionTag = link.select("div[class$=md]").select("p")

                    val desc = descriptionTag.text();
                    val title = childLink.text()
                    val URL = childLink.attr("abs:href")

                    Log.e(TAG, "title:  $title")
                    Log.e(TAG, "Url:  $URL")
                    Log.e(TAG, "Description:  $desc")

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




























