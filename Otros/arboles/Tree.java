package arboles;

public class Tree {

	Node root = null;//raiz del arbol

	// metodo que verifica si el arbol esta vacio
	public boolean isEmpty() {
		return root == null ? true : false;
	}

	//metodo que inserta un nodo en el arbol
	public void insert(int value) {

		if (isEmpty()) {
			Node newNode = new Node(value);
			root = newNode;
		} else {

			Node temp = root;
			Node parent = root;

			while (temp != null) {

				parent = temp;

				if (value < temp.value)
					temp = temp.left;
				else
					temp = temp.right;

			}

			Node newNode = new Node(value);

			if (value < parent.value)
				parent.left = newNode;
			else
				parent.right = newNode;
		}

	}

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

	//metodo que busca un valor en el arbol
	public Node search(int value) {
		Node temp = root;

		while (temp != null) {

			if (temp.value == value)
				break;

			else if (value < temp.value)
				temp = temp.left;
			else
				temp = temp.right;
		}

		return temp;
	}

	//metodo que verifica si un nodo es una hoja
	public boolean isleaf(Node node) {
		return (node.left == null && node.right == null ? true : false);
	}

	//metodo que verifica si un nodo solo tiene un hijo
	public boolean oneChild(Node node) {
		return (node.left != null && node.right != null ? false : true);
	}

	public Node lessNode(Node node) {
		Node less = node.left;
		while (less != null) {
			node = node.left;
			less = less.left;
		}

		delete(node.value);
		
		return node;
	}

	//metodo que elimina un nodo del arbol
	public void delete(int value) {
		Node temp = root;
		Node parent = root;
		while (temp != null) {

			if (temp.value == value)
				break;

			else {

				parent = temp;
				if (value < temp.value)

					temp = temp.left;
				else
					temp = temp.right;
			}

		}

		if (temp == null)
			System.out.println("No existe ese nodo");
		else {
			if (isleaf(temp)) {
				temp = null;
				if (value < parent.value)
					parent.left = null;
				else
					parent.right = null;

			} else {

				if (oneChild(temp)) {

					if (temp.left != null) {

						if (value < parent.value)
							parent.left = temp.left;
						else
							parent.right = temp.left;

					} else {
						if (value < parent.value)
							parent.left = temp.right;
						else
							parent.right = temp.right;
					}

					temp = null;
				} else {

					Node temp2 = temp.right;

					if (temp2.left == null) {

						temp2.left = temp.left;
						if (value < parent.value)
							parent.left = temp2;
						else
							parent.right = temp2;
					} else {

						// dos hijos hacer balanceo de arboles

						Node temp3 = lessNode(temp2.right);
						temp2.value = temp3.value;
					}

				}
			}
		}

	}
	
	//rotacion simple a la derecha
	public void rotationRight(int value) {
		
		Node padre = this.search(value);
//		parent(new Node(value));
		Node nPadre = padre.left;
		
		padre.left = nPadre.right;
		
		padre = nPadre;
		nPadre.right = padre;
		
	}
	
	//metodo que retorna el padre de un nodo
	public Node parent(int value) {
		Node temp = root;
		Node parent = root;
		while (temp != null) {

			if (temp.value == value)
				break;

			else if (value < temp.value) {
				parent = temp;
				temp = temp.left;
			}else {
				parent = temp;
				temp = temp.right;
			}
		}
		
		return parent;
	}

	//rotacion simple a la derecha
	public Node rotationRight(Node padre) {
		
		
		Node nPadre = padre.left;
		padre.left = nPadre.right;
		nPadre.right = padre;
		
		return nPadre;
	}
	
	//rotacion simple a la izquierda
	public Node rotationLeft(Node padre) {
		
		
		Node nPadre = padre.left;
		padre.left = nPadre.right;
		nPadre.right = padre;
		
		return nPadre;
	}
	
	public static void main(String[] args) {

		Tree treeTest = new Tree();

		treeTest.insert(5);
		treeTest.insert(8);
		treeTest.insert(6);
		treeTest.insert(2);
		treeTest.insert(3);
		treeTest.insert(1);

		// System.out.println("Preorder");
		// preorder(treeTest.root);
		//
		// System.out.println("\n\nPostorder");
		// postorder(treeTest.root);
		//
		// System.out.println("\n\ninorder");
		// inorder(treeTest.root);

		
//		preorder(treeTest.root);
//		System.out.println(treeTest.search(6));
//		treeTest.delete(6);
		
//		 treeTest.rotationRight(5);
		
		System.out.println(treeTest.parent(6).toString());
		preorder(treeTest.root);

		
		
	}

}
