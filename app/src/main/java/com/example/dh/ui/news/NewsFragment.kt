package com.example.dh.ui.news

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dh.R
import com.example.dh.adapter.FavsListAdapter
import com.example.dh.adapter.NewsListAdapter
import com.example.dh.model.Data
import com.example.dh.network.RealmService

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel
    private lateinit var newsRecylerView:RecyclerView
    private lateinit var layoutManager: LinearLayoutManager

    private  var page :Int=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.news_fragment, container, false)
         newsRecylerView = rootView.findViewById<RecyclerView>(R.id.news_recycler_view)
        newsRecylerView.adapter=NewsListAdapter(listOf<Data>())
        layoutManager =LinearLayoutManager(rootView.context)
        newsRecylerView.layoutManager=layoutManager
        newsRecylerView.setHasFixedSize(true)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        page=0
        viewModel.progressBar = rootView.findViewById<ProgressBar>(R.id.progress_bar)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        newsRecylerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy>0){
                    var visibleItemCount=layoutManager.childCount
                    val postVisibleItemCount= layoutManager.findFirstVisibleItemPosition()
                    val total = layoutManager.itemCount
                    if((visibleItemCount+postVisibleItemCount)>=total){
                        if(!viewModel.requesting) {
                            page++
                            viewModel.getDataFromApi(page)
                        }
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
        viewModel.getNewsListObserver().observe(viewLifecycleOwner, Observer {
                it->if(newsRecylerView.adapter?.itemCount==0){newsRecylerView.adapter= NewsListAdapter(it)}else{
                    newsRecylerView.adapter!!.notifyDataSetChanged()
                }
        })
        RealmService.newsLive.observe(viewLifecycleOwner, Observer {
                it->viewModel.chechkInFavList(it)
        })
    }

}