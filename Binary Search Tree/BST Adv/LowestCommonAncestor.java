//lc-236
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
        {
            return null;
        }

        //If root itself is equal to p or q, return root as LCA
        if(root==p || root==q)
        {
            return root;
        }

        //Recursively search for LCA in the left and right subtrees
        TreeNode leftLCA=lowestCommonAncestor(root.left,p,q);
        TreeNode rightLCA=lowestCommonAncestor(root.right,p,q);

        if(rightLCA==null)//means p and q in leftLCA
        {
            return leftLCA;
        }

        if(leftLCA==null)//means p and q in rightLCA
        {
            return rightLCA;
        }

        return root;//for condition if(leftLCA!=null && rightLCA!=null) means p in left q in right or viceversa

        // if(leftLCA!=null && rightLCA!=null)
        // //If p is found in the left subtree and q is found in the right subtree , root is LCA
        // {
        //     return root;
        // }
        // //If only one subtree contains either p or q, return that subtree.
        // return (leftLCA!=null)?leftLCA:rightLCA;
    }
}