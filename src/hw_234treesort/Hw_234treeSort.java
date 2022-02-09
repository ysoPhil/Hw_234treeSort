/*
 * Philip Devoll
 * Course: CSCI 3352 Section 01
 * Date: 4/5/2020
 * Programming Assignment 2
 * Environment: Windows 10 version 10.0.18362
 * Files HW_234treeSort.java, Tree.java, Node.java, Key.java
 * Purpose: To act as a controller for the tree class.
 * Input: generates an array of random unsorted values
 * Output: returns array of random sorted values
 */
package hw_234treesort;

/**
 *
 * @author Phil
 */
public class Hw_234treeSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Tree tree = new Tree();
        long[] dataArr = new long[20];
        
	//insert all values into the tree
	for(int j = 0; j < dataArr.length; j++)
        {
            dataArr[j] = (long)(Math.random()*10);
            System.out.print(dataArr[j] + " ");
            tree.insert(dataArr[j]);
            tree.Sort(dataArr);
        }
        
        System.out.print("\n");
        for(long k : dataArr)
        {
            System.out.print( k + " ");
        }
        

    }
    
}
