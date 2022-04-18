package uz.umarxon.ramazon

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import uz.umarxon.ramazon.adapters.RvAdapter
import uz.umarxon.ramazon.databinding.FragmentMainBinding
import uz.umarxon.ramazon.models.RamadanTImeClass
import java.text.SimpleDateFormat
import java.util.*


class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)

        val dateFormat = SimpleDateFormat("EEEE", Locale.US)
        val asWeek = dateFormat.format(Date())

        val dateFormat2 = SimpleDateFormat("MMMM", Locale.US)
        val asMonth = dateFormat2.format(Date())

        val dateFormat3 = SimpleDateFormat("dd", Locale.US)
        val asDay = dateFormat3.format(Date())

        Constants.today.observe(viewLifecycleOwner) {
            binding.textView14.text = "Ramazon ${Constants.today.value} - kun 1443-yil"
        }
        binding.wednesday.text = "${getWeek(asWeek)}, ${asDay} - ${getMonth(asMonth)}"

        val list = ArrayList<RamadanTImeClass>()

        list.add(RamadanTImeClass("2-Aprel Shanba", "04:47", "18:51", 1, "02.04.2022"))
        list.add(RamadanTImeClass("3-Aprel Yakshanba", "04:45", "18:52", 2, "03.04.2022"))
        list.add(RamadanTImeClass("4-Aprel Dushanba", "04:43", "18:53", 3, "04.04.2022"))
        list.add(RamadanTImeClass("5-Aprel Seshanba", "04:41", "18:54", 4, "05.04.2022"))
        list.add(RamadanTImeClass("6-Aprel Chorshanba", "04:39", "18:55", 5, "06.04.2022"))
        list.add(RamadanTImeClass("7-Aprel Payshanba", "04:37", "18:56", 6, "07.04.2022"))
        list.add(RamadanTImeClass("8-Aprel Juma", "04:35", "18:57", 7, "08.04.2022"))
        list.add(RamadanTImeClass("9-Aprel Shanba", "04:34", "18:58", 8, "09.04.2022"))
        list.add(RamadanTImeClass("10-Aprel Yakshanba", "04:32", "18:59", 9, "10.04.2022"))
        list.add(RamadanTImeClass("11-Aprel Dushanba", "04:30", "19:00", 10, "11.04.2022"))
        list.add(RamadanTImeClass("12-Aprel Seshanba", "04:28", "19:01", 11, "12.04.2022"))
        list.add(RamadanTImeClass("13-Aprel Chorshanba", "04:26", "19:03", 12, "13.04.2022"))
        list.add(RamadanTImeClass("14-Aprel Payshanba", "04:25", "19:04", 13, "14.04.2022"))
        list.add(RamadanTImeClass("15-Aprel Juma", "04:23", "19:05", 14, "15.04.2022"))
        list.add(RamadanTImeClass("16-Aprel Shanba", "04:21", "19:06", 15, "16.04.2022"))
        list.add(RamadanTImeClass("17-Aprel Yakshanba", "04:19", "19:07", 16, "17.04.2022"))
        list.add(RamadanTImeClass("18-Aprel Dushanba", "04:17", "19:08", 17, "18.04.2022"))
        list.add(RamadanTImeClass("19-Aprel Seshanba", "04:15", "19:09", 18, "19.04.2022"))
        list.add(RamadanTImeClass("20-Aprel Chorshanba", "04:13", "19:10", 19, "20.04.2022"))
        list.add(RamadanTImeClass("21-Aprel Payshanba", "04:12", "19:11", 20, "21.04.2022"))
        list.add(RamadanTImeClass("22-Aprel Juma", "04:10", "19:12", 21, "22.04.2022"))
        list.add(RamadanTImeClass("23-Aprel Shanba", "04:08", "19:13", 22, "23.04.2022"))
        list.add(RamadanTImeClass("24-Aprel Yakshanba", "04:06", "19:14", 23, "24.04.2022"))
        list.add(RamadanTImeClass("25-Aprel Dushanba", "04:05", "19:15", 24, "25.04.2022"))
        list.add(RamadanTImeClass("26-Aprel Seshanba", "04:04", "19:17", 25, "26.04.2022"))
        list.add(RamadanTImeClass("27-Aprel Chorshanba", "04:02", "19:18", 26, "27.04.2022"))
        list.add(RamadanTImeClass("28-Aprel Payshanba", "03:59", "19:19", 27, "28.04.2022"))
        list.add(RamadanTImeClass("29-Aprel Juma", "03:57", "19:20", 28, "29.04.2022"))
        list.add(RamadanTImeClass("30-Aprel Shanba", "03:56", "19:21", 29, "30.04.2022"))
        list.add(RamadanTImeClass("1-May Yakshanba", "03:54", "19:22", 30, "01.05.2022"))

        binding.rv.adapter = RvAdapter(list, object : RvAdapter.rv_click {
            override fun onClick(user: RamadanTImeClass, position: Int) {

            }
        })

        binding.rv.layoutManager = LinearLayoutManager(binding.root.context)

        return binding.root
    }

    private fun getMonth(asMonth: String): String {
        return when (asMonth) {
            "January" -> "Yanvar"
            "February" -> "Fevral"
            "March" -> "Mart"
            "April" -> "Aprel"
            "May" -> "May"
            "June" -> "Iyun"
            "July" -> "Iyul"
            "August" -> "Avgust"
            "September" -> "Sentyabr"
            "October" -> "Oktyabr"
            "November" -> "Noyabr"
            "December" -> "Dekabr"
            else -> {
                ""
            }
        }
    }

    private fun getWeek(asWeek: String): String {
        return when (asWeek) {
            "Monday" -> "Dushanba"
            "Tuesday" -> "Seshanba"
            "Wednesday" -> "Chorshanba"
            "Thursday" -> "Payshanba"
            "Friday" -> "Juma"
            "Saturday" -> "Shanba"
            "Sunday" -> "Yakshanba"
            else -> {
                ""
            }
        }
    }
}