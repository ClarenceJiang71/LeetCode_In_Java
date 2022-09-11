import java.util.Hashtable;
import java.util.Set;

public class Ransom_Note {
    public static boolean canConstruct(String ransomNote, String magazine) {

        // speed not fast enough
        if (ransomNote.length()>magazine.length()){
            return false;
        }

        //
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();

        int pointer = 0;
        while (pointer < magazine.length()){

            char b = magazine.charAt(pointer);
            if (!table.containsKey(b)){
                table.put(b, -1);
            }
            else {
                table.put(b, table.get(b)-1);
            }

            if (pointer<ransomNote.length()){
                char a = ransomNote.charAt(pointer);
                if (!table.containsKey(a)){
                    table.put(a, 1);
                }
                else {
                    table.put(a, table.get(a)+1);
                }
            }
            pointer++;
        }

        Set<Character> setOfKeys = table.keySet();

        for (Character c: setOfKeys){
            System.out.println(c);
            System.out.println(table.get(c));
            if (table.get(c)>0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "aa";
        String b = "aab";
        System.out.println(canConstruct(a,b));
    }
}
