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
class Node
{
    private static final int order = 4;
    private int keyIndex;
    private Node parent;
    private Node[] childrenArr = new Node[order];
    private Key[] keyArr = new Key[order-1];

    public void pointChild(int childNum, Node child)
    {
        childrenArr[childNum] = child;
        if(child != null) child.parent = this;
    }
    
    //removes the pointer to child
    public Node removePointer(int childNum)
    {
        Node tempNode = childrenArr[childNum];
        childrenArr[childNum] = null;
        return tempNode;
    }

    //returns a particular child
    public Node getChild(int childNum)
    { 
        return childrenArr[childNum]; 
    }

    //gets the node's parent
    public Node getParent()
    { 
        return parent; 
    }

    //tests if node is root
    public boolean isLeaf()
    {
        boolean ans = false;
        if ( childrenArr[0] == null)
        {
            ans = true;
        }
        return ans;
    }

    //gets the number of items
    public int getKeyIndex()
    { 
        return keyIndex; 
    }

    public Key getItem(int index)
    { 
        return keyArr[index]; 
    }

    public boolean isFull()
    { 
        //returns false, unless node is full
        boolean ans = false;
        if ( keyIndex == order-1)
        {
            ans = true;
        }
        return ans;
    }
    

    public int findItem(long key)
    {
            for(int j=0; j<order-1; j++)
            {
                    if(keyArr[j] == null)
                            break;
                    else if(keyArr[j].value == key)
                            return j;
            }
            return -1;
    }

    //Inersts the data into the node
    public int insertKey(Key i)
    {
        keyIndex++;
        long newKey = i.value;

        for(int j=order-2; j>=0; j--)
        {
            if(keyArr[j] != null)
            {
                long itsKey = keyArr[j].value;
                if(newKey < itsKey) keyArr[j+1] = keyArr[j];
                else
                {
                    keyArr[j+1] = i;
                    return j+1;
                }
            }
        }
        keyArr[0] = i;
        return 0;
    }

    public Key removeKey()
    {
        Key temp = keyArr[keyIndex-1];
        keyArr[keyIndex-1] = null;
        keyIndex--;
        return temp;
    }
}
