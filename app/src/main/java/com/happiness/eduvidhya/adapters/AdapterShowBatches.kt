package com.happiness.eduvidhya.adapters

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.happiness.eduvidhya.R
import com.happiness.eduvidhya.datamodels.ListOfBatchesModel

class AdapterShowBatches(val context: Activity, show_batches: ArrayList<ListOfBatchesModel>?) : RecyclerView.Adapter<AdapterShowBatches.ViewHolder>() {

    var create_classroom: DocumentReference? = null
    val db = FirebaseFirestore.getInstance()
    val teacher_collection = db.collection("teachers")
    var mArray: ArrayList<ListOfBatchesModel>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.for_showing_btaches, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val mySharedPreferences =
//            context.getSharedPreferences("MYPREFERENCENAME", Context.MODE_PRIVATE)
//        val email = mySharedPreferences.getString("user_email", "")
//        var check = teacher_collection.document(email!!).collection("classrooms")
//            .document(mArray?.get(position)?.classroom_name.toString())
//            .collection("Batches")
//
        holder.etTitleTextView.setText(mArray?.get(position)?.batches_name)
//        holder.card_view.setOnClickListener {
//
//            Toast.makeText(context, "yes", Toast.LENGTH_SHORT).show()
//            check.get()
//                .addOnSuccessListener { documents ->
//                    for (document in documents) {
//                        Log.d("TAG", "${document.id} => ${document.data}")
//                        Toast.makeText(
//                            context,
//                            document.data.toString(),
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//
//
//                }.addOnFailureListener { exception ->
//                    Log.w("TAG", "Error getting documents: ", exception)
//                    Toast.makeText(
//                        context,
//                        exception.message.toString(),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//
//        }




    }

    override fun getItemCount(): Int {
        return if (null != mArray) mArray!!.size else 0
    }



    inner class ViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {
        val etTitleTextView: TextView
        val crossImage: ImageView
        val card_view: CardView

        val mySharedPreferences =context.getSharedPreferences("MYPREFERENCENAME", Context.MODE_PRIVATE)
        val email = mySharedPreferences.getString("user_email", "")


        init {
            etTitleTextView = parent.findViewById(R.id.new_batch_item) as TextView
            crossImage = parent.findViewById(R.id.crossImage) as ImageView
            card_view = parent.findViewById(R.id.card_view) as CardView



        }
    }



    init {
        this.mArray = show_batches
    }
}