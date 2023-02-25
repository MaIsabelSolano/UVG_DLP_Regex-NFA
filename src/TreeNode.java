package src;

public class TreeNode {
    Symbol value;
    TreeNode leftChild;
    TreeNode righChild;

    public TreeNode(Symbol value){
        this.value = value;
    }

    public TreeNode(Symbol value, TreeNode leftChild) {
        this.value = value;
        this.leftChild = leftChild;
    }

    public TreeNode(Symbol value, TreeNode leftChild, TreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.righChild = rightChild;
    }
}
