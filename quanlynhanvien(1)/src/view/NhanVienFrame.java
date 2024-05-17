package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import view.NhanVien;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DecimalFormat;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import static javax.xml.xpath.XPathConstants.NODE;
import static javax.xml.xpath.XPathEvaluationResult.XPathResultType.NODE;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Node;
public class NhanVienFrame extends javax.swing.JFrame {

    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;
    String tenflie = "src/view/NhanVien.xml";
    ArrayList<NhanVien> nvList;
    DefaultTableModel dfModel;

    private void hienthi() {
        try {
            try {
                dbf = DocumentBuilderFactory.newInstance();
                db = dbf.newDocumentBuilder();
                doc = db.parse(tenflie);

                NodeList n1MaNv = doc.getElementsByTagName("manv");
                NodeList n1HoTen = doc.getElementsByTagName("hoten");
                NodeList n1NgaySinh = doc.getElementsByTagName("ngaysinh");
                NodeList n1GioiTinh = doc.getElementsByTagName("gioitinh");
                NodeList n1QueQuan = doc.getElementsByTagName("quequan");
                NodeList n1PhongBan = doc.getElementsByTagName("phongban");
                NodeList n1ChucVu = doc.getElementsByTagName("chucvu");
                NodeList n1Luong = doc.getElementsByTagName("luong");
                NodeList n1HoaHong = doc.getElementsByTagName("hoahong");
                NodeList n1PhuCapChucVu = doc.getElementsByTagName("phucap");

                nvList = new ArrayList<>();
                for (int i = 0; i < n1MaNv.getLength(); i++) {
                    NhanVien nv = new NhanVien();
                    nv.setMaNV(n1MaNv.item(i).getTextContent());
                    nv.setHoTen(n1HoTen.item(i).getTextContent());
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date ngaySinh = null;
                    try {
                        ngaySinh = dateFormat.parse(n1NgaySinh.item(i).getTextContent());
                    } catch (ParseException ex) {
                        Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    nv.setNgaySinh(ngaySinh);
                    
                
                    nv.setGioiTinh(n1GioiTinh.item(i).getTextContent());
                    nv.setQueQuan(n1QueQuan.item(i).getTextContent());
                    nv.setPhongBan(n1PhongBan.item(i).getTextContent());
                    nv.setChucVu(n1ChucVu.item(i).getTextContent());
                    
                    
                    nv.setLuong(n1Luong.item(i).getTextContent());
                    nv.setHoaHong(n1HoaHong.item(i).getTextContent());
                    nv.setPhuCapChucVu(n1PhuCapChucVu.item(i).getTextContent());

                    nvList.add(nv);
                }

                dfModel = new DefaultTableModel();
                dfModel.setColumnCount(0);
                dfModel.setRowCount(0);

                dfModel.addColumn("MÃ NV");
                dfModel.addColumn("HỌ TÊN");
                dfModel.addColumn("NGÀY SINH");
                dfModel.addColumn("GIỚI TÍNH");
                dfModel.addColumn("QUÊ QUÁN");
                dfModel.addColumn("PHÒNG BAN");
                dfModel.addColumn("LƯƠNG");
                dfModel.addColumn("CHỨC VỤ");
                dfModel.addColumn("HOA HỒNG");
                dfModel.addColumn("PHỤ CẤP");

                for (NhanVien nv : nvList) {
                    Vector v = new Vector();
                    v.add(nv.getMaNV());
                    v.add(nv.getHoTen());
                    
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    String ngaySinhFormatted = dateFormat.format(nv.getNgaySinh());
                    v.add(ngaySinhFormatted);
                    
                   
                    v.add(nv.getGioiTinh());
                    v.add(nv.getQueQuan());
                    v.add(nv.getPhongBan());
                    v.add(nv.getChucVu());
                    v.add(nv.getLuong());
                    v.add(nv.getHoaHong());
                    v.add(nv.getPhuCapChucVu());

                    dfModel.addRow(v);

                }
                tblbang.setModel(dfModel);

            } catch (SAXException | IOException ex) {
                Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    

    private void hienthi2() {
                dfModel = new DefaultTableModel();
                dfModel.setColumnCount(0);
                dfModel.setRowCount(0);

                dfModel.addColumn("MÃ NV");
                dfModel.addColumn("HỌ TÊN");
                dfModel.addColumn("NGÀY SINH");
                dfModel.addColumn("GIỚI TÍNH");
                dfModel.addColumn("QUÊ QUÁN");
                dfModel.addColumn("PHÒNG BAN");
                dfModel.addColumn("LƯƠNG");
                dfModel.addColumn("CHỨC VỤ");
                dfModel.addColumn("HOA HỒNG");
                dfModel.addColumn("PHỤ CẤP");

                
                tblbang2.setModel(dfModel);
    }
    
    public NhanVienFrame() {
        initComponents();
        hienthi();
        hienthi2();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtngaysinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtquequan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtluong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txthoahong = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtphucap = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        txtma = new javax.swing.JTextField();
        txtgt = new javax.swing.JTextField();
        comboxpb = new javax.swing.JComboBox<>();
        comboxcv = new javax.swing.JComboBox<>();
        btnreset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btntimkiem = new javax.swing.JButton();
        btnthongke = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbang2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(601, 601, 601))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jLabel2.setText("MÃ NV");

        jLabel3.setText("HỌ TÊN");

        jLabel4.setText("NGÀY SINH");

        jLabel5.setText("GIỚI TÍNH");

        jLabel6.setText("QUÊ QUÁN");

        jLabel7.setText("PHÒNG BAN");

        jLabel8.setText("CHỨC VỤ");

        jLabel9.setText("LƯƠNG");

        jLabel10.setText("HOA HỒNG");

        jLabel11.setText("PHỤ CẤP");

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        comboxpb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lựa chọn", "Giám Đốc", "Hành Chính", "Tài Chính - Kế Toán", "Marketing" }));

        comboxcv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "lựa chọn", "Giám Đốc", "Phó Giám Đốc", "Trưởng Phòng ", "Phó Phòng", "Nhân Viên", "Chuyên Viên" }));

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtma))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txthoten)
                            .addComponent(txtngaysinh)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtquequan))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtluong))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txthoahong))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnsua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnreset))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboxpb, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboxcv, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtphucap, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtgt, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnthem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnxoa)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtgt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtquequan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboxpb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboxcv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txthoahong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtphucap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnxoa))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsua)
                    .addComponent(btnreset))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tblbang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblbang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbang);

        btntimkiem.setText("TÌM KIẾM");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        btnthongke.setText("THỐNG KÊ");
        btnthongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthongkeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(btntimkiem)
                .addGap(356, 356, 356)
                .addComponent(btnthongke)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btntimkiem)
                    .addComponent(btnthongke))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        tblbang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblbang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbang2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblbang2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1112, Short.MAX_VALUE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        String manv, hoten, ngaysinh, gioitinh, quequan, phongban, chucvu, luong, hoahong, phucap;

        manv = txtma.getText();
        hoten = chuanHoa(txthoten.getText());
        ngaysinh = txtngaysinh.getText();
        gioitinh = chuanHoa(txtgt.getText().trim().toLowerCase());
        quequan = chuanHoa(txtquequan.getText());
        phongban = comboxpb.getSelectedItem().toString();
        chucvu = comboxcv.getSelectedItem().toString();
        luong = txtluong.getText();
        hoahong = txthoahong.getText();
        phucap = txtphucap.getText();

       

        if (!dadayduthongtin(manv, hoten, ngaysinh, gioitinh, quequan, phongban, chucvu, luong, hoahong, phucap)) {
            JOptionPane.showMessageDialog(this, "VUI LÒNG NHẬP THÔNG TIN ĐẦY ĐỦ", "WARNING", JOptionPane.WARNING_MESSAGE);
        } else {
            if (datrungmanv(manv)) {
                JOptionPane.showMessageDialog(this, "TRÙNG MÃ NHÂN VIÊN", "WARNING", JOptionPane.WARNING_MESSAGE);
            } else {
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);

                try {
                    Date ngaysinhDate = dateFormat.parse(ngaysinh);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(this, "NGÀY SINH KHÔNG HỢP LỆ, VUI LÒNG NHẬP THEO ĐỊNH DẠNG dd/MM/YYYY", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                gioitinh = gioitinh.substring(0, 1).toUpperCase() + gioitinh.substring(1);

                if (!gioitinh.equals("Nam") && !gioitinh.equals("Nữ")) {
                    JOptionPane.showMessageDialog(this, "GIỚI TÍNH KHÔNG HỢP LỆ, CHỈ ĐƯỢC NHẬP 'Nam' HOẶC 'Nữ'", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
                String luongWithoutComma = luong.replaceAll(",", "");
                String hoahongWithoutComma = hoahong.replaceAll(",", "");
                String phucapWithoutComma = phucap.replaceAll(",", "");
                
                try {
                    double parsedSalary = Double.parseDouble(luongWithoutComma);
                    luong = decimalFormat.format(parsedSalary);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "LƯƠNG KHÔNG HỢP LỆ", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                try {
                    double parsedBonus = Double.parseDouble(hoahongWithoutComma);
                    hoahong = decimalFormat.format(parsedBonus);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "HOA HỒNG KHÔNG HỢP LỆ", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                
                try {
                    double parsedAllowance = Double.parseDouble(phucapWithoutComma);
                    phucap = decimalFormat.format(parsedAllowance);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "PHỤ CẤP KHÔNG HỢP LỆ", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }


                NhanVien nv = new NhanVien(manv, hoten, ngaysinh, gioitinh, quequan, phongban, chucvu, luong, hoahong, phucap);
                Element NhanVien = doc.getDocumentElement();
                themNhanVien(doc, NhanVien, nv);
                ghiflie();
                hienthi();
            }
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        try {
        
        String manv = txtma.getText();
        if (manv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "VUI LÒNG NHẤN VÀO BẢNG THÔNG TIN NHÂN VIÊN.", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String duongdan = "/nhanviens/nhanvien[manv='" + manv + "']";
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();
        Node chon = (Node) xp.evaluate(duongdan, doc, XPathConstants.NODE);
        if (chon != null) {
            chon.getParentNode().removeChild(chon);
            ghiflie();
            hienthi();
            txtma.setText("");
            txthoten.setText("");
            txtngaysinh.setText("");
            txtgt.setText("");
            txtquequan.setText("");
            txtluong.setText("");
            txthoahong.setText("");
            txtphucap.setText("");
            comboxpb.setSelectedIndex(0);
            comboxcv.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "KHÔNG TÌM THẤY NHÂN VIÊN CÓ MÃ: " + manv, "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    } catch (XPathExpressionException ex) {
        Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        try {
        String manv, hoten, ngaysinh, gioitinh, quequan, phongban, chucvu, luong, hoahong, phucap;
        manv = txtma.getText();
        hoten = chuanHoa(txthoten.getText());
        ngaysinh = txtngaysinh.getText();
        gioitinh = chuanHoa(txtgt.getText().trim().toLowerCase());
        quequan = chuanHoa(txtquequan.getText());
        phongban = comboxpb.getSelectedItem().toString();
        chucvu = comboxcv.getSelectedItem().toString();
        luong = txtluong.getText();
        hoahong = txthoahong.getText();
        phucap = txtphucap.getText();
        
        if (manv.isEmpty() || hoten.isEmpty() || ngaysinh.isEmpty() || gioitinh.isEmpty() || quequan.isEmpty() || phongban.isEmpty() || chucvu.isEmpty() || luong.isEmpty() || hoahong.isEmpty() || phucap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "VUI LÒNG NHẤN VÀO BẢNG THÔNG TIN NHÂN VIÊN.", "WARNING", JOptionPane.WARNING_MESSAGE);
            return;
        }
             
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);

                try {
                    Date ngaysinhDate = dateFormat.parse(ngaysinh);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(this, "NGÀY SINH KHÔNG HỢP LỆ, VUI LÒNG NHẬP THEO ĐỊNH DẠNG dd/MM/YYYY", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                gioitinh = gioitinh.substring(0, 1).toUpperCase() + gioitinh.substring(1);

                if (!gioitinh.equals("Nam") && !gioitinh.equals("Nữ")) {
                    JOptionPane.showMessageDialog(this, "GIỚI TÍNH KHÔNG HỢP LỆ, CHỈ ĐƯỢC NHẬP 'Nam' HOẶC 'Nữ'", "WARNING", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                
                

        String duongdan = "/nhanviens/nhanvien[manv='" + manv + "']";
        
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();
        Node chon = (Node) xp.evaluate(duongdan, doc, XPathConstants.NODE);
        
        
        if (chon != null) {
           
            Element nhanvienElement = (Element) chon;
            nhanvienElement.getElementsByTagName("hoten").item(0).setTextContent(hoten);
            nhanvienElement.getElementsByTagName("ngaysinh").item(0).setTextContent(ngaysinh);
            nhanvienElement.getElementsByTagName("gioitinh").item(0).setTextContent(gioitinh);
            nhanvienElement.getElementsByTagName("quequan").item(0).setTextContent(quequan);
            nhanvienElement.getElementsByTagName("phongban").item(0).setTextContent(phongban);
            nhanvienElement.getElementsByTagName("chucvu").item(0).setTextContent(chucvu);
            
            
            DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
            luong = luong.replaceAll(",", "");
            hoahong = hoahong.replaceAll(",", "");
            phucap = phucap.replaceAll(",", "");
            
            double luongDouble = Double.parseDouble(luong);
            double hoahongDouble = Double.parseDouble(hoahong);
            double phucapDouble = Double.parseDouble(phucap);


            txtluong.setText(decimalFormat.format(luongDouble));
            txthoahong.setText(decimalFormat.format(hoahongDouble));
            txtphucap.setText(decimalFormat.format(phucapDouble));
            
            nhanvienElement.getElementsByTagName("luong").item(0).setTextContent(decimalFormat.format(luongDouble));
            nhanvienElement.getElementsByTagName("hoahong").item(0).setTextContent(decimalFormat.format(hoahongDouble));
            nhanvienElement.getElementsByTagName("phucap").item(0).setTextContent(decimalFormat.format(phucapDouble));

            
          
            ghiflie();
            hienthi();
        } else {
            JOptionPane.showMessageDialog(this, "BẠN KHÔNG ĐƯỢC SỬA MÃ NHÂN VIÊN ", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    } catch (XPathExpressionException ex) {
        Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        txtma.setText("");
        txthoten.setText(""); 
        txtngaysinh.setText("");
        txtgt.setText("");
        txtquequan.setText("");
        txtluong.setText(""); 
        txthoahong.setText("");
        txtphucap.setText("");
        comboxpb.setSelectedIndex(0);
        comboxcv.setSelectedIndex(0);
    }//GEN-LAST:event_btnresetActionPerformed

    private void tblbangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbangMouseClicked
        int hangchon = tblbang.getSelectedRow();
        String manv, hoten, ngaysinh, gioitinh, quequan, phongban, chucvu, luong, hoahong, phucap;
        
        manv = (String)tblbang.getValueAt(hangchon, 0);
        hoten = (String)tblbang.getValueAt(hangchon, 1);
        ngaysinh = (String)tblbang.getValueAt(hangchon, 2);
        gioitinh = (String)tblbang.getValueAt(hangchon, 3);
        quequan = (String)tblbang.getValueAt(hangchon, 4);
        phongban = (String)tblbang.getValueAt(hangchon, 5);
        chucvu = (String)tblbang.getValueAt(hangchon, 6);
        luong = (String)tblbang.getValueAt(hangchon, 7);
        hoahong = (String)tblbang.getValueAt(hangchon, 8);
        phucap = (String)tblbang.getValueAt(hangchon, 9);
        
        txtma.setText(manv);
        txthoten.setText(hoten);
        txtngaysinh.setText(ngaysinh);
        txtgt.setText(gioitinh);
        txtquequan.setText(quequan);
        comboxpb.setSelectedItem(phongban);
        comboxcv.setSelectedItem(chucvu);
        txtluong.setText(luong);
        txthoahong.setText(hoahong);
        txtphucap.setText(phucap);

    }//GEN-LAST:event_tblbangMouseClicked

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        String manv = txtma.getText().trim();
    if (!manv.isEmpty()) {
        updateEmployeeTable(manv);
    } else {
        JOptionPane.showMessageDialog(this, "VUI LÒNG NHẬP MÃ NHÂN VIÊN ĐỂ TÌM KIẾM.", 
                "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void btnthongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthongkeActionPerformed

        int rowCount = tblbang.getRowCount();
        JOptionPane.showMessageDialog(this, "Số lượng nhân viên: " + rowCount, 
                "Thống kê", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnthongkeActionPerformed

    private void tblbang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbang2MouseClicked
        int hangchon = tblbang2.getSelectedRow();
        String manv, hoten, ngaysinh, gioitinh, quequan, phongban, chucvu, luong, hoahong, phucap;
        
        manv = (String)tblbang2.getValueAt(hangchon, 0);
        hoten = (String)tblbang2.getValueAt(hangchon, 1);
        ngaysinh = (String)tblbang2.getValueAt(hangchon, 2);
        gioitinh = (String)tblbang2.getValueAt(hangchon, 3);
        quequan = (String)tblbang2.getValueAt(hangchon, 4);
        phongban = (String)tblbang2.getValueAt(hangchon, 5);
        chucvu = (String)tblbang2.getValueAt(hangchon, 6);
        luong = (String)tblbang2.getValueAt(hangchon, 7);
        hoahong = (String)tblbang2.getValueAt(hangchon, 8);
        phucap = (String)tblbang2.getValueAt(hangchon, 9);
        
        txtma.setText(manv);
        txthoten.setText(hoten);
        txtngaysinh.setText(ngaysinh);
        txtgt.setText(gioitinh);
        txtquequan.setText(quequan);
        comboxpb.setSelectedItem(phongban);
        comboxcv.setSelectedItem(chucvu);
        txtluong.setText(luong);
        txthoahong.setText(hoahong);
        txtphucap.setText(phucap);
    }//GEN-LAST:event_tblbang2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienFrame().setVisible(true);
            }
        });
    }

    private boolean dadayduthongtin(String manv, String hoten, String ngaysinh, String gioitinh, String quequan,
             String phongban, String chucvu, String luong, String hoahong, String phucap) {
    boolean dadaydu = true;
    if (manv.trim().isEmpty() || hoten.trim().isEmpty() || phongban.trim().isEmpty() 
                        || chucvu.trim().isEmpty() || luong.trim().isEmpty()|| hoahong.trim().isEmpty()|| phucap.trim().isEmpty()) {
        dadaydu = false;
    } else if (ngaysinh.trim().isEmpty() || gioitinh.trim().isEmpty() || quequan.trim().isEmpty()) {
        dadaydu = false;
    }

    return dadaydu;
}


    private boolean datrungmanv(String manv) {
        boolean datrung = false;
        for (NhanVien nv : nvList) {
            if (nv.getMaNV().compareToIgnoreCase(manv) == 0) {
                datrung = true;
                break;
            }
        }

        return datrung;
    }

    private void themNhanVien(Document doc, Element NhanViens, NhanVien nv) {

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
    
    private void ghiflie(){
        TransformerFactory tff = TransformerFactory.newInstance();
            try {
                Transformer tf = tff.newTransformer();
                tf.setOutputProperty(OutputKeys.INDENT,"yes");
                tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","3");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult("src/view/NhanVien.xml");
                tf.transform(source, result);
                System.out.println("Ghi flie thanh cong!!");
                
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(taoxml.class.getName()).log(Level.SEVERE, null, ex);
            } catch (TransformerException ex) {
                Logger.getLogger(taoxml.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    private void updateEmployeeTable(String manv) {
    DefaultTableModel model = (DefaultTableModel) tblbang2.getModel();
    model.setRowCount(0); 
    
    try {
        String duongdan = "/nhanviens/nhanvien[manv='" + manv + "']";
        
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xp = xpf.newXPath();
        Node chon = (Node) xp.evaluate(duongdan, doc, XPathConstants.NODE);
        
        if (chon != null) {
         
            Element nhanvienElement = (Element) chon;
            String hoten = nhanvienElement.getElementsByTagName("hoten").item(0).getTextContent();
            String ngaysinh = nhanvienElement.getElementsByTagName("ngaysinh").item(0).getTextContent();
            String gioitinh = nhanvienElement.getElementsByTagName("gioitinh").item(0).getTextContent();
            String quequan = nhanvienElement.getElementsByTagName("quequan").item(0).getTextContent();
            String phongban = nhanvienElement.getElementsByTagName("phongban").item(0).getTextContent();
            String chucvu = nhanvienElement.getElementsByTagName("chucvu").item(0).getTextContent();
            String luong = nhanvienElement.getElementsByTagName("luong").item(0).getTextContent();
            String hoahong = nhanvienElement.getElementsByTagName("hoahong").item(0).getTextContent();
            String phucap = nhanvienElement.getElementsByTagName("phucap").item(0).getTextContent();
            
            
            model.addRow(new Object[]{manv, hoten, ngaysinh, gioitinh, quequan, phongban, chucvu, luong, hoahong, phucap});
        } else {
            JOptionPane.showMessageDialog(this, "KHÔNG TÌM THẤY NHÂN VIÊN VỚI MÃ " + manv, "THÔNG BÁO", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (XPathExpressionException ex) {
        JOptionPane.showMessageDialog(this, "ĐÃ XẢY RA LỖI KHI TÌM KIẾM.", "ERROR", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(NhanVienFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    private String chuanHoa(String ten) {
    StringBuilder stringBuilder = new StringBuilder();
    String[] words = ten.trim().split("\\s+");

    for (String word : words) {
        if (!word.isEmpty()) {
            stringBuilder.append(Character.toUpperCase(word.charAt(0)))
                         .append(word.substring(1).toLowerCase())
                         .append(" ");
        }
    }

    return stringBuilder.toString().trim();
}

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthongke;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> comboxcv;
    private javax.swing.JComboBox<String> comboxpb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblbang;
    private javax.swing.JTable tblbang2;
    private javax.swing.JTextField txtgt;
    private javax.swing.JTextField txthoahong;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtluong;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtngaysinh;
    private javax.swing.JTextField txtphucap;
    private javax.swing.JTextField txtquequan;
    // End of variables declaration//GEN-END:variables
}
