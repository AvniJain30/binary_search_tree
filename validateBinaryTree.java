public class validateBinaryTree {
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

        public boolean isValid(treeNode root, long min, long max){
            if(root == null)   return true;
            if(root.data <= min || root.data >= max)  return false;

            boolean left = isValid(root.left, min, root.data);
            if(left){
                boolean right = isValid(root.right, root.data, max);
                return true;
            }
            return false;
        }

        public static void main(String[] args){
            validateBinaryTree n = new validateBinaryTree();
            n.insert(5);
            n.insert(3);
            n.insert(7);
            n.insert(10);

            System.out.println(n.isValid(n.root, Long.MIN_VALUE, Long.MAX_VALUE));
        }
    }


