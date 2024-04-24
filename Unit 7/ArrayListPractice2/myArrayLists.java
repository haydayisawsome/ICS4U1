
import java.util.*;
class myArrayLists{
    public static ArrayList<Integer> numbers(int size){
        ArrayList<Integer> list = new ArrayList<Integer>(20);
        for (int i = 0; i < size; i++){
            list.add((int)(Math.random()*20));
        }
        return list;
    }
    public static boolean search(ArrayList<Integer> list, int item){
        boolean b = false;
        for (int i = 0;i < list.size();i++){
            if (list.get(i) == item){
                b = true;
            }
        }
        return b;
    }
    public static ArrayList<Integer> sort(ArrayList<Integer> list){
        int temp;
        for (int i = 0;i<list.size();i++){
            for (int j = i+1;j<list.size();j++){
                if (list.get(j) < list.get(i)){
                    temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        return list;
    }
    public static ArrayList<Integer> swap(ArrayList<Integer> list, int indexA, int indexB){
        int temp = list.get(indexA);
        list.set(indexA,list.get(indexB));
        list.set(indexB,temp);
        return list;
    }
    public static ArrayList<Integer> shuffle(ArrayList<Integer>list){
        for (int i =0; i<list.size();i++){
            int temp = list.get(i);
            int j = (int)(Math.random()*list.size());
            list.set(i,list.get(j));
            list.set(j,temp);
        }
        return list;
    }
    public static ArrayList<Integer> reverse(ArrayList<Integer> list){
        int indexA = list.size();
        int temp;
        for (int i = 0;i<list.size()/2;i++){
            temp = list.get(indexA-1);
            list.set(indexA-1,list.get(i));
            list.set(i,temp);
            indexA --;
        }
        return list;
    }
    public static ArrayList<String> insert(ArrayList<String> list,int pos,String name){
        list.add(pos,name);
        return list;
    }
    public static ArrayList<String> takeOut(ArrayList<String> list,int index){
        list.remove(index);
        return list;
    }
    public static ArrayList<String> takeOut(ArrayList<String> list,String name){
        ArrayList<String> newList = new ArrayList<String>();
        for (int i = 0;i<list.size();i++){
            if (list.get(i) != name){
                newList.add(list.get(i));
            }
        }
        return newList;
    }
    public static ArrayList<String> replace(ArrayList<String> list, String element, int index){
        ArrayList<String> newList = new ArrayList<String>();
        for (int i = 0;i < list.size();i++){
            if (i == index){
                newList.add(element);
            }
            else {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}
