package com.example.myapplicatiosaintropez

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //JavaScriptを有効にする
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/html/index.html")

        // コンテキストメニューを追加するビューを指定する
        registerForContextMenu(webView)
    }

    /**
     * コンテキストメニューが表示されるときに呼び出されるメソッド
     * @param menu メニュー項目を設定するコンテキストメニュー
     * @param v　長押しされたビュー
     * @param menuInfo コンテキストメニューの作成に関する追加情報
     */
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        //メニューXMLをコンテキストメニューに設定
        menuInflater.inflate(R.menu.context, menu)
    }

    /**
     * コンテキストメニューが選択されたときに呼び出されるメソッド
     * @param item 選択されたメニュー
     * @return メニュー処理を続行するにはfalse、終了する場合にはtrue
     */
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.sms -> {
                val number = "999-9999-9999"
                val uri = Uri.parse("sms:$number")
                var intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                startActivity(intent)
                return true
            }
            R.id.mail -> {
                val email = "nobody@example.com"
                val subject = "予約問い合わせ"
                val text = "以下のとおり予約希望します"
                val uri = Uri.parse("mailto:")
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = uri
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                      .putExtra(Intent.EXTRA_SUBJECT, subject)
                      .putExtra(Intent.EXTRA_TEXT, text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
            R.id.share -> {
                val text = "美味しいレストランを紹介します。"
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, text)
                val chooser = Intent.createChooser(intent, null)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(chooser)
                }
                return true
            }
            R.id.browse -> {
                val uri: String = "http://www.yahoo.co.jp"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(uri)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    /**
     * オプションメニューを初期化するメソッド
     * @param menu メニューアイテムを配置するオプションメニュー
     * @return メニューを表示する場合はtrue
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true //メニューを表示する場合はtrueを返す
    }

    /**
     * オプションメニューが選択されたときに呼び出されるメソッド
     * @param item 選択されたメニュー
     * @return メニュー処理を続行するにはtrue、続行しない場合はfalseを返します
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.top -> {
                webView.loadUrl("file:///android_asset/html/index.html")
                return true
            }

            R.id.lunch01 -> {
                webView.loadUrl("file:///android_asset/html/lunch01.html")
                return true
            }

            R.id.lunch02 -> {
                webView.loadUrl("file:///android_asset/html/lunch02.html")
                return true
            }

            R.id.dinner01 -> {
                webView.loadUrl("file:///android_asset/html/dinner01.html")
                return true
            }

            R.id.dinner02 -> {
                webView.loadUrl("file:///android_asset/html/dinner02.html")
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
