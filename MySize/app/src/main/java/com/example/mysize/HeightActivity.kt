package com.example.mysize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Spinner
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_height.*

class HeightActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_height)

        // スピナーで選択肢がタップされたときに実行する処理
        spinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                // 項目が選択されずにビューが閉じられた時の処理
                override fun onNothingSelected(parent: AdapterView<*>?) { }

                // 項目が選択された時の処理
                override fun onItemSelected(
                    parent: AdapterView<*>?, // 選択が発生した親ビュー(スピナー)
                    view: View?, //選択された項目そのもの
                    position: Int,
                    id: Long
                ) {
                    val spinner = parent as? Spinner
                    val item = spinner?.selectedItem as? String
                    item?.let {
                        if (it.isNotEmpty()) height.text = it
                    }
                }

            }

        // ラジオボタンが選択された時の処理
        radioGroup.setOnCheckedChangeListener {
                group, checkedId ->
                height.text = findViewById<RadioButton>(checkedId).text
        }

        // シークバーの値が変更されたら、TextViewにシークバーの値を表示するようにする
        // TextViewに現在表示されている値を共有プリファレンスに保存する処理も付け加える
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val heightVal = pref.getInt("HEIGHT", 160)
        height.text = heightVal.toString()
        seekBar.progress = heightVal

        //シークバーを操作したときにイベントが発生
        seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener{

                // シークバーの値を変更したときの処理
                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    height.text = progress.toString()
                }

                // シークバーに触れた時の処理
                override fun onStartTrackingTouch(seekBar: SeekBar?) { }

                // シークバーを離した時の処理
                override fun onStopTrackingTouch(seekBar: SeekBar?) { }

            }
        )
    }

    // アクティビティが非表示になるときに呼ばれる
    override fun onPause() {
        super.onPause()
        val  pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            putInt("HEIGHT", height.text.toString().toInt())
        }
    }
}
