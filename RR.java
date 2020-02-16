import java.util.*;
import java.io.*;
class RR
{
	public static void main (final String [] args) throws Exception
	{
		int n,q,t,temp,AT[],BT[],CT[],TAT[],WT[],D_AT[],D_BT[],p[];
		float AWT = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("How many Processes are there :- ");
		n = sc.nextInt();
		p = new int[n];
		AT = new int[n];
		BT = new int[n];
		CT = new int[n];
		TAT = new int[n];
		WT = new int[n];
		D_AT = new int[n];
		D_BT = new int[n];
        for (int i = 0; i < n; i++) {
			p[i]=i+1;
			System.out.print("Enter the Arrival time of process "+(i+1)+" :- ");
			AT[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			System.out.print("Enter the Brust time of process "+(i+1)+" :- ");
			BT[i] = sc.nextInt();
        }
        System.out.println("Enter Quantum No. :- ");
		q = sc.nextInt();
		for (int i = 0; i < n; i++) 
        {
            for (int j = i + 1; j < n; j++) { 
                if (AT[i] > AT[j]) 
                {
                    temp = AT[i];
                	AT[i] = AT[j];
					AT[j] = temp;
					temp = BT[i];
                	BT[i] = BT[j];
					BT[j] = temp;
					temp = p[i];
					p[i] = p[j];
					p[j] = temp;
                }
            }
        }
		for (int i = 0; i < n; i++) 
		{ 
            D_AT[i] = AT[i];
            D_BT[i] = BT[i]; 
        } 
        t = 0;
		while (true) 
		{ 
            boolean Done = true; 
			for (int i = 0; i < n; i++) 
			{ 
				if (D_AT[i] <= t) 
				{ 
					if (D_AT[i] <= q) 
					{ 
						if (D_BT[i] > 0) 
						{ 
                            Done = false; 
							if (D_BT[i] > q) 
							{ 
                                t = t + q; 
                                D_BT[i] = D_BT[i] - q; 
                                D_AT[i] = D_AT[i] + q; 
                            } 
							else 
							{ 
                                t = t + D_BT[i]; 
                                TAT[i] = t - AT[i]; 
                                WT[i] = t - BT[i] - AT[i]; 
                                D_BT[i] = 0; 
                            } 
                        } 
                    } 
					else if (D_AT[i] > q) 
					{ 
						for (int j = 0; j < n; j++) 
						{ 
							if (D_AT[j] < D_AT[i]) 
							{ 
								if (D_BT[j] > 0) 
								{ 
									Done = false; 
									if (D_BT[j] > q) 
									{ 
										t = t + q; 
										D_BT[j] = D_BT[j] - q; 
										D_AT[j] = D_AT[j] + q; 
									} 
									else 
									{ 
										t = t + D_BT[j]; 
										TAT[j] = t - AT[j]; 
										WT[j] = t - BT[j] - AT[j]; 
										D_BT[j] = 0; 
									} 
								}  
                            } 
                        } 
						if (D_BT[i] > 0) 
						{ 
                            Done = false; 
							if (D_BT[i] > q) 
							{ 
                                t = t + q; 
                                D_BT[i] = D_BT[i] - q; 
                                D_AT[i] = D_AT[i] + q; 
                            } 
							else 
							{ 
                                t = t + D_BT[i]; 
                                TAT[i] = t - AT[i]; 
                                WT[i] = t - BT[i] - AT[i]; 
                                D_BT[i] = 0; 
                            } 
                        } 
                    } 
                } 
				else if (D_AT[i] > t) 
				{ 
                    t++; 
                    i--; 
                } 
            } 
			if (Done) 
			{ 
                break; 
            } 
        } 
		for (int i = 0; i < n; i++) 
		{
			CT[i] = TAT[i] + AT[i];
			AWT = AWT + WT[i];
		}
		System.out.println("According to the RR Algorithm :- ");
		System.out.println("\t||\t"+"P.No\t||\t"+"AT\t||\t"+"BT\t||\t"+"CT\t||\t"+"TAT\t||\t"+"WT\t||\t");
		for (int i = 0; i < n; i++) {
			System.out.println("\t||\t"+"P"+p[i]+"\t||\t"+AT[i]+"\t||\t"+BT[i]+"\t||\t"+CT[i]+"\t||\t"+TAT[i]+"\t||\t"+WT[i]+"\t||\t");
		}
		System.out.println("Average Waiting Time is :- "+(AWT/n));
	}
}
