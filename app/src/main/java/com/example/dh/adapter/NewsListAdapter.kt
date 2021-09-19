package com.example.dh.adapter


import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.example.dh.R
import com.example.dh.model.Data
import com.example.dh.network.RealmService
import com.squareup.picasso.Picasso
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import io.realm.kotlin.where

class NewsListAdapter(private val newsList: List<Data>):RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewsListAdapter.NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsListAdapter.NewsViewHolder, position: Int) {
        val currentItem = newsList[position]
        var data=RealmService.getData(currentItem)
        if(data?.getIsFavorite() == true){
            currentItem.setIsFavorite(true)
            holder.favButton.setImageResource(R.drawable.ic_baseline_favorite_24)
        }
        else{
            currentItem.setIsFavorite(false)
            holder.favButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
        holder.newTitle.text = currentItem.getTitle()

        (  holder.newImage.layoutParams as ConstraintLayout.LayoutParams).dimensionRatio = "${currentItem.getImage().getWidth()}:${currentItem.getImage().getHeight()}"

        holder.newImage.updateLayoutParams<ConstraintLayout.LayoutParams> {
            dimensionRatio = "${currentItem.getImage().getWidth()}:${currentItem.getImage().getHeight()}"
        }
        Picasso.get().load(currentItem.getImage().getValue()).into(holder.newImage);
        holder.newContent.text=currentItem.getShortContent()
        holder.textArea.setBackgroundColor(Color.parseColor(currentItem.getColorAvarage()))
        holder.newTitle.setTextColor(Color.parseColor(currentItem.getTextColor()))
        holder.newContent.setTextColor(Color.parseColor(currentItem.getSubTextColor()))
        holder.favButton.setOnClickListener(View.OnClickListener {
            currentItem.setIsFavorite(!currentItem.getIsFavorite())

            if(currentItem.getIsFavorite()){
                holder.favButton.setImageResource(R.drawable.ic_baseline_favorite_24)
                RealmService.insertData(currentItem)
            }
            else{
                holder.favButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                RealmService.removeData(currentItem)
            }
            RealmService.getAllData()

        })
        holder.newItem.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(currentItem.getUrl())
            startActivity(holder.itemView.context,intent, Bundle())
        })
    }

    override fun getItemCount(): Int {
       return newsList.size
    }

    class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val newTitle : TextView = itemView.findViewById(R.id.new_title)
        val newImage : ImageView = itemView.findViewById(R.id.new_image)
        val newContent : TextView = itemView.findViewById(R.id.new_content)
        val textArea : View = itemView.findViewById(R.id.text_area)
        val newItem : View = itemView.findViewById(R.id.new_item)
        val favButton : ImageView = itemView.findViewById(R.id.fav_button)
    }

}
