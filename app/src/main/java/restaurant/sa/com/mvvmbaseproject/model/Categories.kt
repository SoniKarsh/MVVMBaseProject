package restaurant.sa.com.mvvmbaseproject.model

data class Categories(var id: String, var title: String, var desc: String, var imagePath: String) {

    constructor():this("", "", "", "")

}