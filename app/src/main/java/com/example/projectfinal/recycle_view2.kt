package com.example.projectfinal

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject
import java.io.IOException

/**
 * A simple [Fragment] subclass.
 */
class recycle_view2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycle_view2, container, false)
        // Inflate the layout for this fragment

        val jsonString : String = loadJsonFromAsset("recipes.json", activity!!.baseContext).toString()
        val json = JSONObject(jsonString)
        val jsonArray = json.getJSONArray("dessert")

        val recyclerView: RecyclerView = view.findViewById(R.id.recyLayout)

        //ตั้งค่า Layout
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity!!.baseContext)

        recyclerView.layoutManager = layoutManager

        //ตั้งค่า Adapter
        val adapter = MyRecyclerAdapter(activity!!.baseContext,activity!!.supportFragmentManager,jsonArray)
        recyclerView.adapter = adapter


        return view
    }
    private fun loadJsonFromAsset(filename: String, context: Context): String? {
        val json: String?

        try {
            val inputStream = context.assets.open(filename)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, Charsets.UTF_8)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }


}
