package kiemtra;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ComputerManager manager = new ComputerManagerImpl();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        // Thêm sẵn 2 dữ liệu mẫu vào kho để tiện demo các chức năng Tìm kiếm/Sửa/Xóa ngay lập tức
        manager.addComputer(new Computer("1", "Dell XPS 15", 35000000, 10, "Intel Core i7", 16, "Windows 11"));
        manager.addComputer(new Computer("2", "MacBook Pro M3", 45000000, 5, "Apple M3 Pro", 18, "macOS"));

        do {
            System.out.println("\n=================== QUẢN LÝ MÁY TÍNH ===================");
            System.out.println("1. Thêm máy tính mới");
            System.out.println("2. Sửa thông tin máy tính (theo ID)");
            System.out.println("3. Xóa máy tính (theo ID)");
            System.out.println("4. Tìm kiếm máy tính theo Tên");
            System.out.println("5. Tìm kiếm máy tính theo Giá");
            System.out.println("6. Tìm kiếm máy tính theo RAM ");
            System.out.println("7. Hiển thị & Sắp xếp máy tính theo cấu hình (Lọc theo giá)");
            System.out.println("0. Thoát chương trình");
            System.out.println("========================================================");
            System.out.print("Mời bạn chọn chức năng (0-7): ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                choice = -1; // Xử lý nếu người dùng nhập sai định dạng số
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- 1. THÊM MÁY TÍNH MỚI ---");
                    Computer newComputer = inputComputer(scanner);
                    if (manager.addComputer(newComputer)) {
                        System.out.println("=> Thêm máy tính thành công!");
                    } else {
                        System.out.println("=> Thêm máy tính thất bại (ID có thể đã tồn tại)!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- 2. SỬA THÔNG TIN MÁY TÍNH ---");
                    System.out.print("Nhập mã ID máy tính cần sửa: ");
                    String editId = scanner.nextLine();

                    // Nhập thông tin mới nhưng giữ nguyên ID cần sửa
                    System.out.println("Nhập các thông tin cập nhật mới cho máy tính này:");
                    System.out.print("Tên sản phẩm: ");
                    String editName = scanner.nextLine();
                    System.out.print("Giá sản phẩm: ");
                    double editPrice = Double.parseDouble(scanner.nextLine());
                    System.out.print("Số lượng: ");
                    int editTotal = Integer.parseInt(scanner.nextLine());
                    System.out.print("CPU: ");
                    String editCpu = scanner.nextLine();
                    System.out.print("RAM (GB): ");
                    int editRam = Integer.parseInt(scanner.nextLine());
                    System.out.print("Hệ điều hành: ");
                    String editOs = scanner.nextLine();

                    Computer editComp = new Computer(editId, editName, editPrice, editTotal, editCpu, editRam, editOs);
                    if (manager.editComputer(editComp)) {
                        System.out.println("=> Cập nhật thông tin thành công!");
                    } else {
                        System.out.println("=> Không tìm thấy máy tính có ID: " + editId);
                    }
                    break;

                case 3:
                    System.out.println("\n--- 3. XÓA MÁY TÍNH ---");
                    System.out.print("Nhập mã ID máy tính cần xóa: ");
                    String delId = scanner.nextLine();

                    // Tạo một đối tượng tạm chỉ chứa ID để truyền vào hàm xóa
                    Computer delComp = new Computer();
                    delComp.setProduct_id(delId);

                    if (manager.delComputer(delComp)) {
                        System.out.println("=> Xóa thành công máy tính ID: " + delId);
                    } else {
                        System.out.println("=> Không tìm thấy máy tính có ID: " + delId + " để xóa!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- 4. TÌM KIẾM THEO TÊN ---");
                    System.out.print("Nhập tên máy tính cần tìm: ");
                    String searchName = scanner.nextLine();
                    printList(manager.searchComputer(searchName));
                    break;

                case 5:
                    System.out.println("\n--- 5. TÌM KIẾM THEO GIÁ ---");
                    System.out.print("Nhập mức giá cần tìm: ");
                    try {
                        double searchPrice = Double.parseDouble(scanner.nextLine());
                        printList(manager.searchComputerByPrice(searchPrice));
                    } catch (Exception e) {
                        System.out.println("Giá nhập vào không hợp lệ!");
                    }
                    break;

                case 6:
                    System.out.println("\n--- 6. TÌM KIẾM THEO RAM ---");
                    System.out.print("Nhập dung lượng RAM (GB) cần tìm: ");
                    try {
                        int searchRam = Integer.parseInt(scanner.nextLine());
                        printList(manager.searchComputerByRam(searchRam));
                    } catch (Exception e) {
                        System.out.println("RAM nhập vào không hợp lệ!");
                    }
                    break;

                case 7:
                    System.out.println("\n--- 7. HIỂN THỊ & SẮP XẾP THEO CẤU HÌNH ---");
                    System.out.print("Nhập mức giá tối thiểu để lọc (Nhập 0 để hiển thị tất cả): ");
                    try {
                        double minPrice = Double.parseDouble(scanner.nextLine());
                        System.out.println("Danh sách máy tính (Sắp xếp RAM giảm dần):");
                        printList(manager.sortedComputer(minPrice));
                    } catch (Exception e) {
                        System.out.println("Giá nhập vào không hợp lệ!");
                    }
                    break;

                case 0:
                    System.out.println("\nCảm ơn bạn đã sử dụng chương trình!");
                    break;

                default:
                    System.out.println("\nLựa chọn không hợp lệ, vui lòng chọn lại!");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    // nhập dữ liệu cho 1 máy tính từ bàn phím
    private static Computer inputComputer(Scanner scanner) {
        System.out.print("Mã sản phẩm (ID): ");
        String id = scanner.nextLine();
        System.out.print("Tên sản phẩm: ");
        String name = scanner.nextLine();

        double price = 0;
        int total = 0, ram = 0;

        try {
            System.out.print("Giá sản phẩm: ");
            price = Double.parseDouble(scanner.nextLine());
            System.out.print("Số lượng: ");
            total = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Nhập sai định dạng số, hệ thống tạm gán giá trị 0.");
        }

        System.out.print("CPU: ");
        String cpu = scanner.nextLine();

        try {
            System.out.print("RAM (GB): ");
            ram = Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Nhập sai định dạng số, hệ thống tạm gán RAM = 0.");
        }

        System.out.print("Hệ điều hành: ");
        String os = scanner.nextLine();

        return new Computer(id, name, price, total, cpu, ram, os);
    }

    //in danh sách ra màn hình
    private static void printList(List<Computer> list) {
        if (list.isEmpty()) {
            System.out.println("-> Không tìm thấy sản phẩm nào phù hợp!");
            return;
        }
        for (Computer c : list) {
            System.out.println(c);
        }
    }
}