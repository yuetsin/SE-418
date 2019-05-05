package com.yue.wordladder.prac.ladder;
import com.yue.wordladder.prac.exceptions.LadderNotFoundException;
import com.yue.wordladder.prac.exceptions.WordNotFoundException;
import com.yue.wordladder.prac.utils.Node;
import java.util.*;

public class LadderHelper {
    public static Dictionary generateDict() {
        return new Dictionary("static/dictionary.txt");
    }

    public ArrayList<ArrayList<String>> calculateLadder(String start, String end, Dictionary dic) throws WordNotFoundException, LadderNotFoundException {

        HashSet<String> dict = new HashSet<>(Arrays.asList(dic.getStringArray()));

//        Printer p = new Printer();
//        Set<String> lib = new HashSet<String>(Arrays.asList(dic.getStringArray()));

        if (start == null || start.isEmpty()) {
            throw new WordNotFoundException("Must provide the start word.");
        }

        if (end == null || end.isEmpty()) {
            throw new WordNotFoundException("Must provide the end word.");
        }

        if (!dict.contains(start)) {
            throw new WordNotFoundException(String.format("Word 「%s」 isn't in my dictionary.", start));
        }

        if (!dict.contains(end)) {
            throw new WordNotFoundException(String.format("Word 「%s」 isn't in my dictionary.", end));
        }

        /*
        if (start.equals(end)) {
            throw new LadderNotFoundException(String.format("Uh. I thought 「%s」.equals(「%s」)...", start, end));
        }
        */


        // Don't limited to exactly same length word

//        if (start.length() != end.length()) {
//            throw new LadderNotFoundException(String.format("Failed to generate ladder from %s to %s.", start, end));
//        }
//        assert(start.length() == end.length());
//        if (lib.size() == 0) {
//            throw new LadderNotFoundException(String.format("Failed to generate ladder from %s to %s.", start, end));
//        }

        HashMap<String, HashSet<String>> neighbours = new HashMap<>();

        dict.add(start);
        dict.add(end);

        // First get any possible words that str might goes to
        for(String str : dict){
            calcNeighbours(neighbours, str, dict);
        }

        // Possible result placed here
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        // BFS search queue
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(null, start, 1));

        // BFS level
        int previousLevel = 0;

        // Visited Nodes would be placed here
        HashMap<String, Integer> visited = new HashMap<>();
        while(!queue.isEmpty()){
            Node n = queue.pollFirst();
            if (end.equals(n.str)){
                // end == n.str means we've found what we want
                if(previousLevel == 0 || n.level == previousLevel){
                    previousLevel = n.level;
                    findPath(n, result);
                } else {
                    // all path with length *previousLevel* have been found
                    break;
                }
            } else {
                HashSet<String> set = neighbours.get(n.str);

                if (set == null || set.isEmpty()) continue;

                ArrayList<String> toRemove = new ArrayList<>();
                for (String s : set) {

                    // This node has been visited before.
                    if (visited.containsKey(s)){
                        Integer occurLevel = visited.get(s);
                        if (n.level + 1 > occurLevel){
                            neighbours.get(s).remove(n.str);
                            toRemove.add(s);
                            continue;
                        }
                    }
                    visited.put(s, n.level + 1);
                    queue.add(new Node(n, s, n.level + 1));
                    if (neighbours.containsKey(s))
                        neighbours.get(s).remove(n.str);
                }
                for (String s: toRemove){
                    set.remove(s);
                }
            }
        }

        if (result.size() != 0) {
            return result;
        } else {
            throw new LadderNotFoundException(String.format("Failed to generate ladder from %s to %s.", start, end));
        }
    }

    private void findPath(Node n, ArrayList<ArrayList<String>> result){
        ArrayList<String> path = new ArrayList<>();
        Node p = n;
        while (p != null){
            path.add(0, p.str);
            p = p.parent;
        }
        result.add(path);
    }
//
//    private Set<String> getFollowing(String current, Set<String> dict) {
//        Set<String> nextWords = new HashSet<>();
//        String temp;
////        Printer p = new Printer();
//        for (int i = 0; i < current.length(); i++) {
//            StringBuilder sb = new StringBuilder(current);
//            for (char c = 'a'; c <= 'z'; c++) {
//                sb.setCharAt(i, c);
//                temp = sb.toString();
//                if (dict.contains(temp)) {
//                    nextWords.add(temp);
//                }
//            }
////
//            sb = sb.deleteCharAt(i);
//
//            temp = sb.toString();
//            if (dict.contains(temp)) {
//                nextWords.add(temp);
//            }
//        }
////        System.out.println(String.format("Word %s goes to ...", current));
////        p.printSet(nextWords);
//
//        for (int i = 0; i < current.length() + 1; i++) {
//            for (char c = 'a'; c <= 'z'; c++) {
//                StringBuilder sb = new StringBuilder(current);
//                sb.insert(i, c);
//                temp = sb.toString();
//                if (dict.contains(temp)) {
//                    nextWords.add(temp);
//                }
//            }
//        }
//
//        return nextWords;
//    }

    void calcNeighbours(HashMap<String, HashSet<String>> neighbours, String str, HashSet<String> dict) {
        int length = str.length();
        char [] chars = str.toCharArray();
        for (int i = 0; i < length; i++) {
            char old = chars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == old) {
                    continue;
                }
                chars[i] = c;
                String newStr = new String(chars);

                addNewWord(neighbours, str, dict, newStr);
            }
            chars[i] = old;

            String newStr = new StringBuilder(new String(chars)).deleteCharAt(i).toString();

            addNewWord(neighbours, str, dict, newStr);
        }

        for (int i = 0; i < length + 1; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String newStr = new StringBuilder(new String(chars)).insert(i, c).toString();

                addNewWord(neighbours, str, dict, newStr);
            }
        }

    }

    private void addNewWord(HashMap<String, HashSet<String>> neighbours, String str, HashSet<String> dict, String newStr) {
        if (dict.contains(newStr)) {
            HashSet<String> set = neighbours.get(str);
            if (set != null) {
                set.add(newStr);
            } else {
                HashSet<String> newSet = new HashSet<>();
                newSet.add(newStr);
                neighbours.put(str, newSet);
            }
        }
    }
}

