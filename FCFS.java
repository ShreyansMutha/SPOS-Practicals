import java.util.*;
import java.io.*;
class FCFS{
	public static void main (final String [] args) throws Exception{
		System.out.println("Hello World");
		int n,AT[],BT[],CT[],TAT[],WT[];
		float AWT = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Processes are there :- ");
		n = sc.nextInt();
		AT = new int[n];
		BT = new int[n];
		CT = new int[n];
		TAT = new int[n];
		WT = new int[n];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the Arrival time of process :- "+(i+1));
			AT[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the Brust time of process :- "+(i+1));
			BT[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			if(i==0){
				CT[i] = AT[i] + BT[i];
			}
			else{
				if(AT[i] > CT[i-1]){
					CT[i] = AT[i] + BT[i];
				}
				else{
					CT[i] = CT[i-1] + BT[i];
				}
			}
		}
		for (int i = 0; i < n; i++) {
			TAT[i] = CT[i] - AT[i];
		}
		WT[0]=0;
		for (int i = 1; i < n; i++) {
			WT[i] = TAT[i] - BT[i];
			AWT = AWT + WT[i];
		}
		System.out.println("Given Data is :- ");
		System.out.println("\t||\t"+"P.No\t||\t"+"AT\t||\t"+"BT\t||\t"+"CT\t||\t"+"TAT\t||\t"+"WT\t||\t");
		for (int i = 0; i < n; i++) {
			System.out.println("\t||\t"+(i+1)+"\t||\t"+AT[i]+"\t||\t"+BT[i]+"\t||\t"+CT[i]+"\t||\t"+TAT[i]+"\t||\t"+WT[i]+"\t||\t");
		}
		System.out.println("Average Waiting Time is :- "+(AWT/n));
	}
}
