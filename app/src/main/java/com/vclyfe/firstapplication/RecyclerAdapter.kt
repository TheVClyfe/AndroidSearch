package com.vclyfe.firstapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import kotlinx.android.synthetic.main.row_item.view.*

class RecyclerAdapter(val list: ArrayList<String>, val context: Context): RecyclerView.Adapter<RecyclerAdapter.RecyclerVH>(), Filterable {

    private val copyList = ArrayList<String>(list)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerVH {
        return RecyclerVH(LayoutInflater.from(context).inflate(R.layout.row_item, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: RecyclerVH, p1: Int) {
        p0.textView.text = list[p1]
        p0.linearLayout.setOnClickListener {
            Toast.makeText(context, "This is a toast called on item ${list[p1]}!", Toast.LENGTH_SHORT).show()
            //need to use this to send data back to the previous fragment
        }
    }

    class RecyclerVH(view: View): RecyclerView.ViewHolder(view) {
        val textView = view.textBox
        val linearLayout = view.linearLayout
    }

    override fun getFilter(): Filter {
        return FilterClass()
    }

    inner class FilterClass: Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList = ArrayList<String>()
            if(constraint == null || constraint.isEmpty()) {
                filteredList.addAll(copyList)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim()
                for(item in copyList) {
                    if(item.contains(filterPattern)) filteredList.add(item)
                }
            }

            val filterResults = FilterResults()
            filterResults.values = filteredList
            return filterResults
        }

        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            list.clear()
            list.addAll(results?.values as ArrayList<String>)
        }

    }

}