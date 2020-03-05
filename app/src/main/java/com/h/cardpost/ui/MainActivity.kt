package com.h.cardpost.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import com.h.cardpost.R

class MainActivity : AppCompatActivity() {

    private var countLike: TextView? = null
    private var isLiked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_item)

        initViews()
        setCountLike()
        setCountCommentAndReply()
        setLike()
    }

    private fun initViews(){
        countLike = findViewById(R.id.countLikes)
    }

    private fun setCountLike(){
        if (countLike!!.text.toString() == "0") {
            countLike!!.visibility = View.INVISIBLE
        } else {
            countLike!!.visibility = View.VISIBLE
        }
    }

    private fun setCountCommentAndReply() {


        val countComment: TextView = findViewById(R.id.countComments)
        if (countComment.text.toString() == "0") {
            countComment.visibility = View.INVISIBLE
        } else {
            countComment.visibility = View.VISIBLE
        }

        val countReply: TextView = findViewById(R.id.countReply)
        if (countReply.text.toString() == "0") {
            countReply.visibility = View.INVISIBLE
        } else {
            countReply.visibility = View.VISIBLE
        }
    }

    private fun setLike(){
        val like: ImageButton = findViewById(R.id.ImageButtonLike)
        var countLikesL: Long = countLike?.text.toString().toLong()
        like.setOnClickListener {
            isLiked = !isLiked
            if(!isLiked){
                like.setImageResource(R.drawable.ic_favorite_border_24dp)
                countLikesL -= 1
            } else {
                like.setImageResource(R.drawable.ic_favorite_24dp)
                countLikesL += 1
            }
            countLike?.text = countLikesL.toString()
            setCountLike()
        }
    }
}
