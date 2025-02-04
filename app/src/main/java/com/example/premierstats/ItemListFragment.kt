package com.example.premierstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.net.toUri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.premierstats.adapter.EquipoAdapter
import com.example.premierstats.databinding.FragmentItemListBinding
import com.example.recyclerviewejemplo.EquipoProvider


class ItemListFragment : Fragment() {

    private var _binding: FragmentItemListBinding? = null
    private val binding get() = _binding!!

private val _comentarios = MutableLiveData<MutableMap<Int, MutableList<String>>>(mutableMapOf())
    val comentarios: LiveData<MutableMap<Int, MutableList<String>>> get() = _comentarios

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(requireContext())
        binding.recyclerpremier.layoutManager = manager
        binding.recyclerpremier.adapter = EquipoAdapter(
            EquipoProvider.listaEquipos,
            { equipo -> onItemSelected(equipo) },
            { equipo -> agregarAFavoritos(equipo) },
            { equipo -> onComentarioClickListener(equipo) }

        )
    }





    private fun onItemSelected(equipo: Equipo) {
        val action = ItemListFragmentDirections.actionItemListFragmentToDetaillItemFragment(
            idEquipo = equipo.id
        )
        findNavController().navigate(action)
    }

    private fun agregarAFavoritos(equipo: Equipo) {
        // Agregar a la lista de favoritos
        FavoriteManager.agregarFavorito(equipo)


        val favFragment = parentFragmentManager.findFragmentByTag("FavItemListFragment") as? FavItemListFragment
        favFragment?.agregarAFavoritos(equipo)
    }

    private fun onComentarioClickListener(equipo: Equipo) {
        // Agregar a la lista de favoritos
        //FavoriteManager.comentario(equipo)
        //Toast.makeText(context,"hola",Toast.LENGTH_SHORT).show()
        val action = ItemListFragmentDirections.actionItemListFragmentToDetailFavItemFragment(
            nombreEquipo = equipo.nombre,
            idequipo = equipo.id
        )
        findNavController().navigate(action)
        /**val request = NavDeepLinkRequest.Builder
            .fromUri("android-app://com.example.premierstats.detailFavItemFragment".toUri())
            .build()
        findNavController().navigate(request)*/

        //val favFragment = parentFragmentManager.findFragmentByTag("FavItemListFragment") as? FavItemListFragment
        //favFragment?.agregarAFavoritos(equipo)
    }


}