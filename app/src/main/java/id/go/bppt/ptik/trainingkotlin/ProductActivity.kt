package id.go.bppt.ptik.trainingkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_product.*
import java.util.*
import kotlin.collections.ArrayList

class ProductActivity : AppCompatActivity() {

    var productList: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        generateProduct()

        recyclerView_product.layoutManager = LinearLayoutManager(this)
        recyclerView_product.adapter = ProductAdapter(productList, this)
    }

    fun generateProduct()
    {
        for (i in 1..10){
            var item = Product("Product $i", "ini produk $i Lorem Ipsum janchick", "", Date())
            productList.add(item)
        }

    }
}
