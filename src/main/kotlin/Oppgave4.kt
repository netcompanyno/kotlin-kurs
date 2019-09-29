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

// Løsningsforslag oppgave 4

// Finn kunder fra den gitte byen, sortert på kundens navn.
fun Shop.getCustomersFrom(city: City): List<Customer> =
    customers.filter { it.city == city }
        .sortedBy { it.name }

// Finn ordreId på kundens leverte ordre.
fun Customer.getDeliveredOrderIds(): List<Int> =
    orders.filter { it.isDelivered }
        .map { it.orderId }

// Sjekk om alle produktene i ordren koster mer enn den gitte prisen.
fun Order.isAllProductsMoreExpensiveThan(amount: Double): Boolean =
    products.all { it.price > amount }

// Gi et map fra by til et set av kundene som er derfra.
fun Shop.groupCustomersByCity(): Map<City, Set<Customer>> =
    customers.groupBy { it.city }
        .mapValues { entry -> entry.value.toSet() }

// Finn kundens dyreste ordre.
fun Customer.getMostExpensiveOrder(): Order? =
    orders.maxBy { it.products.sumByDouble { it.price } }

// Finn butikken som har solgt varer for mest penger.
fun List<Shop>.findMostValuableShop(): Shop? =
    maxBy { shop ->
        shop.customers
            .flatMap { it.orders }
            .flatMap { it.products }
            .sumByDouble { it.price }
    }


// -------------- Ikke endre dette --------------

data class Shop(val name: String, val customers: List<Customer>)
data class Customer(val name: String, val city: City, val orders: List<Order>)
data class Order(val orderId: Int, val products: List<Product>, val isDelivered: Boolean)
data class Product(val name: String, val price: Double)
data class City(val name: String)