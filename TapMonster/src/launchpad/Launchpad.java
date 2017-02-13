package launchpad;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.sound.midi.Transmitter;
import javax.sound.midi.MidiDevice.Info;

import java.util.Arrays;
import java.util.ArrayList;

public class Launchpad {
	
	public static final int WHITE = 3;
	public static final int RED = 5;
	public static final int GREEN = 21;
	public static final int BLUE = 49;
	public static final int YELLOW = 13;
	
//	CHANNEL NUMBERING IN JAVA STARTS AT 0, IN MIDI STARTS AT 1
	public static final int FLASH = 1;
	public static final int PULSE = 2;
	public static final int SOLID = 5;
	
	public static final int NOTE_ON = 0x90;
	
	
	public static int[][] messageOutline = {
			{0,1},
			{0,2},
			{0,3},
			{0,4},
			{0,5},
			{0,6},
			{1,0},
			{1,7},
			{2,0},
			{2,7},
			{3,0},
			{3,7},
			{4,1},
			{4,2},
			{4,3},
			{4,4},
			{4,5},
			{4,6},
			{5,1},
			{5,2},
			{6,1}
			};
	
	public static int[][] exclamationMark = {
			{0,3},
			{0,4},
			{1,3},
			{1,4},
			{2,3},
			{2,4},
			{3,3},
			{3,4},
			{4,3},
			{4,4},
			
			{6,3},
			{6,4},
			{7,3},
			{7,4},
			};
	
	public static int[][] plus6x6 = {
			{1,3},
			{1,4},
			{2,3},
			{2,4},

			{3,1},
			{3,2},
			{3,3},
			{3,4},
			{3,5},
			{3,6},
			
			{4,1},
			{4,2},
			{4,3},
			{4,4},
			{4,5},
			{4,6},
			
			{5,3},
			{5,4},
			{6,3},
			{6,4},
			};

	public static int[][] questionMark = {
			{0,2},
			{0,3},
			{0,4},
			{0,5},
			
			{1,2},
			{1,3},
			{1,4},
			{1,5},
			{1,6},
			
			{2,5},
			{2,6},
			
			{3,3},
			{3,4},
			{3,5},
			{4,3},
			{4,4},
			{4,5},
			{5,3},
			{5,4},
			
			{7,3},
			{7,4},
			};
	
	public static final int[][] SQUARE2X2 = {
			{3,3},
			{3,4},
			{4,3},
			{4,4},
			};
	
	public static final int[][] SQUARE4X4 = {
			{2,2},
			{2,3},
			{2,4},
			{2,5},
			{3,2},
			{3,5},
			{4,2},
			{4,5},
			{5,2},
			{5,3},
			{5,4},
			{5,5}
			};
	
	public static final int[][] SQUARE6X6 = {
			{1,1},
			{1,2},
			{1,3},
			{1,4},
			{1,5},
			{1,6},
			{2,1},
			{2,6},
			{3,1},
			{3,6},
			{4,1},
			{4,6},
			{5,1},
			{5,6},
			{6,1},
			{6,2},
			{6,3},
			{6,4},
			{6,5},
			{6,6}
			};
	
	public static final int[][] SQUARE8X8 = {
			{0,0},
			{0,1},
			{0,2},
			{0,3},
			{0,4},
			{0,5},
			{0,6},
			{0,7},
			{1,0},
			{1,7},
			{2,0},
			{2,7},
			{3,0},
			{3,7},
			{4,0},
			{4,7},
			{5,0},
			{5,7},
			{6,0},
			{6,7},
			{7,0},
			{7,1},
			{7,2},
			{7,3},
			{7,4},
			{7,5},
			{7,6},
			{7,7},
			};
	
	public static final int[][] SQUARE4X4SOLID = {
			{2,2},
			{2,3},
			{2,4},
			{2,5},
			{3,2},
			{3,3},
			{3,4},
			{3,5},
			{4,2},
			{4,3},
			{4,4},
			{4,5},
			{5,2},
			{5,3},
			{5,4},
			{5,5}
			};
	
	public static final int[][][] SQUARES_OUTWARD = new int[][][] {SQUARE2X2, SQUARE4X4, SQUARE6X6, SQUARE8X8};
			
			
	
	public static int lastKeyPressed = 0;
	
	public static MidiDevice launchpad;
	public static MidiDevice launchpadIn;
	static Receiver nrec;
	static Transmitter ntra;
	
	public static final int[][] keys = {
			{64,65,66,67,96,97,98,99},
			{60,61,62,63,92,93,94,95},
			{56,57,58,59,88,89,90,91},
			{52,53,54,55,84,85,86,87},
			{48,49,50,51,80,81,82,83},
			{44,45,46,47,76,77,78,79},
			{40,41,42,43,72,73,74,75},
			{36,37,38,39,68,69,70,71}
			};
	
	static MidiDevice.Info[] infosA = MidiSystem.getMidiDeviceInfo();
	static String displaysAs = "LivePort";
	
	public static boolean main(String[] args) throws MidiUnavailableException, InterruptedException, InvalidMidiDataException {
		int launchpadDeviceNumber = -1;
		int	launchpadInNumber = -1;
		
		for (int i = 0; i < infosA.length; i++) {
			Info inf = infosA[i];
			String name = inf.getName().replace(" ", "");
//			System.out.println("\"" + name + "\"");
			if (name.equals(displaysAs)) {
				launchpadDeviceNumber = i;
			}
			
		}
		for (int i = 0; i < infosA.length; i++) {
			Info inf = infosA[i];
			String name = inf.getName().replace(" ", "");
//			System.out.println("\"" + name + "\"");
			if (name.equals(displaysAs)) {
				launchpadInNumber = i;
				break;
			}
			
		}
		
		if (launchpadDeviceNumber == -1 || launchpadInNumber == 0) {
			System.out.println("Cannot find Launchpad.");
			return false;
		}
		
		System.out.println("Receiving from MIDI device " + launchpadInNumber);
		System.out.println("Sending to MIDI device     " + launchpadDeviceNumber);
		
		launchpad = MidiSystem.getMidiDevice(infosA[launchpadDeviceNumber]);
		launchpadIn = MidiSystem.getMidiDevice(infosA[launchpadInNumber]);
		launchpad.open();
		launchpadIn.open();
		
		nrec = launchpad.getReceiver();
		ntra = launchpadIn.getTransmitter();
		
		Thread.yield();
		return true;
	}
	
	
	
	



	private static int[] seqIntArray(int startNum, int length){
		
		int[] outArr = new int[length];
		
		for (int i = 0; i < length; i++) {
			outArr[i] = startNum + i;
		}
		
		return outArr;
	}
	
	public static void display(MidiDevice device, int[][] pxl, int color, String mode) throws InterruptedException, InvalidMidiDataException, MidiUnavailableException {
		int channel = SOLID;
		switch (mode) {
		case "blink": channel = FLASH;
		case "flash": channel = FLASH;
		case "pulse": channel = PULSE;
		case "solid": channel = SOLID;
		}
		
		for (int i = 0; i < pxl.length; i++) {
			
			
			
//			int disp = keys[pxl[i][0]][pxl[i][1]];
			
//			System.out.println(disp);
			
//			ShortMessage msg1 = new ShortMessage(ShortMessage.NOTE_ON, channel, disp, color);
//			ShortMessage msg2 = new ShortMessage(ShortMessage.NOTE_OFF, channel, disp, color);
//			
//			launchpad.getReceiver().send(msg1, -1);
//			Thread.sleep(1000);
//			launchpad.getReceiver().send(msg2, -1);
			
			changePixel(device, pxl[i], channel, color);
			
		}
	}
	
	public static void display(MidiDevice device, int[] pxl, int color, String mode) throws InterruptedException, InvalidMidiDataException, MidiUnavailableException {
		
		
		
			
			int channel;
			switch (mode) {
			case "blink":
				channel = FLASH;
				break;
			
			case "flash":
				channel = FLASH;
				break;
			
			case "pulse":
				channel = PULSE;
				break;
				
			default:
				channel = SOLID;
				break;
			}
			
			changePixel(device, pxl, channel, color);
			
//			int disp = keys[pxl[0]][pxl[1]];
//			
////			System.out.println(disp);
//			
//			ShortMessage msg1 = new ShortMessage(ShortMessage.NOTE_ON, channel, disp, color);
//			ShortMessage msg2 = new ShortMessage(ShortMessage.NOTE_OFF, channel, disp, color);
//			
//			device.getReceiver().send(msg1, -1);
////			Thread.sleep(1000);
//			launchpad.getReceiver().send(msg2, -1);
		
	}
	
	public static void clearPads(MidiDevice device, int indDelay, int rowDelay) throws InvalidMidiDataException, MidiUnavailableException, InterruptedException {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
//					ShortMessage msg1 = new ShortMessage(ShortMessage.NOTE_ON, 1, keys[i][j], 0);
//					ShortMessage msg2 = new ShortMessage(ShortMessage.NOTE_ON, 2, keys[i][j], 0);
//					ShortMessage msg5 = new ShortMessage(ShortMessage.NOTE_ON, 5, keys[i][j], 0);
//					device.getReceiver().send(msg1, -1);
//					device.getReceiver().send(msg2, -1);
//					device.getReceiver().send(msg5, -1);
				
				int[] pxl = {i, j};

				changePixel(device, pxl, FLASH, 0);
				changePixel(device, pxl, PULSE, 0);
				changePixel(device, pxl, SOLID, 0);

				Thread.sleep(indDelay);
			}
			Thread.sleep(rowDelay);
		}
	
	}
	
	public static void fillPads(MidiDevice device, int color, String mode, int indDelay, int rowDelay) throws InvalidMidiDataException, MidiUnavailableException, InterruptedException {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
//					ShortMessage msg1 = new ShortMessage(ShortMessage.NOTE_ON, 1, keys[i][j], 0);
//					ShortMessage msg2 = new ShortMessage(ShortMessage.NOTE_ON, 2, keys[i][j], 0);
//					ShortMessage msg5 = new ShortMessage(ShortMessage.NOTE_ON, 5, keys[i][j], 0);
//					device.getReceiver().send(msg1, -1);
//					device.getReceiver().send(msg2, -1);
//					device.getReceiver().send(msg5, -1);
				
				int[] pxl = {i, j};

				display(device, pxl, color, mode);

				Thread.sleep(indDelay);
			}
			Thread.sleep(rowDelay);
		}
	}
	
	public static void changePixel(MidiDevice device, int[] pxl, int channel, int color) throws InvalidMidiDataException, MidiUnavailableException {
		ShortMessage msg = new ShortMessage(ShortMessage.NOTE_ON, channel, keys[pxl[0]][pxl[1]], color);
		device.getReceiver().send(msg, -1);
	}
	
	public static int getInput() throws MidiUnavailableException, InvalidMidiDataException{
		Sequencer sequencer = MidiSystem.getSequencer();
		
		Transmitter transmitter;
		Receiver receiver;

		// Open a connection to the default sequencer (as specified by MidiSystem)
		sequencer.open();
		// Get the transmitter class from your input device
		transmitter = launchpadIn.getTransmitter();
		// Get the receiver class from your sequencer
		receiver = sequencer.getReceiver();
		// Bind the transmitter to the receiver so the receiver gets input from the transmitter
		transmitter.setReceiver(receiver);
		
		int keyPress = lastKeyPressed;
		while(keyPress == lastKeyPressed) {

			Sequence seq = new Sequence(Sequence.PPQ, 1);
			Track currentTrack = seq.createTrack();
			sequencer.setSequence(seq);
			sequencer.setTickPosition(1);
			sequencer.recordEnable(currentTrack, -1);
			sequencer.startRecording();
			
			int cursize = currentTrack.size();
			while(sequencer.isRecording()){ 
				if(currentTrack.size() != cursize){
					cursize = currentTrack.size();
//					System.out.println(currentTrack.size());
				}
				if(cursize >= 2) {
					sequencer.stopRecording();
				}
			}
			
			sequencer.recordDisable(currentTrack);
			Sequence sequence = sequencer.getSequence();

			int trackNumber = 0;
			for (Track track :  sequence.getTracks()) {
				trackNumber++;
				for (int i=0; i < track.size(); i++) { 
					MidiEvent event = track.get(i);
					MidiMessage message = event.getMessage();
					if (message instanceof ShortMessage) {
						ShortMessage sm = (ShortMessage) message;
						if (sm.getCommand() == NOTE_ON) {
							int key = sm.getData1();
							int velocity = sm.getData2();
							if (velocity > 0) {
//								System.out.println(key);
								keyPress = key;
//								ShortMessage msg = new ShortMessage(ShortMessage.NOTE_ON, 5, key, 3);
//								launchpad.getReceiver().send(msg, -1);
								
							}
						}
//	                    else if (sm.getCommand() == NOTE_OFF) {
//	                        int key = sm.getData1();
//	                        int velocity = sm.getData2();
//	                        System.out.println(key);
//	                    }
	                }
	            }
	        }
		}
		return keyPress;
	}
	
	public static int[][] make2x2Square(int[] topLeftCorner) {
		int yStart = topLeftCorner[0];
		int xStart = topLeftCorner[1];
		if((yStart >= keys.length - 1) || (xStart >= keys[xStart].length - 1)) {
			System.out.println("Could not create 2x2 square at {" + yStart + ", " + xStart + "}.");
			return null;
		}
		else{
			int[][] square = new int[4][2];
			square[0] = topLeftCorner;
			
			int count = 0;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					int num = 2*i + j;
					square[num][0] = yStart + i;
					square[num][1] = xStart + j;
				}
			}
			
			return square;
			
		}
	}
	
	public static void flashImg(MidiDevice device, int[][] pxls, int color, long onTime, long offTime, int reps, int indDelayOn, int rowDelayOn, int indDelayOff, int rowDelayOff, boolean pauseAtEnd) throws InterruptedException, InvalidMidiDataException, MidiUnavailableException{
		int[][] sortedPixels = new int[pxls.length][2];
		
		int count = 0;
		for (int i = 0; i < keys.length; i++) {
			for (int j = 0; j < keys[i].length; j++) {
				int[] toSearchFor = {i,j};
//				System.out.println("searching for " + toSearchFor[0] + " " + toSearchFor[1]);
				int index = arrIndexOf(toSearchFor, pxls);
//				System.out.println(index >= 0);
				if(index >= 0) {
					sortedPixels[count] = pxls[index];
					count++;
				}
			}
		}
		
		for (int i = 0; i < reps; i++) {
			displayDelay(device, sortedPixels, color, "solid", indDelayOn, rowDelayOn);
			Thread.sleep(onTime);
			clearPads(device, indDelayOff, rowDelayOff);
			if (i < reps - 1 || pauseAtEnd) {
				Thread.sleep(offTime);
			}
		}
		if(pauseAtEnd) {
			displayDelay(device, sortedPixels, color, "solid", indDelayOn, rowDelayOn);
		}
	}







	public static void displayDelay(MidiDevice device, int[][] pxls, int color, String mode, int indDelay, int rowDelay) throws InterruptedException, InvalidMidiDataException, MidiUnavailableException {
		int[][] sortedPixels = new int[pxls.length][2];
		
		int count = 0;
		for (int i = 0; i < keys.length; i++) {
			for (int j = 0; j < keys[i].length; j++) {
				int[] toSearchFor = {i,j};
//				System.out.println("searching for " + toSearchFor[0] + " " + toSearchFor[1]);
				int index = arrIndexOf(toSearchFor, pxls);
//				System.out.println(index >= 0);
				if(index >= 0) {
					sortedPixels[count] = pxls[index];
					count++;
				}
			}
		}
		
		for (int j = 0; j < keys.length; j++) {
			for (int i = 0; i < sortedPixels.length; i++) {
				if(sortedPixels[i][0] == j) {
					display(device, sortedPixels[i], color, mode);
					Thread.sleep(indDelay);
				}
			}
			Thread.sleep(rowDelay);
		}
	}

	private static int[] indexesIn2DArr(int n, int[][] arr2D) {
		int[] indexes = {-1, -1};
		
		for (int i = 0; i < arr2D.length; i++) {
			for (int j = 0; j < arr2D[i].length; j++) {
				int q;
				q = arr2D[i][j];
				if (q == n) {
					indexes[0] = i;
					indexes[1] = j;
					return indexes;
				}
			}
		}
		
		return indexes;
	}





	private static int arrIndexOf(int[] nArr, int[][] arr2D) {
		for (int i = 0; i < arr2D.length; i++) {
				int count = 0;
				for (int n = 0; n < arr2D[i].length; n++) {
					if (arr2D[i][n] == nArr[n]) {
						count++;
					}
				}
				if (count == nArr.length) {
					return i;
				}
				
				
//				if(arr2D[i].equals(n)){
//					return i;
//				}
			
		}
		return -1;
	}
	
	public static void chase(MidiDevice device, int[][][] steps, int color, String mode, long stepDelay, int indDelay, int rowDelay, boolean clearAfterStep) throws InterruptedException, InvalidMidiDataException, MidiUnavailableException {
		for (int i = 0; i < steps.length; i++) {
//			display(device, steps[i], color, mode);
			displayDelay(device, steps[i], color, mode, indDelay, rowDelay);
			Thread.sleep(stepDelay);
			if (clearAfterStep) {
				clearPads(device, indDelay, rowDelay);
			}
		}
	}
	
}







	



