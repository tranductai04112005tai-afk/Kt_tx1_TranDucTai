package kiemtra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ComputerManagerImpl implements ComputerManager {
    private List<Computer> warehouse = new ArrayList<>();

    @Override
    public boolean addComputer(Computer c) {
        if (c == null) return false;
        // Kiểm tra trùng ID
        for (Computer comp : warehouse) {
            if (comp.getProduct_id().equalsIgnoreCase(c.getProduct_id())) {
                System.out.println("Lỗi: ID " + c.getProduct_id() + " đã tồn tại!");
                return false;
            }
        }
        return warehouse.add(c);
    }

    @Override
    public boolean editComputer(Computer c) {
        if (c == null) return false;
        for (int i = 0; i < warehouse.size(); i++) {
            if (warehouse.get(i).getProduct_id().equalsIgnoreCase(c.getProduct_id())) {
                warehouse.set(i, c);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delComputer(Computer c) {
        if (c == null) return false;
        return warehouse.removeIf(comp -> comp.getProduct_id().equalsIgnoreCase(c.getProduct_id()));
    }

    @Override
    public List<Computer> searchComputer(String name) {
        return warehouse.stream()
                .filter(c -> c.getProduct_name().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Computer> searchComputerByPrice(double price) {
        return warehouse.stream()
                .filter(c -> c.getProduct_price() == price)
                .collect(Collectors.toList());
    }

    @Override
    public List<Computer> searchComputerByRam(int ram) {
        return warehouse.stream()
                .filter(c -> c.getRam() == ram)
                .collect(Collectors.toList());
    }

    @Override
    public List<Computer> sortedComputer(double price) {
        return warehouse.stream()
                .filter(c -> c.getProduct_price() >= price)
                .sorted((c1, c2) -> Integer.compare(c2.getRam(), c1.getRam()))
                .collect(Collectors.toList());
    }
}