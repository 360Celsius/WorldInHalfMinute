package com.a360.worldinhalfminute.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.a360.worldinhalfminute.R
import com.a360.worldinhalfminute.databinding.FragmentMainBinding
import com.a360.worldinhalfminute.viewmodels.ExternaIPViewModel
import com.a360.worldinhalfminute.viewmodels.LocationDataByIPViewModel
import com.a360.worldinhalfminute.viewmodels.ViewModelFactory
import com.a360.worldinhalfminute.viewmodels.WorldNewsViewModel
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class MainFragment : Fragment(), KodeinAware{

    private lateinit var binding: FragmentMainBinding

    final override val kodeinContext = kcontext<Fragment>(this)
    final override val kodein: Kodein by kodein()

    private val factory: ViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        binding.setLifecycleOwner(this)


        val externaIPViewModel = ViewModelProviders.of(this,factory).get(ExternaIPViewModel::class.java)
        val locationDataByIPViewModel = ViewModelProviders.of(this,factory).get(LocationDataByIPViewModel::class.java)
        val worldNewsViewModel = ViewModelProviders.of(this,factory).get(WorldNewsViewModel::class.java)


        return binding.root
    }
}