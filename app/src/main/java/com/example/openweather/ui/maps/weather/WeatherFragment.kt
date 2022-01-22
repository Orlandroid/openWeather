package com.example.openweather.ui.maps.weather

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.openweather.data.Result
import com.example.openweather.data.api.API_KEY
import com.example.openweather.databinding.FragmentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Error

@AndroidEntryPoint
class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeatherBinding.inflate(layoutInflater, container, false)
        setUpUi()
        setUpObservers()
        return binding.root
    }


    private fun setUpUi() {
        viewModel.getWeatherResponse("17.978733", "-101.016948", API_KEY)
        with(binding){
            containerCard.setOnClickListener {
                viewModel.getWeatherResponse("17.978733", "-101.016948", API_KEY)
            }
        }
    }

    private fun setUpObservers() {
        viewModel.weatherResponse.observe(viewLifecycleOwner, {
            when (it) {
                is Result.Loading -> {
                    binding.skeleton.showSkeleton()
                }
                is Result.Success -> {
                    with(binding) {
                        binding.skeleton.showOriginal()
                        val urlImage = "http://openweathermap.org/img/wn/${it.data.weather[0].icon}@2x.png"
                        Glide.with(this@WeatherFragment).load(urlImage).into(binding.imageView)
                        weatherMain.text = it.data.weather[0].main
                        txtDescription.text = it.data.weather[0].description
                        txtMainTemp.text = it.data.main.temp.toString()
                        txtMinTemp.text = it.data.main.temp_min.toString()
                        txtMaxTemp.text = it.data.main.temp_max.toString()
                        txtWindSpeed.text = it.data.wind.speed.toString()
                        txtDeg.text = it.data.wind.deg.toString()
                        txtGust.text = it.data.wind.gust.toString()
                        txtCountry.text=it.data.sys.country
                    }
                }
                is Result.Error -> {
                    binding.skeleton.showOriginal()
                }
                is Result.ErrorNetwork -> {
                    binding.skeleton.showOriginal()
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}