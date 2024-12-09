package soegningelevopgaverOpgave4;

public class SoegningApp {

	// TODO Opgave1
	public static boolean findUlige(int[] tabel) {
		boolean fundetUlige = false;
		int i = 0;
		while (!fundetUlige && i < tabel.length){
			int k = tabel[i];
			if (k % 2 == 1){
				fundetUlige = true;
			}
		}
		return fundetUlige;
	}

	// TODO Opgave2

//	Skriv en metode i SoegningApp, der ved lineær søgning finder det første tal i et array af heltal,
//	der ligger i intervallet [10,15]. Hvis arrayet ikke indeholder et sådant tal returneres -1.
//	Hvis arrayet ser ud som nedenstående, skal metoden altså returnere 14.
//			[7, 56, 34, 3, 7, 14, 13, 4]. Test metoden fra main() i SoegningApp.

	public static int helTal(int[] heltal){
		int i = 0;
		int indeks = -1;
		while (indeks == -1 && i < heltal.length){ // vi siger -1, da vi også kigger på den til højre.
			// Vores kandidatmængde bliver derfor mindre, og derfor skal vi stoppe 1 gang før,
			// ellers får vi en nullpointerexception.
			int k = heltal[i];
			if (k >= 10 && k <= 15){
				indeks = k;
			}
			else {
				i++;
			}
		}
		return indeks;


	}

	//TODO opgave 3

	//	Skriv en metode i SoegningApp, der afgør, om der i et array står 2 ens tal ved siden af
//	hinanden. For 7 9 13 7 9 13 skal metoden returnere False, og for [7 9 13 13 9 7] skal algoritmen returnere True
//	Skriv metoden, som en søgning. Test metoden fra main() i SoegningApp.
	public static boolean toEnsTal(int[] sammeTal ){
		boolean toEns = false;
		int i = 0;
		while (!toEns && i < sammeTal.length-1){
			int k = sammeTal[i];
			if (sammeTal[i] == sammeTal[i+1]){
				toEns = true;
			}
			else {
				i++;
			}

		}
		return toEns;
	}

	//TODO opgave 4
	//Givet nedenstående klasse Spiller (findes i den udleverede zip fil)

	// her skriver du metoder til opgaverne 2,3,5,6 og 7
	
	public static void main(String[] args) {
		// Kode til afprøvning af opgave 1
		int[] talArray = {5,4,8,3};
		System.out.println("Er der et ulige tal i talArray ? " + findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + findUlige(talArray));

		//opgave 2
		int[] førsteHeltal = {7, 56, 34, 3, 7, 14, 13, 4};
		System.out.println("Det første heltal ? " + helTal(førsteHeltal));

		//opgave 3
		int[] test1 = {7, 9, 13, 7, 9, 13};
		int[] test2 = {7, 9, 13, 13, 9, 7};

		System.out.println("Står der to ens tal ved siden af hinanden?: " + toEnsTal(test1)); // Forventet output: false
		System.out.println("Står der to ens tal ved siden af hinanden?: " + toEnsTal(test2)); // Forventet output: true
	}
		// Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7
	}


