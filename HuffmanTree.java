package HuffmanTree;

import java.io.*;
import java.util.*;




public class HuffmanTree implements Serializable {



	public static class HuffData implements Serializable {
		private final int frequency;
		private final char symbol;

		public HuffData(int f, char c) {
			this.frequency = f;
			this.symbol = c;
		}

		public char getSymbol() {
			return symbol;
		}
	}

	private BinaryTree<HuffData> huffTree;

	public void buildTree(HuffData[] symbols) {
		Queue<BinaryTree<HuffData>> theQueue = new PriorityQueue<>(symbols.length,
				(lt, rt) -> Integer.compare(lt.getData().frequency, rt.getData().frequency));

		for (HuffData nextSymbol : symbols) {
			BinaryTree<HuffData> aBinaryTree = new BinaryTree<>(nextSymbol, null, null);
			theQueue.offer(aBinaryTree);
		}
		while (theQueue.size() > 1) {
			BinaryTree<HuffData> left = theQueue.poll();
			BinaryTree<HuffData> right = theQueue.poll();
			int wl = left.getData().frequency;
			int wr = right.getData().frequency;
			HuffData sum = new HuffData(wl + wr, '\u0000');
			BinaryTree newTree = new BinaryTree<>(sum, left, right);
			theQueue.offer(newTree);
		}
		huffTree = theQueue.poll();
	}

	private void printCode(PrintStream out, String code, BinaryTree<HuffData> tree) {
		HuffData theData = tree.getData();
		if (theData.symbol != '\u0000') {
			if (theData.symbol == ' ') {
				out.println("space: " + code);
			} else {
				out.println(theData.symbol + ": " + code);
			}
		} else {
			printCode(out, code + "0", tree.getLeftSubtree());
			printCode(out, code + "1", tree.getRightSubtree());
		}

	}

	/**
	 * Outputs the resulting code.
	 *
	 * @param out
	 *            A PrintStream to write the output to
	 */
	public void printCode(PrintStream out) {
		printCode(out, "", huffTree);
	}

	/**
	 * Method to decode a message that is input as a string of digit characters '0'
	 * and '1'.
	 *
	 * @param codedMessage
	 *            The input message as a String of zeros and ones.
	 * @return The decoded message as a String
	 */
	public String decode(String codedMessage) {
		StringBuilder result = new StringBuilder();
		BinaryTree<HuffData> currentTree = huffTree;
		for (int i = 0; i < codedMessage.length(); i++) {
			if (codedMessage.charAt(i) == '1') {
				currentTree = currentTree.getRightSubtree();
			} else {
				currentTree = currentTree.getLeftSubtree();
			}
			if (currentTree.isLeaf()) {
				HuffData theData = currentTree.getData();
				result.append(theData.symbol);
				currentTree = huffTree;
			}
		}
		return result.toString();
	}
}
