package ed.lab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class E01FlattenBT {

    public void flatten(TreeNode<Integer> root) {
        List<Integer>  listaOrdenada = new LinkedList<>();
        preorder(root, listaOrdenada);

    }
    public List<Integer> preorder(TreeNode<Integer> root, List<Integer> result){
        if(root==null)
            return result;
        Stack<TreeNode> stack = new Stack();

        if(root.right!=null){
            stack.push(root.right);
        }
        if(root.left!=null){
            stack.push(root.left);
        }
        //iterador
        TreeNode current = root;

        while(!stack.isEmpty()){
            TreeNode<Integer> node = stack.pop(); //removiendo los nodos del stack
            current.right = node;
            current.left = null;
            current = current.right;
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

}
