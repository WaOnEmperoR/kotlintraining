package id.go.bppt.ptik.trainingkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_product.view.*

class ProductAdapter(val items:ArrayList<Product>, val context: Context): RecyclerView.Adapter<ProductViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.item_product, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size;
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = items.get(position)

        holder.itemTitle.text = item.title
        holder.itemDesciption.text = item.description
        holder.itemCreated.text = item.created.toString()
    }

}

class ProductViewHolder(view: View):RecyclerView.ViewHolder(view) {
    var itemTitle = view.tv_product_name
    var itemDesciption = view.tv_description
    var itemPicture = view.imgView_product
    var itemCreated = view.tv_datetime
}