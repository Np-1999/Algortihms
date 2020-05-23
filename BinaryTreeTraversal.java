public class BinaryTreeTraversal {
    static class Node{
        int key;
        Node left;
        Node right;
        Node(int key){
            this.key=key;
            left=right=null;
        }
    }
    public static void printPreorder(Node root) {
        if (root == null){

        }
        else{
            System.out.println(root.key);
            printPreorder(root.left);
            printPreorder(root.right);
        }

    }
    public static void printInorder(Node root){
        if(root==null){

        }
        else{
            printInorder(root.left);
            System.out.println(root.key);
            printInorder(root.right);
        }
    }
    public static void printPostorder(Node root){
        if(root==null){

        }
        else{
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.println(root.key);
        }
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.left.right.left=new Node(6);
        root.right=new Node(3);
        root.right.right=new Node(7);
        printPostorder(root);
    }
}