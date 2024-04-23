class MyArray{
    public MyArray(){
        //defult constructor stuff
    }
    public int[] fill(int size){
        int[] random = new int[size];
        for (int i = 0;i < random.length;i++){
            random[i] = (int)(Math.random()*(size+1));
        }
        return random;
    }
    public void print(int[] array){
        System.out.print("[");
        for (int i = 0; i < array.length;i++){
            System.out.print(array[i]);
            if (i != array.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
    public void print(String[] array){
        System.out.print("[");
        for (int i = 0; i < array.length;i++){
            System.out.print(array[i]);
            if (i != array.length-1){
                System.out.print(",");
            }
        }
        System.out.print("]");
        System.out.println();
    }
    public int[] searchPositions(int[] array,int value){
        //finding length of new array
        int countLength = 0;
        for (int i = 0;i < array.length;i++){
            if (array[i] == value){
                countLength++;
            }
        }
        
        //making new array
        int count = 0;
        int[] positions = new int[countLength];
        for (int i = 0; i < array.length;i++){
            if (array[i] == value){
                positions[count] = i;
                count++;
            }
        }
        return positions;
    }
    public int[] addEnd(int[] array,int add){
        int[] newArray = new int[array.length + 1];
        for (int i = 0;i<array.length;i++){
            newArray[i] = array[i];
        }
        newArray[newArray.length - 1] = add;
        return newArray;
    }
    public int[] addFront(int[] array,int add){
        int[] newArray = new int[array.length + 1];
        newArray[0] = add;
        for (int i = 0;i<array.length;i++){
            newArray[i+1] = array[i];
        }
        return newArray;
    }
    public int[] remove (int[] array, int position){
        int[] newArray = new int[array.length-1];
        for (int i = 0;i<newArray.length;i++){
            if (i < position-1){
                newArray[i] = array[i];
            }
            else {
                newArray[i] = array[i+1];
            }
        }
        return newArray;
    }
    public int[] insert (int[] array, int value, int pos){
        int[] newArray = new int[array.length + 1];
        for (int i = 0; i<newArray.length;i++){
            if (i<pos){
                newArray[i] = array[i];
            }
            else if (i == pos){
                newArray[i] = value;
            }
            else {
                newArray[i] = array[i-1];
            }
        }
        return newArray;
    }
    public int[] sort(int[] array){
        for (int i = 0;i<array.length;i++){
            for (int j = i+1;j<array.length;j++){
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    public void twoSmallest(int[] array){
        for (int i =0;i<array.length;i++){
            for (int j = i+1;j<array.length;j++){
                if (array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        int small1 = array[0];
        int small2 = array[1];
        System.out.println("Two smallest values: "+small1+" and "+small2);
    }
    public String[] sort(String[] array){
        for (int i = 0;i<array.length;i++){
            for (int j = i+1;j<array.length;j++){
                if (array[i].compareTo(array[j]) > 0){
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
    public int[] reverse(int[] array){
        int[] newArray = new int[array.length];
        for (int i = 0;i < array.length;i++){
            newArray[i] = array[array.length-i-1];
        }
        return newArray;
    }
}
public class MyArrayTester{
    public static void main(String[]args){
        MyArray demo = new MyArray();
        int[] m;
        System.out.println("An array of 20 random integers from 1 - 20: ");
        m = demo.fill(20);
        demo.print(m);
        System.out.println("\nAdding 99 to the end of the array: ");
        m = demo.addEnd(m,99);
        demo.print(m);
        System.out.println("\nAdding 99 to the front of the array: ");
        m = demo.addFront(m,99);
        demo.print(m);
        System.out.println("\nRemoving the third element of the array: ");
        m = demo.remove(m,3);
        demo.print(m);
        System.out.println("\nPrinting index positions of elements that have a value of 2: ");
        int[] pos = demo.searchPositions(m,2);
        demo.print(pos);
        System.out.println("\nInserting 9 to index 5: ");
        m = demo.insert(m,9,5);
        demo.print(m);
        System.out.println("\nSorting the array: ");
        m = demo.sort(m);
        demo.print(m);
        System.out.println("\nPrinting the two smallest values: ");
        demo.twoSmallest(m);
        System.out.println("\nCreating an array with 4 strings: ");
        String[] name = {"Bob","Joe","Isaac","Sam"};
        demo.print(name);
        System.out.println("\nSorting and printing the array of strings: ");
        name = demo.sort(name);
        demo.print(name);
        System.out.println("\nPrinting the reverse of the array of integers: ");
        int[] reverse = demo.reverse(m);
        demo.print(reverse);
        System.out.println();
    }
}