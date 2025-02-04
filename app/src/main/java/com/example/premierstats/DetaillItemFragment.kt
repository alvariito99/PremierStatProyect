package com.example.premierstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.premierstats.adapter.EquipoAdapter
import com.example.premierstats.databinding.FragmentDetaillItemBinding
import com.example.recyclerviewejemplo.EquipoProvider


class DetaillItemFragment : Fragment() {

    private var _binding: FragmentDetaillItemBinding? = null
    private val binding get() = _binding!!

    private val args: DetaillItemFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetaillItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val equipoId = args.idEquipo


        val equipoSeleccionado = EquipoProvider.listaEquipos.find { it.id == equipoId }

        if (equipoSeleccionado != null) {

            binding.teamName.text = equipoSeleccionado.nombre
            binding.teamLeague.text = "Liga: ${equipoSeleccionado.liga}"
            binding.teamStadium.text = "Estadio: ${equipoSeleccionado.estadio}"

            equipoSeleccionado.imagen?.let {
                Glide.with(this).load(it).into(binding.teamLogo)
            }
        } else {
            // Manejo de error si el equipo no se encuentra
            Toast.makeText(requireContext(), "Equipo no encontrado", Toast.LENGTH_SHORT).show()
        }

        binding.btnClose.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }



}


