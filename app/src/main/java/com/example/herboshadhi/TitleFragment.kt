package com.example.herboshadhi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.navigation.findNavController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_title, container, false)

        val API = rf.create(RetrofitInterface::class.java)
        val call = API.posts
        call?.enqueue(object : Callback<List<PostModel?>?> {
            override fun onResponse(
                call: Call<List<PostModel?>?>,
                response: Response<List<PostModel?>?>
            ) {
                var pbar=view!!.findViewById<ProgressBar>(R.id.progressBar_as)
                var postlist: List<PostModel>? = response.body() as List<PostModel>
                val post = arrayOfNulls<String>(postlist!!.size)
                val img= arrayOfNulls<String>(postlist.size)
                pbar.visibility=View.GONE
                //Toast.makeText(context, "title: ${postlist[0]._embedded?.featuremedia?.get(0)?.source_url}", Toast.LENGTH_LONG).show()

                for (i in postlist!!.indices)
                    post[i] = postlist[i]!!.title?.rendered

                for (i in postlist.indices)
                    img[i]=postlist[i]._embedded?.featuremedia?.get(0)?.source_url

                val adapter1 =
                    MyListAdapter(activity,post,img)
                val listview = view!!.findViewById<ListView>(R.id.lstview_as)
                listview.adapter = adapter1
                listview.onItemClickListener = object : AdapterView.OnItemClickListener {
                    override fun onItemClick(
                        parent: AdapterView<*>, view: View,
                        position: Int, id: Long
                    ) {

                        //val itemValue = listview.getItemAtPosition(position)
                        var ttl = postlist[position].title?.rendered
                        var cont = postlist[position].content?.rendered

                        view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToContentFragment(ttl.toString(), cont.toString()))
                    }
                    }

            }

            override fun onFailure(call: Call<List<PostModel?>?>, t: Throwable) {
            }

        })

        return view
    }
}

