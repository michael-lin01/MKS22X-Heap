public class MyHeap{

  private static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  private static void pushDown(int[] data, int size, int index){
    while(true){
      int left = index*2+1;
      int right = left + 1;

      if(right<size){ //if there are 2 children
        if(data[left]>data[right]){
          if(data[left]>data[index]){
            swap(data,index,left);
            index = left;
          }
        }
        else{
          if(data[right]>data[index]){
            swap(data,index,right);
            index = right;
          }
        }
      }

      else{
        if(right==size){ //if there is one child
          if(data[left]>data[index]){
            swap(data,index,left);
          }
        }
        return; //no other children
      }
    }
  }

  private static void pushUp(int[] data, int index){
    while(index > 0){
      int parent = (index-1)/2;
      if(data[parent] < data[index]){
        swap(data,index,parent);
        index = parent;
      }
      else return;
    }
  }

}
