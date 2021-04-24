package com.ulanapp.bonus

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.ulanapp.bonus.di.BonusInfoComponent

class MainFragment: Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (requireContext() as BonusInfoComponent)
                .inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<Toolbar>(R.id.main_toolbar)
        toolbar.title = "ЛОГОТИП"
        toolbar.inflateMenu(R.menu.info_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.info -> { }
            }
            true
        }

        val toolbarlayout = view.findViewById<CollapsingToolbarLayout>(R.id.toolbarlayout)
        toolbarlayout.isTitleEnabled = false;

    }
}