import org.junit.jupiter.api.Test
import testdata.*
import kotlin.math.exp
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class Oppgave4Test {

    @Test
    fun `getCustomersFrom skal returnere kunder fra gitt by`() {
        val customers = shop4.getCustomersFrom(trondheim)
        assertTrue(customers.all { it.city == trondheim })
    }

    @Test
    fun `getCustomersFrom skal sortere kundene på navn`() {
        val customers = shop3.getCustomersFrom(oslo)
        assertEquals(listOf(customer2, customer5), customers)
    }

    @Test
    fun `getDeliveredOrderIds skal hente kundens leverte ordreIder`() {
        val orderIds = customer1.getDeliveredOrderIds()

        val expected = listOf(1, 5)
        assertTrue(orderIds.containsAll(expected) && expected.containsAll(orderIds),
            "Expected: $expected. Actual result: $orderIds")
    }

    @Test
    fun `isAllProductsMoreExpensiveThan skal gi true dersom alle produktene i ordren er dyrere enn amount`() {
        val result = order1.isAllProductsMoreExpensiveThan(14.0)
        assertTrue(result)
    }

    @Test
    fun `isAllProductsMoreExpensiveThan skal gi false dersom det finnes et produkt i ordren som er billigere enn amount`() {
        val result = order1.isAllProductsMoreExpensiveThan(22.0)
        assertFalse(result)
    }

    @Test
    fun `groupCustomersByCity skal gruppere kundene på by`() {
        val expected = mapOf(
            bergen to setOf(customer6, customer3),
            oslo to setOf(customer5, customer2)
        )

        val result = shop3.groupCustomersByCity()

        assertEquals(expected, result)
    }

    @Test
    fun `getMostExpensiveOrder skal returnere kundens dyreste ordre`() {
        val mostExpensive = customer5.getMostExpensiveOrder()
        assertEquals(order4, mostExpensive)
    }

    @Test
    fun `getMostExpensiveOrder skal returnere null dersom kunden ikke har noen ordre`() {
        val mostExpensive = customer7.getMostExpensiveOrder()
        assertNull(mostExpensive)
    }

    @Test
    fun `findMostValuableShop skal returnere butikken som har solgt varer for mest penger`() {
        val mostValuable = shops.findMostValuableShop()
        assertEquals(shop4, mostValuable)
    }

    @Test
    fun `findMostValuableShop skal returnere null dersom input er en tom liste`() {
        val mostValuable = emptyList<Shop>().findMostValuableShop()
        assertNull(mostValuable)
    }

}