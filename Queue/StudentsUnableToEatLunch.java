//lc-1700
class StudentsUnableToEatLunch {
    //optimal
    public int countStudents(int[] students, int[] sandwiches) {
        //0 is circular sandwich
        //1 is square sandwich
        int circle=0;
        int square=0;
        for(int i=0;i<students.length;i++)
        {
            if(students[i]==0)//count the circular sandwich preferred students
            {
                circle++;
            }
            else//count the square sandwich preferred students
            {
                square++;
            }
        }
        for(int i=0;i<sandwiches.length;i++)
        {
            if(sandwiches[i]==0 && circle==0)//If the current sandwich is circular and there are no students left who prefer circles
            {
                return square;//if only circle left but the student prefer square are in line so they refuse it and remain uneaten
            }
            if(sandwiches[i]==1 && square==0)//If the current sandwich is square and there are no students left who prefer square
            {
                return circle;//if only square left but the student prefer circle are in line so they refuse it and remain uneaten
            }
            if(sandwiches[i]==0)//for each circular sandwitch the preferred student count decremented bcoz each student takes 1 sandwich
            {
                circle--;
            }
            else//similar for square sandwich
            {
                square--;
            }
        }
        return 0;
    }


// class Solution {
//     public int countStudents(int[] students, int[] sandwiches) {
//         // Initialize the student queue
//         Queue<Integer> studentQueue = new LinkedList<>();
//         for (int i=0;i<students.length;i++) 
//         {
//             studentQueue.offer(students[i]);
//         }

//         // Initialize the sandwich queue
//         Queue<Integer> sandwichQueue = new LinkedList<>();
//         for(int i=0;i<sandwiches.length;i++)
//         {
//             sandwichQueue.add(sandwiches[i]);
//         }

//         // Track the number of rotations without success
//         int rotations=0;
//         int n=students.length;

//         for (int i = 0;i<n*n;i++) 
//         { // Upper limit to prevent infinite loop
//             int currentStudent=studentQueue.poll();
//             int currentSandwich=sandwichQueue.peek();

//             if(currentStudent==currentSandwich) //if 0==0 or 1==1
//             {
//                 // The student takes the sandwich
//                 sandwichQueue.remove();
//                 rotations=0; // Reset rotations on successful match
//             } 
//             else 
//             {
//                 // Student refuses the sandwich, so move to the back of the queue
//                 studentQueue.offer(currentStudent);
//                 rotations++;
//             }

//             // Check if all remaining students refuse the sandwich
//             if(rotations==studentQueue.size()) //if whole queue is traversed
//             {
//                 return rotations; // Remaining students who don't want the sandwich
//             }

//             // If no sandwiches are left, break out of loop
//             if(sandwichQueue.isEmpty()) 
//             {
//                 break;
//             }
//         }
//         return 0; // All students were able to get their preferred sandwiches
//     }
// }
}