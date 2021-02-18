package com.victor.ko.companies.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.victor.ko.companies.databinding.ActivityCompaniesBinding
import com.victor.ko.companies.databinding.FragmentCompanyListBinding

class CompanyListFragment : Fragment() {

    private var bnd: FragmentCompanyListBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = bnd!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bnd = FragmentCompanyListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }
}