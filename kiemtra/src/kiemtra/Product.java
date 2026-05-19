package kiemtra;

public class Product {
    // Sử dụng chính xác tên thuộc tính theo đề bài
    protected String product_id;
    protected String product_name;
    protected double product_price;
    protected int product_total;

    // 1. Constructor không tham số
    public Product() {
    }

    // 2. Constructor đủ tham số
    public Product(String product_id, String product_name, double product_price, int product_total) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_total = product_total;
    }

    // Các phương thức Getter và Setter (được generate tự động theo chuẩn tên biến gạch dưới)
    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getProduct_total() {
        return product_total;
    }

    public void setProduct_total(int product_total) {
        this.product_total = product_total;
    }

    // Phương thức toString() xuất thông tin
    @Override
    public String toString() {
        return "Product [product_id=" + product_id +
                ", product_name=" + product_name +
                ", product_price=" + product_price +
                ", product_total=" + product_total + "]";
    }
}