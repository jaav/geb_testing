package be.collishop
class CartPage extends CollishopPage {
    static at = { products.size() > 0 }
    static content = {
        products { $(".basketTable>table>tbody>tr") }
    }
}
