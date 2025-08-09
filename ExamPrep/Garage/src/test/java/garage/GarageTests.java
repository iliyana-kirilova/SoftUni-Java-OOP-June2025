package garage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GarageTests {
    private Car car1;
    private Car car2;
    private Car car3;
    private Garage garage;

    @BeforeEach
    public void setUp(){
        garage = new Garage("AutoGar", 2);
        car1 = new Car("BMW", 150, "black");
        car2 = new Car("Skoda", 85, "metallic");
        car3 = new Car("Seat", 110, "red");
    }

    @Test
    public void testAddCar_Successfully(){
        garage.addCar(car1);
        Assertions.assertEquals(1, garage.getCount());
    }

    @Test
    public void testAddCarWhenThereIsNoSpace_ExpectedException(){
        garage.addCar(car1);
        garage.addCar(car2);

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> garage.addCar(car3)
        );

        Assertions.assertEquals("No more space in the garage!", exception.getMessage());
    }

    @Test
    public void testCarWhenCarAlreadyExists_ExpectedException(){
        garage.addCar(car1);
        IllegalArgumentException exception = Assertions
                .assertThrows(IllegalArgumentException.class, ()-> garage.addCar(car1));

        Assertions.assertEquals("This car exist in the garage!", exception.getMessage());
    }

    @Test
    public void testRemoveCar(){
        garage.addCar(car1);
        boolean removedCar = garage.removeCar(car1.getBrand());
        Assertions.assertTrue(removedCar, "The car should be removed successfully.");
        assertEquals(0, garage.getCount());
    }

    @Test
    public void testRemoveCar_notFound() {
        garage.addCar(car1);
        boolean removed = garage.removeCar("Ferrari");
        assertFalse(removed, "Removing a car that doesn't exist should return false.");
        assertEquals(1, garage.getCount(), "The count should remain unchanged.");
    }

    @Test
    public void testGetMostPowerfulCar(){
        garage.addCar(car1);
        garage.addCar(car2);

        String mostPowerfulCar = garage.getMostPowerfulCar();
        Assertions.assertEquals("BMW", mostPowerfulCar);
    }


    @Test
    public void getCarsWithDesiredColor(){
        garage.addCar(car1);
        garage.addCar(car2);

        List<Car> metallicCars = garage.getCarsWithDesiredColor("metallic");
        Assertions.assertEquals(1, metallicCars.size());
    }

    @Test
    public void testGetCount(){
        garage.addCar(car1);
        Assertions.assertEquals(1, garage.getCount());
    }

    @Test
    public void testGetName(){
        Assertions.assertEquals("AutoGar", garage.getName());
    }

    @Test
    public void testSetName(){
        garage.setName("NewName");
        Assertions.assertEquals("NewName", garage.getName());
    }

    @Test
    public void testSetName_ExpectedException_WhenIsNull(){
        garage = new Garage("GarageTest", 5);
        NullPointerException exception = assertThrows(NullPointerException.class,
                ()-> garage.setName(null));

        Assertions.assertEquals("Invalid garage name!", exception.getMessage());
    }

    @Test
    public void testSetName_ExpectedException_WhenIsEmpty(){
        garage = new Garage("GarageTest", 5);
        NullPointerException exception = assertThrows(NullPointerException.class,
                ()-> garage.setName(""));

        Assertions.assertEquals("Invalid garage name!", exception.getMessage());
    }

    @Test
    public void testSetName_ExpectedException_WhenIsBLank(){
        garage = new Garage("GarageTest", 5);
        NullPointerException exception = assertThrows(NullPointerException.class,
                ()-> garage.setName("   "));

        Assertions.assertEquals("Invalid garage name!", exception.getMessage());
    }

    @Test
    public void testSetCapacity(){
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> garage.setCapacity(-1)
        );

        Assertions.assertEquals("Invalid capacity!", exception.getMessage());
    }


   //TODO write unit tests here covering all the methods
}


