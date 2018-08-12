package restaurant.sa.com.mvvmbaseproject.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import restaurant.sa.com.mvvmbaseproject.R
import restaurant.sa.com.mvvmbaseproject.databinding.CategoryBinding
import restaurant.sa.com.mvvmbaseproject.viewmodel.CategoryViewModel

class CustomAdapter(private val context: Context, private val arrayList: ArrayList<CategoryViewModel>)
    : RecyclerView.Adapter<CustomAdapter.CustomView>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomView {
        val layoutInflater = LayoutInflater.from(context)

        val categoryBinding: CategoryBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_view
        , parent, false)

        return CustomView(categoryBinding)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: CustomView, position: Int) {
        val categoryViewModel = arrayList[holder.adapterPosition]
        holder.bind(categoryViewModel)
    }


    class CustomView(val categoryBinding: CategoryBinding): RecyclerView.ViewHolder(categoryBinding.root){
        fun bind(categoryViewModel: CategoryViewModel){
            this.categoryBinding.categorymodel = categoryViewModel
            categoryBinding.executePendingBindings()
        }
    }

}