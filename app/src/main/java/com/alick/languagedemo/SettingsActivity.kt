package com.alick.languagedemo

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        /**
         * displayName:     中文 (台灣)
         * displayCountry:  台灣
         * displayLanguage: 中文
         * toLanguageTag(): zh-TW
         * language:        zh
         * country:         TW
         */
        val systemLocale = LanguageUtil.getSystemLocale()
        tvLanguage.text = """
            displayName:${systemLocale.displayName}
            displayCountry:${systemLocale.displayCountry}
            displayLanguage:${systemLocale.displayLanguage}
            toLanguageTag():${
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                systemLocale.toLanguageTag()
            } else {
                "LanguageTag()方法不支持Android5.0以下设备"
            }
        }
            language:${systemLocale.language}
            country:${systemLocale.country}
            
        """.trimIndent()

    }

    fun switchZhTW(view: View) {

    }

    fun switchZhCN(view: View) {


    }


}