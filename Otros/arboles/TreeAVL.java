package arboles;

public class TreeAVL {

	Node root = null;//raiz del arbol

	// metodo que verifica si el arbol esta vacio
	public boolean isEmpty() {
		return root == null ? true : false;
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

	// public int unbalance_factor(Node node) {
	//
	// return nodeHeigth(node.left) - nodeHeigth(node.right);
	//
	// }

	//metodo que retorna el factor de desbalanceo en un nodo especifico
	public int unbalance_factor(Node node) {
		if (node.left == null && node.right != null) {
			
			return nodeHeigth(node.left) - nodeHeigth(node.right) - 1;
			
		} else if (node.left != null && node.right == null) {
			
			return nodeHeigth(node.left) + 1 - nodeHeigth(node.right);
			
		} else if (node.left != null && node.right != null) {
			
			return nodeHeigth(node.left) + 1 - nodeHeigth(node.right) - 1;
			
		}
		return 0;
	}

	//metodo que retorna el padre de un nodo
	public Node parent(Node node) {

		if (node == root)
			return root;
		else {
			Node temp = root;
			Node parent = root;
			while (temp != null) {

				if (node.value == temp.value)
					break;
				else {
					parent = temp;
					if (node.value < temp.value)
						temp = temp.left;
					else
						temp = temp.right;

				}
			}

			if (temp == null)
				parent = null;
			return parent;
		}

	}

	// rotacion simple a la derecha
	public void rotationRight(int value) {

		Node padre = search(value);
		if (padre == root) {

			Node nPadre = padre.left;
			padre.left = nPadre.right;
			nPadre.right = padre;
			root = nPadre;
		} else {

			Node temp = parent(padre);
			Node nPadre = padre.left;
			padre.left = nPadre.right;
			nPadre.right = padre;
			if (temp.value > nPadre.value)
				temp.left = nPadre;
			else
				temp.right = nPadre;

		}

	}

	// rotacion simple a la izquierda
	public void rotationLeft(int value) {
		Node padre = search(value);
		if (padre == root) {

			Node nPadre = padre.right;
			padre.right = nPadre.left;
			nPadre.left = padre;
			root = nPadre;
		} else {
			Node temp = parent(padre);
			Node nPadre = padre.right;
			padre.right = nPadre.left;
			nPadre.left = padre;
			if (temp.value < nPadre.value)
				temp.right = nPadre;
			else
				temp.left = nPadre;
		}
	}

	// rotacion doble a la derecha
	public void doubleRotationRight(int value) {
		Node padre = search(value);
		rotationRight(padre.right.value);
		rotationLeft(value);

	}

	// rotacion doble a la izquierda
	public void doubleRotationLeft(int value) {
		Node padre = search(value);
		rotationLeft(padre.left.value);
		rotationRight(value);

	}

	//metodo que inserta un nuevo nodo en el arbol
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
		balance(search(value));
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

	//metodo que balancea el arbol
	public void balance(Node newNode) {

		if (unbalance_factor(newNode) < -1) {

			if (unbalance_factor(newNode.right) == 1)

				doubleRotationRight(newNode.value);
			else
				rotationLeft(newNode.value);

		} else if (unbalance_factor(newNode) > 1) {

			if (unbalance_factor(newNode.left) == -1)

				doubleRotationLeft(newNode.value);

			else

				rotationRight(newNode.value);
		}

		if (newNode != root) {
			balance(parent(newNode));
		}
	}

	public static void main(String[] args) {
		TreeAVL test = new TreeAVL();
		
//		 test.insert(15);
//		 test.insert(10);
//		 test.insert(20);
//		 test.insert(5);
//		 test.insert(13);
//		 test.insert(16);
//		 test.insert(8);
//		 test.insert(11);
//		 test.insert(14);
//		 test.insert(12);

//		 test.insert(10);
//		 test.insert(2);
//		 test.insert(4);
//		 test.insert(6);
//		 test.insert(8);

		test.insert(30);
		test.insert(15);
		test.insert(40);
		test.insert(10);
		test.insert(20);
		test.insert(18);

		preorder(test.root);
	}

}
