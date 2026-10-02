import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // --- формируем variants ---
        double[][] variants;
        System.out.println("»сточник данных:");
        System.out.println("1 Ч TestData.VARIANT_2");
        System.out.println("2 Ч ручной ввод");
        System.out.print("¬аш выбор: ");
        int choice = Integer.parseInt(sc.nextLine().trim());
        if (choice == 1) {
            variants = new double[][] {
                    TestData.VARIANT_2
            };
        } else if (choice == 2) {
            System.out.println("¬ведите интервалы X_i через зап€тую:");
            String line = sc.nextLine().trim();
            String[] parts = line.split(",");
            double[] x = new double[parts.length];
            for (int i = 0; i < parts.length; i++) {
                x[i] = Double.parseDouble(parts[i].trim());
            }
            variants = new double[][] { x };
        } else {
            System.out.println("Ќет такого пункта.");
            return;
        }
        // --- дальше ваш прежний код ---
        if (args.length > 0) {
            runVariant("¬ариант 2", variants[0]);
            return;
        }
        for (int i = 0; i < variants.length; i++) {
            runVariant("" + (i + 1), variants[i]);
        }
    }
    private static void runVariant(String name, double[] x) {
        JelinskiMorandaModel model = new JelinskiMorandaModel(x);
        model.compute();
        model.printReport(name);
    }
}
