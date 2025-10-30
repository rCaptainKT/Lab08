package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        assertTrue(list.hasCity(calgary));
    }

    @Test
    void testDelete() {
        CustomList list = new CustomList();
        City city1 = new City("Regina", "Saskatchewan");
        City city2 = new City("Calgary", "Alberta");
        list.addCity(city1);
        list.addCity(city2);
        assertEquals(2, list.countCities());

        list.deleteCity(city2);
        assertEquals(1, list.countCities());

        list.deleteCity(city1);
        assertEquals(0, list.countCities());
    }

    @Test
    void testDeleteException() {
        CustomList list = new CustomList();
        City city = new City("Yellowknife", "Northwest Territories");
        assertThrows(IllegalArgumentException.class, () -> {
            list.deleteCity(city);
        });
    }

    @Test
    void testCountCities() {
        CustomList list = new CustomList();
        assertEquals(0, list.countCities());
        assertNotEquals(1, list.countCities());
    }
}
