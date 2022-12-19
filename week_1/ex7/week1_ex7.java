package ex7;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;

public class week1_ex7 {
    public static void main(String[] args){
        int[][] onetofour = ArraysOperation.arraytoMatrix_lenx4(evaluation.calOnetoFour());
        int[][] fivetoeight = ArraysOperation.arraytoMatrix_lenx4(evaluation.calFivetoEight());

        outerloop:
        for (int i=0;i<onetofour.length;i++){
            for (int j=0;j<fivetoeight.length;j++){
                if (!ArraysOperation.duplicate(onetofour[i], fivetoeight[j])){
                    System.out.print("[x1,x2,x3,x4] = "); System.out.println(Arrays.toString(onetofour[i]));
                    System.out.print("[x5,x6,x7,x8] = "); System.out.println(Arrays.toString(fivetoeight[j]));
                    System.out.println("");
                    // break outerloop;
                }
            }
        }
    }
}

class ArraysOperation{
    static boolean in(int[] arr,int key){
        boolean ans = false;
        for (int i=0;i<arr.length;i++){
            if (arr[i] == key){
                ans = true;
            }           
        }
        return ans;
    }

    static boolean duplicate(int[] arr1,int[] arr2){
        boolean ans = false;
        outterloop:
        for (int i=0;i<arr1.length;i++){
            for (int j=0;j<arr2.length;j++){
                if (arr1[i]==arr2[j]){
                    ans = true;
                    break outterloop;
                }
            }
        }
        return ans;
    }

    static int[][] arraytoMatrix_lenx4(int[] arr){
        int[][] ans = new int[arr.length/4][4];
        int counter = 0;
        for (int i=0;i<arr.length/4;i++){
            for (int j=0;j<4;j++){
                ans[i][j] = arr[counter]; counter++;
            }
        }
        return ans;
    }
}

class evaluation{
    static int[] calOnetoFour(){
        int[] arr = txtfile.A();
        int[] ans = {};
        int c1 = txtfile.c1; int arrone,arrfour;
        for (int two=0;two<arr.length;two++){
            for (int three=0;three<arr.length;three++){
                if (two == three){}
                else{
                    arrfour = arr[three]+c1-arr[two];
                    arrone = c1-arr[two];

                    if (ArraysOperation.in(arr, arrone) & ArraysOperation.in(arr, arrfour) & arrone != arr[two] & arrone != arr[three] & arrone != arrfour & arrone==arrfour-arr[three]){ 
                        ans = Arrays.copyOf(ans, ans.length+1);
                        ans[ans.length-1] = arrone;

                        ans = Arrays.copyOf(ans, ans.length+1);
                        ans[ans.length-1] = arr[two];

                        ans = Arrays.copyOf(ans, ans.length+1);
                        ans[ans.length-1] = arr[three];

                        ans = Arrays.copyOf(ans, ans.length+1);
                        ans[ans.length-1] = arrfour;
                    }
                } 
            }
        }
        return ans;
    }

    static int[] calFivetoEight(){
        int[] arr = txtfile.A();
        int[] ans = {};
        int c2 = txtfile.c2; int arrfive,arreight;

        for (int six=0;six<arr.length;six++){
            for (int seven=0;seven<arr.length;seven++){
                if (six == seven){}
                else{
                    arrfive = arr[seven]-arr[six];
                    arreight = c2+arr[six];

                    if ( ArraysOperation.in(arr, arrfive) & ArraysOperation.in(arr, arreight) & arrfive != arr[six] & arrfive != arr[seven] & arrfive != arreight){
                        ans = Arrays.copyOf(ans, ans.length+1);
                        ans[ans.length-1] = arrfive;

                        ans = Arrays.copyOf(ans, ans.length+1);
                        ans[ans.length-1] = arr[six];

                        ans = Arrays.copyOf(ans, ans.length+1);
                        ans[ans.length-1] = arr[seven];

                        ans = Arrays.copyOf(ans, ans.length+1);
                        ans[ans.length-1] = arreight;
                    }
                }
            }
        }
        
        return ans;
    } 
}

class txtfile{
    static String[] readfile(){
        String[] fromtxt = {};
        int counter = 0;
        try {
            File myObj = new File("input_ex7.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                fromtxt = Arrays.copyOf(fromtxt, fromtxt.length+1);
                fromtxt[counter] = data;
                counter += 1;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        return fromtxt;
    }

    static int[] input(){
        int[] ans = {};
        for (int i=0;i<3;i++){
            ans = Arrays.copyOf(ans, ans.length+1);
            ans[i] = Integer.parseInt(readfile()[0].split(" ",3)[i]);
        }
        return ans;
    } 

    static int[] A(){
        int[] ans = {};
        for (int i=1;i<input()[0]+1;i++){
            ans = Arrays.copyOf(ans, ans.length+1);
            ans[i-1] = Integer.parseInt(readfile()[i]);
        }
        Arrays.sort(ans);
        return ans;
    }
    static int n = input()[0];
    static int c1 = input()[1];
    static int c2 = input()[2];
}