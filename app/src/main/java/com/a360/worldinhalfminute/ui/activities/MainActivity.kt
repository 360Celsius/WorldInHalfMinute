package com.a360.worldinhalfminute.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a360.worldinhalfminute.R
import com.a360.worldinhalfminute.ui.fragments.MainFragment

class MainActivity : AppCompatActivity() {

    private val fragmentManager = supportFragmentManager
    private val mainFragment = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /* Display Main Fragment  */
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_continer, mainFragment)
        fragmentTransaction.commit()
    }
}