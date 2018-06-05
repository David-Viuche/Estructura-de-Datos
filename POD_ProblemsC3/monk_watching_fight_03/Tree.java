package monk_watching_fight_03;


public class Tree {

	//nodo principal del arbol
	Node root = null;

	//metodo para saber si el arbol esta vacio 
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

	//metodo que retorna la altura del arbol
	public int nodeHeigth(Node node) {

		if (node == null || isleaf(node))
			return 0;
		else {

			return nodeHeigth(node.left) > nodeHeigth(node.right) ? nodeHeigth(node.left) + 1
					: nodeHeigth(node.right) + 1;

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

	//metodo que busca un nodo en el arbol 
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

	//metodo para saber si un nodo es una hoja
	public boolean isleaf(Node node) {
		return (node.left == null && node.right == null ? true : false);
	}

	//metodo para saber si un nodo solo tiene un hijo
	public boolean oneChild(Node node) {
		return (node.left != null && node.right != null ? false : true);
	}

	//metodo para borrar un nodo hoja
	public Node lessNode(Node node) {
		Node less = node.left;
		while (less != null) {
			node = node.left;
			less = less.left;
		}

		delete(node.value);
		
		return node;
	}

	//metodo para borrar un nodo
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
	
	
	
	


	
	

}
