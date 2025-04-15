package com.example.testingtesting123

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }


    // TODO 1: Write a test to ensure items can be added to the collection
    @Test
    fun addAnItem() {

        val before = collection.size()
        collection.addItem(Item("test"));
        val after = collection.size()
        Assert.assertNotEquals(before, after)

    }

    // TODO 2: Write a test to ensure that only unique items can be added to the collection
    // Uniqueness is determined by the Item.name property, which is set via the constructor
    @Test
    fun addUniqueItem() {

        //Adding same item, second add is ignored
        val testItem = Item("test")
        collection.addItem(testItem)
        collection.addItem(testItem)
        Assert.assertEquals(collection.size(), 1)

        //Adding different item, successful add
        val anotherTestItem = Item("test2")
        collection.addItem(anotherTestItem)
        Assert.assertEquals(collection.size(), 2)
    }

    // Test Driven Development (TDD) test - complete specified function so that this test passes
    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }
}