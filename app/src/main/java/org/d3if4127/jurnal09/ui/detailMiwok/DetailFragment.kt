package org.d3if4127.jurnal09.ui.detailMiwok

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import org.d3if4127.jurnal09.R
import org.d3if4127.jurnal09.databinding.FragmentDetailBinding
import org.d3if4127.jurnal09.network.WordListData

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {


    private lateinit var binding: FragmentDetailBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val detail = arguments?.getParcelableArrayList<WordListData>("content")
        val background = arguments?.getString("background")
        val title = arguments?.getString("title")

        (activity as AppCompatActivity).supportActionBar?.title = title

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        viewManager = LinearLayoutManager(context)
        viewAdapter = DetailAdapter(detail, background)
        recyclerView = binding.rvMiwokDetail.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        return binding.root
    }

}
