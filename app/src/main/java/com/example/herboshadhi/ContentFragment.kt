package com.example.herboshadhi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.jsoup.Jsoup


class ContentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view=inflater.inflate(R.layout.fragment_content, container, false)

        val args=ContentFragmentArgs.fromBundle(requireArguments())
        val dettitle: TextView=view.findViewById(R.id.contenttitle)
        val detcontent=view.findViewById<TextView>(R.id.contenttext)
       // Toast.makeText(context, "title: ${args.passtitle}, cotent: ${args.passcontent}", Toast.LENGTH_LONG).show()
        dettitle.text= args.passtitle
        detcontent.text= html2text(args.passcontent)

        return view
    }

    fun html2text(html: String?): String? {
        return Jsoup.parse(html).text()
    }

}