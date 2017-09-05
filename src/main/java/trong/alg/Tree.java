package trong.alg;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tommy on 2017/9/5.
 */
public class Tree {

  /**
   * The tree is complete tree or not
   *
   * @param root
   * @return
   */
  public boolean isCompleteTreeNode(TreeNode root) {
    if (root == null) {
      return false;
    }

    Queue<TreeNode> quene = new LinkedList<>();
    quene.add(root);
    boolean result = true;
    boolean hasNoChild = false;

    while (!quene.isEmpty()) {
      TreeNode current = quene.remove();
      if (hasNoChild) {
        if (current.left != null || current.right != null) {
          result = false;
          break;
        }
      } else {
        if (current.left != null && current.right != null) {
          quene.add(current.left);
          quene.add(current.right);
        } else if (current.left != null && current.right == null) {
          quene.add(current.left);
          hasNoChild = true;
        } else if (current.left == null && current.right != null) {
          result = false;
          break;
        } else {
          hasNoChild = true;
        }
      }
    }

    return result;
  }

  /**
   * Get the number of node in the level k
   *
   * @param root
   * @param k
   * @return
   */
  public int numOfkLevelTreeNode(TreeNode root, int k) {
    if (root == null || k < 1) {
      return 0;
    }

    if (k == 1) {
      return 1;
    }
    int numsLeft = numOfkLevelTreeNode(root.left,k-1);
    int numsRight = numOfkLevelTreeNode(root.right, k-1);
    return numsLeft + numsRight;
  }

  /**
   * The tree is balanced or not
   *
   * @param node
   * @return
   */
  public boolean isBalanced(TreeNode node) {
    return maxDeath2(node) != -1;
  }

  private int maxDeath2(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int left = maxDeath2(node.left);
    int right = maxDeath2(node.right);
    if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
      return -1;
    }
    return Math.max(left, right) + 1;
  }

  /**
   * calculate the node number which has no child
   *
   * @param root
   * @return
   */
  public int getNumOfNoChildNode(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    return getNumOfNoChildNode(root.left) + getNumOfNoChildNode(root.right);
  }

  /**
   * calculate the number of the tree node
   *
   * @param root
   * @return
   */
  public int getNumNode(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = getNumNode(root.left);
    int right = getNumNode(root.right);

    return left + right + 1;
  }

  /**
   * get the max death of the tree
   *
   * @param root
   * @return
   */
  public int maxDeath(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = maxDeath(root.left);
    int right = maxDeath(root.right);

    return Math.max(left, right) + 1;
  }

  /**
   * get the min death of the tree
   *
   * @param root
   * @return
   */
  public int minDeath(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return getMin(root);
  }

  /**
   * get the min death of the tree left/right
   *
   * @param node
   * @return
   */
  private int getMin(TreeNode node) {
    if (node == null) {
      return 0;
    }

    if (node.left == null && node.right == null) {
      return 1;
    }
    return Math.min(getMin(node.left), getMin(node.right)) + 1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    TreeNode left1 = new TreeNode(2);
    TreeNode right1 = new TreeNode(2);
    TreeNode left2 = new TreeNode(3);
    TreeNode left3 = new TreeNode(4);
    root.setLeft(left1);
    root.setRight(right1);
    left1.setLeft(left2);
    left2.setLeft(left3);

    Tree t = new Tree();
    System.out.println("The max death of the tree:" + t.maxDeath(root));
    System.out.println("The max death of the tree:" + t.minDeath(root));
    System.out.println("The number of the tree node:" + t.getNumNode(root));
    System.out.println("The number of node no child:" + t.getNumOfNoChildNode(root));
    System.out.println("Is balanced tree:" + t.isBalanced(root));
    System.out.println("The number of k level:" + t.numOfkLevelTreeNode(root, 3));
  }
}

class TreeNode {
  int value;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    value = val;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public TreeNode getLeft() {
    return left;
  }

  public void setLeft(TreeNode left) {
    this.left = left;
  }

  public TreeNode getRight() {
    return right;
  }

  public void setRight(TreeNode right) {
    this.right = right;
  }
}
