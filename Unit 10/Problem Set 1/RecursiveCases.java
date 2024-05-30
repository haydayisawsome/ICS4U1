public class RecursiveCases{
    /*
     * Author:  Isaac Man
     * Date:    May 30,2024
     * Subject: Recursion Problem Set 2
     */
    public static void main(String[] args) {
        String[]arr = {"Bob","Joe","Isaac","Jane"};
        System.out.println(search(arr,"Isaac")); //should return 2
        System.out.println(search(arr,"Warren")); //should return -1

        System.out.println(palindrome("racecar"));
        System.out.println(palindrome("hello"));

        System.out.println(reverse("Isaac"));
        System.out.println(reverse("Hows it going"));

        System.out.println(findNumOfChar("bob is booing a boomer", 'b')); //should print 4
        System.out.println(findNumOfChar("there are more than five e's in this string", 'e')); //should print 6

        //btw i dont fully understand what the question is asking me to solve
        //i also do not understand what permutations are
        //i just solved for the variable using the n and r values
        System.out.println(permutation(5,2)); //should return 20.0
        System.out.println(permutation(1,3)); //should return -1.0

        System.out.println(factorial(4)); //should print 24
        System.out.println(factorial(6)); //should print 720

        System.out.println(productRange(10,12)); //should print 1320
        System.out.println(productRange(1,5)); //should print 120

        System.out.println(power(10,4)); //should print 10000
        System.out.println(power(4,2)); //should print 16
    }

    //for this question you need to have an extra parameter to keep track of the current index of the recursion
    public static int search(String[] arr, String item) {
        return searchHelper(arr, item, 0); // Call helper method with starting index 0
    }
    private static int searchHelper(String[] arr, String item, int index) {
        if (index >= arr.length) {
            return -1;
        }
        if (arr[index].equals(item)) {
            return index;
        }
        else{
            return searchHelper(arr, item, index + 1);
        }
    }

    public static boolean palindrome(String str){
        if(str.length() == 1 || str.length() == 0){
            return true;
        }
        else if(str.charAt(0) == str.charAt(str.length()-1)){
            return palindrome(str.substring(1,str.length()-1));
        }
        else{
            return false;
        }
    }

    public static String reverse(String str){
        if(str.length() <= 0){
            return "";
        }
        else{
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }

    public static int findNumOfChar(String str, char item){
        if(str.length() <= 0){
            return 0;
        }
        else{
            if(str.charAt(0) == item){
                return 1 + findNumOfChar(str.substring(1),item);
            }
            else{
                return findNumOfChar(str.substring(1),item);
            }
        }
    }

    public static int factorial(int num){
        if(num == 0){
            return 1;
        }
        else{
            return num * factorial(num - 1);
        }
    }

    //doesnt work
    public static double permutation(int n, int r){
        //for this method, you can use the other factorial method instead of making many recursion calls
        if(n>r){
            return factorial(n)/factorial(n-r);
        }
        else{
            return -1;
        }
    }

    public static int productRange(int a,int b){
        if(a == b){
            return a;
        }
        else{
            if(a>b){
                return a * productRange(a-1,b);
            }
            else{
                return b * productRange(a,b-1);
            }
        }
    }

    public static int power(int base, int exp){
        if(exp > 1){
            return base * power(base,exp-1);
        }
        else{
            return base;
        }
    }
}