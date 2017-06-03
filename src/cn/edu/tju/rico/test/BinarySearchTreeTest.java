package cn.edu.tju.rico.test;

import cn.edu.tju.rico.BinarySearchTree.BinarySearchTree;

public class BinarySearchTreeTest {
	public static void main(String[] args) {
		int[] input = {53,78,65,17,87,9,81,45,23};
		BinarySearchTree tree = new BinarySearchTree(input);
		
		System.out.println("中序遍历二叉搜索树：");
		tree.inOrder(tree.getRoot());
		System.out.println();
		System.out.println("\n------------------------\n");
		System.out.println("打印二叉搜索树：");
		tree.printTree(tree.getRoot());
		System.out.println();
		System.out.println("\n------------------------\n");
		
		System.out.println("二叉搜索树搜索目标值：");
		System.out.println(tree.search(23, tree.getRoot()));
		System.out.println("\n------------------------\n");
		
		System.out.println("向二叉搜索树插入目标值：");
		tree.insert(10, tree.getRoot());
		tree.printTree(tree.getRoot());
		System.out.println();
		System.out.println("\n------------------------\n");
		
		System.out.println("向二叉搜索树删除目标值：");
		tree.remove(78, tree.getRoot());
		tree.printTree(tree.getRoot());
		System.out.println();
		System.out.println("\n------------------------\n");
	}
}
