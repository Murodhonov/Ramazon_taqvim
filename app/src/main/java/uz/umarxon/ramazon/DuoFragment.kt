package uz.umarxon.ramazon

import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import uz.umarxon.ramazon.Constants.pause_all
import uz.umarxon.ramazon.Constants.player
import uz.umarxon.ramazon.Constants.player2
import uz.umarxon.ramazon.databinding.FragmentDuoBinding


class DuoFragment : Fragment() {

    lateinit var binding: FragmentDuoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDuoBinding.inflate(layoutInflater)

        pause_all.observeForever {
            if (it){
                binding.speak1.setImageResource(R.drawable.speak)
                binding.speakt1.text = "Ovozni eshitish"
                binding.speak2.setImageResource(R.drawable.speak)
                binding.speakt2.text = "Ovozni eshitish"
            }
        }

        binding.speakb1.setOnClickListener {
            if (player2.isPlaying){
                player2.stop()

                binding.speak2.setImageResource(R.drawable.speak)
                binding.speakt2.text = "Ovozni eshitish"
            }
            if (!player.isPlaying) {
                binding.speak1.setImageResource(R.drawable.ic_baseline_pause_24)
                binding.speakt1.text = "Ovozni to'xtatish"

                val afd = resources.assets.openFd("saharlik_duosi.mp3")
                player = MediaPlayer()
                player.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                player.prepare()
                player.start()

                player.setOnCompletionListener {
                    binding.speak1.setImageResource(R.drawable.speak)
                    binding.speakt1.text = "Ovozni eshitish"
                }
            } else {
                binding.speak1.setImageResource(R.drawable.speak)
                binding.speakt1.text = "Ovozni eshitish"

                player.stop()
            }
        }

        binding.speakb2.setOnClickListener {
            if (player.isPlaying){
                player.stop()

                binding.speak1.setImageResource(R.drawable.speak)
                binding.speakt1.text = "Ovozni eshitish"
            }
            if (!player2.isPlaying) {
                binding.speak2.setImageResource(R.drawable.ic_baseline_pause_24)
                binding.speakt2.text = "Ovozni to'xtatish"

                val afd = resources.assets.openFd("iftorlik_duosi.mp3")
                player2 = MediaPlayer()
                player2.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
                player2.prepare()
                player2.start()

                player2.setOnCompletionListener {
                    binding.speak2.setImageResource(R.drawable.speak)
                    binding.speakt2.text = "Ovozni eshitish"
                }
            } else {
                binding.speak2.setImageResource(R.drawable.speak)
                binding.speakt2.text = "Ovozni eshitish"

                player2.stop()
            }
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        player.stop()
        player2.stop()
    }
    override fun onDestroy() {
        super.onDestroy()
        player.stop()
        player2.stop()
    }
    override fun onDetach() {
        super.onDetach()
        player.stop()
        player2.stop()
    }
}