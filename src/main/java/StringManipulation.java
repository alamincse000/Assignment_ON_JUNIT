import java.util.Locale;

public class StringManipulation {
    public static void main(String[] args) {
        wordCount();

    }

    public static void wordCount() {

//        String str = "I live in Dhaka city";
//        String city = "Dhaka";
//        char[] a = str.toCharArray();
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }
//        System.out.println(a.length);
//        System.out.println(str.length());
//        String ch = String.valueOf(str.charAt(0));
//        System.out.println(str.indexOf("I"));
//        System.out.println(ch);
//        System.out.println(str.contains(city));
//        System.out.println(str.replace("Bangladesh", "Canada"));
//        System.out.println(str.concat(" Hello "));

//       String[] words= str.split(" ");
//        for (String i :words) {
//            System.out.println(i);
//
//        }
//        System.out.println(words.length);
//        String s = str.substring( 15);
//        System.out.println(s);
//        System.out.println(str.length());
//        System.out.println(str.length());
//
//      String city=  str.substring(str.indexOf("Dh"),str.indexOf("ci"));
//
//        System.out.println(city);
//        System.out.println(str.charAt(19));

//        String str2 = "dhaka";
//        String s1 = String.valueOf(str2.charAt(0)).toUpperCase();
//        String s2 = str2.substring(1);
//        System.out.println(s1 + s2);

//        String amount = "100.50";
//        String[] amt =amount.split("\\.");
//        String t =amt[0];
//        int t1=Integer.parseInt(t);
//        System.out.println(t1);
//        String p =amt[1];
//        int p1=Integer.parseInt(p);
//        System.out.println(p1);

        String mystr="This is my country";
        //count string length
        System.out.println(mystr.length());
        String[] str= mystr.split(" ");
//        //count word length
        System.out.println(str.length);
    }

}


