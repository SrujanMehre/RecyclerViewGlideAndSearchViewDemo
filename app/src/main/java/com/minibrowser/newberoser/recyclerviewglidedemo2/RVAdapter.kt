package com.minibrowser.newberoser.recyclerviewglidedemo2

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.minibrowser.newberoser.recyclerviewglidedemo2.databinding.RvListBinding
import java.util.*

class RVAdapter(private val landscapeData: ArrayList<LandscapeData>) :
    RecyclerView.Adapter<RVAdapter.MyViewHolder>(), Filterable {

    private val searchList = ArrayList(landscapeData)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val i = LayoutInflater.from(parent.context)

        val listItemBinding = RvListBinding.inflate(i, parent, false)
        return MyViewHolder(listItemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.landscapedata = landscapeData[position]
    }

    override fun getItemCount(): Int {
        return landscapeData.size
    }

    inner class MyViewHolder(val binding: RvListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence): FilterResults {
                val filteredList = ArrayList<LandscapeData>()

                if (constraint.isBlank() or constraint.isEmpty()) {
                    filteredList.addAll(searchList)
                } else {
                    val filterPattern = constraint.toString().lowercase(Locale.ROOT).trim()

                    searchList.forEach {
                        if (it.id.lowercase(Locale.ROOT).contains(filterPattern)) {
                            filteredList.add(it)
                        }
                    }
                }

                val result = FilterResults()
                result.values = filteredList

                return result
            }

            override fun publishResults(p0: CharSequence?, result: FilterResults?) {
                landscapeData.clear()
                landscapeData.addAll(result!!.values as List<LandscapeData>)
                notifyDataSetChanged()
            }

        }
    }
}