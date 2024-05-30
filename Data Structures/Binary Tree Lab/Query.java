import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class runs the methods to parse text into a binary tree, while omitting words from the text, and allowing the user to search the text
 * @author Alvaro Vera
 * @version 1.0
 */
public class Query
{
    private PrintWriter pw;
    private Hash hashTable = new Hash(37);
    private ObjectBinaryTree gettyTree = new ObjectBinaryTree();
    private ObjectTreeNode nodeT;

    /**
     * Constructor the class Query
     * @param inPw printwriter object used to mirror output to text file
     */
    public Query(PrintWriter inPw)
    {
        pw = inPw;
    }

    /**
     * Takes a text file and while filtering out omitted words from the text using a hasb table, places them into a binary tree for later searching
     * @throws FileNotFoundException when specified file is not found
     */
    public void parseText() throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("getty.txt"));
        int row = 0;

        LinePosition lp;

        while(sc.hasNextLine())
        {
            int col = 0;
            String input;
            int key;
            Word holder;
            ObjectListNode p;
            Word tempWord;

            row++;

            String placeholder = sc.nextLine();
            System.out.println(row + " " + placeholder);
            pw.println(row + " " + placeholder);
            String delim = "[ , -;]+";

            String[] tokens = placeholder.split(delim);

            for(int i = 0; i < tokens.length; i++)
            {
                input = tokens[i];
                col++;

                tempWord = new Word(input, pw);
                lp = new LinePosition(row, col);
                tempWord.setRef(lp);


                key = hashTable.getHash(input);
                p = hashTable.getNode(key);

                if(hashTable.getNode(key) == null)
                {
                    gettyTree.insertBSTDup(tempWord);
                }

                else if(hashTable.getNode(key) != null)
                {
                    holder = (Word)p.getInfo();

                    while(p != null)
                    {
                        if(holder.getWord().compareTo(tempWord.getWord()) == 0)
                        {
                            break;
                        }

                        p = p.getNext();

                        if (p != null)
                        {
                            holder = (Word)p.getInfo();
                        }
                    }

                    if(holder.getWord().compareTo(tempWord.getWord()) != 0)
                        gettyTree.insertBSTDup(tempWord);

                }
            }
        }
        sc.close();
    }

    /**
     * Takes in the omitted words, parses it, then places it into a hash table for easy lookup
     * @throws FileNotFoundException when specified file is not found
     */
    public void hashing() throws FileNotFoundException
    {
        Scanner omitWord = new Scanner(new File("unimportant.txt"));
        String temp;
        int key;
        Word word;

        while(omitWord.hasNextLine())
        {
            temp = omitWord.nextLine();
            key = hashTable.getHash(temp);
            word = new Word(temp, pw);
            hashTable.setIndex(key, word);
        }

        System.out.println("Number of Hash Table Collisions: " + hashTable.getCollision());
        System.out.printf("Average chain size: %.2f \n",  hashTable.averageChainSize());
        System.out.println("Maximum chain size: " + hashTable.getMaximumChainSize());
        System.out.printf("Load factor of Hash Table: %.2f \n \n", hashTable.loadFactor());
        System.out.print("Hash function: " + hashTable.hashFunctionOutput());
        System.out.println("\nLoops through chars in string, adds ascii value of chars together and multiplies it by the word length \n");

        pw.println("Number of Hash Table Collisions: " + hashTable.getCollision());
        pw.printf("Average chain size: %.2f \n",  hashTable.averageChainSize());
        pw.println("Maximum chain size: " + hashTable.getMaximumChainSize());
        pw.printf("Load factor of Hash Table: %.2f \n \n", hashTable.loadFactor());
        pw.print("Hash function: " + hashTable.hashFunctionOutput());
        pw.println("\nLoops through chars in string, adds ascii value of chars together and multiplies it by the word length \n");

    }

    /**
     * Allows the user to search through the binary and find information about the specific word
     */
    public void search()
    {
        String s;

        while(1 > 0)
        {
            Scanner search = new Scanner(System.in);
            System.out.println("\nEnter your search term: (Use exit1 to end search)");
            s = search.nextLine();

            pw.println("\nEnter your search term: (Use exit1 to end search)");
            pw.println(s);

            if(s.compareTo("exit1") == 0)
            {
                break;
            }

            Word temp = new Word(s, pw);
            nodeT = gettyTree.searchBST(temp);

            if(nodeT == null)
            {
                System.out.println("This word could not be found.");
                pw.println("This word could not be found.");
                continue;
            }

            Word outWord = (Word)nodeT.getInfo();
            outWord.visit();
        }
    }

    /**
     * Traverses the binary tree and prints out the words in alphabetical order
     */
    public void inOrder()
    {
        gettyTree.inTrav(gettyTree.getRoot());
    }

    /**
     * Outputs the hash table into a
     */
    public void outputHash()
    {
        ObjectListNode p;
        Word tempWord;


        for(int i = 0; i < 37; i++)
        {
           p = hashTable.getNode(i);

           if(p == null)
           {

               System.out.println("--------------------");
               System.out.println(i +"| NULL");

               pw.println("--------------------");
               pw.println(i +"| NULL");
           }

           if(p != null)
           {
               tempWord = (Word)p.getInfo();

               System.out.println("--------------------");
               System.out.println(i +"|"+ " " + tempWord.getWord());

               pw.println("--------------------");
               pw.println(i +"|"+ " " + tempWord.getWord());

               p = p.getNext();

               while(p != null)
               {
                   tempWord = (Word)p.getInfo();

                   System.out.println("--------------------");
                   System.out.println(i +"|"+ " " + tempWord.getWord());

                   pw.println("--------------------");
                   pw.println(i +"|"+ " " + tempWord.getWord());

                   p = p.getNext();
               }
           }
        }
    }
}
