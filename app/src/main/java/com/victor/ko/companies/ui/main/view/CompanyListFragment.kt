package com.victor.ko.companies.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.victor.ko.companies.data.api.ApiHelper
import com.victor.ko.companies.data.api.RetrofitBuilder
import com.victor.ko.companies.data.model.Company
import com.victor.ko.companies.databinding.ActivityCompaniesBinding
import com.victor.ko.companies.databinding.FragmentCompanyListBinding
import com.victor.ko.companies.ui.base.ViewModelFactory
import com.victor.ko.companies.ui.main.adapter.MainAdapter
import com.victor.ko.companies.ui.main.viewmodel.MainViewModel
import com.victor.ko.companies.utils.Status

class CompanyListFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    private var bnd: FragmentCompanyListBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val getBnd get() = bnd!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bnd = FragmentCompanyListBinding.inflate(inflater, container, false)
        val view = getBnd.root

        setupViewModel()
        setupUI()
        setupObservers()

        return view
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        getBnd.companyList.layoutManager = LinearLayoutManager(context)
        adapter = MainAdapter(arrayListOf())
        getBnd.companyList.addItemDecoration(
            DividerItemDecoration(
                getBnd.companyList.context,
                (getBnd.companyList.layoutManager as LinearLayoutManager).orientation
            )
        )
        getBnd.companyList.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getCompanyList().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        getBnd.companyList.visibility = View.VISIBLE
                        getBnd.progressBar.visibility = View.GONE
                        resource.data?.let { companies -> retrieveCompanyList(companies) }
                    }
                    Status.ERROR -> {
                        getBnd.companyList.visibility = View.VISIBLE
                        getBnd.progressBar.visibility = View.GONE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        getBnd.progressBar.visibility = View.VISIBLE
                        getBnd.companyList.visibility = View.GONE
                    }
                }
            }
        })
    }

    /*
    viewModel.getPlants().observe(viewLifecycleOwner, Observer { plants ->
            if (plants != null) adapter.submitList(plants)
        })
     */
    private fun retrieveCompanyList(companies: List<Company>) {
        adapter.apply {
            addCompanies(companies)
            notifyDataSetChanged()
        }
    }
}
/*
super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
 */

/*
val binding = FragmentPlantListBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root

        val factory = InjectorUtils.providePlantListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(PlantListViewModel::class.java)

        val adapter = PlantAdapter()
        binding.plantList.adapter = adapter
        subscribeUi(adapter)

        setHasOptionsMenu(true)
        return binding.root
 */