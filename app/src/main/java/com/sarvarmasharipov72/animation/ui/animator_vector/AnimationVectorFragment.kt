package com.sarvarmasharipov72.animation.ui.animator_vector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.sarvarmasharipov72.animation.R
import com.sarvarmasharipov72.animation.databinding.FragmentAnimationVectorBinding


class AnimationVectorFragment : Fragment() {

    private var _binding: FragmentAnimationVectorBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initView(inflater.inflate(R.layout.fragment_animation_vector, container, false))



        return binding.root
    }

    private fun initView(view: View) {
        _binding = FragmentAnimationVectorBinding.bind(view)


        val myVectorAnimation =
            AnimatedVectorDrawableCompat.create(requireContext(), R.drawable.vector_animator_root)
        binding.vectorAnimator.setImageDrawable(myVectorAnimation)
        binding.btnVectorAnimationStart.setOnClickListener {
            myVectorAnimation?.start()
        }
        binding.btnVectorAnimationStop.setOnClickListener {
            myVectorAnimation?.stop()
        }
        binding.btnVectorAnimationNext.setOnClickListener {
            findNavController().navigate(R.id.action_animationVectorFragment_to_seekableAnimationFragment)
        }
    }
}