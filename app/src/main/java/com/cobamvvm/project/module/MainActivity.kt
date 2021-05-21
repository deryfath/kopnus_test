package com.cobamvvm.project.module

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cobamvvm.project.R
import com.cobamvvm.project.Utils.observe
import com.cobamvvm.project.data.model.ConfirmedResponseItem
import com.cobamvvm.project.module.adapter.MainAdapter
import com.cobamvvm.project.module.adapter.OnLoadMoreListener
import com.cobamvvm.project.module.adapter.RecyclerViewLoadMoreScroll
import com.cobamvvm.project.module.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.architecture.ext.viewModel


class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModel()
    private lateinit var adapter: MainAdapter
    private val handler = Handler()
    private lateinit var scrollListener: RecyclerViewLoadMoreScroll
    var listConfirmed: MutableList<ConfirmedResponseItem> = mutableListOf()
    lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        init()
    }

    private fun init(){
        viewModel.start()
        viewModel.getConfirmedList()

        progressBar.visibility = View.VISIBLE
        rv_confirmed.visibility = View.GONE

        adapter = MainAdapter(listConfirmed!!,this)
        mLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rv_confirmed.setLayoutManager(mLayoutManager)
        rv_confirmed.adapter = adapter


        observe(viewModel.confirmedResponseDetail, {
            it?.forEachIndexed { index, i ->
                adapter.addItem(i)
            }

            if(adapter.itemCount==it!!.size){

                Handler().postDelayed({
                    rv_confirmed.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }, 5000)

            }
        })


    }


}
