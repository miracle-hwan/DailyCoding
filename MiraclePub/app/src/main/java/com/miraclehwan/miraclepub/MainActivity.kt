package com.miraclehwan.miraclepub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.miraclehwan.miraclepub.di.component.DaggerPubComponent
import com.miraclehwan.miraclepub.model.Server
import com.miraclehwan.miraclepub.model.ale.PaleAle
import com.miraclehwan.miraclepub.model.ale.Porter
import com.miraclehwan.miraclepub.model.ale.Stout
import com.miraclehwan.miraclepub.model.larger.Pilsner
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mServerProvider: Provider<Server>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pubCompoent = DaggerPubComponent.create()
        pubCompoent.inject(this)

        val server1 = mServerProvider.get()
        val server2 = mServerProvider.get()

        Log.e("test", server1.mName)
        Log.e("test", server2.mName)

        val pilsner = server1.makeBeer(Pilsner::class.java)
        Log.e("test", pilsner.toString())
        val pilsner2 = server1.makeBeer(Pilsner::class.java)
        Log.e("test", pilsner2.toString())
    }
}
