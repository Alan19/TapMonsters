/**
 * 
 */
package main;

import java.util.ArrayList;

/**
 * @author Max
 *
 */
public class Sequence {

	private ArrayList<Integer> sequence;

	/**
	 * @return 
	 * @return 
	 * 
	 */
	
/**	public static void main(String[] args) {
		Sequence x = new Sequence(10);
		/**for (int i = 0; i < x.getSequence().size(); i++) {
			System.out.println(x.getSequence().get(i));
		}
		System.out.println(x.getSequence().get(1));

	}*/
	
	public Sequence(int numKeys) {
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		for (int i = 0; i < numKeys; i++) {
			double rand = Math.random();
			int num = (int) (4*rand);
			sequence.add(num);
		}
		this.setSequence(sequence);
//		System.out.println(sequence.toString());
	}

	public ArrayList<Integer> getSequence() {
		return sequence;
	}

	public void setSequence(ArrayList<Integer> sequence) {
		this.sequence = sequence;
	}

}
