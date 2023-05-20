import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hoşgeldiniz... ");

        System.out.println("Lütfen ödeme tutarını giriniz: ");
        Double paymentAmount = scanner.nextDouble();


        while (paymentAmount < 0 || paymentAmount % 1 != 0 || paymentAmount > 2500) {
            try {

                throw new NumberFormatException("Girdiğiniz ödeme tutarı geçersiz." +
                        " Ödeme tutarı negatif, virgüllü ve kart limitinizin üstünde olamaz. Lütfen tekrar ödeme tutarı giriniz. ");

            } catch (NumberFormatException numberFormatException) {
                System.out.println(numberFormatException.getMessage());
                paymentAmount = scanner.nextDouble();

            }
        }

        scanner.nextLine();
        System.out.println("Lütfen kart numaranızı giriniz: ");
        String cardNumber = scanner.nextLine();


        while (cardNumber.length() != 16 || !cardNumber.matches("[0-9]+")) {
            try {

                throw new InvalidCardNumberException("Kart numaranız geçersiz. " +
                        "Kart numarası 16 haneli ve rakamlardan oluşmalıdır. Lütfen yeniden kart numarası giriniz: ");

            } catch (InvalidCardNumberException invalidCardNumberException) {
                System.out.println(invalidCardNumberException.getMessage());
                cardNumber = scanner.nextLine();
            }

        }

        System.out.println("Lütfen kartınızın son kullanma tarihini giriniz: ");
        String expirationDate = scanner.nextLine();
        String[] words = expirationDate.split("/");

        while (Integer.parseInt(words[0]) >= 13 || Integer.parseInt(words[1]) < LocalDate.now().getYear()) {
            try {

                throw new InvalidExpirationDateException("Geçersiz son kullanma tarihi girdiniz. " +
                        "Lütfen tekrar deneyiniz. ");

            } catch (InvalidExpirationDateException invalidExpirationDateException) {
                System.out.println(invalidExpirationDateException.getMessage());
                expirationDate = scanner.nextLine();
                words = expirationDate.split("/");
            }

        }
        System.out.println("Lütfen güvenlik kodunu giriniz: ");
        String secrutiyNumber = scanner.nextLine();


        while (secrutiyNumber.length() != 3 || !secrutiyNumber.matches("[0-9]+")) {
            try {

                throw new InvalideSecrutiyNumberException("Güvenlik numaranız geçersiz. " +
                        "Güvenlik numaranız 3 haneli olmalı ve  rakamlardan oluşmalı." + "Lütfen tekrar giriniz. ");

            } catch (InvalideSecrutiyNumberException invalideSecrutiyNumberException) {
                System.out.println(invalideSecrutiyNumberException.getMessage());
                secrutiyNumber = scanner.nextLine();
            }

        }

        for (int i = 0; i < 2; i++) {


            try {
                pay();
                System.out.println("Sistem çalışıyor");
                System.out.println("Ödeme işlemi başarılı şekilde gerçekleşti.");
                return;
            } catch (SystemNotWorkingException systemNotWorkingException) {
                System.out.println(systemNotWorkingException.getMessage());

            }

        }
        System.out.println("Ödeme gerçekleştirilemedi.");

    }

    public static void pay() {
        Random random = new Random();
        Integer number = random.nextInt(100);
        if (number > 75) {
            throw new SystemNotWorkingException("Sistem çalışmıyor. Bir kez daha deneyin !!! ");
        }


    }
}