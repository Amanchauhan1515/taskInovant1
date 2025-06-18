package com.example.taskinovant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {

    private val _isProductInfoExpanded = MutableLiveData(false)
    val isProductInfoExpanded: LiveData<Boolean> = _isProductInfoExpanded

    fun toggleProductInfo() {
        _isProductInfoExpanded.value = _isProductInfoExpanded.value?.not()
    }


    private val _product = MutableLiveData<Product>()
    val product: LiveData<Product> get() = _product

    init {
        loadProduct()
    }

    private fun loadProduct() {
        _product.value = Product(
            name = "ANESTHESIA",
            price = "3.50 KWD",
            sku = "SKU: anesthesia-once-collection-weekly",
            subtitle = "Once Collection Weekly",
            paymentInfo1 = "4 interest-free payments",
            paymentInfo2 = "0.88 KWD",
            description = "Anesthesia Once Collection by Anesthesia\n" +
                    "\n" +
                    "Product Type: Contact Lens\n" +
                    "Color: Blended Grey, Russet, Olivia, Mistic, Honey, Brownish, Coffee, Cloudio, Caramello, Greyish\n" +
                    "\n" +
                    "The newest addition to the Anesthesia contact lens family, Once is an Anesthesia series for daily wear that combines a wealth of color experience with beauty. Easy to handle, stable and comfortable, it provides a subtle transformation in an instant. With its high water content and Hydrogel technology enabling long-lasting comfort, the Anesthesia Once is the perfect choice for fashion-conscious wearers.\n" +
                    "\n" +
                    "Designed to make your eyes look beautiful, Anesthesia Once Collection by Anesthesia is a perfect lens for both daily wear and special occasions. The color applies like a second skin, gently hugging every curve of your eyes. You can also choose between various powers depending on how much you need them to correct your astigmatism. This will allow you to enjoy your time without worrying about any symptoms of dryness or irritation.\n" +
                    "\n" +
                    "This collection is inspired by the understated and sophisticated glamour of a private room in an exclusive hospital. The Anesthesia collection is the ultimate definition of luxury eyewear that embodies individuality, sophistication, and style. Anesthesia Collection by Anesthesia is the first and only certified, FDA approved collection of eyewear for the modern medical professional.\n" +
                    "\n" +
                    "Key Features:\n" +
                    "• Weekly disposable contact lenses\n" +
                    "• Anesthesia lenses are certified as safe and are FDA approved\n" +
                    "• Comes with two pair of lenses\n" +
                    "• Material: HEMA\n" +
                    "• Base Curve: 8.6 mm\n" +
                    "• Diameter: 14.2 mm\n" +
                    "• Hydration: 0.38\n" +
                    "• Central Thickness: 0.05 mm\n" +
                    "\n" +
                    "How To Wear Your Contact Lenses:\n" +
                    "• Wash And Dry Your Hands:\n" +
                    "Before you begin, wash your hands with soap (preferably an unscented, antibacterial liquid soap), then rinse and dry your hands with a lint-free towel.\n" +
                    "\n" +
                    "• Check If The Lens Is Reversed:\n" +
                    "To do this, just put the lens on the tip of your finger and hold it up to the light. If the edges flare out, it’s inside out. If it looks like a smooth-edged cup, it’s ready to go.\n" +
                    "\n" +
                    "• Open Your Eye:\n" +
                    "With your free hand, gently hold your upper eyelid so you don’t blink. With the lens on your fingertip, use the other fingers of your applying hand to pull down your lower eyelid.\n" +
                    "\n" +
                    "• Place The Lens On Your Eye:\n" +
                    "Keep your hand steady and look upwards as you place the lens on your eye, then slowly release your eyelid and close your eye for a moment to allow the lens to settle. Repeat for your other eye.\n" +
                    "\n" +
                    "About Anesthesia:\n" +
                    "Anesthesia is a brand of color contact lenses with over 20 years in the optical market. Their products are created with a passion for beauty, charm and elegance. All their products are produced with the strictest quality control systems, with technologically advanced equipment that works hand in hand with professionals who have vast experience in visual science.\n" +
                    "\n" +
                    "Anesthesia is a product line of contact lenses offering an extensive color range and very high quality at a reasonable cost. Each lens color is available in cosmetic, as well as diopters for myopia and hypermetropia. Anesthesia Contact lenses is also proud to be one of very few brands worldwide offering colors in an astigmatic range. Anesthesia lenses are compliant with ISO and International Medical Standards, carrying CE mark and are FDA approved.\n" +
                    "\n" +
                    "The Anesthesia brand was founded on the principle of offering beauty seekers the highest quality products at an affordable price. Today, Anesthesia manufactures a complete range of contact lenses including daily wear, disposable and bifocal lenses to meet the needs of all wearers. Our state-of-the-art facilities are supervised by acclaimed Doctors of Optometry to ensure that only the best quality standards and craftsmanship are maintained while offering unique products in every category produced by our company.",
            swatches = listOf(
                R.drawable.honey,
                R.drawable.blended_grey,
                R.drawable.brownish,
                R.drawable.caramello,
                R.drawable.cloudio,
                R.drawable.coffee,
                R.drawable.greyish,
                R.drawable.mistic,
                R.drawable.olivia,
                R.drawable.russet
            ),
            imageResId = R.drawable.product_img,
            tabby_logo = R.drawable.tabby_logo
        )
    }
}
