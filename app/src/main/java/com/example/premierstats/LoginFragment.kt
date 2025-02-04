package com.example.premierstats

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.premierstats.R
import com.example.premierstats.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Al hacer clic en el botón, validamos el nombre y pasamos a la siguiente actividad
        binding.navigateToCreditsButton.setOnClickListener {
            val nombre = binding.usernameInput.text.toString()
            if (nombre.isBlank()) {
                Toast.makeText(requireContext(), "Debe introducir un nombre", Toast.LENGTH_SHORT)
                    .show()
            } else {
               /** = requireActivity().supportFragmentManager.beginTransaction()
                transaction.replace(
                    R.id.fragmentContainerView,
                    fragment
                ) // Asegúrate de usar el ID correcto del contenedor del fragmento
                transaction.addToBackStack(null)  // Esto permite volver al fragmento anterior si es necesario
                transaction.commit()*/

                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToCreditFragment (user = "Alvaro"))


            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}