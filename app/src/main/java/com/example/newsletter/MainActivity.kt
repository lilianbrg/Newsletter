package com.example.newsletter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.newsletter.data.fragment.AccueilFragment

class MainActivity : AppCompatActivity() , NavigationListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment(AccueilFragment())

    }

    override fun showFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack(null)
        }.commit()
    }

    override fun showInFragment(id:Int, fragment: Fragment){
        supportFragmentManager.beginTransaction().apply{
            replace(id, fragment)
            addToBackStack(null)
        }.commit()
    }

    override fun updateTitle(title: Int){

    }
}