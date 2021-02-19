package com.victor.ko.companies.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.victor.ko.companies.R
import com.victor.ko.companies.data.api.RetrofitBuilder
import com.victor.ko.companies.data.model.Company
import com.victor.ko.companies.ui.main.adapter.MainAdapter.DataViewHolder

class MainAdapter(private val companies: ArrayList<Company>) : RecyclerView.Adapter<DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgView: ImageView = itemView.findViewById(R.id.company_item_image)
        var companyId: TextView = itemView.findViewById(R.id.company_id)
        var titleView: TextView = itemView.findViewById(R.id.company_item_title)

        fun bind(company: Company) {
            itemView.apply {
                titleView.text = company.name
                companyId.text = company.id
                Glide.with(context)
                    .load(RetrofitBuilder.BASE_URL + company.img)
                    .placeholder(R.drawable.placeholder)
                    .into(imgView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_company, parent, false)
        return DataViewHolder(itemView)
    }

    override fun getItemCount(): Int = companies.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(companies[position])
    }

    fun addCompanies(companies: List<Company>) {
        this.companies.apply {
            clear()
            addAll(companies)
        }

    }
}