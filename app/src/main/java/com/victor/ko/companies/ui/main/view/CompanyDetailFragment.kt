package com.victor.ko.companies.ui.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.victor.ko.companies.databinding.FragmentCompanyDetailBinding
import com.victor.ko.companies.databinding.FragmentCompanyListBinding

class CompanyDetailFragment : Fragment() {

    private val args: CompanyDetailFragmentArgs by navArgs()

    private var bnd: FragmentCompanyDetailBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val getBnd get() = bnd!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bnd = FragmentCompanyDetailBinding.inflate(inflater, container, false)
        val view = getBnd.root

        val companyId = args.companyId

        return view
    }

/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val amount = args.companyId
        tv.text = amount.toString()
    }*/
}