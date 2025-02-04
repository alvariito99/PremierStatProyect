package com.example.premierstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.premierstats.databinding.FragmentDetailFavItemBinding
import com.example.recyclerviewejemplo.EquipoProvider


class DetailFavItemFragment : Fragment() {
    private var _binding: FragmentDetailFavItemBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFavItemFragmentArgs by navArgs()

    // Lista de comentarios locales para almacenar los datos
    private val listaComentarios = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailFavItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val equipoId = args.idequipo


        obtenerImagenEquipo(binding.itemImage, equipoId)

        // Manejar el botón de añadir comentario
        binding.btnAddInfo.setOnClickListener {
            val nuevoComentario = binding.inputInfo.text.toString().trim()
            if (nuevoComentario.isNotEmpty()) {
                listaComentarios.add(nuevoComentario)
                actualizarComentarios()
                binding.inputInfo.text.clear()
            }
        }

        // Manejar el botón de cerrar
        binding.btnClose.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }


    private fun obtenerImagenEquipo(imageView: ImageView, idEquipo: Int) {
        val equipo = EquipoProvider.listaEquipos.find { it.id == idEquipo }
        equipo?.imagen?.let { url ->
            Glide.with(requireContext())
                .load(url)
                .placeholder(R.drawable.ic_play) // Imagen de carga
                .error(R.drawable.ic_profile) // Imagen en caso de error
                .into(imageView)
        }
    }

    // Función para actualizar el TextView de comentarios
    private fun actualizarComentarios() {
        binding.itemInfo.text = listaComentarios.joinToString("\n") // Mostrar comentarios en líneas separadas
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}