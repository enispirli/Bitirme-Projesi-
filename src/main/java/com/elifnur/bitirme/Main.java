package com.elifnur.bitirme;

import java.util.List;

public class Main {

	public static void main(String[] args) {
	
		int n = 8;
		Board board = new Board(n);
		addChild(board, n); // agacı olusturdu
		System.out.println("eklemebitti");
		Search search = new Search(board);
		List<Board> bfsResult = search.dfs();
		for(Board b : bfsResult) {
			System.out.println(b); 
		}
	}
	
	/**
	 * bir obje System.out.println içine yazıldıgında toString metodu calısır
	 * bu metod normalde obje sınıfı içerinde bulunur.
	 * her java sınıfı obje sınıfından türemiştir.
	 * eğer toString metodu ezilmezse varsayılan olarak objenin idsini yazar
	 * @param board
	 * @param n
	 */

	public static void addChild(Board board, int n) {
		board.incrementCurrentRow();
		if (board.getCurrentRow() == n) {
			return;

		}
		// sutunları dolanıyo
		for(int i=0;i<n;i++){
			Board childBoard=board.copyBoard();
			if(isValidMove(childBoard.getBoardArray(), childBoard.getCurrentRow(), i)){
				childBoard.putQueen(childBoard.getCurrentRow(), i);
				board.addChild(childBoard);
			}
			
		}
		
		for(Board childBoards: board.getChildList()){
			addChild(childBoards, n);
		}
	}
	
	

	public static boolean isValidMove(int arrayArray[][], int i, int k) {
		return checkCol(arrayArray, i, k) && checkCross(arrayArray, i, k);
	}
	
	private static boolean checkCol(int[][] boardArray, int x, int y) {
		for (int i = 0; i < boardArray.length; i++) {
			if (i == x) {
				continue;
			}
			if (boardArray[i][y] == 1) {
				return false;
			}
		}
		return true;
	}
	
	private static boolean checkCross(int[][] boardArray, int x, int y) {
		int i = x, j = y;
		while (i > 0 && j > 0) {
			if (boardArray[--i][--j] == 1) {
				return false;
			}
		}
		i = x;
		j = y;
		while (i < boardArray.length - 1 && j < boardArray.length - 1) {
			if (boardArray[++i][++j] == 1) {
				return false;
			}
		}
		i = x;
		j = y;
		while (i < boardArray.length - 1 && j > 0) {
			if (boardArray[++i][--j] == 1) {
				return false;
			}
		}
		i = x;
		j = y;
		while (i > 0 && j < boardArray.length - 1) {
			if (boardArray[--i][++j] == 1) {
				return false;
			}
		}
		return true;
	}


}