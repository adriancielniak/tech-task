
class Node{
    public int value;
    public Node left;
    public Node right;

    Node(int value){
        this.value = value;
        left = null;
        right = null;
    }
}

public class Tree{
    Node root;

    public Tree(){
        root = null;
    }

    // 1. calculating the number of nodes that do not have any children...

    public int anyChildren(Node node){
        if(node == null)
            return 0;

        if(node.left == null && node.right == null)
            return 1;
        
        int counter = 0;    

        if(node.left != null)
            counter += anyChildren(node.left);

        if(node.right != null)
            counter += anyChildren(node.right);
        
        return counter;
    }


    // 2. calculating the largest number of edges in a path from the root node to a leaf node...

    public int longestPath(Node node){
        if(node == null)
            return 0;

        if(node.left == null && node.right == null)
            return 0;
        
        int left = 0;
        int right = 0;

        if(node.left != null)
            left = longestPath(node.left) + 1;
        
        if(node.right != null)
            right = longestPath(node.right) + 1;

        return Math.max(left, right);
    }

    // 3. checking if two instances are equivalent...

    public boolean areEquivalent(Node first, Node second){
        
        if(first == null && second == null)
            return true;
        
        if(first != null && second != null)
            return (first.value == second.value && areEquivalent(first.left, second.left) && areEquivalent(first.right, second.right));

        return false;

    }



    public static void main (String [] args){

        //tree from pdf providing tasks

        Tree tree = new Tree();
        tree.root = new Node(5);
        tree.root.left = new Node(3);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(1);
        tree.root.right.right = new Node(0);
        tree.root.right.right.left = new Node(2);
        tree.root.right.right.right = new Node(8);
        tree.root.right.right.right.right = new Node(5);
        
        System.out.println(tree.anyChildren(tree.root));   // 5
        System.out.println(tree.longestPath(tree.root));    // 4 
        System.out.println(tree.areEquivalent(tree.root, tree.root));   // true

        //other tests 

        System.out.println();

        Tree second_tree = new Tree();
        
        System.out.println(tree.anyChildren(second_tree.root));   // 0
        System.out.println(tree.longestPath(second_tree.root));    // 0 
        System.out.println(tree.areEquivalent(second_tree.root, second_tree.root));   // true

        System.out.println();

        // simillar to the first tree but with other values

        Tree third_tree = new Tree();
        third_tree.root = new Node(5);
        third_tree.root.left = new Node(3);
        third_tree.root.right = new Node(4);
        third_tree.root.left.left = new Node(2);
        third_tree.root.left.right = new Node(5);
        third_tree.root.right.left = new Node(3);
        third_tree.root.right.right = new Node(0);
        third_tree.root.right.right.left = new Node(2);
        third_tree.root.right.right.right = new Node(9);       
        third_tree.root.right.right.right.right = new Node(5);

        System.out.println(tree.areEquivalent(tree.root, third_tree.root));   // false

    }
}


