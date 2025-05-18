package collection.array;

import java.util.Arrays;

public class MyArrayListV3 {
    private static final int DEFAULT_CAPACITY=5;

    private Object[] elementData;
    private int size = 0;

    public MyArrayListV3(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayListV3(int initialCapacity){
        elementData = new Object[initialCapacity];
    }

    public int size(){
        return size;
    }

    public void add(Object e){
        //코드 추가
        if(size == elementData.length){
            grow();
        }
        elementData[size]=e;
        size++;
    }

    public void add(int index, Object e){
        if(size == elementData.length){
            grow();
        }

        shiftRightFrom(index);
        elementData[index]=e;
        size++;
    }

    private void shiftRightFrom(int index){
        for(int i = size; i> index; i--){
            elementData[i]=elementData[i-1];
        }
    }

    //코드 추가
    private void grow(){
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity * 2;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public Object get(int index){
        return elementData[index];
    }

    public Object set(int index, Object element){
        Object oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    public Object remove(int index){
        Object oldValue = elementData[index]; 
        shiftLeftFrom(index);
        size--;
        elementData[size]=null;
        return oldValue;
    }

    private void shiftLeftFrom(int index){
        for(int i = index; i<size-1;i++){
            elementData[i]=elementData[i+1];
        }
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
