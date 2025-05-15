package com.example.taskinovant

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

import androidx.activity.viewModels

import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecommerce_main)

        val swatchesLayout = findViewById<LinearLayout>(R.id.colorSwatches)
        val paymentText = "<b>0.88 KWD</b> <u>Learn More</u>"
        findViewById<TextView>(R.id.paymentInfo).text = Html.fromHtml(paymentText, Html.FROM_HTML_MODE_LEGACY)
        val productInfoHeader = findViewById<LinearLayout>(R.id.productInfoHeader)
        val arrowIcon = findViewById<ImageView>(R.id.arrowIcon)
        val productInfoContent = findViewById<TextView>(R.id.productInfoContent)
        val btnincrease= findViewById<Button>(R.id.btnincrease)
        val btndecraese=findViewById<Button>(R.id.btndecrease)
        val textQuantity=findViewById<TextView>(R.id.textQuantity)

        var quantity =1
        btnincrease.setOnClickListener {
            quantity++
            textQuantity.text=quantity.toString()
        }
        btndecraese.setOnClickListener{
            if (quantity>1){
                quantity--
                textQuantity.text=quantity.toString()
            }
        }

        val viewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        viewModel.isProductInfoExpanded.observe(this) { expanded ->
            productInfoContent.visibility = if (expanded) View.VISIBLE else View.GONE
            arrowIcon.animate().rotation(if (expanded) 180f else 0f).setDuration(200).start()
        }

        productInfoHeader.setOnClickListener {
            viewModel.toggleProductInfo()
        }



        viewModel.product.observe(this) { product ->
            displaySwatches(swatchesLayout, product.swatches)
        }
    }

    private fun displaySwatches(layout: LinearLayout, swatches: List<Int>) {
        layout.removeAllViews()
        val size = resources.getDimensionPixelSize(R.dimen.swatch_size)
        val margin = resources.getDimensionPixelSize(R.dimen.swatch_margin)

        for (resId in swatches) {
            val imageView = ImageView(this).apply {
                layoutParams = LinearLayout.LayoutParams(size, size).apply {
                    setMargins(margin, margin, margin, margin)
                }
                setImageResource(resId)
                scaleType = ImageView.ScaleType.CENTER_CROP

                background = ContextCompat.getDrawable(context, R.drawable.swatch_border)
                clipToOutline = true
            }
            layout.addView(imageView)
        }
    }
}