package com.elifnur.bitirme;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Search {

	private Board board;

	public Search(Board board) {
		this.board = board;
	}

	public List<Board> bfs() {
		Queue<Board> queue = new LinkedList<Board>();
		ArrayList<Board> explored = new ArrayList<Board>();
		queue.add(board);

		while (!queue.isEmpty()) {
			Board temp = queue.remove();
			if (temp.getCurrentRow() == temp.getBoardArray().length ) {
				explored.add(temp);
				return explored;
			} else {
				queue.addAll(temp.getChildList());
			}
			explored.add(temp);
		}

		return explored;
	}

	public List<Board> dfs() {
		Stack<Board> stack = new Stack<Board>();
		ArrayList<Board> explored = new ArrayList<Board>();

		stack.push(board);

		while (!stack.isEmpty()) {
			Board temp = stack.pop();
			if (temp.getCurrentRow() == temp.getBoardArray().length ) {
				explored.add(temp);
				return explored;
			} else {
				List<Board> childList = temp.getChildList();
				for (int i = childList.size() - 1; i >= 0; i--) {
					stack.push(childList.get(i));

				}

			}
			explored.add(temp);
		}

		// hiç çözüm bulamazsa burdan return olcak
		return explored;
	}
}
