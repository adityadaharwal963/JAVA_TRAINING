import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Problem4 {
    /*
    Exam Result Processing System
    Scenario:
    A university stores student marks.
    Requirements:
     Store roll number and marks
     Display students sorted by marks
     Find the topper
    Hint:
    Use TreeMap<Integer, Integer> or sorting with List<Map.Entry>
     */

    // reference https://www.geeksforgeeks.org/java/how-to-sort-a-treemap-by-value-in-java/
    public static <K, V extends Comparable<V> > Map<K, V>
    valueSort(final Map<K, V> map)
    {
        // Static Method with return type Map and
        // extending comparator class which compares values
        // associated with two keys
        Comparator<K> valueComparator = new Comparator<K>() {

            // return comparison results of values of
            // two keys
            public int compare(K k1, K k2)
            {
                int comp = map.get(k1).compareTo(
                        map.get(k2));
                if (comp == 0)
                    return 1;
                else
                    return comp;
            }

        };

        // SortedMap created using the comparator
        Map<K, V> sorted = new TreeMap<K, V>(valueComparator);

        sorted.putAll(map);

        return sorted;
    }

    static void displaySortMarks(){
        Map<Integer,Integer> sorted = valueSort(marks);
        System.out.println("Roll no | Marks");
        for(Map.Entry<Integer,Integer> mark : sorted.entrySet() ){
            System.out.println(mark.getKey()+" "+mark.getValue());
        }
    }
    static void dislayTopper(){
        System.out.println(marks.lastEntry().getKey()+ " is Topper");
    }
    // store <roll no , mark> of students
    static TreeMap<Integer,Integer> marks = new TreeMap<>();
    public static void main(String[] args) {

        // add roll no and mark of student
        marks.put(1,23);
        marks.put(2,25);
        marks.put(3,25);
        marks.put(4,24);
        marks.put(5,30);

        //display student by sorted marks
        displaySortMarks();
        // display topper
        dislayTopper();
    }



}
