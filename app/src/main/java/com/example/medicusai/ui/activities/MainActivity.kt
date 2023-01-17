package com.example.medicusai.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medicusai.R
import com.example.medicusai.base.BaseActivity
import com.example.medicusai.databinding.ActivityMainBinding
import com.example.medicusai.model.Biomarker
import com.example.medicusai.network.ApiInterface
import com.example.medicusai.network.RetrofitInstance
import com.example.medicusai.ui.interfaces.OnItemClickListener
import com.example.medicusai.ui.adapter.RecyclerAdapter
import com.example.medicusai.ui.fragment.DetailBiomarkFragment
import com.example.medicusai.viewmodel.MainViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainActivity : BaseActivity(), OnItemClickListener {

    private val TAG = "MainActivity"

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainViewModel

    private lateinit var databinding: ActivityMainBinding

    lateinit var recyclerAdapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        databinding.recyclerview.layoutManager = LinearLayoutManager(this)


        recyclerAdapter = RecyclerAdapter(this)

        databinding.recyclerview.adapter = recyclerAdapter


        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        viewModel.biomarkerList.observe(this, Observer {
            recyclerAdapter.setBiomarkerList(it)
        })

        viewModel.apiRequest()

    }

    override fun onClick(biomarker: Biomarker) {
//        databinding.root.removeAllViews()
        var item = DetailBiomarkFragment()
        item.biomarker = biomarker

        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.your_placeholder, item, "tt")
        ft.addToBackStack(null)
        ft.commit()
    }


}