package com.vclyfe.firstapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuInflater
import com.vclyfe.secondmodule.SecondActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: RecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = ArrayList<String>()
        list.add("Hello")
        list.add("This")
        list.add("IS A BIG")
        list.add("TEST")
        list.add("TO")
        list.add("See how")
        list.add("things")
        list.add("work")
        list.add("with")
        list.add("the recycler")
        list.add("view!")
        list.add("Hello")
        list.add("This")
        list.add("IS A BIG")
        list.add("TEST")
        list.add("TO")
        list.add("See how")
        list.add("things")
        list.add("work")
        list.add("with")
        list.add("the recycler")
        list.add("view!")
        list.add("Hello")
        list.add("This")
        list.add("IS A BIG")
        list.add("TEST")
        list.add("TO")
        list.add("See how")
        list.add("things")
        list.add("work")
        list.add("with")
        list.add("the recycler")
        list.add("view!")
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(list, this)
        recyclerView.adapter = adapter
        goToLib.setOnClickListener {
            var intentToLibraryActivity = Intent(this, SecondActivity::class.java)
            startActivity(intentToLibraryActivity)
            this.finish()
        }
    }

    fun chutiyapaTest(): String {
        return "TESTLOL"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView
        searchView.queryHint = "Search View Hint"
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.getFilter().filter(newText)
                return false
            }
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
        })
        return true
    }
}


