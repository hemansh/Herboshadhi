package com.example.herboshadhi.frags

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.herboshadhi.R
import com.example.herboshadhi.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentlist= arrayListOf<Fragment>(
            TitleFragment(),
            AyurvedSidhantFragment(),
            GhareluUpcharFragment(),
            JyotishiFragment(),
            YogFragment(), SaundaryaFragment()
        )

        val adapterr= ViewPagerAdapter(fragmentlist,requireActivity().supportFragmentManager,lifecycle)

        val vp:ViewPager2=view.findViewById(R.id.view_pager)
        vp.adapter=adapterr

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val vp:ViewPager2=view.findViewById(R.id.view_pager)
        val tabLayout:TabLayout = view.findViewById(R.id.tab_layout)
        val tabTitles= arrayListOf<String>("ALL","आयुर्वेद","घरेलू उपचार","ज्योतिष","योग","सौन्दर्य उपचार")
        TabLayoutMediator(tabLayout, vp) { tab, position ->
            tab.text = tabTitles[position]
            vp.setCurrentItem(tab.position, true)
        }.attach()


    }

}