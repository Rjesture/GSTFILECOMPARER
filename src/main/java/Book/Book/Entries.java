package Book.Book;

import java.util.Date;

class Entries {
    private String gstno;
    private String name;
    private String billno;
    private Date date;
    private double total;
    private double tvalue;
    private double igst;
    private double cgst;
    private double sgst;
    private String source;

    public Entries(String gstno, String name, String billno, Date date, double total, double tvalue, double igst, double cgst, double sgst, String source) {
        this.gstno = gstno;
        this.name = name;
        this.billno = billno;
        this.date = date;
        this.total = total;
        this.tvalue = tvalue;
        this.igst = igst;
        this.cgst = cgst;
        this.sgst = sgst;
        this.source = source;
    }


    public String getGstno() {
        return gstno;
    }

    public void setGstno(String gstno) {
        this.gstno = gstno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getTvalue() {
        return tvalue;
    }

    public void setTvalue(double tvalue) {
        this.tvalue = tvalue;
    }

    public double getIgst() {
        return igst;
    }

    public void setIgst(double igst) {
        this.igst = igst;
    }

    public double getCgst() {
        return cgst;
    }

    public void setCgst(double cgst) {
        this.cgst = cgst;
    }

    public double getSgst() {
        return sgst;
    }

    public void setSgst(double sgst) {
        this.sgst = sgst;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
