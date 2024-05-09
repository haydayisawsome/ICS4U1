public class SeatingPlanTester {
    public static void main(String[] args) {
        SeatingPlan[][] class1 = new SeatingPlan[3][3];
        class1[0][0] = new SeatingPlan("Maria",0,0);
        class1[0][1] = new SeatingPlan("Minoo",0,1);
        class1[0][2] = new SeatingPlan("Ali",0,2);
        class1[1][0] = new SeatingPlan("John",1,0);
        class1[1][1] = new SeatingPlan("Reza",1,1);
        class1[1][2] = new SeatingPlan("Mahin",1,2);
        class1[2][0] = new SeatingPlan("Maria",2,0);
        class1[2][1] = new SeatingPlan("Mina",2,1);
        class1[2][2] = new SeatingPlan("Tara",2,2);
        System.out.println("Grade 12 Seating plan");
        for(int i = 0;i<class1.length;i++){
            for(int j = 0;j<class1[i].length;j++){
                System.out.print(class1[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
