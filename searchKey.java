public class searchKey {
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

    public treeNode search(int value){
        return search(root, value);
    }

    public treeNode search(treeNode root, int key){
        if(root == null || root.data == key){
            return root;
        }
        if(key < root.data){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }

    public static void main(String[] args){
        searchKey n = new searchKey();
        n.insert(5);
        n.insert(3);
        n.insert(7);
        n.insert(1);

        n.inOrder(n.root);
        System.out.println();
        if(n.search(5) != null){
            System.out.println("key found!!");
        }
        else{
            System.out.println("key not found!!");
        }
    }
}
