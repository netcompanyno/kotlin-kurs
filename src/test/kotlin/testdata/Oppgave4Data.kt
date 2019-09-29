package testdata

import City
import Customer
import Order
import Product
import Shop

val trondheim = City("Trondheim")
val oslo = City("Oslo")
val bergen = City("Bergen")

val brod = Product("Brød", 29.9)
val melk = Product("Melk", 15.9)
val ost = Product("Ost", 34.9)
val smor = Product("Smør", 19.9)
val brus = Product("Brus", 24.9)
val sjokolade = Product("Sjokolade", 12.5)

val order1 = Order(1, listOf(brod, melk, melk), true)
val order2 = Order(2, listOf(brod, ost, smor), true)
val order3 = Order(3, listOf(brus, sjokolade), true)
val order4 = Order(4, listOf(brod, melk, ost, smor, brus), false)
val order5 = Order(5, listOf(brus, brus, brus, brus), true)
val order6 = Order(6, listOf(brod, melk, brus), true)
val order7 = Order(7, listOf(sjokolade, sjokolade), false)
val order8 = Order(8, listOf(brod, melk, ost, smor, brus, sjokolade), true)

val customer1 = Customer("Kunde1", trondheim, listOf(order1, order4, order5))
val customer2 = Customer("Kunde2", oslo, listOf(order2))
val customer3 = Customer("Kunde3", bergen, listOf(order7, order8))
val customer4 = Customer("Kunde4", trondheim, listOf(order2, order2, order2))
val customer5 = Customer("Kunde5", oslo, listOf(order3, order4, order5))
val customer6 = Customer("Kunde6", bergen, listOf(order1, order6, order7))
val customer7 = Customer("Kunde7", trondheim, emptyList())

val shop1 = Shop("Shop1", listOf(customer2, customer1))
val shop2 = Shop("Shop2", listOf(customer3))
val shop3 = Shop("Shop3", listOf(customer6, customer5, customer3, customer2))
val shop4 = Shop("Shop4", listOf(customer6, customer4, customer1))
val shop5 = Shop("Shop5", listOf(customer5, customer1, customer7))
val shops = listOf(
    shop1,
    shop2,
    shop3,
    shop4,
    shop5
)