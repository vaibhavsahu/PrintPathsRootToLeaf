package com.vaibhav.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }


    public static List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return new ArrayList<String>();
        }

        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();

        binaryTreePathsHelper(root, stack, list);

        return list;

    }

    public static void binaryTreePathsHelper(TreeNode root, Stack<String> stack, List<String> list) {
        if(root == null){
            return;
        }

       stack.push(String.valueOf(root.val));
        if(root.left != null){
            binaryTreePathsHelper(root.left, stack, list);
        }
        if(root.left == null && root.right == null){
            String result = printListToString(stack);
            list.add(result);
        }

        if(root.right != null){
            binaryTreePathsHelper(root.right, stack, list);
        }
        stack.pop();
    }

    public static String printListToString(Stack<String> stack) {
          List<String> list = new ArrayList(stack);
        String result = "";
          if(!stack.isEmpty()){
              result = list.stream().collect(Collectors.joining("->"));
          }
          return result;
    }
}


public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        System.out.println(TreeNode.binaryTreePaths(root));
    }
}
