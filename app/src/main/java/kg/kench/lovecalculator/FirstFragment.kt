package kg.kench.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import kg.kench.lovecalculator.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initClick()
    }

    private fun initClick() = with(binding) {
        btnCalculate.setOnClickListener {
            RetrofitService.api.getPercentage(etFname.text.toString(), etSname.text.toString())
                .enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        Log.e("ololo", "onResponse: ${response.body()}")
                        findNavController().navigate(R.id.secondFragment, bundleOf(RESPONSE_BODY to response.body()))
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Toast.makeText(requireContext(), t.message, Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    companion object{
        const val RESPONSE_BODY = "response_body.result"
    }
}