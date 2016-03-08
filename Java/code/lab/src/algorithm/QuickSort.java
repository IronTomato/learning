package algorithm;

public class QuickSort {

    private int getMiddle(int[] arr, int low, int high) {
        if (low >= high)
            throw new IllegalArgumentException("low:" + low + ",high:" + high);
        int temp = arr[low]; //第一个元素作为比较的基数，此时arr[low]是冗余的，此后每个变成冗余的元素都是即将被覆盖的目标
        while (low < high) {
            //移动元素的原则是比temp大的放后面，比temp小的放前面
            //low和high分别是两头的游标
            while (low < high && arr[high] >= temp) {    //high游标向中间靠拢，元素不小于temp则直接跳到下一个
                high--;
            }
            if (low < high) {
                arr[low] = arr[high];
                low++;
            }
            while (low < high && arr[low] < temp) {    //low游标向中间靠拢，元素小于temp就直接跳到下一个
                low++;
            }
            if (low < high) {
                arr[high] = arr[low];
                high--;
            }
        }
        arr[low] = temp;
        return low;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int middle = getMiddle(arr, low, high);
            if (middle > low) {
                quickSort(arr, low, middle - 1);
            }
            if (middle < high) {
                quickSort(arr, middle + 1, high);
            }

        } else if (low > high) {
            throw new IllegalArgumentException("low:" + low + ",high:" + high);
        }
    }

    public void sort(int[] arr) {
        if (arr.length <= 1)
            return;
        quickSort(arr, 0, arr.length - 1);
    }
}
