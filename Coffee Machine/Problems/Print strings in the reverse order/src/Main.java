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

        // use ListIterator to iterate list in reverse from required index
        ListIterator listIterator = strs.listIterator(3);
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}