package com.example.herboshadhi.frags

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.herboshadhi.R
import org.jsoup.Jsoup


class ContentFragment : Fragment() {

    private val viewModel: ContentViewModel by lazy {
        ViewModelProvider(this).get(ContentViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_content, container, false)
        val args= ContentFragmentArgs.fromBundle(requireArguments())
        var dettitle: TextView=view.findViewById(R.id.contenttitle)
        val detcontent=view.findViewById<TextView>(R.id.contenttext)
        val pgbar=view.findViewById<ProgressBar>(R.id.lodder)
        viewModel.iD=args.passid
        viewModel.onsucc.observe(viewLifecycleOwner, Observer { cont->
            dettitle.text=cont.title?.rendered
            detcontent.text=html2text(cont.content?.rendered)

            if (viewModel.status.value==PostsApiStatus.DONE){
                pgbar.visibility=View.GONE
            }

        })

        viewModel.getcont()
        setHasOptionsMenu(false)
        return view
    }

    fun html2text(html: String?): String? {
        return Jsoup.parse(html).text()
    }

}