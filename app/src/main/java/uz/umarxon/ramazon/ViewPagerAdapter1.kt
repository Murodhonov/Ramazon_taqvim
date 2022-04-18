package uz.umarxon.ramazon

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter1(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {

        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){

            0->{
                DuoFragment()
            }
            1->{
                MainFragment()
            }
            2->{
                AboutFragment()
            }

            else->{
                Fragment()
            }

        }
    }
}
