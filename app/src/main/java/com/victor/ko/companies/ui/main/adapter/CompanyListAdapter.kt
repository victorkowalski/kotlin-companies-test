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
import com.victor.ko.companies.ui.main.adapter.CompanyListAdapter.DataViewHolder

class CompanyListAdapter(private val companies: ArrayList<Company>, private val onClickCompany: (Company) -> Unit)
    : RecyclerView.Adapter<DataViewHolder>() {

    class DataViewHolder(itemView: View, private val onClickCompany: (Company) -> Unit)
        : RecyclerView.ViewHolder(itemView) {
        var imgView: ImageView = itemView.findViewById(R.id.company_item_image)
        var companyId: TextView = itemView.findViewById(R.id.company_id)
        var titleView: TextView = itemView.findViewById(R.id.company_item_title)

        private var currentCompany: Company? = null

        fun bind(company: Company) {
            currentCompany = company
            itemView.apply {
                titleView.text = company.name
                companyId.text = company.id
                Glide.with(context)
                    .load(RetrofitBuilder.BASE_URL + company.img)
                    .placeholder(R.drawable.placeholder)
                    .into(imgView)

                setOnClickListener {
                    currentCompany?.let {
                        onClickCompany(it)
                    }
                }
            }
        }
/*
        init {
            itemView.setOnClickListener {
                currentCompany?.let {
                    onClickCompany(it)
                }
            }
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_company, parent, false)
        return DataViewHolder(itemView, onClickCompany)
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