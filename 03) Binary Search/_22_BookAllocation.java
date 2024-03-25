public class _22_BookAllocation {

    public static int maxPagesAllocation(int[] books, int students, int maxPages) {
        int allocatedPages = 0, allocatedStudents = 1;

        for(int i=0; i<books.length; i++) {
            int currentPages = books[i];
            if(allocatedPages + currentPages <= maxPages) {
                allocatedPages += currentPages;
            } 
            else {
                allocatedStudents++;
                allocatedPages = currentPages;
            }
        }

        return allocatedStudents;
    }


    // Brute Force Approach
    public static int placeBooks(int[] books, int students) {
        int pages = 0; 
        if(books.length < students) 
            return -1; 
        
        int minPages = 0; 
        int maxPages = 0;

        for(int i=0; i<books.length; i++) {
            minPages = Math.max(books[i], minPages);
            maxPages += books[i];
        }

        for(int i=minPages; i<=maxPages; i++) {
            if(maxPagesAllocation(books, students, i) == students) {
                pages = i;
                break;
            }
        }

        return pages;
    }

    // Optimal Approach
    public static int placeBooks2ndApproach(int[] books, int students) {
        int pages = 0;

        if(books.length < students)
            return -1;

        int minPages = 0;
        int maxPages = 0;

        for(int i=0; i<books.length; i++) {
            minPages = Math.max(books[i], minPages);
            maxPages += books[i];
        }

        int low = minPages, high = maxPages;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int studentsAllocated = maxPagesAllocation(books, students, mid);

            if(studentsAllocated <= students){
                pages = mid; 
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return pages;
    }

    public static void main(String[] args) {
        // int[] books = {25, 46, 28, 49, 24};
        // int students = 4;
        int[] books = new int[]{1, 17, 14, 9, 15, 9, 14 };
        int students = 7;
        System.out.println(placeBooks(books, students));
        System.out.println(placeBooks2ndApproach(books, students));
        //System.out.println(maxPagesAllocation(books, students, 17));
        //System.out.println(maxPagesAllocation(books, students, 63));
    }
}
