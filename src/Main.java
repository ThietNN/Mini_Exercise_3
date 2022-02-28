import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Material> materials = new ArrayList<>();
        // 5 đối tượng bột chiên giòn
        CrispyFlour cf1 = new CrispyFlour("1","CF1",LocalDate.of(2018,2,22),10000,25);
        CrispyFlour cf2 = new CrispyFlour("2","CF1",LocalDate.of(2019,2,22),12000,12);
        CrispyFlour cf3 = new CrispyFlour("3","CF1",LocalDate.of(2020,2,22),15000,16);
        CrispyFlour cf4 = new CrispyFlour("4","CF1",LocalDate.of(2021,2,22),27000,7);
        CrispyFlour cf5 = new CrispyFlour("5","CF1",LocalDate.of(2022,2,22),25000,98);
        materials.add(cf1);
        materials.add(cf2);
        materials.add(cf3);
        materials.add(cf4);
        materials.add(cf5);

        //5 đối tượng thịt
        Meat m1 = new Meat("6","M1",LocalDate.of(2022,2,15),30000,7.2);
        Meat m2 = new Meat("7","M2",LocalDate.of(2022,2,17),30000,12.12);
        Meat m3 = new Meat("8","M3",LocalDate.of(2022,2,19),30000,9.27);
        Meat m4 = new Meat("9","M4",LocalDate.of(2022,2,20),30000,22.7);
        Meat m5 = new Meat("10","M5",LocalDate.of(2022,2,22),30000,79);
        materials.add(m1);
        materials.add(m2);
        materials.add(m3);
        materials.add(m4);
        materials.add(m5);

        // Menu
        System.out.println("Menu: ");
        System.out.println("1. Hiện toàn bộ vật liệu hiện có");
        System.out.println("2. Thêm vật liệu");
        System.out.println("3. Sửa thông tin vật liệu");
        System.out.println("4. Xóa vật liệu");
        System.out.println("5. Lấy số chêch lệch giữa giá đúng và giá của ngày hôm nay của MỘT vật liệu");
        System.out.println("6. Lấy số chêch lệch giữa giá đúng và giá của ngày hôm nay của TẤT CẢ vật liệu");
        System.out.println("7. Thoát khỏi chương trình");

        // Chương trình
        Scanner scChoice = new Scanner(System.in);

        int choice;
        do {
            choice = scChoice.nextInt();
            switch (choice){
                case 1:
                    for (Material material : materials)
                        System.out.println(material.toString());
                    break;
                case 2:
                    Scanner type = new Scanner(System.in);
                    System.out.println("Nhập M để thêm thịt, C để thêm bột chiên giòn: ");
                    String typeChoice = type.nextLine();
                    if (typeChoice.equals("M"))
                        materials.add(addMeat());
                    else if (typeChoice.equals("C"))
                        materials.add(addCrispyFlour());
                    break;
                case 3:
                    Scanner editID = new Scanner(System.in);
                    System.out.println("Nhập ID vật liệu muốn thay đổi: ");
                    editInfo(materials,editID.nextLine());
                    break;
                case 4:
                    Scanner del = new Scanner(System.in);
                    System.out.println("Nhập ID vật liệu muốn xóa: ");
                    String delID = del.nextLine();
                    Material delMaterial = getItemFromID(materials,delID);
                    materials.remove(delMaterial);
                    break;
                case 5:
                    Scanner compare = new Scanner(System.in);
                    System.out.println("Nhập ID vật liệu muốn so sánh giá: ");
                    String compareID = compare.nextLine();
                    Material material = getItemFromID(materials,compareID);
                    double result = material.getCost() - material.getRealCost();
                    System.out.println("Chênh lệch giá: " + result);
                    break;
                case 6:
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Nhập Meat để xem chênh lệch giá của tất cả vật liệu thịt, Crispy Flour để xem chênh lệch của bột chiên giòn, All để xem chênh lệch tất cả vật liệu: ");
                    String sumChoice = sc.nextLine();
                    double resultDifference = getDifference(materials,sumChoice);
                    System.out.println("Chênh lệch giá: " + resultDifference);
                    break;
            }
        }while (choice != 7);

    }

    public static Material getItemFromID(ArrayList<Material> materials, String id){
        for (Material material : materials){
            if (material.getId().equals(id)){
                return material;
            }
        }
        return null;
    }

    public static void editInfo(ArrayList<Material> materials, String id){
        Scanner choice = new Scanner(System.in);
        Scanner setName = new Scanner(System.in);
        Scanner setYear = new Scanner(System.in);
        Scanner setMonth = new Scanner(System.in);
        Scanner setDay = new Scanner(System.in);
        Scanner setCost = new Scanner(System.in);
        Scanner setWeight = new Scanner(System.in);
        Scanner setQuantity = new Scanner(System.in);

        Material material = getItemFromID(materials, id);
        if (material instanceof Meat){
            System.out.println("Nhập dữ liệu muốn thay đổi: ");
            System.out.println("1. Tên");
            System.out.println("2. Ngày sản xuất");
            System.out.println("3. Giá tiền");
            System.out.println("4. Khối lượng");
            int choiceEdit = choice.nextInt();
            switch (choiceEdit){
                case 1:
                    System.out.println("Nhập tên: ");
                    material.setName(setName.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập năm sản xuất: ");
                    int y = setYear.nextInt();
                    System.out.println("Nhập tháng sản xuất: ");
                    int m = setMonth.nextInt();
                    System.out.println("Nhập ngày sản xuất: ");
                    int d = setDay.nextInt();
                    material.setManufacturingDate(LocalDate.of(y,m,d));
                    break;
                case 3:
                    System.out.println("Nhập giá tiền: ");
                    material.setCost(setCost.nextInt());
                    break;
                case 4:
                    System.out.println("Nhập khối lượng");
                    ((Meat) material).setWeight(setWeight.nextInt());
                    break;
            }
        }
        else if (material instanceof CrispyFlour){
            System.out.println("Nhập dữ liệu muốn thay đổi: ");
            System.out.println("1. Tên");
            System.out.println("2. Ngày sản xuất");
            System.out.println("3. Giá tiền");
            System.out.println("4. Số lượng");
            int choiceEdit = choice.nextInt();
            switch (choiceEdit) {
                case 1:
                    System.out.println("Nhập tên: ");
                    material.setName(setName.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập năm sản xuất: ");
                    int y = setYear.nextInt();
                    System.out.println("Nhập tháng sản xuất: ");
                    int m = setMonth.nextInt();
                    System.out.println("Nhập ngày sản xuất: ");
                    int d = setDay.nextInt();
                    material.setManufacturingDate(LocalDate.of(y, m, d));
                    break;
                case 3:
                    System.out.println("Nhập giá tiền: ");
                    material.setCost(setCost.nextInt());
                    break;
                case 4:
                    System.out.println("Nhập số lượng");
                    ((CrispyFlour) material).setQuantity(setQuantity.nextInt());
                    break;
            }
        }
    }

    public static Meat addMeat(){
        //Scanner
        Scanner addID = new Scanner(System.in);
        Scanner addName = new Scanner(System.in);
        Scanner addYear = new Scanner(System.in);
        Scanner addMonth = new Scanner(System.in);
        Scanner addDay = new Scanner(System.in);
        Scanner addCost = new Scanner(System.in);
        Scanner addWeight = new Scanner(System.in);

        // Input
        Meat newMeat = new Meat();
        System.out.println("Nhập ID: ");
        newMeat.setId(addID.nextLine());
        System.out.println("Nhập tên: ");
        newMeat.setName(addName.nextLine());
        System.out.println("Nhập năm sản xuất: ");
        int y = addYear.nextInt();
        System.out.println("Nhập tháng sản xuất: ");
        int m = addMonth.nextInt();
        System.out.println("Nhập ngày sản xuất: ");
        int d = addDay.nextInt();
        newMeat.setManufacturingDate(LocalDate.of(y,m,d));
        System.out.println("Nhập giá: ");
        newMeat.setCost(addCost.nextInt());
        System.out.println("Nhập khối lượng: ");
        newMeat.setWeight(addWeight.nextInt());
        return newMeat;
    }
    public static CrispyFlour addCrispyFlour(){
        //Scanner
        Scanner addID = new Scanner(System.in);
        Scanner addName = new Scanner(System.in);
        Scanner addYear = new Scanner(System.in);
        Scanner addMonth = new Scanner(System.in);
        Scanner addDay = new Scanner(System.in);
        Scanner addCost = new Scanner(System.in);
        Scanner addQuantity = new Scanner(System.in);

        // Input
        CrispyFlour newCrispyFlour = new CrispyFlour();
        System.out.println("Nhập ID: ");
        newCrispyFlour.setId(addID.nextLine());
        System.out.println("Nhập tên: ");
        newCrispyFlour.setName(addName.nextLine());
        System.out.println("Nhập năm sản xuất: ");
        int y = addYear.nextInt();
        System.out.println("Nhập tháng sản xuất: ");
        int m = addMonth.nextInt();
        System.out.println("Nhập ngày sản xuất: ");
        int d = addDay.nextInt();
        newCrispyFlour.setManufacturingDate(LocalDate.of(y,m,d));
        System.out.println("Nhập giá: ");
        newCrispyFlour.setCost(addCost.nextInt());
        System.out.println("Nhập số lượng: ");
        newCrispyFlour.setQuantity(addQuantity.nextInt());
        return newCrispyFlour;
    }

    public static double getSumPrice(ArrayList<Material> materials, String type){
        int sum = 0;
        if (type.equals("Meat")){
            for (Material material : materials) {
                if (material instanceof Meat)
                    sum += material.getCost();
            }
        }
        else if (type.equals("Crispy Flour")) {
            for (Material material : materials) {
                if (material instanceof CrispyFlour)
                    sum += material.getCost();
            }
        }
        return sum;
    }
    public static double getSumRealPrice(ArrayList<Material> materials, String type){
        int sum = 0;
        if (type.equals("Meat")){
            for (Material material : materials) {
                if (material instanceof Meat)
                    sum += material.getRealCost();
            }
        }
        else if (type.equals("Crispy Flour")) {
            for (Material material : materials) {
                if (material instanceof CrispyFlour)
                    sum += material.getRealCost();
            }
        }
        return sum;
    }

    public static double getDifference(ArrayList<Material> material, String type){
        if (type.equals("Meat"))
            return getSumPrice(material,"Meat") - getSumRealPrice(material,"Meat");
        else if (type.equals("Crispy Flour"))
            return getSumPrice(material,"Crispy Flour") - getSumRealPrice(material,"Crispy Flour");
        else if (type.equals("All"))
            return getSumPrice(material,"Meat") - getSumRealPrice(material,"Meat") +
                    getSumPrice(material,"Crispy Flour") - getSumRealPrice(material,"Crispy Flour");
        else
            return 0;
    }
}