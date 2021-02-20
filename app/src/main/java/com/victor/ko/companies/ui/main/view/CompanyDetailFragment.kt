package com.victor.ko.companies.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.victor.ko.companies.R
import com.victor.ko.companies.data.api.ApiHelper
import com.victor.ko.companies.data.api.RetrofitBuilder
import com.victor.ko.companies.data.model.Company
import com.victor.ko.companies.databinding.FragmentCompanyDetailBinding
import com.victor.ko.companies.ui.base.ViewModelFactory
import com.victor.ko.companies.ui.main.viewmodel.CompanyDetailViewModel
import com.victor.ko.companies.utils.Status


class CompanyDetailFragment : Fragment() {

    private val args: CompanyDetailFragmentArgs by navArgs()
    private lateinit var companyId: String

    private lateinit var companyDetailViewModel: CompanyDetailViewModel

    private var bnd: FragmentCompanyDetailBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val getBnd get() = bnd!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bnd = FragmentCompanyDetailBinding.inflate(inflater, container, false)
        val view = getBnd.root

        companyId = args.companyId

        setupViewModel()
        setupObservers()

        return view
    }

    private fun setupViewModel() {
        companyDetailViewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(CompanyDetailViewModel::class.java)
    }

    private fun setupObservers() {
        var res = companyDetailViewModel.getCompanyDetail(companyId)
        companyDetailViewModel.getCompanyDetail(companyId).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        with(getBnd) {
                            progressBar.visibility = View.GONE
                            textViewPhoneLabel.visibility = View.VISIBLE
                            textViewUrlLabel.visibility = View.VISIBLE
                        }
                        resource.data?.let { companies -> populateCompany(companies.first()) }
                    }
                    Status.ERROR -> {
                        getBnd.progressBar.visibility = View.GONE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        with(getBnd) {
                            progressBar.visibility = View.VISIBLE
                            textViewPhoneLabel.visibility = View.GONE
                            textViewUrlLabel.visibility = View.GONE
                        }
                    }
                }
            }
        })
    }

    private fun populateCompany(company: Company) {
        Glide.with(requireContext())
            .load(RetrofitBuilder.BASE_URL + company.img)
            .placeholder(R.drawable.placeholder)
            .into(getBnd.companyItemImage)

        with(getBnd) {
            companyItemTitle.text = company.name
            textViewUrl.text = company.www
            textViewPhone.text = company.phone
            companyDescription.text = company.description
        }
    }
}