package kg.kench.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kg.kench.lovecalculator.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        getData()
    }

    private fun getData() = with(binding) {
        val result = arguments?.getSerializable(FirstFragment.RESPONSE_BODY) as LoveModel
        result.let {
            this.tvFname.setText(it.firstName)
            this.tvSname.setText(it.secondName)
            this.tvPercentage.setText(it.percentage)
            this.tvToast.setText(it.result)
        }
    }
}