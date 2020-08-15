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

        // use subList to get a restricted view of the list
        // and ListIterator to iterate over it
        ListIterator listIterator = strs.subList(0,4).listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}