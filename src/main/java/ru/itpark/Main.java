package ru.itpark;

import org.jetbrains.annotations.NotNull;
import ru.itpark.model.ChargerProduct;
import ru.itpark.model.MouseProduct;
import ru.itpark.model.Product;
import ru.itpark.model.ScrewdriverProduct;
import ru.itpark.service.UlmartServices;
import ru.itpark.service.UlmartService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    public static final int productPerPage = 3;

    public static void printList(@NotNull List<Product> productList, Consumer<Product> out) {
        for (Product product : productList) {
            out.accept(product);
        }
    }

    public static void main(String[] args) {
        UlmartService ulmartService = new UlmartService();

        ulmartService.addProduct(new ScrewdriverProduct(
                "аккумуляторный шуруповерт Bosch PSR Select Micro USB (0.603.977.021)",
                "",
                412000,
                5,
                3600,
                "Li-ion")
        );
        ulmartService.addProduct(new ScrewdriverProduct(
                "шуруповерт Bosch GSR 140-LI",
                "",
                699000,
                4,
                14400,
                "Li-ion")
        );

        ulmartService.addProduct(new MouseProduct(
                "мышь Genius Micro Traveler 9000R V3 USB, pink",
                "",
                145000,
                3,
                "Розовый",
                "Беспроводная")
        );

        List<Product> result = new ArrayList<Product>();
        System.out.println("\nИсходные данные:");
        result = ulmartService.findByName("");
        Main.printList(result, (o) -> System.out.println(o.getName()));

        List<Product> productList = new ArrayList<Product>();
        productList.add(new ChargerProduct(
                "Сетевое зарядное устройство Ginzzu [GA-3312UB], 3.1A, 2 USB, с кабелем micro USB, нейлоновая оплётка, черный",
                "",
                54000,
                4,
                "Сетевое")
        );

        productList.add(new ChargerProduct(
                "Автомобильное зарядное устройство Xiaomi Mi Car Charger Pro 4.8A, 2 USB, серебристый",
                "",
                85000,
                3,
                "Автомобильное")
        );

        System.out.println("\nДобавим продукты (списком):");
        Main.printList(productList, (o) -> System.out.println(o.getName()));
        ulmartService.addProductsFromList(productList);


        System.out.println("\nРезультат:");
        result = ulmartService.findByName("");
        Main.printList(result, (o) -> System.out.println(o.getName()));

        System.out.println("\nПоиск по \"micro\"");
        result=ulmartService.findByName("micro");
        Main.printList(result, (o) -> System.out.println(o.getName()));

        result = ulmartService.findByName("");
        System.out.println("\nПо возрастанию цены");
        UlmartServices.sortByPriceAsc(result);
        Main.printList(result, (o) -> System.out.println(o.getName()+" "+o.getPrice()/100));

        System.out.println("\nПо убыванию цены");
        UlmartServices.sortByPriceDesc(result);
        Main.printList(result, (o) -> System.out.println(o.getName()+" "+o.getPrice()/100));

        System.out.println("\nПо рейтингу");
        UlmartServices.sortByRating(result);
        Main.printList(result, (o) -> System.out.println(o.getName()+" "+o.getRating()));

        System.out.println("\nПостранично");
        UlmartServices.sortByName(result);

        for (int i = 1; !UlmartServices.paginate(result, i, productPerPage).isEmpty(); i++) {
            System.out.println("Страница:" + i);
            Main.printList(UlmartServices.paginate(result, i, productPerPage), (o) -> System.out.println(o.getName()));
        }

        System.out.println("\nПо категории");
        result=ulmartService.findByCategory("ЗАРЯДНОЕ УСТРОЙСТВО");
        Main.printList(result, (o) -> System.out.println(o.getCategory() + ":" + o.getName()));
        result.clear();

        System.out.println("\nПо всем категориям");
        result=ulmartService.findByCategory("");
        Main.printList(result, (o) -> System.out.println(o.getCategory() + ":" + o.getName()));
        result.clear();

    }
}
