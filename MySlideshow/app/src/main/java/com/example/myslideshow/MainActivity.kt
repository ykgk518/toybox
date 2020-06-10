package com.example.myslideshow

import android.media.AsyncPlayer
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    // onCreateメソッド内で初期化したいのでlateinitで宣言
    private lateinit var player: MediaPlayer
    class MyAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        // フラグメントに表示する画像を保持するためのリスト
        private val resource = listOf(
            R.drawable.slide00, R.drawable.slide01,
            R.drawable.slide02, R.drawable.slide03,
            R.drawable.slide04, R.drawable.slide05,
            R.drawable.slide06, R.drawable.slide07,
            R.drawable.slide08, R.drawable.slide09
        )

        // ページ総数を返す
        override fun getCount(): Int {
            return resource.size
        }

        // ページに対応するフラグメントを返す
        override fun getItem(position: Int): Fragment {
            return ImageFragment.newInstance(resource[position])
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ViewPagerとViewAdapterを関連付ける
        pager.adapter = MyAdapter(supportFragmentManager)

        // タイマーの実装
        val handler = Handler()
        timer(period = 5000) {
            handler.post{
                pager.currentItem = (pager.currentItem + 1) % 10
            }
        }

        player = MediaPlayer.create(this, R.raw.getdown)
        player.isLooping = true //繰り返し再生

    }

    // アクティビティが画面表示される時に呼び出される
    override fun onResume() {
        super.onResume()
        player.start()
    }

    // アプリが中断されたときに呼び出される
    override fun onPause() {
        super.onPause()
        player.pause()
    }
}
