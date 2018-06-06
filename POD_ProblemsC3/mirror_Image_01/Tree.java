package mirror_Image_01;

public class Tree {

	//nodo principal del arbol
	Node root = null;

	//metodo para saber si el arbol esta vacio
	public boolean isEmpty() {
		return root == null ? true : false;
	}

	//metodo que busca un nodo en el arbol
	public Node searchMirror(Node node, int value) {

		Node temp = root;

		if (node != null) {
			if (node.value == value) {
				temp = node;
			}
			searchMirror(node.left, value);
			searchMirror(node.right, value);

		}
		return temp;
	}
	
	

	//metodo que busca un nodo en el arbol
	public Node searchMirror2(Node node, int value) {
		if (node != null) {
			if (node.value == value) {
				return node;
			}
			if (node.left != null) {
				searchMirror2(node.left, value);

			} else if (node.right != null) {
				searchMirror2(node.right, value);
			}

		}
		return null;
	}

	//metodo que inserta un nodo en el arbol
	public void insertMirror(int par, int value, String dir, Node node) {
		if (node != null) {

			if (node.value == par) {
				if (dir.equals("R")) {
					node.right = new Node(value);
				} else if (dir.equals("L")) {
					node.left = new Node(value);
				}
			} else {
				insertMirror(par, value, dir, node.right);
				insertMirror(par, value, dir, node.left);
			}

		}
	}

	//metodo que retorna el nodo espejo de un nodo 
	public void mirrorNode(int value, Node node) {
		if (node != null) {

			if(node.right != null) {
				mirrorNode(value, node.right);
				if (node.right.value == value) {
					
					System.out.println(node.left.value);
					
				} else if (node.left.value == value) {
					
					System.out.println(node.right.value);
					
				}
			}else
			if(node.left != null) {
				mirrorNode(value, node.left);
			
			
			if (node.right.value == value) {
				
				System.out.println(node.left.value);
				
			} else if (node.left.value == value) {
				
				System.out.println(node.right.value);
				
			}
			}
		}
	}

//	public int mirrorNode(int value) {
//		Node parent = parent(value);
//
//		if (parent.right.value != value) {
//
//			if (parent.right == null)
//				return -1;
//			else
//				return parent.right.value;
//
//		} else if (parent.left.value != value)
//
//			if (parent.left == null)
//				return -1;
//			else
//				return parent.left.value;
//
//		return 0;
//	}
	

	public static void preorder(Node node) { // preorder
		if (node != null) {
			System.out.print(node.toString() + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public static void postorder(Node node) { // postorder
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.toString() + " ");
		}
	}

	public static void inorder(Node node) { // inorder
		if (node != null) {
			inorder(node.left);
			System.out.print(node.toString() + " ");
			inorder(node.right);
		}
	}

	
	
	


	
	
	
	

}
