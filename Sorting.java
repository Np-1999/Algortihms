import java.util.*;
public class Sorting{
    
   
    public static int[] bubbleSort(int arr[]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    swap_ud(j,j+1,arr);
                }
            }
        }
        return arr;
    }
    public static void swap_ud(int j, int j1,int a[]) {
        int temp=a[j];
        a[j]=a[j+1];
        a[j+1]=temp;
    }
    public static int[] mergeSort(int i,int j,int a[]){
        if(i<j){
        int m=(int)(i+(j-i)/2);
        mergeSort(i, m, a);
        mergeSort(m+1, j, a);
        merge(i,j,m,a);
        }
        
        return a;
    }
    public static void merge(int i,int j,int m,int a[]){
        int k,l,n1,n2;
        n1=m-i+1;
        n2=j-m;
        int L[]=new int[n1];
        int R[]=new int[n2];
        for(k=0;k<n1;k++){
            L[k]=a[k+i];
        }
        for(l=0;l<n2;l++){
            R[l]=a[m+l+1];
        }
        k=0;
        l=0;

        while(k<n1 && l <n2){
            if(L[k]<R[l]){
                a[i]=L[k];
                k++;
            }
            else{
                a[i]=R[l];
                l++;
            }
            i++;
        }
        
        while(k<n1){
            a[i]=L[k];
            i++;
            k++;
        }
        while(l<n2){
            a[i]=R[l];
            i++;
            l++;
        }
    }
    public static void main(String[] args) {
        int arr[]={1,3,8,2,9,2,5,6};
        //System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println(Arrays.toString(mergeSort(0, arr.length-1, arr)));
    }
}