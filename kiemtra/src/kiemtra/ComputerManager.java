package kiemtra;

import java.util.List;

public interface ComputerManager {
    public boolean addComputer(Computer c);

    public boolean editComputer(Computer c);

    public boolean delComputer(Computer c);

    public List<Computer> searchComputer(String name);

    // Bổ sung để phục vụ ý tìm theo giá
    public List<Computer> searchComputerByPrice(double price);

    // Bổ sung để phục vụ ý tìm theo thuộc tính đề xuất riêng (RAM)
    public List<Computer> searchComputerByRam(int ram);

    public List<Computer> sortedComputer(double price);
}