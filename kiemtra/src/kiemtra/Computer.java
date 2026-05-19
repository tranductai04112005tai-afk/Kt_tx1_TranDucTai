package kiemtra;

public class Computer extends Product {
    // 3 thuộc tính riêng
    private String cpu;
    private int ram; // Đơn vị: GB
    private String os;

    // 1. Constructor không tham số
    public Computer() {
        super();
    }

    // 2. Constructor đủ tham số
    public Computer(String product_id, String product_name, double product_price, int product_total,
                    String cpu, int ram, String os) {
        super(product_id, product_name, product_price, product_total);
        this.cpu = cpu;
        this.ram = ram;
        this.os = os;
    }

    // Getter và Setter cho thuộc tính riêng
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public String toString() {
        return "Computer [" + super.toString() +
                ", cpu=" + cpu +
                ", ram=" + ram + "GB" +
                ", os=" + os + "]";
    }
}