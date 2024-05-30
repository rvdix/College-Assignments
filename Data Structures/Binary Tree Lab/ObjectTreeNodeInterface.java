/**
 * Interface for ObjectTreeNode class
 */
public interface ObjectTreeNodeInterface
{
    void setInfo(Object o);

    Object getInfo();

    void setLeft(ObjectTreeNode p);

    ObjectTreeNode getLeft();

    void setRight(ObjectTreeNode p);

    ObjectTreeNode getRight();
}
