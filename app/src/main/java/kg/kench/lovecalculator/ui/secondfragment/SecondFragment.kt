package kg.kench.lovecalculator.ui.secondfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import kg.kench.lovecalculator.R
import kg.kench.lovecalculator.databinding.FragmentSecondBinding
import kg.kench.lovecalculator.model.LoveModel
import kg.kench.lovecalculator.ui.firstfragment.FirstFragment

class SecondFragment : Fragment(R.layout.fragment_second) {

    private val binding: FragmentSecondBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataAccept()
        historyNavigation()
    }

    private fun historyNavigation() {
        binding.ivHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }

    private fun dataAccept() {
        with(binding) {
            val body = arguments?.getSerializable(FirstFragment.BODY) as LoveModel
            body.let {
                tvFirstName.text = it.firstName
                tvSecondName.text = it.secondName
                percent.text = it.percentage
                tvResult.text = it.result
            }
        }
    }
}