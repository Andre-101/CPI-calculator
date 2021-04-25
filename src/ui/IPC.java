package ui;

import java.util.Scanner;
import java.util.Arrays;

public class IPC{
	
	private final static int MAX_YEARS = 5;
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		double[] CPI_percentage = new double[MAX_YEARS];
		double[] CPI_food_items = new double[MAX_YEARS];
		double[] CPI_transport_items = new double[MAX_YEARS];
		double[] CPI_education_items = new double[MAX_YEARS];
		double[] CPI_health_items = new double[MAX_YEARS];
		double[] CPI_PublicServices_items = new double[MAX_YEARS];
		
		System.out.println(
		"Welcome to the data manipulation program of the Colombian CPI of the last 5 years\n"+
		"type in percentage the value of the CPI of the following years without symbols such as -%-"
		);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException ex){}
		
		for(int i = 0; i < MAX_YEARS; i++){
			
			System.out.println("20"+(i+16));
			CPI_percentage[i] = sc.nextDouble();
			
		}
		
		System.out.println(
		"Now enter the value of each of the CPI items for each year\n"+
		"the percentage of the items should not exceed 100%\n"+
		"do not place symbols like -% -"
		);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException ex){}
		
		for(int i = 0; i < MAX_YEARS; i++){
			double sum = 0;
			System.out.println("20"+(i+16));
			do{
				
				System.out.println("food item");
				CPI_food_items[i] = sc.nextDouble();
				
				System.out.println("transportation item");
				CPI_transport_items[i] = sc.nextDouble();
				
				System.out.println("education item");
				CPI_education_items[i] = sc.nextDouble();
				
				System.out.println("health item");
				CPI_health_items[i] = sc.nextDouble();
				
				System.out.println("public services item");
				CPI_PublicServices_items[i] = sc.nextDouble();
				
				sc.nextLine();
				
				sum = CPI_food_items[i] + CPI_transport_items[i] + CPI_education_items[i] + CPI_health_items[i] + CPI_PublicServices_items[i];
				
			} while(sum > 100.0);
			
		}
		
		IPC ppal= new IPC();
		int option= 0;
		do{
			option = ppal.showMenu();
			ppal.executeOperation(option, CPI_percentage, CPI_food_items, CPI_transport_items, CPI_education_items, CPI_health_items, CPI_PublicServices_items);
			
		}while (option!=0);
		
	}
	
	/**
	*<b>Name:showMenu</b><br>
	*This method is used to display the menu to the user
	*<b>Pre:</b>The menu list is visible<br>
	*<b>Post:</b>the menu list has been displayed<br>
	*@return the option value that the user chose
	*/
	public int showMenu() {
		Scanner sc = new Scanner(System.in);
		int option=0;
		System.out.println(
		"main menu\n"+
		"(1) report\n"+
		"(2) the average value of inflation for all years\n"+
		"(3) the median value of the inflation data\n"+
		"(4) the year in which there was the highest inflation\n"+
		"(5) the years in which the food ruble was the highest\n"+
		"(6) the years in which each of the items had their highest value\n"+
		"(7) projection of the CPI for the year 2021\n"+
		"(0) exit"
		);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	/**
	*<b>Name:executeOperation</b><br>
	*This method is used to define the function of each option
	*<b>Pre:</b>The options have been initialized<br>
	*<b>Post:</b>One of the options has been chosen<br>
	*@param operation int. Variable with option number. operation !=""
	*@param CPIptge[] double. Variable with the percentage of the CPI for each year. CPIptge[]!=null
	*@param CPIfi[] double. variable with the percentage of food items of each year. CPIfi[]!=null
	*@param CPIti[] double. variable with the percentage of transportation items each year. CPIti[]!=null
	*@param CPIei[] double. variable with the percentage of education items for each year. CPIei[]!=null
	*@param CPIhi[] double. variable with the percentage of health items each year. CPIhi[]!=null
	*@param CPIpsi[] double. variable with the percentage of the items of public services of each year. CPIpsi[]!=null
	*/
	public void executeOperation(int operation, double[] CPIptge, double[] CPIfi, double[] CPIti, double[] CPIei, double[] CPIhi, double[] CPIpsi){
		Scanner sc = new Scanner(System.in);
		double[] xCPIptge = new double[MAX_YEARS];
		int counter_Item = 0;
		switch(operation) {
		case 0:
		System.out.println("Bye");
		break;
		case 1:
		System.out.println("=====================================================================================");
		for(int i = 0; i < MAX_YEARS; i++){
			System.out.println(
			"--------------------------------------\n"+
			"YEAR = 20"+(i+16)+"\n"+
			"--------------------------------------\n"+
			" _IPC = "+CPIptge[i]+"%\n"+
			" _Food = "+CPIfi[i]+"\n"+
			" _Transport = "+CPIti[i]+"\n"+
			" _Public Services = "+CPIpsi[i]+"\n"+
			" _Health = "+CPIhi[i]+"\n"+
			" _Education = "+CPIei[i]+"\n"+
			"--------------------------------------\n"
			);
		}
		System.out.println("=====================================================================================");
		break;
		case 2:
		System.out.println("The average inflation is: "+average(CPIptge));
		break;
		case 3:
		for(int i = 0; i < MAX_YEARS; i++){
			xCPIptge[i] = CPIptge[i];
		}
		System.out.println("The median of the inflation data is: "+median(xCPIptge));
		break;	
		case 4:
		System.out.println("The year with the highest inflation is: "+(2016+higher(CPIptge)));
		break;
		case 5:
		int counter_Ifood = 0;
		int number_Ifood = 0;
		for(int b = 0; b < MAX_YEARS; b++){
			int a = b;
			if(number_Ifood == highest(CPIfi, CPIti, CPIei, CPIhi, CPIpsi, a)){
				counter_Ifood += 1;
			}
		}
		System.out.println("the number of years that the food item was the highest is: "+counter_Ifood+" year(s)");
		break;
		case 6:
		int n = 0;
		int choose_item;
		int number_Item = 0;
		double value_Item = 0;
		System.out.println(
		"choose an item\n"+
		"(1) food item\n"+
		"(2) transportation item\n"+
		"(3) education item\n"+
		"(4) health item\n"+
		"(5) public services item"
		);
		do{
			n = sc.nextInt();
		} while(n < 1 || n > 5);
		
		number_Item = n-1;
		boolean[] counter_years = new boolean[MAX_YEARS];
		for(int c = 0; c < MAX_YEARS; c++){
			int d = c;
			if(number_Item == highest(CPIfi, CPIti, CPIei, CPIhi, CPIpsi, d)){
				counter_Item += 1;
				counter_years[c] = true;
			} else {
				counter_years[c] = false;
			}
		}
		System.out.println("the number of years that the item was the highest is: "+counter_Item+" year(s)");
		for(int t = 0; t < MAX_YEARS; t++){
			if(counter_years[t] == true){
				if(number_Item == 0){
				value_Item = CPIfi[t];
				}else{
					if(number_Item == 1){
						value_Item = CPIti[t];
					}else{
						if(number_Item == 2){
							value_Item = CPIei[t];
						}else{
							if(number_Item == 3){
								value_Item = CPIhi[t];
							}else{
								value_Item = CPIpsi[t];
							}
						}
					}
				}
				System.out.println((2016+t)+" with the value of: "+value_Item);
			}
		}
		break;
		case 7:
		int u = 0;
		System.out.println("to calculate the projection of the CPI for 2021 it is necessary to know the GDP");
		try {
			Thread.sleep(2500);
		} catch (InterruptedException ex){}
		System.out.println("choose the option that contains the GDP value");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex){}
		System.out.println(
		"(1)GDP is less than 50,000 million dollars\n"+
		"(2)GDP is between 50,000 and 55,965 million dollars\n"+
		"(3)GDP is greater than 55,966 million dollars"
		);
		do{
			u = sc.nextInt();
		} while(u < 1 || u > 3);
		System.out.println(projectionIPC(CPIptge, u));
		break;
		default:
			System.out.println("Error, wrong option");
		}
	}
	
	/**
	*<b>Name:average</b><br>
	*This method is used to calculate the average
	*<b>Pre:</b>The numbers are doubles and can be added and divided<br>
	*<b>Post:</b>The average has been taken<br>
	*@param a[] double. This variable contains the percentages of the CPI for each year. a[]!=null
	*@return Average an average in double form
	*/
	public static double average(double[] a){
		double Average = 0;
		double sum = 0;
		for(int i = 0; i < MAX_YEARS; i++){
			sum += a[i];
		}
		Average = sum/MAX_YEARS;
		return Average;
	}
	
	/**
	*<b>Name:median</b><br>
	*This method is used to calculate the median
	*<b>Pre:</b>The numbers are in the array<br>
	*<b>Post:</b>The average has been calculated<br>
	*@param a[] double. This variable contains the percentages of the CPI for each year. a[]!=null
	*@return Median the number of the media that has been arranged from the array
	*/
	public static double median(double[] a){
		double Median = 0;
		Arrays.sort(a);
		Median = a[2];
		return Median;
	}
	
	/**
	*<b>Name:highest</b><br>
	*This method is used to organize each item by year
	*<b>Pre:</b>The numbers are in the array<br>
	*<b>Post:</b>The values have been organized<br>
	*@param a[] double. This variable has the values of each item (food item). a[]!=null
	*@param b[] double. This variable has the values of each item (transportation item). b[]!=null
	*@param c[] double. This variable has the values of each item (education item). c[]!=null
	*@param d[] double. This variable has the values of each item (health item). d[]!=null
	*@param e[] double. This variable has the values of each item (public services item). e[]!=null
	*@param f int. this variable has the numerical position of each item. f!=""
	*@return Number the numerical value of one of the items
	*/
	public static int highest(double[] a, double[] b, double[] c, double[] d, double[] e, int f){
		double[] order = new double[MAX_YEARS];
		int number = 0;
		order[0] = a[f];
		order[1] = b[f];
		order[2] = c[f];
		order[3] = d[f];
		order[4] = e[f];
		number = higher(order);
		return number;
	}
	
	/**
	*<b>Name:higher</b><br>
	*This method is used to find the largest number
	*<b>Pre:</b>The numbers are in the array<br>
	*<b>Post:</b>The largest number has been calculated<br>
	*@param a[] double. This variable contains the percentages of the CPI for each year or items. a[]!=null
	*@return Higher the largest number in the array
	*/
	public static int higher(double[] a){
		int Higher = 0;
		for(int i = 1; i < MAX_YEARS; i++){
			if( a[i] > a[Higher]){
				Higher = i;
			}
		}
		return Higher;
	}
	
	/**
	*<b>Name:projectionIPC</b><br>
	*This method is used to find the projection of the CPI for 2021
	*<b>Pre:</b>The numbers are in the array<br>
	*<b>Post:</b>The projection of the CPI has been calculated<br>
	*@param a[] double. This variable contains the percentages of the CPI for each year or items. a[]!=null
	*@param b int. this variable can have the choice of GDP intervals. b!=""
	*@return Higher the largest number in the array
	*/
	public static String projectionIPC(double[] a, int b){
		String pIPC = "";
		switch(b){
			case 1:
			pIPC = "the CPI is between: "+(a[4] - 1.5)+" and "+(a[4] + 1.5);
			break;
			case 2:
			pIPC = "the CPI is: "+((a[4]*2)+(a[2]-a[3]));
			break;
			case 3:
			pIPC = "the CPI is "+((a[0]*5)/(a[4]*3));
			break;
		}
		return pIPC;
	}
	
} 