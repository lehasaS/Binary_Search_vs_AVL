// Hussein's AVL Tree
// 2 April 2017
// Hussein Suleman
// reference: kukuruku.co/post/avl-trees/

public class AVLTree extends BinaryTree
{
   public int insertionCounter=0;
   public int findCounter=0;
   public int height ( BinaryTreeNode node )
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   public int balanceFactor ( BinaryTreeNode node )
   {
      return height (node.right) - height (node.left);
   }
   
   public void fixHeight ( BinaryTreeNode node )
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   public BinaryTreeNode rotateRight ( BinaryTreeNode p )
   {
      BinaryTreeNode q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }

   public BinaryTreeNode rotateLeft ( BinaryTreeNode q )
   {
      BinaryTreeNode p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   public BinaryTreeNode balance ( BinaryTreeNode p )
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }

   public void insert ( Loadshedding d )
   {
      root = insert (d, root);
   }
   public BinaryTreeNode insert ( Loadshedding d, BinaryTreeNode node )
   {
      insertionCounter++;
      if (node == null)
         return new BinaryTreeNode (d, null, null);
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
   }
   
   public void delete ( Loadshedding d )
   {
      root = delete (d, root);
   }   
   public BinaryTreeNode delete ( Loadshedding d, BinaryTreeNode node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else
      {
         BinaryTreeNode q = node.left;
         BinaryTreeNode r = node.right;
         if (r == null)
            return q;
         BinaryTreeNode min = findMin (r);
         min.right = removeMin (r);
         min.left = q;
         return balance (min);
      }
      return balance (node);
   }

   public void resetInsertCounter(){
      insertionCounter=0;
   }

   public int returnInsertCounter(){
      return insertionCounter;
   }

   public void resetFindCounter(){
      findCounter = 0;
   }

   public int returnFindCounter(){
      return findCounter;
   }

   public BinaryTreeNode findMin ( BinaryTreeNode node )
   {
      if (node.left != null)
         return findMin (node.left);
      else
         return node;
   }

   public BinaryTreeNode removeMin ( BinaryTreeNode node )
   {
      if (node.left == null)
         return node.right;
      node.left = removeMin (node.left);
      return balance (node);
   }

   public BinaryTreeNode find ( Loadshedding d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   public BinaryTreeNode find ( Loadshedding d, BinaryTreeNode node )
   {
      findCounter++;
      int cmp = d.compareTo (node.data);
      if (cmp == 0)
         return node;
      else if (cmp < 0)
         return (node.left == null) ? null : find (d, node.left);
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   
   public void treeOrder ()
   {
      treeOrder (root, 0);
   }
   public void treeOrder ( BinaryTreeNode node, int level )
   {
      if (node != null)
      {
         for ( int i=0; i<level; i++ )
            System.out.print (" ");
         System.out.println (node.data);
         treeOrder (node.left, level+1);
         treeOrder (node.right, level+1);
      }
   }
}

