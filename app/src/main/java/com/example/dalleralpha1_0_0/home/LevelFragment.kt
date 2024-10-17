package com.example.dalleralpha1_0_0.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import com.example.dalleralpha1_0_0.MenuActivity
import com.example.dalleralpha1_0_0.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LevelFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LevelFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_level, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 點擊按鈕返回到 CurrentFragment
        val button = view.findViewById<Button>(R.id.back)
        button.setOnClickListener {
            // 確保 activity 是 MenuActivity
            val activity = activity as? MenuActivity
            activity?.replaceFragment(HomeFragment()) // 返回 HomeFragment
        }
    }
//    override fun onDestroyView() {
//        super.onDestroyView()
//
//        // 當 Fragment 銷毀時，重新顯示 BottomNavigationView
//        (activity as? MenuActivity)?.showBottomNavigation()
//    }
}