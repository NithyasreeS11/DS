package Graph;
import java.util.*;

class TNode{
	int data;
	TNode left,right;
	
	TNode(int data){
		this.data= data;
		left = right = null;
	}
}

class Tree{
	TNode root;
	public Tree(int data) {
		root = new TNode(data);
	}
	
	public void insertLeft(TNode root, int data) {
		root.left = new TNode(data);
	}
	
	public void insertRight(TNode root, int data) {
		root.right = new TNode(data);
	}
	
	public void delete(int key) {
		if(root==null) return;
		
		if(root.left==null && root.right==null) {
			if(root.data==key) {
				root = null;
				return;
			}
		}
		
		Queue<TNode> q = new LinkedList<>();
		q.add(root);
		TNode temp =null, keyNode = null, parent = null;
		while(!q.isEmpty()) {
			temp = q.poll();
			if(temp.data==key) {
				keyNode=temp;
			}
			
			if(temp.left!=null) {
				q.add(temp.left);
				parent = temp;
			}
			
			if(temp.right!=null) {
				q.add(temp.right);
				parent = temp;
			}
		}
		
		if(keyNode!=null) {
			keyNode.data = temp.data;
			if(parent.left == temp)
				parent.left=null;
			else if(parent.right == temp)
				parent.right=null;
		}
		
	}
	
	public void InOrder(TNode root) {
		if(root==null) return;
		InOrder(root.left);
		System.out.print(root.data+" ");
		InOrder(root.right);
	}
	
	public void PreOrder(TNode root) {
		if(root==null) return;
		System.out.print(root.data+" ");
		PreOrder(root.left);
		PreOrder(root.right);
	}
	
	public void PostOrder(TNode root) {
		if(root==null) return;
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.print(root.data+" ");
	}
}
public class Binary_Tree_Implementation {
	public static void main(String[] args) {
		Tree t = new Tree(1);
		t.insertLeft(t.root, 2);
		t.insertRight(t.root, 3);
		t.insertLeft(t.root.left,4);
		t.insertRight(t.root.left, 5);
		t.insertLeft(t.root.right, 6);
		
		/*
		Tree t = new Tree();
        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(3);
        t.root.left.left = new Node(4);
        t.root.left.right = new Node(5);
        t.root.right.left = new Node(6);
		 */
		System.out.print("InOrder Traversal : ");
		t.InOrder(t.root);

		System.out.print("\nPreOrder Traversal : ");
		t.PreOrder(t.root);

		System.out.print("\nPostOrder Traversal : ");
		t.PostOrder(t.root);
		
		t.delete(5);
		
		System.out.println("\n\nAfter delete the node 5 : ");
		System.out.print("InOrder Traversal : ");
		t.InOrder(t.root);

		System.out.print("\nPreOrder Traversal : ");
		t.PreOrder(t.root);

		System.out.print("\nPostOrder Traversal : ");
		t.PostOrder(t.root);
		
	}
}
