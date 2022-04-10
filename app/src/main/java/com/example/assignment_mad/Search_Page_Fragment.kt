package com.example.assignment_mad

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_mad.databinding.FragmentSearchPageBinding
import kotlinx.android.synthetic.main.fragment_notification_.*
import java.util.*
import kotlin.collections.ArrayList

class Search_Page_Fragment : Fragment() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Company_Search>
    private lateinit var tempArrayList: ArrayList<Company_Search>
    lateinit var imageId:Array<Int>
    lateinit var job_name:Array<String>
    lateinit var saveicon:Array<Int>
    lateinit var company_name:Array<String>
    lateinit var place:Array<String>
    lateinit var salary:Array<String>
    lateinit var news:Array<String>

    private var _binding:FragmentSearchPageBinding?=null
    private val binding get()=_binding!!

    override fun onResume() {
        super.onResume()
        val places=resources.getStringArray(R.array.place)
        val arrayAdapter=ArrayAdapter(requireContext(),R.layout.dropdown_item,places)

        val jobs=resources.getStringArray(R.array.job)
        val arrayAdapter2=ArrayAdapter(requireContext(),R.layout.dropdown_item,jobs)

        binding.autoCompleteTextView.setAdapter(arrayAdapter)
        binding.autoCompleteTextView2.setAdapter(arrayAdapter2)
    }


    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<Search_Page_Adapter.MyViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentSearchPageBinding.inflate(inflater,container,false)
        val views=binding.root
        //val views =inflater.inflate(R.layout.fragment_search__page_, container, false)
        newRecyclerView=views.findViewById(R.id.recyclerView_Search)

        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {

        super.onViewCreated(itemView, savedInstanceState)
        setHasOptionsMenu(true)

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

        job_name= arrayOf(
            "Engineer",
            "Computer",
            "Coder",
            "Teacher",
            "Engineer",
            "Engineer",
            "Engineer",
            "Engineer",
            "Engineer",
            "Engineer"
        )

        saveicon= arrayOf(
            R.drawable.ic_baseline_bookmark_added_24,
            R.drawable.ic_baseline_bookmark_added_24,
            R.drawable.ic_baseline_bookmark_added_24,
            R.drawable.ic_baseline_bookmark_added_24,
            R.drawable.ic_baseline_bookmark_added_24,
            R.drawable.ic_baseline_bookmark_added_24,
            R.drawable.ic_baseline_bookmark_added_24,
            R.drawable.ic_baseline_bookmark_added_24,
            R.drawable.ic_baseline_bookmark_added_24,
            R.drawable.ic_baseline_bookmark_added_24
        )

        company_name= arrayOf(
            "Phonix Sdn Bhd",
            "Computer Sdn Bhd",
            "Coder",
            "Teacher",
            "Engineer",
            "Engineer",
            "Engineer",
            "Engineer",
            "Engineer",
            "Engineer"
        )

        place= arrayOf(
            "Kuala Lumpur",
            "Kuala Lumpur",
            "Selangor",
            "Rimbunan",
            "Kuala Lumpur",
            "Kuala Lumpur",
            "Kuala Lumpur",
            "Kuala Lumpur",
            "Kuala Lumpur",
            "Kuala Lumpur"
        )

        salary= arrayOf(
            "RM3000",
            "RM4000",
            "RM3500",
            "RM2000",
            "RM1000",
            "RM3000",
            "RM3000",
            "RM3000",
            "RM3000",
            "RM3000",
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

        newArrayList= arrayListOf<Company_Search>()
        tempArrayList= arrayListOf<Company_Search>()
        getUserdata()



//        newRecyclerView.apply {
//            layoutManager= LinearLayoutManager(activity)
//            newRecyclerView.setHasFixedSize(true)
//
//        }
//
//
//        recyclerView.apply {
//            // set a LinearLayoutManager to handle Android
//            // RecyclerView behavior
//            layoutManager= LinearLayoutManager(activity)
//
//            // set the custom adapter to the RecyclerView
//            adapter = Search_Page_Adapter(newArrayList)
//        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu,menu)
        val item=menu?.findItem(R.id.search_action)
        val searchView=item?.actionView as SearchView
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArrayList.clear()
                val searchText= newText!!.lowercase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    newArrayList.forEach{
                        if (it.job_name.lowercase(Locale.getDefault()).contains(searchText)){
                            tempArrayList.add(it)
                        }
                    }

                    newRecyclerView.adapter!!.notifyDataSetChanged()
                }else{
                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                    newRecyclerView.adapter!!.notifyDataSetChanged()
                }


                return false
            }

        })


        return super.onCreateOptionsMenu(menu,inflater)
    }


    private fun getUserdata() {
        for (i in imageId.indices){
            val companySearch=Company_Search(imageId[i],job_name[i],saveicon[i],company_name[i],place[i],salary[i])
            newArrayList.add(companySearch)
        }

        tempArrayList.addAll(newArrayList)

        val adapter=Search_Page_Adapter(tempArrayList)
        adapter.setOnItemClickListener(object :Search_Page_Adapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(context,"You clicked in item no . $position",Toast.LENGTH_SHORT).show()
//
//                val intent= Intent(context,Search_Page_Detail::class.java)
//                intent.putExtra("name",newArrayList[position].job_name)
//                intent.putExtra("imageId",newArrayList[position].titleImage)
//                intent.putExtra("news",news[position])
//                startActivity(intent)
            }
        })

        newRecyclerView.layoutManager=LinearLayoutManager(activity)
        newRecyclerView.setHasFixedSize(true)
        newRecyclerView.adapter=adapter
    }


}

