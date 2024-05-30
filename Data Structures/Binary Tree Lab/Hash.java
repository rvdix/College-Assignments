/**
 * Class used to create hash tables with methods for various stats about the hash table
 * @author Alvaro Vera
 * @version 1.0
 */
public class Hash
{
    private ObjectList[] hashTable;
    private int sizeOfArray;
    private int collision = 0;
    private int usedCells = 0;
    private int chainsize[];
    private int maximumChainSize = 0;

    /**
     * Constructor for the Hash class
     * @param inSizeOfArray used to set the size of the hash table
     */
    public Hash(int inSizeOfArray)
    {
        hashTable = new ObjectList[inSizeOfArray];
        sizeOfArray = inSizeOfArray;
        chainsize = new int[37];

        for (int i = 0; i < inSizeOfArray; i++)
        {
            hashTable[i] = new ObjectList();
        }
    }

    /**
     * Takes in a string and uses the hash function to get a key, then uses this key to give you an index into the hash table
     * @param inKey String used to create the key
     * @return Corresponding index into the hash table
     */
    public int getHash(String inKey)
    {
        double ascii = 0;

        char c;

        for (int i = 0; i < inKey.length(); i++)
        {
            c = inKey.charAt(i);
            ascii += (int)c;
            ascii = (inKey.length() * ascii);
        }

        return (int)(ascii % sizeOfArray);
    }

    /**
     * Takes the index and a word object and places it into the hash table as the first object in the list, if space is already taken, adds object to end of list
     * @param inIndex Index of the hash table location
     * @param inWord Word object used for insertion
     */
    public void setIndex(int inIndex, Word inWord)
    {
        if(getNode(inIndex) == null)
        {
            hashTable[inIndex].addFirst(inWord);
            usedCells++;
            chainsize[inIndex] += 1;
        }
        else
        {
            hashTable[inIndex].addLast(inWord);
            chainsize[inIndex] += 1;
            collision++;

        }
    }

    /**
     * Returns the first node of the objectlist in the location pointed to by the index
     * @param inIndex location to grab the node from
     * @return node to the first object list object
     */
    public ObjectListNode getNode(int inIndex)
    {
        return hashTable[inIndex].getFirstNode();
    }

    /**
     * Gives the number of collisions in the given hash table
     * @return Number of collisions
     */
    public int getCollision()
    {
        return collision;
    }

    /**
     * Calculates the average chain size of the items in the hash table with items inside
     * @return average chain size
     */
    public double averageChainSize()
    {
        double sumOfChains = 0;
        for(int i = 0; i < sizeOfArray; i++)
        {
            if(chainsize[i] > 0)
            {
                if(chainsize[i] > maximumChainSize)
                {
                    maximumChainSize = chainsize[i];
                }
                sumOfChains += chainsize[i];
            }
        }
        return sumOfChains/usedCells;

    }

    /**
     * Gives you the largest chain size that was found in the current hash table
     * @return maximum chain size
     */
    public int getMaximumChainSize()
    {
        return maximumChainSize;
    }

    /**
     * Calculates how much of the hash table is being currently used
     * @return ratio of how full the hash table is
     */
    public double loadFactor()
    {
        double loadFactor = (double)usedCells/sizeOfArray;
        return loadFactor;
    }

    /**
     * Creates a string representation of the hash function
     * @return string of hash function
     */
    public String hashFunctionOutput()
    {
        return String.format(" for (int i = 0; i < inKey.length(); i++)\n" +
                "        {\n" +
                "            c = inKey.charAt(i);\n" +
                "            ascii += (int)c;\n" +
                "            ascii = (inKey.length() * ascii);\n" +
                "        }");
    }
}
