//put imports you need here

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strs = new ArrayList<>();

        while (sc.hasNext()) {
            strs.add(sc.next());
        }

        ListIterator<String> listIterator = strs.listIterator(strs.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // Alternative
        /*
        Deque<String> guests = new LinkedList<>();
        while (sc.hasNext()) {
            guests.add(sc.next());
        }
        guests.descendingIterator().forEachRemaining(System.out::println);
        */
    }
}