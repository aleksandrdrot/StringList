import expection.ArrayOutOfBounds;
import expection.ElementNotFound;
import expection.PozishonIsNull;
import expection.StringIsNull;

import java.util.Arrays;

public class StringList implements IStringList {

    private int SIZE;
    private String[] list;

    public StringList(int SIZE) {
        this.SIZE = SIZE;
        list = new String[SIZE];
    }


    public void getList() {
        int s = size();
        for (int i = 0; i < s; i++) {
            System.out.println(list[i]);
        }
    }

    public boolean indexNoNull(int index) {
        if (index == 0) {
            throw new PozishonIsNull();
        }
        return true;
    }

    public boolean stringNoEmpty(String str) {
        if (str == "") {
            throw new StringIsNull();
        }
        return true;
    }

    public boolean checkedOnNull(int index, String item){
        if (indexNoNull(index) && stringNoEmpty(item)){
            return true;
        }
        return false;
    }

    public int arrayNoOutOfBounds(int index){
        int listSize = size();
        if (index >= SIZE || index > listSize || listSize >= SIZE) {
            throw new ArrayOutOfBounds();
        }
        return listSize;
    }

    @Override
    public String add(String item) {
        if (stringNoEmpty(item)) {
            list[size()] = item;
        }
        return item;
    }

    @Override
    public String add(int index, String item) {
        String str;
        int listSize = arrayNoOutOfBounds(index);
        if (checkedOnNull(index, item)) {
            for (int i = listSize; i >= index; i--) {
                str = list[i - 1];
                list[i] = str;
            }
            list[index - 1] = item;
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        arrayNoOutOfBounds(index);
        if (checkedOnNull(index, item)){
            list[index - 1] = item;
        }
        return item;
    }

    @Override
    public String remove(String item) {
        int size = size();
        int countElement = indexOf(item);
            if (countElement == -1){
                throw new ElementNotFound();
        }
        for (int j = countElement; j < size; j++) {
            String str = list[j + 1];
            list[j] = str;
        }
        return item;
    }

    @Override
    public String remove(int index) {
        indexNoNull(index);
        int size = arrayNoOutOfBounds(index);
        int i = 0;
        for (; i < size;){
            if (i == index-1){
                break;
            }
            i++;
        }
        String element = list[i];
        for (int j = i; j < size; j++) {
            String str = list[j + 1];
            list[j] = str;
        }
        return element;
    }

    @Override
    public boolean contains(String item) {
        stringNoEmpty(item);
        for (String str: list) {
            if (str == null) break;
            if (str.equals(item)) return true;
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        int size = size();
        stringNoEmpty(item);
        int i = 0;
        for (; i < size; ) {
            if (list[i].equals(item)) {
                break;
            }
            i++;
            if (i >= size) {
                return -1;
            }
        }
        return i+1;
    }

    @Override
    public int lastIndexOf(String item) {
        int size = size();
        stringNoEmpty(item);
        int i = size -1;
        for (; i >= 0; ) {
            if (list[i].equals(item)) {
                break;
            }
            i--;
            if (i <= -1) {
                return -1;
            }
        }
        return i+1;
    }

    @Override
    public String get(int index) {
        arrayNoOutOfBounds(index);
        indexNoNull(index);
        return list[index - 1];
    }

    @Override
    public boolean equals(StringList otherList) {

        return false;
    }

    @Override
    public int size() {
        int i = 0;
        for (; i < SIZE; i++) {
            if (list[i] == null) {
                break;
            }
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        for (String str: list) {
            if (str != null) return true;
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < SIZE; i++) {
            list[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        return new String[0];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringList list1 = (StringList) o;
        return Arrays.equals(list, list1.list);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(list);
    }
}
