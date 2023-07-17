package kg.kench.lovecalculator.ui.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import kg.kench.lovecalculator.databinding.ItemOnboardBinding
import kg.kench.lovecalculator.model.OnBoardModel

class OnBoardAdapter(private val finishClick: () -> Unit,private val skip:()-> Unit) :
    Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private var arrayList = arrayListOf<OnBoardModel>(
        OnBoardModel("https://www.inspiredgenerations.com/img/Items/2619_The%20Peace,%20Love%20&%20Happy%20Hour%20Bar%20Board%20with%20Tiny%20White%20Heart%20Dish.jpg"),
        OnBoardModel("https://www.inspiredgenerations.com/img/Items/2619_The%20Peace,%20Love%20&%20Happy%20Hour%20Bar%20Board%20with%20Tiny%20White%20Heart%20Dish.jpg"),
        OnBoardModel("https://www.inspiredgenerations.com/img/Items/2619_The%20Peace,%20Love%20&%20Happy%20Hour%20Bar%20Board%20with%20Tiny%20White%20Heart%20Dish.jpg"),
        OnBoardModel("https://www.inspiredgenerations.com/img/Items/2619_The%20Peace,%20Love%20&%20Happy%20Hour%20Bar%20Board%20with%20Tiny%20White%20Heart%20Dish.jpg")
    )


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnboardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.onBind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    inner class OnBoardViewHolder(private val binding: ItemOnboardBinding) :
        ViewHolder(binding.root) {
        fun onBind(model: OnBoardModel) {
            with(binding) {
                ivOnboard.load(model.image)

                btnStart.isVisible = adapterPosition == arrayList.lastIndex
                btnStart.setOnClickListener {
                    finishClick()
                }
                btnNext.isVisible = adapterPosition != arrayList.size - 1
                btnNext.setOnClickListener {
                    skip()
                }
            }
        }
    }
}