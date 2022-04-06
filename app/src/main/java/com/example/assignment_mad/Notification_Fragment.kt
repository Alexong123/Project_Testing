package com.example.assignment_mad

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.assignment_mad.databinding.ActivityMainBinding
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_notification_.*


class Notification_Fragment : Fragment( ) {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Company>
    private lateinit var tempArrayList: ArrayList<Company>
    lateinit var imageId:Array<Int>
    lateinit var heading:Array<String>
    lateinit var news:Array<String>



    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<NotificationAdapter.MyViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification_, container, false)


    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {

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

        heading= arrayOf(
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


        newArrayList= arrayListOf<Company>()
        tempArrayList= arrayListOf<Company>()
        getUserdata()

        super.onViewCreated(itemView, savedInstanceState)

        newRecyclerView.apply {
            layoutManager=LinearLayoutManager(activity)
            newRecyclerView=findViewById(R.id.recyclerView)
            newRecyclerView.setHasFixedSize(true)

        }

        recyclerView.apply {
            // set a LinearLayoutManager to handle Android
            // RecyclerView behavior
            layoutManager = LinearLayoutManager(activity)
            // set the custom adapter to the RecyclerView
            adapter = NotificationAdapter(newArrayList)
        }


    }


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


}



