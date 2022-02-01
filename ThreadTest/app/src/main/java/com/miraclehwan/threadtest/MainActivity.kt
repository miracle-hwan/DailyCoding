package com.miraclehwan.threadtest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.miraclehwan.threadtest.databinding.ActivityMainBinding
import org.jsoup.Jsoup

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    val string =
        "ㆍAll prices are VAT(10%) included.\nㆍYou may withdraw your subscription within 7 days from the day of purchase.\nㆍUsed [event voucher] value will be deducted from the total refund value when you withdraw your subscription.\nㆍThe given [event voucher] is valid for up to 3 days from the day of purchase.\nㆍThe [event voucher] will automatically become invalid when the period of use is over."

    val stringlist = string.split("\n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        val easySS = EasySS(string.replace(string[0].toString(), ""))
//        stringlist.forEach {
//            easySS.setSpanTargetText(it.substring(1))
//            easySS.setBulletText()
//        }
//
//        easySS.into(binding.tvTitle)


        Thread {
            val url = "https://diablo2.inven.co.kr/dataninfo/item/?ic2=1101"
            val doc = Jsoup.connect(url).get()

            val articles = doc.select("tr")
            Log.e("daehwan", "daehwan")
//            doc.body().allElements.forEach{
//                if (it.id() == "diablo2Body"){
//                    it.childNodes().forEach {
//                        it.nodeName()
//                    }
//                }
//            }

        }.start()

    }
}