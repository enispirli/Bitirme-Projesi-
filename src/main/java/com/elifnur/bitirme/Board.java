package com.elifnur.bitirme;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private int[][] boardArray;

	private List<Board> childList;
	private int currentRow;

	public Board() {
		currentRow = -1;
		childList = new ArrayList<Board>();
	}

	public Board(int n) {
		// her oluşturulan tahtanın aktif rowu -1 olcak ve her
		// taş koyuldugunda 1 artcak
		currentRow = -1;
		boardArray = new int[n][n]; // nxn lik bir array
		childList = new ArrayList<Board>(); // boş cocuklar
		fillWithZero();

	}

	private void fillWithZero() { // tahtanın içi 0 larla doldurulur
		for (int i = 0; i < boardArray.length; i++) {
			for (int k = 0; k < boardArray.length; k++) {
				boardArray[i][k] = 0;

			}
		}
	}

	/*
	 * aktif satırı bir artırır
	 */
	public void incrementCurrentRow() {
		currentRow++;
	}

	/*
	 * verilen koordinatlara vezir koyar
	 * 
	 */
	public void putQueen(int i, int k) {
		boardArray[i][k] = 1;
	}

	/*
	 * gönderilen tahta objesini cocuk listesine ekler
	 */
	public void addChild(Board board) {
		childList.add(board);

	}

	public Board copyBoard() {
		Board copyBoard = new Board();
		copyBoard.setCurrentRow(getCurrentRow());
		copyBoard.setBoardArray(copyArray(getBoardArray()));
		return copyBoard;
	}

	/*
	 * kendisine gelen dizi yeni olusturuduguu bir diziye atayıp geri döner
	 */
	private int[][] copyArray(int[][] array) {
		int[][] copyArray = new int[array.length][array.length];
		for (int i = 0; i < array.length; i++) {
			for (int k = 0; k < array.length; k++) {
				copyArray[i][k] = array[i][k];
			}
		}
		return copyArray;
	}

	public int[][] getBoardArray() {
		return boardArray;
	}

	public void setBoardArray(int[][] boardArray) {
		this.boardArray = boardArray;
	}

	public List<Board> getChildList() {
		return childList;
	}

	public void setChildList(List<Board> childList) {
		this.childList = childList;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < boardArray.length; i++) {
			for (int j = 0; j < boardArray.length; j++) {
				s += boardArray[i][j];
			}
			s += "\n";
		}
		s += "----------";
		return s;
	}

}
