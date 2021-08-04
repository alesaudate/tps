package br.com.tps.domain

import java.math.BigDecimal

data class Product(val name: String,
                   val price:BigDecimal = BigDecimal.ZERO,
                   val spotPrice:BigDecimal = BigDecimal.ZERO) {
    override fun toString() = prepareToString()

    fun prepareToString(): String {
        return "Produto: $name (Preço à vista: $spotPrice . Preço a prazo: $price)"
    }
}

class ShoppingCart(val products: List<Product>) {

    fun sumOfSpotPrices() = products.sumOf { it.spotPrice }

}

fun main() {
    var sneakers = Product(name="Tênis Y", spotPrice=BigDecimal("600.53"))
    var sneakersX = sneakers.copy(name = "Tênis X")
    val productsList = listOf(sneakers, sneakersX)
    val cart = ShoppingCart(productsList)

    println(cart.sumOfSpotPrices())

}