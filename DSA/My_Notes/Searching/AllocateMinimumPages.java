import java.util.Arrays;

//Given that there are N books and M students. 
// Also given are the number of pages in each book in ascending order. 
// The task is to assign books in such a way that the maximum number of pages assigned to a student is minimum,
//  with the condition that every student is assigned to read some consecutive books. Print that minimum number of pages.
public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] books = {12, 34, 67, 90};
        int students = 2;
        int result = allocateMinimumPages(books, students);
        System.out.println("Minimum pages allocated: " + result);
    }

    public static int allocateMinimumPages(int[] books, int students) {
        int n = books.length;
        if (n < students)
            return -1; // Not enough books to allocate.

        // Initialize the search range.
        int low = Arrays.stream(books).max().getAsInt();
        int high = Arrays.stream(books).sum();

        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isValid(books, students, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    public static boolean isValid(int[] books, int students, int maxPagesPerStudent) {
        int studentsRequired = 1;
        int currentPages = 0;

        for (int i = 0; i < books.length; i++) {
            if (currentPages + books[i] > maxPagesPerStudent) {
                studentsRequired++;
                currentPages = books[i];
            } else {
                currentPages += books[i];
            }

            if (studentsRequired > students) {
                return false;
            }
        }

        return true;
    }
}
