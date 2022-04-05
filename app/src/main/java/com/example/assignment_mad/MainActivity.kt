package com.example.assignment_mad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.assignment_mad.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Company>
    private lateinit var tempArrayList: ArrayList<Company>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>
    lateinit var news:Array<String>
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setContentView(R.layout.activity_main)
        setUpTabBar()

        imageId= arrayOf(
            R.drawable.company_logo_1,
            R.drawable.company_logo_2,
            R.drawable.company_logo_3,
            R.drawable.company_logo_4,
            R.drawable.company_logo_5,
            R.drawable.company_logo_6,
            R.drawable.company_logo_7,
            R.drawable.company_logo_8,
            R.drawable.company_logo_9,
            R.drawable.company_logo_10
        )

        heading = arrayOf(
            "Candidate Biden Called Saudi Arable a Pareft eaft.",
            "The definitive text on the healing powers of the mind/body connection.",
            "This is the definitive book on mindfulness from the beloved Zen master.",
            "A timeless classic in personal development.",
            "The definitive text on the healing powers of the mind/body connection.",
            "The definitive text on the healing powers of the mind/body connection.",
            "The definitive text on the healing powers of the mind/body connection.",
            "The definitive text on the healing powers of the mind/body connection.",
            "The definitive text on the healing powers of the mind/body connection.",
            "The definitive text on the healing powers of the mind/body connection."
        )

        news= arrayOf(
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
            getString(R.string.news_j)
        )

        newRecyclerView=findViewById(R.id.recyclerView)
        newRecyclerView.layoutManager=LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList= arrayListOf<Company>()
        tempArrayList= arrayListOf<Company>()
        getUserdata()


    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.menu_item,menu)
//        val item=menu?.findItem(R.id.search_action)
//        val searchView=item?.actionView as SearchView
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                TODO("Not yet implemented")
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                tempArrayList.clear()
//                val searchText= newText!!.lowercase(Locale.getDefault())
//                if(searchText.isNotEmpty()){
//                    newArrayList.forEach{
//                        if (it.heading.lowercase(Locale.getDefault()).contains(searchText)){
//                            tempArrayList.add(it)
//                        }
//                    }
//
//                    newRecyclerView.adapter!!.notifyDataSetChanged()
//                }else{
//                    tempArrayList.clear()
//                    tempArrayList.addAll(newArrayList)
//                    newRecyclerView.adapter!!.notifyDataSetChanged()
//                }
//
//                return false
//            }
//
//        })
//
//        return super.onCreateOptionsMenu(menu)
//    }

    private fun getUserdata() {
        for (i in imageId.indices){
            val company=Company(imageId[i],heading[i])
            newArrayList.add(company)
        }

//        tempArrayList.addAll(newArrayList)
//
//        val adapter = Notification_Fragment(tempArrayList)

        newRecyclerView.adapter=NotificationAdapter(newArrayList)
//        adapter.setOnItemClickListener(object : Notification_Fragment.onItemClickListener{
//            override fun onItemClick(position: Int) {
//                //Toast.makeText(this@MainActivity,"You clicked in item no. $position",Toast.LENGTH_SHORT).show()
//
//                val intent = Intent(this@MainActivity,NewsActivity::class.java)
//                intent.putExtra("heading",newArrayList[position].heading)
//                intent.putExtra("imageId",newArrayList[position].titleImage)
//                intent.putExtra("news",news[position])
//                startActivity(intent)
//            }
//
//        })
    }


    private fun setUpTabBar() {
        val adapter=TabPageAdapter(this, tabLayout.tabCount)
        viewPager.adapter=adapter

        viewPager.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener
        {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem=tab.position

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
    }

}