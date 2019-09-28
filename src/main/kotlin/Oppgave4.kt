/**
 * Oppgave 4
 *
 * Nedenfor er det definert en struktur med butikker, varer, kunder, ordre og produkter.
 * Implementer funksjonene under ved å bruke metoder definert på List, Set og Map.
 * Testene i Oppgave4Test vil kjøre grønt når funksjonene er implementert riktig.
 *
 * Du finner APIene her:
 * List: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list
 * Set: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-set
 * Map: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-map
 */

// Finn kunder fra den gitte byen.
fun Shop.getCustomersFrom(city: City): List<Customer> = TODO()

// Finn ordreId på kundens leverte ordre.
fun Customer.getDeliveredOrderIds(): List<Int> = TODO()

// Sjekk om alle produktene i ordren koster mer enn den gitte prisen.
fun Order.isAllProductsMoreExpensiveThan(amount: Double): Boolean = TODO()

// Gi et map fra by til et set av kundene som er derfra.
fun Shop.groupCustomersByCity(): Map<City, Set<Customer>> = TODO()

// Finn kundens dyreste ordre.
fun Customer.getMostExpensiveOrder(): Order? = TODO()

// Finn butikken som har solgt varer for mest penger.
fun List<Shop>.findMostValuableShop(): Shop? = TODO()


// -------------- Ikke endre dette --------------

data class Shop(val name: String, val customers: List<Customer>)
data class Customer(val name: String, val city: City, val orders: List<Order>)
data class Order(val orderId: Int, val products: List<Product>, val isDelivered: Boolean)
data class Product(val name: String, val price: Double)
data class City(val name: String)