import java.util.ArrayList;

public class RomanArab {
    ArrayList<String> romanList;

    public RomanArab(){
        romanList = new ArrayList<>();
        romanList.add("I");
        romanList.add("II");
        romanList.add("III");
        romanList.add("IV");
        romanList.add("V");
        romanList.add("VI");
        romanList.add("VII");
        romanList.add("VIII");
        romanList.add("IX");
        romanList.add("X");
    }

    public static int romanArab(String roman){
        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            default:
                return 0;
        }
    }
    public static String arabToRoman(int arabicNumber) {
        String romanNumber = "";

        if (arabicNumber==0){
            return "0";
        }
        if (arabicNumber<0){
            arabicNumber *= -1;
            romanNumber += "-";
        }

        while (arabicNumber == 100) {
            romanNumber += "C";
            arabicNumber -= 100;
        }
        while (arabicNumber >= 90) {
            romanNumber += "XC";
            arabicNumber -= 90;
        }
        while (arabicNumber >= 50) {
            romanNumber+= "L";
            arabicNumber -= 50;
        }
        while (arabicNumber >= 40) {
            romanNumber += "XL";
            arabicNumber -= 40;
        }
        while (arabicNumber >= 10) {
            romanNumber += "X";
            arabicNumber -= 10;
        }
        while (arabicNumber >= 9) {
            romanNumber += "IX";
            arabicNumber -= 9;
        }
        while (arabicNumber >= 5) {
            romanNumber += "V";
            arabicNumber -= 5;
        }
        while (arabicNumber >= 4) {
            romanNumber += "IV";
            arabicNumber -= 4;
        }
        while (arabicNumber >= 1) {
            romanNumber += "I";
            arabicNumber -= 1;
        }
        return romanNumber;
    }
    public boolean checkRoman(String number){
        for (int i = 0; i <romanList.size(); i++) {
            if (number.equals(romanList.get(i))){
                return true;
            }
        }
        return false;
    }
}
