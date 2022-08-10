package com.sarvarmasharipov72.animation.ui.seekable_animation_vector

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.vectordrawable.graphics.drawable.SeekableAnimatedVectorDrawable
import com.sarvarmasharipov72.animation.R
import com.sarvarmasharipov72.animation.databinding.FragmentSeekableAnimationBinding


class SeekableAnimationFragment : Fragment() {

    private var _binding: FragmentSeekableAnimationBinding? = null
    private val registerAnimationCallback = object : SeekableAnimatedVectorDrawable.AnimationCallback() {
        override fun onAnimationStart(drawable: SeekableAnimatedVectorDrawable) {
            super.onAnimationStart(drawable)
        }

        override fun onAnimationEnd(drawable: SeekableAnimatedVectorDrawable) {
            super.onAnimationEnd(drawable)
        }

        override fun onAnimationPause(drawable: SeekableAnimatedVectorDrawable) {
            super.onAnimationPause(drawable)
        }

        override fun onAnimationResume(drawable: SeekableAnimatedVectorDrawable) {
            super.onAnimationResume(drawable)
        }

        override fun onAnimationUpdate(drawable: SeekableAnimatedVectorDrawable) {
            super.onAnimationUpdate(drawable)
        }
    }

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initView(inflater.inflate(R.layout.fragment_seekable_animation, container, false))


        return binding.root
    }

    private fun initView(view: View) {
        _binding = FragmentSeekableAnimationBinding.bind(view)
        val icon = SeekableAnimatedVectorDrawable.create(requireContext(), R.drawable.seekable_anim)
        binding.seekableVectorAnimator.setImageDrawable(icon)

        binding.btnSeekableVectorAnimationStart.setOnClickListener {
            startAnimation(icon!!)
        }
        binding.btnSeekableVectorAnimationStop.setOnClickListener {
            stopAnimation(icon!!)
        }
        binding.btnSeekableVectorAnimationNext.setOnClickListener {
            stopAnimation(icon!!)
        }
        binding.btnSeekableVectorAnimationPrev.setOnClickListener {
            stopAnimation(icon!!)
            findNavController().navigate(R.id.action_seekableAnimationFragment_to_animationVectorFragment)
        }

        icon?.registerAnimationCallback(registerAnimationCallback)
    }

    private fun startAnimation(icon: SeekableAnimatedVectorDrawable) {
        icon.start()

    }

    private fun stopAnimation(icon: SeekableAnimatedVectorDrawable) {
        icon.stop()
    }


}