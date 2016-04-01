package CodingPractice.problems;

/**
 * Created by sj034021 on 3/31/16.
 */
public class MergeSort {

  static int[] sort(int[] elements, int startIndex, int endIndex) {
  int returnArray[] = new int[10];
  int returnArrayIndex = 0;
  for(int i = 0; i< returnArray.length; i++) {
    returnArray[i] = -1;
  }


    int midPoint = (startIndex + endIndex)/2;
    if (startIndex == endIndex) {
      returnArray[returnArrayIndex] = elements[startIndex];
      return returnArray;
    }

    int m = 0;
    int n = 0;

    int[] array1 = sort(elements, startIndex, midPoint);
    int[] array2 = sort(elements, midPoint+1, endIndex);

    while(array1[m]!=-1 || array2[n]!=-1) {
      if(array1[m] == -1) {
        while(array2[n]!=-1) {
          returnArray[returnArrayIndex] = array2[n];
          returnArrayIndex++;
          n++;
        }
        break;
      } if(array2[n] == -1) {
        while(array1[m]!=-1) {
          returnArray[returnArrayIndex] = array1[m];
          returnArrayIndex++;
          m++;
        }
        break;
      }

      if (array1[m] < array2[n]) {
        returnArray[returnArrayIndex] = array1[m];
        returnArrayIndex++;
        m++;
      } else if(array1[m] > array2[n]) {
        returnArray[returnArrayIndex] = array2[n];
        returnArrayIndex++;
        n++;
      }
      else {
        returnArray[returnArrayIndex] = array1[m];
        returnArrayIndex++;
        m++;
        n++;
      }
    }

    return returnArray;
  }


  public static void main(String args[]) {
    int elements[] = { 2,9,7,4,10,3,8,1,5,6 };
    int sortedArray[] = sort(elements, 0, 9);
    for(int i = 0; i< sortedArray.length; i++) {
      System.out.println(sortedArray[i]);
    }
  }
}
