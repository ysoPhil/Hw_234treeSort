/*
 * Philip Devoll
 * Course: CSCI 3352 Section 01
 * Date: 4/5/2020
 * Programming Assignment 2
 * Environment: Windows 10 version 10.0.18362
 * Files HW_234treeSort.java, Tree.java, Node.java, Key.java
 * Purpose: instantiates a root node and follows 2-3-4 insertion and deletion
            logic. This class uses this to sort an array of keys.
 * Input: recieves an unsorted array
 * Output: returns a sorted array
 */
package hw_234treesort;

/**
 *
 * @author Phil
 */

class Tree
{
    private Node root = new Node();

    public int find(long key)
    {
        Node node = root;
        int childNumber;
        while(true)
        {
            if( (childNumber=node.findItem(key)) != -1) return childNumber;
            else if( node.isLeaf() ) return -1;					
            else node = getNextChild(node, key);
        }
    }

    
    //initial sort call
    public void Sort(long[] theArray)
    {
        int i = 0;
        Sort(root, theArray, i);
    }

    //recursive sort call
    private int Sort(Node curNode, long[] theArray, int i)
    {
        if(curNode.isLeaf())
        {
            for(int j = 0; j<curNode.getKeyIndex(); j++)
            {
                theArray[i] = curNode.getItem(j).value;
                i++;
            }
            return i;
    }
        else
        {
            for(int j = 0; j < curNode.getKeyIndex()+1; j++)
            {
                i = Sort(curNode.getChild(j), theArray, i);
                if(j < curNode.getKeyIndex())
                {
                    theArray[i] = curNode.getItem(j).value;
                    i++;
                }
            }
            return i;
        }
    }
    
    //method that gets the next child in the node
    public Node getNextChild(Node theNode, long theValue)
    {
            int j;
            int numItems = theNode.getKeyIndex();
            for(j=0; j<numItems; j++)		
            {								
                if( theValue < theNode.getItem(j).value)
                    //return left child    
                    return theNode.getChild(j); 
            }
            //return right child
            return theNode.getChild(j);		
    }
    
    //Places value into the key then follows 2-3-4 insertion logic
    public void insert(long val)
	{
            Node node = root;
            Key  tempKey = new Key(val);

            while(true)
            {
                if (node.isFull() )
                {
                    //split node if it is full
                    splitNode(node);			
                    node = node.getParent();
                    node = getNextChild(node, val);
                }

                else if (node.isLeaf()) break;					
                
                else node = getNextChild(node, val);
            }

            node.insertKey( tempKey);	
	}
    
    public void splitNode(Node node)
    {
        
        Key valOne;
        Key valTwo;
        Node parent, childL, childR;
        int itemIndex;
        
        //remove rightmost data
        valTwo = node.removeKey(); 
        //remove next data
        valOne = node.removeKey(); 
        //remove children
        childL = node.removePointer(2); 
        childR = node.removePointer(3);

        Node newRight = new Node();

        if(node==root)				
        {
            //create new root
            root = new Node();			
            parent = root;
            //add pointers to parenr
            root.pointChild(0, node);
        }
        else parent = node.getParent();

        //insert into parent
        itemIndex = parent.insertKey(valOne);
        int n = parent.getKeyIndex();	
        
        //change parent's pointers
        for(int j = n-1; j>itemIndex; j--)	
        {
            Node temp = parent.removePointer(j);
            parent.pointChild(j+1, temp);
        }

        //connect newRight to parent
        parent.pointChild(itemIndex+1, newRight);

        //deal with newRight
        newRight.insertKey(valTwo);			
        newRight.pointChild(0, childL);	
        newRight.pointChild(1, childR);	
    }
}

 


