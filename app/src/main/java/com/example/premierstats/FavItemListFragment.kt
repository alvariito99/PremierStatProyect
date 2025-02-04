package com.example.premierstats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.premierstats.adapter.EquipoAdapter
import com.example.premierstats.databinding.FragmentFavItemListBinding

class FavItemListFragment : Fragment() {

    private var _binding: FragmentFavItemListBinding? = null
    private val binding get() = _binding!!

    private val listaFavoritos = FavoriteManager.listaFavoritos
    private lateinit var adapter: EquipoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView en el fragmento de favoritos
        adapter = EquipoAdapter(FavoriteManager.listaFavoritos, {}, {}, {})
        binding.recyclerpremier2.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerpremier2.adapter = adapter

// Ocultar el RecyclerView si no hay favoritos
        binding.recyclerpremier2.visibility = if (listaFavoritos.isEmpty()) View.GONE else View.VISIBLE


    }
    fun eliminarDeFavoritos(equipo: Equipo) {
        FavoriteManager.eliminarFavorito(equipo)
        adapter.notifyDataSetChanged() // Notificar al adaptador que ha habido un cambio
    }

    fun agregarAFavoritos(equipo: Equipo) {
        FavoriteManager.agregarFavorito(equipo)

        val navHostFragment = requireActivity().supportFragmentManager.findFragmentById(R.id.navHostFragment)
        val favFragment = navHostFragment?.childFragmentManager?.fragments?.find { it is FavItemListFragment } as? FavItemListFragment

        favFragment?.agregarAFavoritos(equipo)
    }



    fun actualizarListaFavoritos() {
        adapter.notifyDataSetChanged()
    }

}
