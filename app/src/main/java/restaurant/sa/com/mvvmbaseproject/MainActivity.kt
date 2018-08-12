package restaurant.sa.com.mvvmbaseproject

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import restaurant.sa.com.mvvmbaseproject.adapter.CustomAdapter
import restaurant.sa.com.mvvmbaseproject.viewmodel.CategoryViewModel

class MainActivity : AppCompatActivity() {

    private var customAdapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)

        categoryViewModel.getArrayList().observe(this, Observer {categoryViewModels ->
            customAdapter = CustomAdapter(this@MainActivity, categoryViewModels!!)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = customAdapter
        })

    }
}
