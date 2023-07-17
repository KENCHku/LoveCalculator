package kg.kench.lovecalculator.ui.historyfragment.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kg.kench.lovecalculator.databinding.ItemHistoryBinding
import kg.kench.lovecalculator.model.LoveModel

class HistoryAdapter : Adapter<HistoryAdapter.HistoryViewHolder>() {

    private val arrayList = arrayListOf<LoveModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun getList(list: List<LoveModel>) {
        arrayList.clear()
        arrayList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class HistoryViewHolder(private var binding: ItemHistoryBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: LoveModel) {
            with(binding) {
                tvFirstName.text = model.firstName
                tvSecondName.text = model.secondName
                tvResult.text = model.result
                tvPercent.text = model.percentage
            }
        }
    }
}