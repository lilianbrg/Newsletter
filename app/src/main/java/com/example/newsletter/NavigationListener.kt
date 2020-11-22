package com.example.newsletter

import androidx.fragment.app.Fragment

interface NavigationListener {

    fun updateTitle(title: Int)
    fun showFragment(fragment: Fragment)
    fun showInFragment(id: Int, fragment: Fragment)
}