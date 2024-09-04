package basic;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalculatorTest {
    //private Calculator calculator = new Calculator(); deklarcja pola, i inicjalizacja
    private Calculator calculator;//deklarcja pola, że bedzie używany

    @BeforeClass // Metoda oznaczona @beforeClass jest uruchamaina tylko raz przed startem testu w tej klasie
    //gdybysmy uzyli beforeMetod byłaby urychamiana przed uruchomieniem kazdej metody
    public void setUp() {
        calculator = new Calculator();
    }


    @Test
    public void calculateSumTest(){
        //utworzenie obiektu klasy Calculator z katalogu main/java - musimy tu zrobic, zeby moc skorzystac z metody wewnatrz tej klasy
        //Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.calculateSum(4, 8), 4+8, "Incorrect sum");
        //dodanie komunikatu do raportu
        Reporter.log("My message");

    }

    @Test
    public void calculateMultiplyTest(){
        Assert.assertEquals(calculator.calculateMultiply(2, 6), 12, "incorrect");

    }
}
