import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Tasks extends Task {
	private int start;
	private int end;
    private ArrayList<Integer> odd_numbers;
    String taskname;
    boolean isCompleted;
    
    public Tasks(int first, int last) {
        super("Odd numbers between:(" + first + "," + last+")");
        odd_numbers = new ArrayList<Integer>();
        this.start = first;
        this.end = last;
    }

    // Function to Check if a number is odd 
    public static boolean check_OddNumbers(int value) {
        if( value % 2 == 0) {
            return false;
        }
        return true;
	}   
@Override
    public void run() {
        System.out.println(this.getName() +"\t"+ Thread.currentThread().getName()+"\t started running");
        for (int i = start; i <= end; ++i) {
            if (check_OddNumbers(i)) {
                odd_numbers.add(i);
            }
        }
        System.out.println( this.getName() +"\t" +"odd numbers generated are: " + Arrays.toString(odd_numbers.toArray()) );
        System.out.println( this.getName() +"\t" + odd_numbers.size() + " Odd numbers generated by " + Thread.currentThread().getName());
   }
    // Main Function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input range: ");	// input range
        int upper_bound = scanner.nextInt();
        int complete_thread = 10; 			// number of threads to complete the task
        int no_thread = 10;					// number of threads

        ThreadPool threadpool = new ThreadPool(no_thread);
        int task_size = (int) Math.floor(upper_bound / complete_thread);

        ArrayList<Tasks> tasks = new ArrayList<Tasks>();
        int j = 0;

        for(int i=(j+task_size); i<=upper_bound; i=j+task_size)
        {
            Tasks task = new Tasks(j, i-1);
            threadpool.execute(task);
            tasks.add(task);
            j = i;
        }
        threadpool.shutdown();			// terminate the thread
        scanner.close();
    }
}