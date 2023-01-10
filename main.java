import java.math.RoundingMode;
import java.text.DecimalFormat;

class HelloWorld {
    public static void main(String[] args) {
        try {
            spicyChicken(1, 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        calculateTaxAmount(180001);
        calculateTaxAmount(37009);
        calculateTaxAmount(37001);
        calculateTaxAmount(1);
    } 

    /**
     * Generate spicyChicken output using min and max integer  
     * @param min
     * @param max
     * @throws Exception
     */
    private static void spicyChicken(int min, int max) throws Exception {

        // Define constant values
        final String SPICY = "Spicy";
        final String CHICHKEN = "Chicken";

        // Validate input parameters
        if (min > max) {
            throw new Exception("Min value cannot greater than Max value. Min : " + min + " Max : " + max);
        }

        // Loop through the given range
        for(int i = min; i <= max; i++) {
            String resultString = "";

            if (i % 3 == 0) {
                resultString += SPICY;
            }

            if (i % 5 == 0) {
                resultString += CHICHKEN;
            }

            System.out.println(i + " " + resultString);
        }
    }

    /**
     * calculate Tax amount for given income
     * @param income
     */
    private static void calculateTaxAmount(double income) {
        double band;
        double totalTax = 0;

        // Calculate total payable tax for each bands
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

        // Round DOWN total tax in to two decimal points
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);

        System.out.println(df.format(totalTax));
    }
}