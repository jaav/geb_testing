package be.collishop
class ProductDetailsPage extends CollishopPage {
    static at = {
        // check if EUR symbol is displayed
        $(".natural").text().contains "\u20AC"
        addToCartButton
    }

    static content = {
        addToCartButton(to: CartPage, wait: true) { $(".lnkBuy.buttonPrimary>a") }
    }
}
