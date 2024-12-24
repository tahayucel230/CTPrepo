public class BinarySearch {
    public static int search(int[] array, int firstIndex, int lastIndex, int target){
        //App.wait(1000);
        int numberOfElementsToCheck = lastIndex - firstIndex + 1;
        System.out.println("new search number of elements to check: " + numberOfElementsToCheck + " = " + lastIndex + " - " + firstIndex + " + 1");
        if (numberOfElementsToCheck < 1){
            return -1;
        }
        for (int i = firstIndex; i<(lastIndex+1); i++){
            System.out.println("list in hand: " + array[i]);
        }
        if (numberOfElementsToCheck == 1){
            if (array[firstIndex] == target){
                return firstIndex;
            }
            return -1;
        }
        
        int pivotIndex = firstIndex+(numberOfElementsToCheck/2);
        System.out.println("pivot index: " + (pivotIndex) + " / pivot index element: " + array[pivotIndex]);
        
        if (array[pivotIndex] == target){
            return (pivotIndex);
        }

        int foundIndex = search(array, firstIndex, pivotIndex-1, target);
        if (foundIndex != -1){
            return foundIndex;
        }
        foundIndex = search(array, pivotIndex+1, lastIndex, target);
        if (foundIndex != -1){
            return foundIndex;
        }
        return -1;
    }
}
