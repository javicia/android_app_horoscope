package com.example.horoscopoapp.ui.palmistry

import android.app.Instrumentation.ActivityResult
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.example.horoscopoapp.Manifest
import com.example.horoscopoapp.databinding.FragmentPalmistryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PalmistryFragment : Fragment() {

    private var _binding: FragmentPalmistryBinding? = null
    private val binding get() = _binding!!
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission())
    { isGranted ->
        if(isGranted){

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(checkCameraPermission()){

        }else{

        }
    }

    fun checkCameraPermission():Boolean{
        return PermissionChecker.checkSelfPermission(requireContext(),
            android.Manifest.permission.CAMERA) == PermissionChecker.PERMISSION_GRANTED
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPalmistryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}
