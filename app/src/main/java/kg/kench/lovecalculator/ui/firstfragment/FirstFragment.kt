package kg.kench.lovecalculator.ui.firstfragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.kench.lovecalculator.LoveViewModel
import kg.kench.lovecalculator.R
import kg.kench.lovecalculator.databinding.FragmentFirstBinding

@AndroidEntryPoint
class FirstFragment : Fragment(R.layout.fragment_first) {

    private val binding: FragmentFirstBinding by viewBinding()
    private val viewModel: LoveViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendData()
        historyNavigation()
    }

    private fun historyNavigation() {
        binding.ivHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }

    private fun sendData() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveData(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(
                        this@FirstFragment
                    ) { loveModel ->
                        Log.e("shalala", "sendData:$loveModel ")
                        findNavController().navigate(
                            R.id.secondFragment,
                            bundleOf(BODY to loveModel)
                        )
                        viewModel.insert(loveModel)
                    }
            }
        }
    }

    companion object {
        const val BODY = "body.response.key"
    }
}
