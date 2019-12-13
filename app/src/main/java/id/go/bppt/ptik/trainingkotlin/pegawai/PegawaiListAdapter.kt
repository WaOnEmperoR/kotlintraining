package id.go.bppt.ptik.trainingkotlin.pegawai

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import id.go.bppt.ptik.trainingkotlin.R
import id.go.bppt.ptik.trainingkotlin.roomsample.Word

class PegawaiListAdapter internal constructor(
    context: Context,
    private val onClickListener: (View, Pegawai) -> Unit,
    private val onLongClickListener: (View, Pegawai) -> Boolean
) : RecyclerView.Adapter<PegawaiListAdapter.PegawaiViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var pegawais = emptyList<Pegawai>()

    inner class PegawaiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nipItemView: TextView = itemView.findViewById(R.id.tv_nip)
        val nameItemView: TextView = itemView.findViewById(R.id.tv_name)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PegawaiViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item_pegawai, parent, false)
        return PegawaiViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return pegawais.size
    }

    override fun onBindViewHolder(holder: PegawaiViewHolder, position: Int) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val current = pegawais[position]
        holder.nipItemView.text = current.nip
        holder.nameItemView.text = current.name

        holder.itemView.setOnClickListener {
            view -> onClickListener.invoke(view, current)
        }

        holder.itemView.setOnLongClickListener { view -> onLongClickListener.invoke(view, current) }

    }

    internal fun setPegawais(pegawais: List<Pegawai>) {
        this.pegawais = pegawais
        notifyDataSetChanged()
    }
}