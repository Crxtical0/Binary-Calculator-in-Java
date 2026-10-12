
import java.util.Scanner;
import java.util.ArrayList;

public class BinaryCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String checkChoice;
        while (true) {
            System.out.println("Decimal -> Binary or Binary -> Decimal ? (1 or 2)");
            checkChoice = scanner.nextLine();
            if (checkChoice.equals("1") || checkChoice.equals("2")) {
                break;
            }
        }
        if (checkChoice.equals("1")) {
            System.out.println("Input your binary number:");
            String binary = scanner.nextLine();

            long finalDecimal = binaryToDecimal(binary);
            if (finalDecimal == 1)
                System.out.println("Not a binary.");
            else
                System.out.println(finalDecimal);
        }
        if (checkChoice.equals("2")) {
            System.out.println("Input your decimal number:");
            long decimal = Long.valueOf(scanner.nextLine());
            long finalBinary = decimalToBinary(decimal);
            System.out.println(finalBinary);
        }
    }

    public static ArrayList<Integer> binaryToArray(String binary) {
        ArrayList<Integer> reversedBinaryDigits = new ArrayList<>();
        int binaryLength = binary.length();
        long binaryInteger = Long.valueOf(binary);
        for (int i = 0; i < binaryLength; i++) {
            reversedBinaryDigits.add((int) (binaryInteger % 10));
            binaryInteger /= 10;
        }
        return reversedBinaryDigits;
    }

    public static long binaryToDecimal(String binary) {
        ArrayList<Integer> binaryDigits = new ArrayList<>();
        binaryDigits = binaryToArray(binary);
        int binaryLength = binary.length();
        for (int i = 0; i < binaryLength; i++) {
            if (binaryDigits.get(i) > 1) {
                return 1;
            }
            int baseTwo = (int) Math.pow(2, i);
            binaryDigits.set(i, (binaryDigits.get(i) * baseTwo));
        }
        int finalDecimal = 0;
        for (int j = 0; j < binaryLength; j++) {
            finalDecimal = finalDecimal + binaryDigits.get(j);
        }
        return finalDecimal;
    }

    public static long decimalToBinary(long decimal) {
        ArrayList<Integer> binaryDigits = new ArrayList<>();
        ArrayList<String> stringBinaryDigits = new ArrayList<>();
        int decimalLength = (String.valueOf(decimal)).length();
        while (true) {
            binaryDigits.add((int) decimal % 2);
            decimal /= 2;
            if (decimal == 0) {
                break;
            }
        }
        for (int j = binaryDigits.size() - 1; j >= 0; j--) {
            stringBinaryDigits.add(String.valueOf(binaryDigits.get(j)));
        }
        String binaryNumber = "";
        for (int k = 0; k < binaryDigits.size(); k++) {
            binaryNumber = binaryNumber + stringBinaryDigits.get(k);
        }
        return Long.valueOf(binaryNumber);
    }
}