public class insertNode {
    private treeNode root;

    private class treeNode{
        private treeNode left;
        private treeNode right;
        private int data;

        public treeNode(int data){
            this.data = data;
        }
    }

    public void insert(int value){
        root = insert(root, value);
    }
    public treeNode insert(treeNode root, int value){
        if(root == null){
            root = new treeNode(value);
            return root;
        }

        if(value < root.data){
            root.left = insert(root.left, value);
        }
        else if(value > root.data){
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void inOrder(treeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args){
        insertNode n = new insertNode();
        n.insert(5);
        n.insert(3);
        n.insert(7);
        n.insert(1);

        n.inOrder(n.root);
    }
}
