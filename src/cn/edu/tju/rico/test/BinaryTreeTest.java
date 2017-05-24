package cn.edu.tju.rico.test;

import cn.edu.tju.rico.tree.BinaryTree;

public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTree<Character> tree = new BinaryTree<Character>();
		tree.createBinaryTree("A(B(D,E(G(I,J),M)),C(F(,H(,K)),))");

		System.out.println();
		System.out.println("tree的层次(广序)遍历 ： " + tree.levelOrder());
		System.out.println("\n----------------------------------------------\n");
		System.out.println("tree的前序遍历 (递归)： " + tree.preOrder(tree.getRoot()));
		System.out.println("tree的前序遍历 (迭代)： " + tree.preOrder());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的中序遍历 (递归)： " + tree.inOrder(tree.getRoot()));
		System.out.println("tree的中序遍历 (迭代)： " + tree.inOrder());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的后序遍历 (递归)： " + tree.postOrder(tree.getRoot()));
		System.out.println("tree的后序遍历 (迭代)： " + tree.postOrder());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的根结点 ： " + tree.getRoot());
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的高度 ： " + tree.height(tree.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		System.out.println("tree的结点数 ： " + tree.size(tree.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		// 复制并构造树
		BinaryTree<Character> tree2 = new BinaryTree<Character>(tree.getRoot());
		System.out.println("tree为 ： " + tree.printBinaryTree(tree.getRoot()));
		System.out.println("复制tree为tree2 ： " + tree2.printBinaryTree(tree2.getRoot()));
		// 判断 tree2 与 tree 是否相等
		System.out.println("tree2 与 tree 是否相等: " + tree.equals(tree2));
		System.out.println("\n----------------------------------------------\n");

		// 构建tree1
		BinaryTree<Character> tree1 = new BinaryTree<Character>();
		tree1.createBinaryTree("A(B(D,E(G(I,J),)),C(F(,H(,K)),))");
		System.out.println("tree为 ： " + tree.printBinaryTree(tree.getRoot()));
		System.out.println("构建tree1为 ： " + tree1.printBinaryTree(tree1.getRoot()));
		// 判断 tree1 与 tree 是否相等
		System.out.println("tree1 与 tree 是否相等: " + tree.equals(tree1));
		System.out.println("\n----------------------------------------------\n");

		// 根据前序遍历创建树
		BinaryTree<Character> tree3 = new BinaryTree<Character>(
				"ABC##DE#G##F###".toCharArray());
		System.out.println("根据前序遍历创建二叉树: " + tree3.printBinaryTree(tree3.getRoot()));
		System.out.println("前序遍历tree3： " + tree.preOrder(tree3.getRoot()));
		System.out.println("中序遍历tree3： " + tree.inOrder(tree3.getRoot()));
		System.out.println("后序遍历tree3： " + tree.postOrder(tree3.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		// 以广义表的形式打印二叉树
		System.out.println("以广义表的形式打印tree为 ：" + tree.printBinaryTree(tree.getRoot()));
		System.out.println("以广义表的形式打印tree1为 ：" + tree1.printBinaryTree(tree1.getRoot()));
		System.out.println("以广义表的形式打印tree2为 ：" + tree2.printBinaryTree(tree2.getRoot()));
		System.out.println("以广义表的形式打印tree3为 ：" + tree3.printBinaryTree(tree3.getRoot()));
		System.out.println("\n----------------------------------------------\n");

		// 根据tree的先序遍历和中序遍历结果构建树
		String pre = tree.preOrder().replace(" ", "");
		String in = tree.inOrder().replace(" ", "");
		BinaryTree<Character> tree4 = new BinaryTree<Character>(pre, in, true);
		System.out.println("根据tree的先序遍历和中序遍历结果构建的tree4为 ："
				+ tree.printBinaryTree(tree4.getRoot()));
		System.out.println("tree与tree4是否相等： " + tree.equals(tree4));
		System.out.println("\n----------------------------------------------\n");
		
		// 根据tree的中序遍历和后序遍历结果构建树
		String post = tree.postOrder().replace(" ", "");
		BinaryTree<Character> tree5 = new BinaryTree<Character>(in, post, false);
		System.out.println("根据tree的中序遍历和后序遍历结果构建的tree5为 ："
				+ tree.printBinaryTree(tree5.getRoot()));
		System.out.println("tree与tree5是否相等： " + tree.equals(tree5));
		
	}
}
