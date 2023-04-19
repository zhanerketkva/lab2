import java.util.Arrays;
public class MyArrayList<T> implements MyList {
    private T[] arr;
    private int size;

    MyArrayList(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    /**
     * @function increaseBufferIfNeeded increase the array buffer
     * @noparams
     * @return void
     * **/

    public void increaseBufferIfNeeded(){
        if(size==arr.length){
            T[] newArr = (T[]) new Object[arr.length*2];
            for(int i=0; i<arr.length; i++){
                newArr[i]=arr[i];
            }

        arr = newArr;
        }
    }
    /**
     * @function size returns the length of the array
     * @noparams
     * @return int
     * **/


    @Override
    public int size() {
        return this.size;
    }
    /**
     * @function contains true if Object o is in array
     * @param o search object
     * @return boolean
     * **/
    @Override
    public boolean contains(Object o) {
        for(T element:arr){
            if(o.equals(element))return true;
        }
        return false;
    }
    /**
     * @function add adds an object to an array
     * @param item object to add
     * @return void
     * **/

    @Override
    public void add(Object item) {
        increaseBufferIfNeeded();
        arr[size++] = (T) item;
    }
    /**
     * @function add adds an object at a specific index
     * @param item object to add
     * @param index index where to add item
     * @return void
     * **/
    @Override
    public void add(Object item, int index) {
        if(index<0 || index>size) throw new IndexOutOfBoundsException();
        increaseBufferIfNeeded();
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = (T) item;
        size++;
    }
    /**
     * @function remove removes an object from an array
     * @param item delete object
     * @return boolean
     * **/

    @Override
    public boolean remove(Object item) {
        int index=indexOf(item);
        if (index>=0){
            remove(index);
            return true;
        }
        return false;
    }
    /**
     * @function remove removes an object from an array
     * @param index The index of the element to remove
     * @returnObject
     * **/

    @Override
    public Object remove(int index) {
        checkIndex(index);
        T temporary=this.arr[index];
        for(int i=index+1; i<size; i++){
            arr[i-1]=arr[i];
        }
        this.size--;
        return temporary;
    }
    /**
     * @function clear clears the array
     * @noparam
     * @return void
     * **/



    public void clear(){
        this.arr = (T[]) new Object[5];
        this.size = 0;
    }
    /**
     * @function get returns the object from the array at its index
     * @param index object index
     * @returnObject
     * **/


    @Override
    public Object get(int index) {
        checkIndex(index);
        return arr[index];
    }
    /**
     * @function indexOf returns the index of the first occurrence of an object
     * @param o the object to search
     * @return int
     * **/

    @Override
    public int indexOf(Object o) {
        for(int i=0; i<arr.length; i++){
            if(arr[i].equals((T)o)){
                return i;
            }
        }
        return -1;
    }
    /**
     * @function lastIndexOf returns the index of the last occurrence of an object in an array
     * @param o the object to search
     * @return int
     * **/

    @Override
    public int lastIndexOf(Object o) {
        int index=-1;
        for(int i=0; i<arr.length; i++)
            if(arr[i].equals((T)o)&& i>index) index=i;
        return index;
    }
    /**
     * @function sort sorts an array (bubble sort, O(n^2))
     * @noparam
     * @return void
     * **/

    @Override
    public void sort() {
        try{
            Integer.valueOf((int) this.get(0));
        } catch(ClassCastException e){
            return;
        }
        for(int i=0; i<size; i++){
            for(int j=i; j<size; j++){
                if ((int) arr[j]<(int)arr[i]){
                    T temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                }
            }
        }

    }
    private void checkIndex(int index){
        if(index < 0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(arr);

    }
}
