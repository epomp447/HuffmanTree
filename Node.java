public class Node<E> {
	public E datavalue;
	public Node<E> left;
	public Node<E> right;

	public Node(E data, Node<E> leftref, Node<E> rightref) {
		datavalue = data;
		left = leftref;
		right = rightref;
	}
}