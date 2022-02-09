/*
 * Philip Devoll
 * Course: CSCI 3352 Section 01
 * Date: 4/5/2020
 * Programming Assignment 2
 * Environment: Windows 10 version 10.0.18362
 * Files HW_234treeSort.java, Tree.java, Node.java, Key.java
 * Purpose: To represent a key and the data it represents.
 *          Primarily exists because I was having trouble with
 *          null derefrencing errors when I was just using an
 *          array comprised of longs.
 * Input: recieves a value
 * Output: displays the recieved value
 */
package hw_234treesort;

/**
 *
 * @author Phil
 */
class Key
{
    public long value;

    public Key(long d)
    { 
        value = d; 
    }

    public void displayValue()
    { 
        System.out.print("/"+value);
    }
}
