public class BinaryTree {
    private Node root;

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) return new Node(data);
        if (data < root.data) root.left = insertRec(root.left, data);
        else if (data > root.data) root.right = insertRec(root.right, data);
        return root;
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node root, int data) {
        if (root == null) return null;

        if (data < root.data) root.left = deleteRec(root.left, data);
        else if (data > root.data) root.right = deleteRec(root.right, data);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
        System.out.println();
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node root, int data) {
        if (root == null) return false;
        if (data == root.data) return true;
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }

    public int getLevel() {
        return getLevelRec(root);
    }

    private int getLevelRec(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(getLevelRec(node.left), getLevelRec(node.right));
    }

    public int getDegree(int data) {
        Node node = findNode(root, data);
        if (node == null) return -1;
        int degree = 0;
        if (node.left != null) degree++;
        if (node.right != null) degree++;
        return degree;
    }

    private Node findNode(Node root, int data) {
        if (root == null || root.data == data) return root;
        return data < root.data ? findNode(root.left, data) : findNode(root.right, data);
    }

    public boolean isFull() {
        return isFullRec(root);
    }

    private boolean isFullRec(Node node) {
        if (node == null) return true;
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) return false;
        return isFullRec(node.left) && isFullRec(node.right);
    }

    public boolean isStrictlyBinary() {
        return isStrictlyBinaryRec(root);
    }

    private boolean isStrictlyBinaryRec(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null)
            return isStrictlyBinaryRec(node.left) && isStrictlyBinaryRec(node.right);
        return false;
    }

    public boolean isComplete() {
        int count = countNodes(root);
        return isCompleteRec(root, 0, count);
    }

    private int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private boolean isCompleteRec(Node root, int index, int nodeCount) {
        if (root == null) return true;
        if (index >= nodeCount) return false;
        return isCompleteRec(root.left, 2 * index + 1, nodeCount)
            && isCompleteRec(root.right, 2 * index + 2, nodeCount);
    }
}

