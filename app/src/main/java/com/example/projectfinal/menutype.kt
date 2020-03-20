package com.example.projectfinal


import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.firebase_authen.authen


/**
 * A simple [Fragment] subclass.
 */
class menutype : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_menutype, container, false)
        // Inflate the layout for this fragment

        val button1: Button = view.findViewById(R.id.btndish);
        val button2: Button = view.findViewById(R.id.btndess);



        button1.setOnClickListener {
            Toast.makeText(context, "Dish", Toast.LENGTH_LONG).show()
            val fragment_recycler_view = recycle_view()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout, fragment_recycler_view,"fragment_recycler_view")
            transaction.addToBackStack("fragment_recycler_view")
            transaction.commit()
        }

        button2.setOnClickListener {
            Toast.makeText(context, "Dessert", Toast.LENGTH_LONG).show()
            val fragment_recycler_view2 = recycle_view2()
            val fm = fragmentManager
            val transaction : FragmentTransaction = fm!!.beginTransaction()
            transaction.replace(R.id.layout, fragment_recycler_view2,"fragment_recycler_view2")
            transaction.addToBackStack("fragment_recycler_view2")
            transaction.commit()
        }

        val button_open_dialog = view.findViewById<Button>(R.id.button_open_dialog)

        button_open_dialog.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this.context)
            builder.setMessage("ต้องการกลับไปหน้า login หรือไม่")
            builder.setPositiveButton("ตกลง",
                DialogInterface.OnClickListener { dialog, id ->
                    // ย้อนกลับ
                    val authen = authen()

                    val fm = fragmentManager
                    val transaction : FragmentTransaction = fm!!.beginTransaction()
                    transaction.replace(R.id.layout, authen,"fragment_authen")
                    transaction.addToBackStack("fragment_authen")
                    transaction.commit()
                    //
                    Log.i("TestDialog","true")
                })
            builder.setNegativeButton("ยกเลิก",
                DialogInterface.OnClickListener { dialog, which ->
                    //dialog.dismiss();
                    Log.i("TestDialog","false")
                })
            builder.show()
        }
        return view;
    }
}


