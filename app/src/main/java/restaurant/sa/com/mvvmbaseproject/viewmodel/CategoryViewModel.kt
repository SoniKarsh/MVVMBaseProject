package restaurant.sa.com.mvvmbaseproject.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import restaurant.sa.com.mvvmbaseproject.R
import restaurant.sa.com.mvvmbaseproject.model.Categories

class CategoryViewModel : ViewModel {

    var id: String = ""
    var title: String = ""
    var desc: String = ""
    var imagePath: String = ""

    constructor():super()

    constructor(category: Categories): super(){
        this.id = category.id
        this.title = category.title
        this.desc = category.desc
        this.imagePath = category.imagePath
    }

    var arrayListMutableLiveData: MutableLiveData<ArrayList<CategoryViewModel>> = MutableLiveData()

    var arrayList = ArrayList<CategoryViewModel>()

//    companion object {
//        @BindingAdapter
//        fun loadImage(imageView: ImageView, imageUrl: String){
//            Picasso.get().load(imageUrl).into(imageView);
//        }
//    }

    fun getArrayList(): MutableLiveData<ArrayList<CategoryViewModel>>{

        val category1 = Categories("1", "First", "This is First.", "ic_person_bordered.png")
        val category2 = Categories("2", "Second", "This is Second.", "ic_person_bordered.png")

        val categoryViewModel1 = CategoryViewModel(category1)
        val categoryViewModel2 = CategoryViewModel(category2)

        arrayList.add(categoryViewModel1)
        arrayList.add(categoryViewModel2)

        arrayListMutableLiveData.value = arrayList

        return arrayListMutableLiveData
    }


//    fun getCategoryArrayListMutableLiveData() = arrayListMutableLiveData

    fun getImageUrl(): String{
        return imagePath
    }

}

object ImageBindingAdapter{

    @JvmStatic
    @BindingAdapter("android:src")
    fun setImageUrl(view: ImageView, url: String) {

        Picasso.get().load(url)
                .placeholder(R.drawable.ic_person)
                .into(view)

    }
}

