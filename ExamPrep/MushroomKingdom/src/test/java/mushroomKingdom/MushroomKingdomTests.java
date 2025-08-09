package mushroomKingdom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

public class MushroomKingdomTests {

//TODO write unit tests here covering all the methods
    private Field field;
    private Mushroom mushroom;
    private Mushroom mushroom2;

    @BeforeEach
    public void setUp(){
        field = new Field("Pirin", 1);
        mushroom = new Mushroom("Porcini", "nutty flavor", true, 0);
        mushroom2 = new Mushroom("Poisonous", "unknown flavor", false, 10);
    }

    @Test
    public void testCreateMushroom(){
        Assertions.assertEquals("Porcini", mushroom.getName());
        Assertions.assertEquals("nutty flavor", mushroom.getFlavor());
        Assertions.assertEquals(0, mushroom.getToxicity());
        Assertions.assertTrue(mushroom.isEdible());
    }

    @Test
    public void testAddMushroom_Successfully(){
        field.addMushroom(mushroom);
        Assertions.assertEquals(1, field.getCount());
    }

    @Test
    public void testAddMushroom_capacityException(){
        field.addMushroom(mushroom);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> field.addMushroom(mushroom2));
        Assertions.assertEquals("No more space in the field!", exception.getMessage());
    }

    @Test
    public void testAddMushroom_mushroomExistException(){
        field.setCapacity(2);
        field.addMushroom(mushroom);
        Mushroom duplicateMushroom = new Mushroom("Porcini", "nutty flavor", true, 0);
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, ()-> field.addMushroom(duplicateMushroom));
        Assertions.assertEquals("This mushroom exists in the field!", exception.getMessage());
    }

    @Test
    public void testRemoveMushroom(){
        field.addMushroom(mushroom);
        boolean removed = field.removeMushroom(mushroom.getName());
        Assertions.assertTrue(true);
        Assertions.assertEquals(0, field.getCount());

    }

    @Test
    public void testGetMostPoisonousMushroom(){
        field.setCapacity(3);
        field.addMushroom(mushroom);
        field.addMushroom(mushroom2);

        Assertions.assertEquals("Poisonous", field.getMostPoisonousMushroom());
    }

    @Test
    public void testGetMostPoisonousMushroomWhenEmpty() {
        Executable getMostPoisonousWhenEmpty = field::getMostPoisonousMushroom;
        Assertions.assertThrows(AssertionError.class, getMostPoisonousWhenEmpty);
    }

    @Test
    public void testGetInedibleMushrooms(){
        field.setCapacity(5);
        Mushroom inedibleMushroom = new Mushroom("Inedible Mushroom", "none", false, 10);
        Mushroom inedibleMushroom2 = new Mushroom("Inedible Mushroom2", "none", false, 80);

        List<Mushroom> inedibleMushroomList = new ArrayList<>();
        inedibleMushroomList.add(inedibleMushroom);
        inedibleMushroomList.add(inedibleMushroom2);

        field.addMushroom(inedibleMushroom);
        field.addMushroom(inedibleMushroom2);

        Assertions.assertEquals(inedibleMushroomList, field.getInedibleMushrooms());

    }

    @Test
    public void testGetMushroomsByFlavor(){
        field.setCapacity(5);
        Mushroom inedibleMushroom = new Mushroom("Inedible Mushroom", "none", false, 10);
        Mushroom inedibleMushroom2 = new Mushroom("Inedible Mushroom2", "none", false, 80);

        List<Mushroom> flavorList = new ArrayList<>();
        flavorList.add(inedibleMushroom);
        flavorList.add(inedibleMushroom2);

        field.addMushroom(inedibleMushroom);
        field.addMushroom(inedibleMushroom2);

        Assertions.assertEquals(flavorList, field.getMushroomsByFlavor("none"));
    }

    @Test
    public void testGetMushroom(){
        field.setCapacity(2);
        field.addMushroom(mushroom);
        field.addMushroom(mushroom2);

        Assertions.assertEquals(mushroom, field.getMushroom("Porcini"));
    }

    @Test
    public void testGetName(){
        field.addMushroom(mushroom);
        Assertions.assertEquals("Pirin", field.getName());
    }

    @Test
    public void testSetNameSuccessfully() {
        field.setName("Rila");
        Assertions.assertEquals("Rila", field.getName());
    }

    @Test
    public void testSetName_Null_ThrowsException() {
        NullPointerException exception = Assertions.assertThrows(NullPointerException.class,
                () -> field.setName(null));

        Assertions.assertEquals("Invalid field name!", exception.getMessage());
    }

    @Test
    public void testSetName_EmptyString_ThrowsException() {
        NullPointerException exception = Assertions.assertThrows(NullPointerException.class,
                () -> field.setName("   ")); // само интервали

        Assertions.assertEquals("Invalid field name!", exception.getMessage());
    }

    @Test
    public void testSetCapacitySuccessfully() {
        field.setCapacity(5);
        Assertions.assertEquals(5, field.getCapacity());
    }

    @Test
    public void testSetCapacityZeroSuccessfully() {
        field.setCapacity(0);
        Assertions.assertEquals(0, field.getCapacity());
    }

    @Test
    public void testSetCapacityNegativeValue_ThrowsException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> field.setCapacity(-1));

        Assertions.assertEquals("Invalid capacity!", exception.getMessage());
    }
}


