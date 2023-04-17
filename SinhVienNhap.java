import java.util.Scanner;
 
public class SinhVienNhap {
    private int maSV;
    private String hoTen;
    private String diaChi;
    private String sTD;
 
    public SinhVienNhap() {
 
    }
    public SinhVienNhap(int maSV, String hoten, String diaChi, String sTD) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.sTD = sTD;
    }
    public int getMaSV() {
        return maSV;
    }
 
    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }
 
    public String getHoten() {
        return hoTen;
    }
 
    public void setHoten(String hoten) {
        this.hoTen = hoten;
    }
 
    public String getDiaChi() {
        return diaChi;
    }
 
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
 
    public String getsTD() {
        return sTD;
    }
 
    public void setsTD(String sTD) {
        this.sTD = sTD;
    }
    @Override
    public String toString() {
        return "SinhVienNhap{" +"maSV=" + maSV +", hoten='" + hoTen +", diaChi='" + diaChi + ", sTD='" + sTD +'}';
    }

    public void hienThiTT() {
        System.out.printf("%-5d %-20s %-15s %-15s \n", maSV, hoTen, diaChi, sTD);
    }
}

    class Main {
    static Scanner sc = new Scanner(System.in);
    static void nhapThongTinh(SinhVienNhap tt) {
        System.out.println("nhap ma so sinh vien: ");
        tt.setMaSV(sc.nextInt());
        ;
        sc.nextLine();
        System.out.println("nhap ho ten sinh vien: ");
        tt.setHoten(sc.nextLine());
        System.out.println("nhap dia chi sinh vien: ");
        tt.setDiaChi(sc.nextLine());
        do {
            System.out.println("nhap so dien thoai gom 7 so: ");
            tt.setsTD(sc.nextLine());
        } while (tt.getsTD().length() != 7);
    }
 
    public static void main(String[] args) {
        SinhVienNhap sv[] = null;
        int a, n = 0;
        boolean flag = true;
        do {
            System.out.println("ban chon lam gi");
            System.out.println("1. nhap thong tin sinh vien");
            System.out.println("2. xuat bang danh sach sinh vien");
            System.out.println("3. nhap so khac de thoat");
            System.out.println("nhap lua chon cua ban: ");
            a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.println("nhap so luong sinh vien can nhap thong tin: ");
                    n = sc.nextInt();
                    sv = new SinhVienNhap[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("sinh vien thu " + (i + 1)+": ");
                        sv[i] = new SinhVienNhap();
                        nhapThongTinh(sv[i]);
                    }
 
                    break;
                case 2:
                    SinhVienNhap temp = sv[0];
                    for (int i = 0; i < sv.length - 1; i++) {
                        for (int j = i + 1; j < sv.length; j++) {
                            if (sv[i].getMaSV() > sv[j].getMaSV()) {
                                temp = sv[j];
                                sv[j] = sv[i];
                                sv[i] = temp;
                            }
                        }
                    }
                    System.out.printf( "%-5s %15s %15s %20s \n","MSSV", "ho va ten", "dia chi", "so dien thoai");
                    for (int i = 0; i < n; i++) {
                        sv[i].hienThiTT();
                    }
                    break;
                default:
                    System.out.println("goodbye");
                    flag = false;
                    break;
            }
        } while (flag);
    }
}