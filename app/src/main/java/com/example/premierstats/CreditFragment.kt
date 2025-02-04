package com.example.premierstats

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.premierstats.R
import com.example.premierstats.databinding.FragmentCreditBinding
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayoutMediator

class CreditFragment : Fragment() {

    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Configurar el ViewPager con el adaptador
        binding.vpNotice.adapter = CreditAdapter(this)

        // Configurar TabLayout con ViewPager2
        TabLayoutMediator(binding.TabNotice, binding.vpNotice) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Inicio"
                    tab.setIcon(R.drawable.ic_house)

                    val badge: BadgeDrawable = tab.orCreateBadge
                    badge.backgroundColor = ContextCompat.getColor(requireContext(), R.color.red)
                    badge.number = 1
                    badge.maxCharacterCount = 2
                    badge.badgeGravity = BadgeDrawable.TOP_START
                }
                1 -> {
                    tab.text = "Menú"
                    tab.setIcon(R.drawable.ic_menu)
                }
            }
        }.attach()
    }}



class CreditAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) CreditTab1Fragment() else CreditTab2Fragment()
    }
}
