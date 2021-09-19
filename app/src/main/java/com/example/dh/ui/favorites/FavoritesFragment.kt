package com.example.dh.ui.favorites

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dh.R
import com.example.dh.adapter.FavsListAdapter
import com.example.dh.adapter.NewsListAdapter
import com.example.dh.model.Data
import com.example.dh.network.RealmService
import com.example.dh.ui.news.NewsViewModel

class FavoritesFragment : Fragment() {

    private lateinit var viewModel: FavoritesViewModel
    private lateinit var newsRecylerView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.favorites_fragment, container, false)
        newsRecylerView = rootView.findViewById<RecyclerView>(R.id.favorites_recycler_view)
        newsRecylerView.adapter= NewsListAdapter(listOf<Data>())
        layoutManager =LinearLayoutManager(rootView.context)
        newsRecylerView.layoutManager=layoutManager
        newsRecylerView.setHasFixedSize(true)
        viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        RealmService.newsLive.observe(viewLifecycleOwner, Observer {
                it->if(newsRecylerView.adapter?.itemCount==0){newsRecylerView.adapter= FavsListAdapter(it)
        }else{
            newsRecylerView.adapter!!.notifyDataSetChanged()
        }
        })

    }

}