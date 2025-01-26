package model;

import java.util.Arrays;

public class opg2_fletningArray_fællesTal {

    public static void main(String[] args) {
       int[] tabel1 = {2, 4, 6, 8, 10, 12, 14};
       int[] tabel2 = {1, 2, 4, 5, 6, 9, 12, 17};

        System.out.println(Arrays.toString(fællesTal(tabel1, tabel2)));



    }

//Programmér en klasse med en main() metode.
   // I main() metoden lav to arrays, fx {2, 4, 6, 8, 10, 12, 14} og {1, 2, 4, 5, 6, 9, 12, 17}

    public static int[] fællesTal(int[] l1, int[] l2){
        int[] result = new int[l1.length + l2.length];

        int i1 = 0;
        int i2 = 0;
        int j = 0;

        while (i1 < l1.length && i2 < l2.length){
            if (l1[i1] < l2[i2]) { //hvis l1´s første tal er mindst
                result[j] = l1[i1];
                i1++;
            } else if (l1[i1] > l2[i2]) {
                i2++;

            }
            else {
                result[j] = l1[i1];
                i1++;
                i2++;
                j++;
            }

        }

        return Arrays.copyOf(result, j);
    }
}
