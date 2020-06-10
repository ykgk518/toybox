package com.example.animalbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // 「ライオン」ボタンが押下されたときの処理
        lionButton.setOnClickListener {
            val lionFragment = LionFragment()
            val fragmentManager = this.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, lionFragment)
                .addToBackStack(null).commit()
        }

        // 「カバ」ボタンが押下されたときの処理
        hippoButton.setOnClickListener {
            val hippoFragment = HippoFragment()
            val fragmentManager = this.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, hippoFragment)
                .addToBackStack(null).commit()
        }

        //「キリン：ボタンを押下されたときの処理
        giraffeButton.setOnClickListener {
            val giraffeFragment = GiraffeFragment()
            val fragmentManager = this.supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, giraffeFragment)
                .addToBackStack(null).commit()
        }

        val fragment = titleFragment as? TitleFragment
        fragment?.setTitle("図鑑画面")
    }
}
