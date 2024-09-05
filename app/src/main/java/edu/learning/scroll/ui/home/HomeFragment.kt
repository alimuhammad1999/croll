package edu.learning.scroll.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import edu.learning.scroll.WebCall.QoutesApi
import edu.learning.scroll.WebCall.RetrofitHelper
import edu.learning.scroll.databinding.FragmentHomeBinding
import retrofit2.create

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val bi get() = _binding!!
    val homeViewModel : HomeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        Log.d("TAG", "onCreateView: method Called")
        return bi.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val qoutesApi = RetrofitHelper.getInstance().create(QoutesApi::class.java)
        val result = qoutesApi.getQuotes()
        Log.d("TAG", result.body().toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy: method")
    }
}