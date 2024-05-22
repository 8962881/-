package arabian;
import java.util.TreeMap;
public class Converter {
    TreeMap<Character, Integer> rimKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();
    public Converter() {
        rimKeyMap.put('I', 1);
        rimKeyMap.put('V', 5);
        rimKeyMap.put('X', 10);
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
    }
    public boolean isRoman(String number){
        return rimKeyMap.containsKey(number.charAt(0));
    }
    public String intToRim(int number) {
        String rim = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            rim += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return rim;
    }
    public int rimToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = rimKeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = rimKeyMap.get(arr[i]);
            if (arabian < rimKeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}