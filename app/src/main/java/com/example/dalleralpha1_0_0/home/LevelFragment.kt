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
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.dalleralpha1_0_0.MenuActivity
import com.example.dalleralpha1_0_0.R
import com.example.dalleralpha1_0_0.api.Question


class LevelFragment : Fragment() {

    private var questions: ArrayList<Question>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        questions = arguments?.getParcelableArrayList("questions")
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

        questions?.let { questionsList -> //positionp[0]是第一題
            view.findViewById<TextView>(R.id.title).text = questionsList[0].id
            view.findViewById<TextView>(R.id.content).text = questionsList[0].questionText
            view.findViewById<Button>(R.id.A1).text = questionsList[0].options1
            view.findViewById<Button>(R.id.A2).text = questionsList[0].options2
            view.findViewById<Button>(R.id.A3).text = questionsList[0].options3
            view.findViewById<Button>(R.id.A4).text = questionsList[0].options4
            var answer = questionsList[0].correctAnswer

            if (answer == questionsList[0].options1)
            view.findViewById<Button>(R.id.A1).setOnClickListener {
                //正確答案跳good
                val goodDialog = GoodFragment.newInstance()
                goodDialog.show(childFragmentManager, "GoodDialog")
                view.findViewById<Button>(R.id.A1)
                    .setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.green))
            }
            view.findViewById<Button>(R.id.A2).setOnClickListener {
                //錯誤答案跳bad
                val badDialog = BadFragment.newInstance()
                badDialog.show(childFragmentManager, "BadDialog")
                view.findViewById<Button>(R.id.A2).setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.red))

            }
            // 點擊按鈕返回到 HomeFragment
            val back = view.findViewById<ImageButton>(R.id.back)
            back.setOnClickListener {
                val menuActivity = activity as? MenuActivity
                menuActivity?.replaceFragment(HomeFragment())
                menuActivity?.showBottomNavigation()
            }
        }
    }
}



