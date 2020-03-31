package org.d3if4127.jurnal09.ui.miwok

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.d3if4127.jurnal09.R
import org.d3if4127.jurnal09.databinding.FragmentMiwokBinding

/**
 * A simple [Fragment] subclass.
 */
class MiwokFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private lateinit var binding: FragmentMiwokBinding
    private lateinit var miwokVM: MiwokViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Miwok - 6706184127"

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_miwok, container, false)
        miwokVM = ViewModelProviders.of(this).get(MiwokViewModel::class.java)
        binding.setLifecycleOwner(this)
        binding.miwokVM = miwokVM

        viewManager = LinearLayoutManager(context)
        miwokVM.items.observe(viewLifecycleOwner, Observer {
            viewAdapter = MiwokAdapter(it, MiwokAdapter.OnClickListener {it, color, title ->
                var bundle = bundleOf("content" to it, "background" to color, "title" to title)
                view?.findNavController()?.navigate(R.id.action_miwokFragment_to_detailFragment, bundle)
            })
            recyclerView = binding.rvMiwok.apply {
                layoutManager = viewManager
                adapter = viewAdapter
            }
        })
        miwokVM.response.observe(viewLifecycleOwner, Observer {
            if (it != "") {
                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }

}
