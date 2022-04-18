package uz.umarxon.ramazon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nitish.typewriterview.TypeWriterView.OnAnimationChangeListener
import uz.umarxon.ramazon.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    lateinit var binding:FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAboutBinding.inflate(layoutInflater)
 
        binding.name.setCharacterDelay(30)
        binding.name.animateText("Ramazon taqvimi 2022")

        binding.name.setOnAnimationChangeListener {
            binding.subtitle.setCharacterDelay(10)
            binding.subtitle.animateText("Murodhonov Umarxon")

            binding.subtitle.setOnAnimationChangeListener {
                binding.about.setCharacterDelay(2)
                binding.about.animateText("Assalomu alaykum qadrli foydalanuvchi  Ushbu ilova yordamida Ramazon ro`zasining kunlari saharlik va iftorlik vaqtlarini kuzatib borish imkoniyati mavjud.\n\n Ushbu ilova dasturchini g'oyasi va mualliflik huquqiga ega hisoblanadi !\n\n\n" +
                        "@Murodhonov siz aziz muhlislarga yangidan yangi ilovalarni taqdim etishda davom etadi ! ")
            }
        }

        return binding.root
    }

}