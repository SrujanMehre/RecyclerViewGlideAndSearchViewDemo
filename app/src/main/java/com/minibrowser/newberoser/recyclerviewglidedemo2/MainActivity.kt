package com.minibrowser.newberoser.recyclerviewglidedemo2

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.minibrowser.newberoser.recyclerviewglidedemo2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context
    private var rvList = ArrayList<LandscapeData>()
    var adapter: RVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        context = applicationContext
        setSupportActionBar(binding.topAppBar)

        //** Add data into the Landscape List
        addData()

        //** Set the Adapter for Recycler View and assign Landscape List to it
        setAdapter()

    }

    //** Add search view inside recycler view
    @SuppressLint("ServiceCast")
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.search_menu, menu)
        val searchmanager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menu.findItem(R.id.search).actionView as android.widget.SearchView
        searchView.setSearchableInfo(searchmanager.getSearchableInfo(componentName))
        searchView.isIconifiedByDefault = false
        searchView.onActionViewExpanded()
        searchView.queryHint = "Search"

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter?.filter?.filter(newText)
                return false
            }
        })

        return true
    }

    private fun addData() {
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2014/02/27/16/10/tree-276014_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072821_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2016/05/05/02/37/sunset-1373171_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2014/02/27/16/10/tree-276014_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072821_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2016/05/05/02/37/sunset-1373171_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2014/02/27/16/10/tree-276014_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072821_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2016/05/05/02/37/sunset-1373171_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2014/02/27/16/10/tree-276014_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072821_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2016/05/05/02/37/sunset-1373171_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Tree Landscape",
                "https://cdn.pixabay.com/photo/2014/02/27/16/10/tree-276014_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2015/12/01/20/28/road-1072821_1280.jpg"
            )
        )
        rvList.add(
            LandscapeData(
                "Road Landscape",
                "https://cdn.pixabay.com/photo/2016/05/05/02/37/sunset-1373171_1280.jpg"
            )
        )

    }

    private fun setAdapter() {
        adapter = RVAdapter(rvList)
        binding.rvView.layoutManager = LinearLayoutManager(this)
        binding.rvView.adapter = adapter
    }


}