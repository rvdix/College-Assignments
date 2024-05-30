/**
 * Interface for the ObjectBinaryTree class
 */
public interface ObjectBinaryTreeInterface
{
    ObjectTreeNode getRoot();

    void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);

    void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);

    void insertBST(Object o);

    void insertBSTDup(Object o);

    ObjectTreeNode searchBST(Object o);

    void preTrav(ObjectTreeNode tree);

    void inTrav(ObjectTreeNode tree);

    void postTrav(ObjectTreeNode tree);

    void delete(Object o);
}
