import java.util.*;

public class KcomplementaryPairs {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the K ");
        int k = input.nextInt();
        System.out.println("Enter the number of elements of the array ");
        int size = input.nextInt();
        if(size>=2){
            int numbers[] = new int[size];
            System.out.println("Enter all the numbers");
            for(int i=0; i<size; i++){
                numbers[i] = input.nextInt();
            }

            Set<Integer> pair = complementaryPairs(k,numbers);
            if(pair.size() == 2){
                System.out.println("Pair found: "+pair);
            }else {
                System.out.println("Not pair of numbers found");
            }
        }else{
            System.out.println("2 numbers are needed at least. Try again...");
            main(new String[]{});
        }
    }

    /**
     * Method that find a pair of number inside a given array whose sum is a given number
     * @param k given number
     * @param numbers the array of numbers where we will search the pair of numbers whose sum is equals to 'k'
     * @return set with the pair of numbers whose sum is equals to 'k'
     */
    public static Set<Integer> complementaryPairs(int k, int[] numbers) {
        Set<Integer> pairs = new HashSet<>();
        Set<Integer> fullSet = new HashSet<>();
        int rest=0;

        //We transfer the numbers in the array to a Hashset to be able to use 'contains()' method
        for(int number:numbers){
            fullSet.add(number);
        }

        for(int number : fullSet){
            if(number<k){
                rest = k-number;
                if(fullSet.contains(rest)){
                    pairs.add(number);
                    pairs.add(rest);
                    return pairs;
                }
            }
        }
        return pairs;
    }

}

