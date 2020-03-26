package edu.iis.mto.bsearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    static BinarySearch binarySearch;
    int seq[];
    int key;
    SearchResult searchResult = null;

    @BeforeAll static void create() {
        binarySearch = BinarySearch.create();
    }

    @Test void isInSequenceOfOneTest() {
        seq = new int[] {2};
        key = 2;
        searchResult = binarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test void isNotInSequenceOfOneTest() {
        seq = new int[] {2};
        key = 1;
        searchResult = binarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertTrue(searchResult.getPosition() == -1);
    }

    @Test void keyAsFirstElement(){
        seq = new int[] {2, 3, 6, 9};
        key = 2;
        searchResult = binarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test void keyAsLastElement(){
        seq = new int[] {2, 3, 6, 9};
        key = 9;
        searchResult = binarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test void keyAsMiddleElement(){
        seq = new int[] {2, 3, 6, 9, 35};
        key = 6;
        searchResult = binarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test void keyNotInSeq(){
        seq = new int[] {2, 3, 6, 9};
        key = 89;
        searchResult = binarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertTrue(searchResult.getPosition() == -1);
    }

    @Test void searchInSeqWithNullPointer(){
        seq = null;
        key=3;
        Assertions.assertThrows(NullPointerException.class, () -> {
            searchResult = binarySearch.search(key, seq);
        });
    }

    @Test void searchInUnsortedArray(){
        seq = new int[]{ 3, -1, 2, 0, 18, -15};
        key=-15;
        searchResult = binarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertTrue(searchResult.getPosition() == -1);
    }

    @Test void searchInArrayWithNoElements(){
        seq = new int[]{};
        key=8;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            searchResult = binarySearch.search(key, seq);
        });

    }
}

//Testy z tabeli nie byly kompletne, nie byly sprawdzane warunki wejsciowe oraz dzialanie programu w przypadku podania nulla
