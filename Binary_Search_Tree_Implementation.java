class TreeNode{
	int data;
	TreeNode left,right;
	public TreeNode(int data) {
		this.data = data;
	}
}

class Binary_Search_Tree{
	TreeNode root;
	
	public void insert(int data) {
		if(root==null) {
			root = new TreeNode(data);
			return ;
		}
		insertNode(root, data);
	}
	
	public TreeNode insertNode(TreeNode root, int data) {
		if(root==null) 
			return new TreeNode(data);
		
		if(data<root.data)
			root.left = insertNode(root.left, data);
	
		else
			root.right = insertNode(root.right,data);
		
		return root;
	}
	
	public void InOrder(TreeNode root) {
		if(root==null) return;
		
		InOrder(root.left);
		System.out.print(root.data+" ");
		InOrder(root.right);
	}
	
	public void PreOrder(TreeNode root) {
		if(root==null) return;
		
		System.out.print(root.data+" ");
		PreOrder(root.left);
		PreOrder(root.right);
	}
	
	public void PostOrder(TreeNode root) {
		if(root==null) return;
		
		PostOrder(root.left);
		PostOrder(root.right);
		System.out.print(root.data+" ");
	}
	
	public void Search(TreeNode root, int data) {
		if(root==null) {
			System.out.println("Element "+ data +" not found");
			return;
		}
		
		if(root.data == data) {
			System.out.println("Element "+data+" found");
			return;
		}
		else if(data<root.data) {
			Search(root.left, data);
		}
		else
			Search(root.right,data);
		
	}
	
	public int Maximum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		if(root.right==null)
			return root.data;
	
		return Maximum(root.right);
	}
	
	public int Minimum(TreeNode root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null)
			return root.data;
	
		return Minimum(root.left);
	}
	
	public TreeNode delete(TreeNode root, int data) {
		if(root==null) {
			return root;
		}
		
		if(data<root.data)
			root.left = delete(root.left, data);
		
		else if(data>root.data)
			root.right = delete(root.right,data);
		
		else {
			if(root.left==null)
				return root.right;
			if(root.right==null)
				return root.left;
			
			root.data = Minimum(root.right);
			delete(root.right, root.data);
		}
		
		return root;
	}
}

public class Binary_Search_Tree_Implementation {
	public static void main(String[] args) {
		Binary_Search_Tree t = new Binary_Search_Tree();
		t.insert(50);
		t.insert(30);
		t.insert(55);
		t.insert(34);
		t.insert(63);
		t.insert(2);
		t.insert(10);
		
		System.out.print("InOrder Traversal : ");
		t.InOrder(t.root);
		
		System.out.print("\n\nPreOrder Traversal : ");
		t.PreOrder(t.root);
		
		System.out.print("\n\nPostOrder Traversal : ");
		t.PostOrder(t.root);
		
		System.out.println("\n\nSearching : ");
		t.Search(t.root, 30);
		t.Search(t.root, 20);
		
		if(t.Maximum(t.root)!=0) 
		System.out.println("\nMaximum element : "+ t.Maximum(t.root));
		else 
			System.out.println("No Tree exist");
		
		if(t.Minimum(t.root)!=0)
			System.out.println("\nMinimum Element : "+ t.Minimum(t.root));
		else 
			System.out.println("No Tree exist");
		
		t.delete(t.root, 30);

		System.out.print("After delete the element 30 : \n ");
		System.out.print("InOrder Traversal : ");
		t.InOrder(t.root);
		
		System.out.print("\n\nPreOrder Traversal : ");
		t.PreOrder(t.root);
		
		System.out.print("\n\nPostOrder Traversal : ");
		t.PostOrder(t.root);
	}
}
