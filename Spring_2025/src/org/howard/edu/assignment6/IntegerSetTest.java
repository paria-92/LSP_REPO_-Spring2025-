package org.howard.edu.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {

    @Test
    @DisplayName("add() inserts elements and ignores duplicates")
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(3);  // duplicate
        set.add(1);
        set.add(2);
        assertEquals(3, set.length());
        assertTrue(set.contains(3) && set.contains(1) && set.contains(2));
    }

    @Test
    @DisplayName("complement() produces the set difference otherSet - thisSet")
    public void testComplement() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setB.add(4);
        setA.complement(setB);
        assertTrue(setA.contains(3) && setA.contains(4));
        assertFalse(setA.contains(1) || setA.contains(2));
    }

    @Test
    @DisplayName("clear() should remove all elements from the set")
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertFalse(set.isEmpty());
        assertEquals(2, set.length());
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.length());
    }

    @Test
    @DisplayName("union() combines two sets (in-place union)")
    public void testUnion() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setB.add(2);
        setA.union(setB);
        assertTrue(setA.contains(1));
        assertTrue(setA.contains(2));
    }

    @Test
    @DisplayName("diff() removes common elements from the set (in-place difference)")
    public void testDiff() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setA.diff(setB);
        assertTrue(setA.contains(1));
        assertFalse(setA.contains(2));
    }

    @Test
    @DisplayName("toString() provides a string representation of the set")
    public void testToString() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString());
        set.add(1);
        set.add(2);
        String output = set.toString();
        assertTrue(output.contains("1") && output.contains("2"));
        assertTrue(output.startsWith("[") && output.endsWith("]"));
    }

    @Test
    @DisplayName("largest() returns the maximum value or throws exception if the set is empty")
    public void testLargest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(5);
        set.add(3);
        assertEquals(5, set.largest());

        IntegerSet empty = new IntegerSet();
        assertThrows(IntegerSetException.class, empty::largest);
    }

    @Test
    @DisplayName("smallest() returns the minimum value or throws exception if the set is empty")
    public void testSmallest() throws IntegerSetException {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(5);
        set.add(3);
        assertEquals(1, set.smallest());

        IntegerSet empty = new IntegerSet();
        assertThrows(IntegerSetException.class, empty::smallest);
    }

    @Test
    @DisplayName("contains() correctly identifies if a value is present in the set")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        assertFalse(set.contains(1));
        set.add(1);
        assertTrue(set.contains(1));
    }

    @Test
    @DisplayName("intersect() keeps only common elements in the set")
    public void testIntersect() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        setA.intersect(setB);
        assertTrue(setA.contains(2));
        assertFalse(setA.contains(1));
        assertFalse(setA.contains(3));
    }

    @Test
    @DisplayName("equals() returns true only for sets with identical elements")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("length() returns the number of elements in the set")
    public void testLength() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length());
        set.add(1);
        assertEquals(1, set.length());
        set.add(2);
        assertEquals(2, set.length());
    }

    @Test
    @DisplayName("isEmpty() returns true for empty set and false otherwise")
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());
        set.add(1);
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("remove() deletes an element if present")
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(1);
        assertFalse(set.contains(1));
    }
}
