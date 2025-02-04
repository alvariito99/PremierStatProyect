package com.example.premierstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.premierstats.databinding.FragmentCreditTab2Binding


class CreditTab2Fragment : Fragment() {


    private var _binding: FragmentCreditTab2Binding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreditTab2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnIniciar.setOnClickListener {
            //findNavController().navigate(CreditFragmentDirections.actionCreditFragmentToMenuFragment())
            findNavController().navigate(R.id.action_creditFragment_to_menuFragment)

        }

    }
}