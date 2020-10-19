package com.a360.worldinhalfminute.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.a360.worldinhalfminute.R
import com.a360.worldinhalfminute.databinding.FragmentMainBinding
import com.a360.worldinhalfminute.viewmodels.ExternaIPViewModel
import com.a360.worldinhalfminute.viewmodels.LocationDataByIPViewModel
import com.a360.worldinhalfminute.viewmodels.WorldNewsViewModel
import com.a360.worldinhalfminute.viewmodels.factories.ExternaIPViewModelFactory
import com.a360.worldinhalfminute.viewmodels.factories.LocationDataByIPFactory
import com.a360.worldinhalfminute.viewmodels.factories.WorldNewsFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

class MainFragment : Fragment(), KodeinAware{

    private lateinit var binding: FragmentMainBinding

    final override val kodeinContext = kcontext<Fragment>(this)
    final override val kodein: Kodein by kodein()

    private val factoryExternaIP: ExternaIPViewModelFactory by instance()
    private val factoryLocationDataByIP: LocationDataByIPFactory by instance()
    private val factoryWorldNews: WorldNewsFactory by instance()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main,container,false)
        binding.setLifecycleOwner(this)


        val externaIPViewModel = ViewModelProviders.of(this,factoryExternaIP).get(ExternaIPViewModel::class.java)
        val locationDataByIPViewModel = ViewModelProviders.of(this,factoryLocationDataByIP).get(LocationDataByIPViewModel::class.java)
        val worldNewsViewModel = ViewModelProviders.of(this,factoryWorldNews).get(WorldNewsViewModel::class.java)


        externaIPViewModel.getexternalIP()
        externaIPViewModel.getExternalIpDataFromDB().observe(viewLifecycleOwner, Observer { externalIpData ->
            if(externalIpData != null){
                Log.e("test", externalIpData.ip)
                Log.e("test", externalIpData.country)
                Log.e("test", externalIpData.cc)
            }

        })

        return binding.root
    }
}