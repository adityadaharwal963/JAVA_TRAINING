package com.example.dema;

import java.util.HashSet;

class Solution {
    public boolean hasAllCodes(String se, int k) {
        HashSet<String> s = new HashSet<String>();
        for(int i=0; i+k<=se.length();i++){
            String t = se.substring(i,i+k);
            s.add(t);
        }
        k = 1 << k;
        return s.size() == k;
    }
}