package com.victor.ko.companies.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.victor.ko.companies.R
import com.victor.ko.companies.data.model.Company
import com.victor.ko.companies.ui.main.adapter.MainAdapter.DataViewHolder

class MainAdapter(private val companies: ArrayList<Company>) : RecyclerView.Adapter<DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: Company) {
            /*itemView.apply {
                textViewUserName.text = user.name
                textViewUserEmail.text = user.email
                Glide.with(imageViewAvatar.context)
                    .load(user.avatar)
                    .into(imageViewAvatar)
            }*/
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_company, parent, false))

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