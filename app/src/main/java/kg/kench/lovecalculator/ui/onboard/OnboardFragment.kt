package kg.kench.lovecalculator.ui.onboard

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kg.kench.lovecalculator.R
import kg.kench.lovecalculator.databinding.FragmentOnboardBinding
import kg.kench.lovecalculator.ui.onboard.adapter.OnBoardAdapter
import kg.kench.lovecalculator.ui.onboard.viewmodel.OnBoardViewModel

@AndroidEntryPoint
class OnboardFragment : Fragment(R.layout.fragment_onboard) {
    private val binding: FragmentOnboardBinding by viewBinding(FragmentOnboardBinding::bind)
    private lateinit var adapter: OnBoardAdapter
    private val viewModel: OnBoardViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardAdapter(this::finishClick, this::skip)
        binding.viewpager2.adapter = adapter

        if (viewModel.isUserSeen()) {
            findNavController().navigate(R.id.firstFragment)
        }
        binding.circleIndicator.setViewPager(binding.viewpager2)
    }

    private fun finishClick() {
        viewModel.saveUserSeen()
        findNavController().navigate(R.id.firstFragment)
    }

    private fun skip() {
        binding.viewpager2.setCurrentItem(binding.viewpager2.currentItem + 1, true)
    }

}


