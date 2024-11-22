package sortering;

import static jdk.internal.icu.text.UTF16.charAt;

public class BubbelSortering_opg1 {
	private static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}

	public static void bubbleSort(int[] list) {
		for (int i = list.length - 1; i >= 0; i--) {
			for (int j = 0; j <= i - 1; j++) {
				if (list[j] > list[j + 1])
					swap(list, j, j + 1);
			}
		}
	}

	//TODO opgave 1

	public static void swap1(String[] list, int i, int j){
		String temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}


	public static void bubbelSortering(String[] list) {
		for (int i = list.length - 1; i >= 0; i--){
			for (int j = 0; j <= i - 1; j++){
				if (list[j].compareTo(list[j + 1]) > 0){ //hvis det der står på j pladsen er større end det der står på j + 1.
					swap1(list, j, j + 1);

				}
			}

		}
	}

}
