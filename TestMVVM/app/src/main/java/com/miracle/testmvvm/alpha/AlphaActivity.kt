package com.miracle.testmvvm.alpha

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.TextViewBindingAdapter
import androidx.lifecycle.ViewModelProvider
import com.miracle.testmvvm.R
import com.miracle.testmvvm.databinding.ActivityTestAlphaBinding

class AlphaActivity : AppCompatActivity() {

    val alphaViewModel: AlphaViewModel by lazy {
        ViewModelProvider(this@AlphaActivity)[AlphaViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityTestAlphaBinding>(this, R.layout.activity_test_alpha)
            .apply {
                vm = alphaViewModel
            }
    }
}