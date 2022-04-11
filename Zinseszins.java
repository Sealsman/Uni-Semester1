public class Zinseszins {
    public static double compoundInterest(double capital, double interestRate, int years) {
        // Überprüfen ob noch jahre durchgegangen werden müssen
        if (years > 0) {
            //recursiver aufruf mit erhöhung des capitals
            return compoundInterest((capital * (interestRate + 1)), interestRate, years - 1);
        }
        //Rückgabe des capitals
        return capital;
    }
    public static void main(String args[]){
        //Tests
        System.out.println(compoundInterest(100, 0.09, 0));
        System.out.println(compoundInterest(100, 0.09, 1));
        System.out.println(compoundInterest(100, 0.09, 2));
        System.out.println(compoundInterest(100, 0.09, 3));
        System.out.println(compoundInterest(100, 0.09, 4));
    }
}
