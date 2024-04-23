public class StringClassMethods{
    public static void main (String[]args){
        String str = "Hello World";
        System.out.println(str.charAt(4)); //o
        System.out.printf("%c%c\n",str.charAt(0),str.charAt(6)); //HW
        if (str.equals(str)){
            System.out.println("JAJA");
        }
        String hehe = "193";
        int jeje = 292;
        System.out.println(Integer.parseInt(hehe)+2);//195
        System.out.println(String.valueOf(jeje+3)+"heeheheh"); //295heeheheheh
        System.out.println(str.substring(0,4)); //Hell
        System.out.println(str.concat(hehe)); //Hello World193
        System.out.println(str.length()); //11
        System.out.println(str.replace("Hell","Meoo")); //Meooo World
        System.out.println(str.indexOf("W")); //6
        String st = new String("ifhwfh");
        String sr = new String("ifhwfh");
        System.out.println(st == sr); //False
        System.out.println(st.equals(sr)); //True
        System.out.println(str.contains("ello")); //True
        System.out.println(str.compareTo("Gello WOrld")); //1
        
        /**
         * charAt           str.charAt(2);
         * parseDouble      Double.parseDouble("1938");
         * valueOf          String.valueOf(2929);
         * equals           str.equals(st);
         * concat           str.concat(st);
         * contains         str.contains("hi");
         * compareTo        str.compareTo(st);
         * length           str.length();
         * new String       String st = new String("Hl");
         * indexOf          str.indexOf("W");
         * replace          str.replace("hi","bye");
         * substring        str.substring(9,39)
         */
    }
}