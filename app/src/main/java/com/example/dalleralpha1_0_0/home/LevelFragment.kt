package com.example.dalleralpha1_0_0.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import com.example.dalleralpha1_0_0.MenuActivity
import com.example.dalleralpha1_0_0.R


class LevelFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_level, container, false)
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 點擊按鈕返回到 HomeFragment
        val back = view.findViewById<ImageButton>(R.id.back)
        back.setOnClickListener{
            val menuActivity = activity as? MenuActivity
            menuActivity?.replaceFragment(HomeFragment())
            menuActivity?.showBottomNavigation()
        }
        val Answer1 = view.findViewById<Button>(R.id.A1)
        Answer1.setOnClickListener {
            //正確答案跳good
            val goodDialog = GoodFragment.newInstance()
            goodDialog.show(childFragmentManager, "GoodDialog")
            Answer1.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))
        }
        val Answer2 = view.findViewById<Button>(R.id.A2)
        Answer2.setOnClickListener {
            //錯誤答案跳bad
            val badDialog = BadFragment.newInstance()
            badDialog.show(childFragmentManager, "BadDialog")
            Answer2.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))
        }
    }
}



