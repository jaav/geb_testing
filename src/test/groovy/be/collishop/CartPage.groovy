package be.collishop
class CartPage extends CollishopPage {
    static at = { products.size() > 0 }
    static content = {
        products(wait: true) { $(".basketTable>table>tbody>tr") }
    }
}
