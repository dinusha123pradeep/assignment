import java.text.DecimalFormat;

class HelloWorld {
    public static void main(String[] args) {
        spicyChicken(1, 100);
        calculateTaxAmount(180001);
    } 

    private static void spicyChicken(int min, int max) {

        String spicy = "Spicy";
        String chichekn = "Chicken";

        for(int i = min; i <= max; i++) {
            String resultString = "";

            if (i % 3 == 0) {
                resultString += spicy;
            }

            if (i % 5 == 0) {
                resultString += chichekn;
            }

            System.out.println(i + " " + resultString);
        }
        
    }

    private static void calculateTaxAmount(double income) {
        double band;
        double totalTax = 0;

        if (income > 180000) {
            band = 180000;
            totalTax += (income - band) * 0.45;
            income = band;
        }

        if (income > 87000 && income <= 180000) {
            band = 87000;
            totalTax += (income - band) * 0.37;
            income = band;
        }

        if (income > 37000 && income <= 87000) {
            band = 37000;
            totalTax += (income - band) * 0.325;
            income = band;
        }

        if (income > 18200 && income <= 37000) {
            band = 18200;
            totalTax += (income - band) * 0.19;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        totalTax = Double.valueOf(df.format(totalTax));

        System.out.println(totalTax);
    }
}