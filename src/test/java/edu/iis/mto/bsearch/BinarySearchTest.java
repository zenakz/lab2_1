package edu.iis.mto.bsearch;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    static BinarySearch binarySearch;
    int seq[];
    int key;
    SearchResult searchResult = null;
    @BeforeAll
    static void create(){
        binarySearch = BinarySearch.create();
    }

    @Test void isInSequenceOfOneTest() {
        seq = new int[]{2};
        key=2;
        searchResult = binarySearch.search(key, seq);
        assertTrue(searchResult.isFound());
        assertEquals(seq[searchResult.getPosition()], key);
    }

    @Test void isNotInSequenceOfOneTest() {
        seq = new int[]{2};
        key=1;
        searchResult = binarySearch.search(key, seq);
        assertFalse(searchResult.isFound());
        assertNotEquals(seq[searchResult.getPosition()], key);
    }

}


