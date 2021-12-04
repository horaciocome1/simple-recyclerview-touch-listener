package io.github.horaciocome1.recyclerviewxtensions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.github.horaciocome1.extensions.extensions.addGestureDetection
import io.github.horaciocome1.extensions.extensions.doubleClick
import io.github.horaciocome1.extensions.extensions.longClick
import io.github.horaciocome1.extensions.extensions.singleClick

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        val cities = listOf("Maputo", "Beira", "Chimoio", "Maxixe", "Nacala", "Niassa")
        recyclerView.adapter = MyAdapter(cities)

        // simple example
        recyclerView.addGestureDetection {
            Log.d(TAG, "addGestureDetection isSingleClick=$isSingleClick")
            Log.d(TAG, "addGestureDetection isDoubleClick=$isDoubleClick")
            Log.d(TAG, "addGestureDetection isLongClick=$isLongPress")
            Log.d(TAG, "addGestureDetection view=$view")
            Log.d(TAG, "addGestureDetection position=$position")
        }
    }

    fun samples(recyclerView: RecyclerView) {
        recyclerView.addGestureDetection {
            Log.d(TAG, "gesture detected")
            singleClick {
                Log.d(TAG, "gesture is single click")
                Log.d(TAG, "view=$view")
                Log.d(TAG, "position=$position")
            }
        }

        recyclerView.addGestureDetection {
            doubleClick { }
        }

        recyclerView.addGestureDetection {
            longClick { }
        }
    }

    class MyAdapter(private val cities: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

        class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

            fun setText(text: String) {
                val textView = view.findViewById<TextView>(R.id.textView)
                textView.text = text
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
            return MyViewHolder(view)
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.setText("$position ${cities[position]}")
        }

        override fun getItemCount(): Int {
            return cities.size
        }
    }
}
