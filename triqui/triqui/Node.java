package triqui;

import java.io.IOException;

public class Node {
	
	int[][] board1;

	Node next = null;

	public Node(int[][] board) {

		this.board1 = board;

	}
	
	public Node clone() {
		int m1 = this.board1[0][0];
		int m2 = this.board1[0][1];
		int m3 = this.board1[0][2];
		int m4 = this.board1[1][0];
		int m5 = this.board1[1][1];
		int m6 = this.board1[1][2];
		int m7 = this.board1[2][0];
		int m8 = this.board1[2][1];
		int m9 = this.board1[2][2];
		int[][] ret = {{m1,m2,m3},{m4,m5,m6},{m7,m8,m9}};
		return  new Node(ret);
	}


	public String toString() {
		String temp = "";

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				temp += this.board1[i][j] == 0 ? "-\t" : (this.board1[i][j] == 1 ? "O\t" : "X\t");

			}
			temp += "\n";
		}

		return temp;
	}
	
	public boolean isEqual(Node compar) {
		
		return this.board1 == compar.board1 ? true : false;
	}
	
	public boolean isFull() {
		boolean flag = false;
		int counter=0; 
		for (int i = 0; i < board1.length; i++) {
			for (int j = 0; j < board1.length; j++) {
				if(this.board1[i][j]!=0) {
					counter++;
				}
			}
		}
		
		if(counter == 9){
			flag = !flag;
		}
		return flag;
	}
	
	public List listTriquiSucessor( int symbol) throws IOException {

		List ret = new List();
		if(this.isFull()==false) {
			ret.insertAtEnd(this.clone());
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					
					if (this.board1[i][j] == 0) {
						Node newSucessor = this.clone();
						newSucessor.board1[i][j] = symbol;
						ret.insertAtEnd(newSucessor);
					}
				}
				
			}
		}
		
		
		
		 return ret;
	}
}
