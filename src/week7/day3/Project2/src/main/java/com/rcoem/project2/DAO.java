package com.rcoem.project2;

import java.util.ArrayList;
import java.util.List;

public class DAO {
    final private  static List<Empolyee> empolyees = new ArrayList<Empolyee>();

    public static void addEmpolyee(Empolyee empolyee) {
        empolyees.add(empolyee);
    }
    public static void removeEmpolyee(Empolyee empolyee) {
        empolyees.remove(empolyee);
    }
    public static List<Empolyee> getEmpolyee() {
        return empolyees;
    }
}
