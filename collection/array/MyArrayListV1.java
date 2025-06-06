package collection.array;

import java.util.Arrays;

public class MyArrayListV1 {
    private static final int DEFAULT_CAPACITY=5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV1(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV1(int initialCapacity){
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(Object e){
        elementData[size]=e;
        size++;
    }

    public Object get(int index){
        return elementData[index];
    }

    public Object set(int index, Object element){
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public int indexOf(Object o){
        for(int i =0; i< size; i++){
            if(o.equals(elementData[i])){//인수와 같은 데이터가 있는 인덱스의 위치 반환함
                return i;
            }
        }
        return -1;//데이터가 없으면 -1 반환
    }

    public String toString(){
        return Arrays.toString(Arrays.copyOf(elementData, size))+" size= "+size+", capacity= "+elementData.length;
    }
}
