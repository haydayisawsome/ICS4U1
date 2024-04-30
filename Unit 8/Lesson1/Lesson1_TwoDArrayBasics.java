class Lesson1_TwoDArrayBasics {
    public static void main(String[]args){
        //A two d array is an array of one d arrays

        //how to declare a two d array
        int[][] a = new int[3][4]; 
        //3 is number of rows
        //4 is number of columns

        a[1][2] = 10;
        System.out.println(a[1][2]);
        System.out.println(a[2][2]);
        //the defult values of elements in a 2D array are:
        //int: 0; double: 0.0; String: null; boolean: false

        //delarge and fill a 2D array in one line
        int[][]b = {{1,2,3},{4,5,6},{7,8,9},{3,2,1}};
        //printing a 2D array using a nested for loop
        for (int i = 0;i<4;i++){
            for (int j = 0;j<3;j++){
                System.out.print(b[i][j] + "  ");
            }
            System.out.println();
        }

        print(b);
        System.out.println();
        int[][]c = {{1,2,3,4},{5,6,7,8},{9,0,9,8},{7,6,5,4}};
        System.out.println();
        print(c);

        //finding the number of rows
        System.out.println("Number of rows = " + c.length);
        //number of rows = c.length
        //number of columns = c[0].length
        System.out.println("Number of columns" + c[0].length);
    }
    //write a method that prints a 2D array of integer
    public static void print(int[][] n){
        for(int i = 0;i<n.length;i++){
            for (int j = 0;j < n[i].length;j++){
                System.out.print(n[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

