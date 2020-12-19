package com.example.herboshadhi.frags

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.herboshadhi.CellClickListener
import com.example.herboshadhi.PostModel
import com.example.herboshadhi.R
import com.example.herboshadhi.adapters.PostAdpater
import com.example.herboshadhi.databinding.FragmentGhareluUpcharBinding

class GhareluUpcharFragment : Fragment(),CellClickListener {
    private lateinit var postAdapter: PostAdpater
    lateinit var tmp:MutableList<PostModel>

    private val viewModel: GhareluUpcharViewModel by lazy {
        ViewModelProvider(this).get(GhareluUpcharViewModel::class.java)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding=FragmentGhareluUpcharBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewmodel=viewModel
        postAdapter= PostAdpater(this)
        binding.recyclerViewGu.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewGu.adapter=postAdapter
        viewModel.onsucess.observe(viewLifecycleOwner, Observer { postList ->
            postList?.let {
                postAdapter.setPosts(it)
                tmp=it

                if (viewModel.status.value==PostsApiStatus.DONE){
                    binding.progressBarGu.visibility=View.GONE
                }
            }
        })

        viewModel.getposts()

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCellClickListener(data: PostModel) {
        view?.findNavController()?.navigate(GhareluUpcharFragmentDirections.actionGhareluUpcharFragmentToContentFragment(data.id))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.refresh -> postAdapter.setPosts(tmp)
        }
        return true
    }

}