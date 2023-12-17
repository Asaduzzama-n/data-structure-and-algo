package divide_and_conquer;



class MinMax {

     int max;
     int min;


    public static MinMax findMinMax(int arr[],int left, int right){
        if(left == right){
            MinMax result = new MinMax();
            result.max = arr[left];
            result.min = arr[right];

            return result;
        }else if(left+1 == right){
            MinMax result = new MinMax();
            if(arr[left]>arr[right]){
                result.max = arr[left];
                result.min = arr[right];
            }else{
                result.max = arr[right];
                result.min = arr[left];

            }
            return result;
        }else{
            int mid = (left+right)/2;
            MinMax friendLeft = findMinMax(arr,left,mid);
            MinMax friendRight = findMinMax(arr,mid+1,right);
            MinMax result = new MinMax();
            if(friendLeft.max > friendRight.max){
                result.max = friendLeft.max;
            }else{
                result.max = friendRight.max;
            }

            if(friendLeft.min < friendRight.min){
                result.min = friendLeft.min;
            }else{
                result.min = friendRight.min;
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        MinMax result = findMinMax(arr, 0, arr.length-1);
        System.out.println(result.max + "  "+ result.min);
    }
}


class MaximumSumSubArray{

    public static int crossingSum(int arr[], int left,int mid,int right){
        //Left
        int sum = 0;
        int max_Left_sum = arr[mid];
        for(int i = mid-1; i>=left; i--){
            sum = sum+arr[i];
            if(sum > max_Left_sum){
                max_Left_sum = sum;
            }
        }

        //right
        sum = 0;
        int max_right_sum = arr[mid];
        for(int i = mid+2; i<=right; i++){
            sum = sum+arr[i];
            if(sum > max_right_sum){
                max_right_sum = sum;
            }
        }

        return  max_Left_sum+max_right_sum;
    }

    public static int findMaximumSum(int arr[],int left, int right){
        if(left==right){
            return arr[left];
        }else{
            int mid = (left+right)/2;

            int leftMax = findMaximumSum(arr,left,mid);
            int rightMax =  findMaximumSum(arr, mid+1, right);
            int crossingSum = crossingSum(arr,left,mid,right);

            if(leftMax>= rightMax && leftMax >= crossingSum){
                return leftMax;
            } else if (rightMax>= leftMax && rightMax>= crossingSum) {
                return rightMax;
            }else{
                return crossingSum;
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,-4};
        int result = findMaximumSum(arr,0,arr.length-1);
        System.out.println(result);
    }
}


class MaxSubArray{
    int sum;
    int leftIndex;
    int rightIndex;

    public static MaxSubArray crossingSum(int arr[], int left, int mid, int right){
        //left
        int sum = arr[mid];
        int LS = arr[mid];
        int indexLS = mid;

        for(int i = mid-1; i>=left; i--){
            sum = sum+arr[i];
            if(sum> LS){
                LS =sum;
                indexLS = i;
            }
        }

        //right
         sum = arr[mid+1];
         int RS = arr[mid+1];
         int indexRS = mid+1;

         for (int i = mid+2; i<=right; i++){
             sum = sum + arr[i];
             if(sum>RS){
                 RS = sum;
                 indexRS = i;
             }
         }

         MaxSubArray result = new MaxSubArray();
         result.sum = LS + RS;
         result.leftIndex = indexLS;
         result.rightIndex = indexRS;

         return result;
    }


    public static MaxSubArray findMaxSubArray(int arr[],int left, int right){
        if(left == right){
            MaxSubArray result = new MaxSubArray();
            result.leftIndex = left;
            result.rightIndex = right;
            result.sum = arr[left];
            return result;
        }else{
            MaxSubArray result = new MaxSubArray();

            int mid = (left+right)/2;
            MaxSubArray leftSide = findMaxSubArray(arr, left, mid);
            MaxSubArray rightSide = findMaxSubArray(arr, mid+1, right);
            MaxSubArray crossingSum = crossingSum(arr,left,mid,right);

            if(leftSide.sum>=rightSide.sum && leftSide.sum>=crossingSum.sum){
                result.sum = leftSide.sum;
                result.leftIndex = leftSide.leftIndex;
                result.rightIndex = leftSide.rightIndex;
            } else if (rightSide.sum>=leftSide.sum && rightSide.sum>=crossingSum.sum) {
                result.sum = rightSide.sum;
                result.leftIndex = rightSide.leftIndex;
                result.rightIndex = rightSide.rightIndex;
            }else{
                result.sum = crossingSum.sum;
                result.leftIndex = crossingSum.leftIndex;
                result.rightIndex = crossingSum.rightIndex;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int arr[] = {-1,2,-1,5,-2};
        MaxSubArray result = findMaxSubArray(arr,0,arr.length-1);
        System.out.println(result.sum+"   "+result.leftIndex+"--->"+result.rightIndex);
    }
}