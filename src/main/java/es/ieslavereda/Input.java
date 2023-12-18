package es.ieslavereda;

import java.util.Scanner;

public class Input {
    private static final String YES = "Y";
    private static final String NO = "N";

    public static int getInteger(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        while(!sc.hasNextInt()){
            System.err.print(message);
            sc.next();
        }
        return sc.nextInt();
    }

    public static String getString(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.next();
    }

    public static String getOption(String message){
        String option =
                String.valueOf(getString(message).toUpperCase().charAt(0));
        while (!option.equals(YES)&&!option.equals(NO)){
            option=String.valueOf(getString(message).toUpperCase().charAt(0));
        }
        return option;
    }

}
