import static org.junit.jupiter.api.Assertions.*;

class TestTest {

    @org.junit.jupiter.api.Test
    void shouldReturnFactorial() {
        assertEquals(1L, Test.factorial(0), "0! = 1");
        assertEquals(1L, Test.factorial(1), "1! = 1");
        assertEquals(2L, Test.factorial(2), "2! = 2");
        assertEquals(24L, Test.factorial(4),"4! = 24");
    }
}