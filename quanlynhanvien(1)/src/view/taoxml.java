package view;

import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.text.SimpleDateFormat;

public class taoxml {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            NhanVien nv1 = new NhanVien("111", "Trịnh Xuân Bách", "16/10/2004", "Nam", "Thái Bình", "Hành Chính", "Giám Đốc", "10,000", "6,000", "5,000");
            NhanVien nv2 = new NhanVien("222", "Lê Đình Anh", "16/10/2004", "Nam", "Thanh Hóa", "Bảo Vệ", "Bảo An", "10,000", "6,000", "5,000");
            NhanVien nv3 = new NhanVien("333", "Ngô Xuân Quỳnh", "16/10/2004", "Nam", "Thanh Hóa", "Nhân Sự", "Trưởng Phòng", "10,000", "6,000", "5,000");

            
            
            Element NhanViens = doc.createElement("nhanviens");

            themNhanVien(doc, NhanViens, nv1);
            themNhanVien(doc, NhanViens, nv2);
            themNhanVien(doc, NhanViens, nv3);

            doc.appendChild(NhanViens);

            TransformerFactory tff = TransformerFactory.newInstance();
            try {
                Transformer tf = tff.newTransformer();
                tf.setOutputProperty(OutputKeys.INDENT, "yes");
                tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "3");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult("src/view/NhanVien.xml");
                tf.transform(source, result);
                System.out.println("Ghi flie thanh cong!!");

            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(taoxml.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(taoxml.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(taoxml.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static private void themNhanVien(Document doc, Element NhanViens, NhanVien nv) {

        Element NhanVien = doc.createElement("nhanvien");

        Element MaNv = doc.createElement("manv");
        MaNv.setTextContent(nv.getMaNV());
        Element HoTen = doc.createElement("hoten");
        HoTen.setTextContent(nv.getHoTen());
        Element GioiTinh = doc.createElement("gioitinh");
        GioiTinh.setTextContent(nv.getGioiTinh());
       
        Element NgaySinh = doc.createElement("ngaysinh");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String ngaySinh = dateFormat.format(nv.getNgaySinh());
        NgaySinh.setTextContent(ngaySinh);
             
        Element QueQuan = doc.createElement("quequan");
        QueQuan.setTextContent(nv.getQueQuan());
        Element PhongBan = doc.createElement("phongban");
        PhongBan.setTextContent(nv.getPhongBan());
        Element ChucVu = doc.createElement("chucvu");
        ChucVu.setTextContent(nv.getChucVu());

        Element Luong = doc.createElement("luong");
        Luong.setTextContent(nv.getLuong());
          
        Element HoaHong = doc.createElement("hoahong");
        HoaHong.setTextContent(nv.getHoaHong()); 
        Element PhuCap = doc.createElement("phucap");
        PhuCap.setTextContent(nv.getPhuCapChucVu());

        NhanVien.appendChild(MaNv);
        NhanVien.appendChild(HoTen);
        NhanVien.appendChild(GioiTinh);
        NhanVien.appendChild(NgaySinh);
        NhanVien.appendChild(QueQuan);
        NhanVien.appendChild(PhongBan);
        NhanVien.appendChild(ChucVu);
        NhanVien.appendChild(Luong);
        NhanVien.appendChild(HoaHong);
        NhanVien.appendChild(PhuCap);

        NhanViens.appendChild(NhanVien);

    }
}
