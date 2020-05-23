
public class Searching {
    public static int binary_search(int arr[],int x){
        int location=0;
        for(int i=arr.length/2;i>=1;i/=2){
            while(location+i<arr.length && arr[location+i]<=x)
                location+=i;
        }
        if(arr[location]==x)
            return location;
        else
            return -1;
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
        mergeSort(0, arr.length-1, arr);
        System.out.println(binary_search(arr,3));
    }
}