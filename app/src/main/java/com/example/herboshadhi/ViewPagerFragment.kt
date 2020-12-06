package com.example.herboshadhi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
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
            AyurvedSidhantFragment()
        )

        val adapterr=ViewPagerAdapter(fragmentlist,requireActivity().supportFragmentManager,lifecycle)

        val vp:ViewPager2=view.findViewById(R.id.view_pager)
        vp.adapter=adapterr

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val vp:ViewPager2=view.findViewById(R.id.view_pager)
        val tabLayout:TabLayout = view.findViewById(R.id.tab_layout)
        val tabTitles= arrayListOf<String>("ALL","आयुर्वेद")
        TabLayoutMediator(tabLayout, vp) { tab, position ->
            tab.text = tabTitles[position]
            vp.setCurrentItem(tab.position, true)
        }.attach()


    }

}