import java.util.*;

public class _07_OneMeetingInARoom {

    static class Meetings {
        int start;
        int end;
        int pos;

        Meetings(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<Meetings> meet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meet.add(new Meetings(start[i], end[i], i));
        }

        Collections.sort(meet, new Comparator<Meetings>() {
            @Override
            public int compare(Meetings m1, Meetings m2) {
                return m1.end - m2.end;
            }
        });

        int prevEnd = meet.get(0).end;
        int meetings = 1; // Add the 1st meeting which is at end[0] (after sorting end array)
        for (int i = 1; i < n; i++) {
            if (meet.get(i).start > prevEnd) {
                prevEnd = meet.get(i).end;
                meetings++;
            }
        }

        return meetings;
    }

    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        System.out.println(maxMeetings(start, end, start.length));
    }
}
