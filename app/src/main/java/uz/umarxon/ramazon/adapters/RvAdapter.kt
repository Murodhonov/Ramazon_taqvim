package uz.umarxon.ramazon.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.umarxon.ramazon.Constants
import uz.umarxon.ramazon.R
import uz.umarxon.ramazon.databinding.ItemRvBinding
import uz.umarxon.ramazon.models.RamadanTImeClass
import java.text.SimpleDateFormat
import java.util.*

class RvAdapter(private val list: List<RamadanTImeClass>, val rvClick: rv_click) :
    RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        @SuppressLint("SimpleDateFormat")
        fun onBind(user: RamadanTImeClass, position: Int) {
            itemRv.name.text = user.name
            itemRv.count.text = "${position + 1}"
            itemRv.time1.text = user.saharlik
            itemRv.time2.text = user.iftorlik

            val sdf = SimpleDateFormat("dd.MM.yyyy")
            val currentDate = sdf.format(Date())

            if (currentDate == user.date){
                itemRv.rootOfView.setBackgroundResource(R.drawable.card2)
                itemRv.count.setTextColor(Color.parseColor("#ffffff"))
                itemRv.time1.setTextColor(Color.parseColor("#ffffff"))
                itemRv.time2.setTextColor(Color.parseColor("#ffffff"))
                itemRv.name.setTextColor(Color.parseColor("#ffffff"))
                Constants.today.value = user.dayOfMonth.toString()
                Log.d("dayOfMonth","${user.dayOfMonth}")
                Constants.todayUz.value = user.date.substring(0,2)
            }else{

                itemRv.rootOfView.setBackgroundResource(R.drawable.card3)
                itemRv.count.setTextColor(Color.parseColor("#3700b3"))
                itemRv.time1.setTextColor(Color.parseColor("#3700b3"))
                itemRv.time2.setTextColor(Color.parseColor("#3700b3"))
                itemRv.name.setTextColor(Color.parseColor("#3700b3"))
            }

        }
    }

    interface rv_click {
        fun onClick(user: RamadanTImeClass, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}