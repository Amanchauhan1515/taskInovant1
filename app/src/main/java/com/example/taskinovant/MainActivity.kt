package com.example.taskinovant

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.*
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {

    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ecommerce_main)

        // UI references
        val swatchesLayout = findViewById<LinearLayout>(R.id.colorSwatches)
        val productName = findViewById<TextView>(R.id.productNameTextView)
        val productPrice = findViewById<TextView>(R.id.productPrice)
        val productSKU = findViewById<TextView>(R.id.skuTextView)
        val productInfoContent = findViewById<TextView>(R.id.productInfoContent)
        val paymentInfo2 = findViewById<TextView>(R.id.paymentInfo2)
        val paymentInfo1=findViewById<TextView>(R.id.paymentInfo1)
        val subtitle=findViewById<TextView>(R.id.subtitle)
        val mainImage = findViewById<ImageView>(R.id.EyesImage)
        val tabby_logo =findViewById<ImageView>(R.id.tabby_logo)

        val arrowIcon = findViewById<ImageView>(R.id.arrowIcon)
        val productInfoHeader = findViewById<LinearLayout>(R.id.productInfoHeader)

        val btnIncrease = findViewById<Button>(R.id.btnincrease)
        val btnDecrease = findViewById<Button>(R.id.btndecrease)
        val textQuantity = findViewById<TextView>(R.id.textQuantity)

        var quantity = 1
        btnIncrease.setOnClickListener {
            quantity++
            textQuantity.text = quantity.toString()
        }
        btnDecrease.setOnClickListener {
            if (quantity > 1) {
                quantity--
                textQuantity.text = quantity.toString()
            }
        }

        // Product Info expand/collapse
        viewModel.isProductInfoExpanded.observe(this) { expanded ->
            productInfoContent.visibility = if (expanded) View.VISIBLE else View.GONE
            arrowIcon.animate().rotation(if (expanded) 180f else 0f).setDuration(200).start()
        }

        productInfoHeader.setOnClickListener {
            viewModel.toggleProductInfo()
        }

        // Observe product and update UI
        viewModel.product.observe(this) { product ->
            productName.text = product.name
            productPrice.text = product.price
            subtitle.text=product.subtitle
            productSKU.text = product.sku
            productInfoContent.text = product.description
            paymentInfo1.text = Html.fromHtml("<b>${product.paymentInfo1}</b>", Html.FROM_HTML_MODE_LEGACY)
            paymentInfo2.text = Html.fromHtml("<b>${product.paymentInfo2}</b> <u>Learn More</u>", Html.FROM_HTML_MODE_LEGACY)
            mainImage.setImageResource(product.imageResId)
            tabby_logo.setImageResource(product.tabby_logo)
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
