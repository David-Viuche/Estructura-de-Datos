package URI_Tree_Recovery_1191;
/*Author: David Viuche 
 * 
 * Arbol binario implementado para funcionar con letras
 * */

public class Tree {

	// vector de letras del abecedario que se usa para convertir las letras a
	// numeros para la insercion
	static String[] alphabet = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" };

	// nodo raiz del arbol
	Node root = null;

	// funcion para verificar si el arbol esta vacio
	public boolean isEmpty() {
		return root == null ? true : false;
	}

	// funcion para insertar una letra al arbol
	public void insert(String letter) {
		// se hace la conversion de la letra a la posicion en el arreglo de letras
		int value = this.getIndex(letter);

		// se realiza la insercion normal en un arbol binario de numeros
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

	// funcion que imprime el recorrido por preorden
	public static void preorder(Node node) {
		if (node != null) {
			System.out.print(alphabet[node.value] );
			preorder(node.left);
			preorder(node.right);
		}
	}

	// funcion que imprime el recorrido por postorden
	public static void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(alphabet[node.value] );
		}
	}

	// funcion que imprime el recorrido por inorden
	public static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(alphabet[node.value] );
			inorder(node.right);
		}
	}

	// funcion que busca en el arbol la letra que recibe por parametro imprime "nao
	// existe" si la letra no existe y "existe" si la letra si existe
	public void search(String letter) {
		int value = this.getIndex(letter);
		Node temp = root;
		while (temp != null) {

			if (temp.value == value)
				break;

			else if (value < temp.value)
				temp = temp.left;
			else
				temp = temp.right;
		}
		if (temp == null) {
			System.out.print(letter + " nao existe");
		} else {
			System.out.print(letter + " existe");
		}
	}

	//retorna el indice en que esta la letra en el arreglo para la conversion
	public int getIndex(String letter) {
		int index = 0;
		for (int i = 0; i < alphabet.length; i++) {
			if (alphabet[i].equals(letter))
				break;
			index++;
		}
		return index;
	}

}
