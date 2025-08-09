package furnitureShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopTests {
    private Shop shop;
    private Furniture furniture;

    @BeforeEach
    public void setUp() {
        // Създава се нов обект Shop с капацитет 3
        shop = new Shop("VintageStuff", 3);

        // Създава се обект Furniture
        furniture = new Furniture("RoyalBed", "Bed", 300);

        // Добавя се едно обзавеждане в магазина
        shop.addFurniture(furniture);
    }

    @Test
    public void getCountShouldReturnOne() {
        // Проверява, че има точно един елемент след setUp()
        int actualCount = shop.getCount();
        int expectedCount = 1;
        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getFurnitureShouldReturnCorrectList() {
        // Създава очакван списък с furniture
        Collection<Furniture> expected = new ArrayList<>();
        expected.add(furniture);

        // Взима реалния списък от магазина
        Collection<Furniture> actualD = shop.getFurnitures();

        // Проверява дали списъците съвпадат
        Assertions.assertEquals(expected, actualD);
    }

    @Test
    public void addFurniture() {
        // Повтаря getCountShouldReturnOne()
        int actualCount = shop.getCount();
        int expectedCount = 1;
        Assertions.assertEquals(expectedCount, actualCount);
    }


    @Test
    public void removeFurniture() {
        // Премахва furniture по тип и проверява, че броят е 0
        shop.removeFurniture(furniture.getType());

        int actualCount = shop.getCount();
        int expectedCount = 0;
        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void addFurnitureWithNullValue() {
        // Проверява дали методът хвърля IllegalArgumentException при добавяне на null furniture
        assertThrows(IllegalArgumentException.class, () -> {
            shop.addFurniture(null);
        });
    }

    @Test
    public void findCheapestFurniture() {

        Shop vintage = new Shop("Vintage", 5);
        Furniture furniture2 = new Furniture("LuxuryTable", "Table",  1000);
        Furniture furniture3 = new Furniture("WallClock", "Clock",  300);
        vintage.addFurniture(furniture2);
        vintage.addFurniture(furniture3);

        String expectedFurniture = "WallClock";
        String actualFurniture = String.valueOf(vintage.getCheapestFurniture());

        Assertions.assertEquals(expectedFurniture, actualFurniture);
    }


    @Test
    public void testGetPrice() {
        // Проверява дали getPrice връща правилната стойност
        Furniture furniture = new Furniture("WallClock", "Clock", 100);
        Assertions.assertEquals(100, furniture.getPrice());
    }

    @Test
    public void findAllFurnitureByType() {
        Shop shop = new Shop("FurnitureWorld", 3);
        Furniture furniture2 = new Furniture("LuxuryTable", "Table", 600);
        Furniture furniture3 = new Furniture("WallClock", "Clock",  100);
        Furniture furniture4 = new Furniture("AbanosTable", "Table",  700);

        shop.addFurniture(furniture2);
        shop.addFurniture(furniture3);
        shop.addFurniture(furniture4);

        List<Furniture> foundByType = shop.findAllFurnitureByType("Table");

        Assertions.assertEquals(2, foundByType.size());
    }

    @Test
    public void testGetCapacity() {
        // Проверява дали капацитетът на магазина е 3
        Assertions.assertEquals(3, shop.getCapacity());
    }

    @Test
    public void getPrice_ShouldReturnFurniturePrice() {
        // Проверява цената на furniture, създадено в setUp()
        Assertions.assertEquals(300, furniture.getPrice());
    }

    @Test
    public void getShopName_ShouldReturnShopName() {
        // Проверява дали името на магазина е "VintageStuff"
        Assertions.assertEquals("VintageStuff", shop.getType());
    }

    @Test
    public void addMethod_ShouldThrowExceptionForInvalidCapacity() {
        // Създава магазин с капацитет 0 и очаква изключение при добавяне
        Shop play = new Shop("Henry'sOldFurniture", 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            play.addFurniture(furniture);
        });
    }

    @Test
    public void addMethod_ShouldThrowExceptionForExceededCapacity() {
        // Създава магазин с капацитет 0 и очаква изключение при добавяне
        Shop play = new Shop("Henry'sOldFurniture", 1);
        Furniture furniture2 = new Furniture("PrettyDesk", "Desk", 50);
        Furniture furniture3 = new Furniture("AbanosChair", "Chair",  40);

        play.addFurniture(furniture2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            play.addFurniture(furniture3);
        });
    }

    @Test
    public void addMethod_ShouldThrowExceptionForExistingFurniture() {
        // Опитва се да добави един и същи обект два пъти
        Shop play = new Shop("Henry'sOldFurniture", 3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            play.addFurniture(furniture);
            play.addFurniture(furniture);
        });


    }

    @Test
    public void constructor_ShouldThrowArgumentExceptionForInvalidCapacity() {
        // Проверява, че не може да се създаде магазин с отрицателен капацитет
        assertThrows(IllegalArgumentException.class, () -> {
            new Shop("Ocean", -10);
        });
    }
}