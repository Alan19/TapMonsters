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

	/**
	 * 
	 */
	
//	public static void main(String[] args) {
//		for (int i = 0; i < 250; i++) {
//			
//			Sequence x = new Sequence((int) (30*Math.random()));
//		}
//	}
	
	public Sequence(int numKeys) {
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		for (int i = 0; i < numKeys; i++) {
			double rand = Math.random();
			int num = (int) (4*rand);
			sequence.add(num);
		}
//		System.out.println(sequence.toString());
	}

}
