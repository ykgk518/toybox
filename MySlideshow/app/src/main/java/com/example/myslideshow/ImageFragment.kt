package com.example.myslideshow

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowId
import kotlinx.android.synthetic.main.fragment_image.*

const val IMG_RES_ID = "IMG_RES_ID"

class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    companion object {
        fun newInstance(imageResourceId: Int) : ImageFragment {
            val bundle = Bundle()
            bundle.putInt(IMG_RES_ID, imageResourceId)
            val imageFragment = ImageFragment()
            // 指定したデータをアーギュメンツに保存
            imageFragment.arguments = bundle
            return imageFragment
        }
    }

    private var imgResId: Int? = null

    // フラグメントが作成/再作成されたときに呼び出される
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // アーギュメンツからデータを取得する
        arguments?.let {
            imgResId = it.getInt(IMG_RES_ID)
        }
    }
    // フラグメントが作成されたら、リソースIDの画像を表示
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imgResId?.let {
            imageView.setImageResource(it)
        }
    }
}
