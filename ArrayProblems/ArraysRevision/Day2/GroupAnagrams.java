package ArrayProblems.ArraysRevision.Day2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String s[] = { "eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagram(s);
        for(List<String> list : result){
            System.out.println(list.toString());
        }
    }

    public static List<List<String>> groupAnagram(String str[]) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : str) {
            int freq[] = new int[26];

            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for (int count : freq) {
                key.append('#').append(count);
            }

            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(s);

        }

        return new ArrayList<>(map.values());
    }
}
