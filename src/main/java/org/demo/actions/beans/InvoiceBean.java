package org.demo.actions.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceBean {

    private String subject;
    private double bruto;

    private double vatIncluded;
    private double pricePlusVat;
    private Date dateFrom;
    private Date dateTo;

    private final double  vat=0.21;
    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getBruto() {
        return bruto;
    }

    public void setBruto(double bruto) {
        this.bruto = bruto;
    }

    public double getVatIncluded() {
        return vatIncluded;
    }

    public void setVatIncluded(double vatIncluded) {
        this.vatIncluded = vatIncluded;
    }

    public double getPricePlusVat() {
        return pricePlusVat;
    }

    public void setPricePlusVat(double pricePlusVat) {
        this.pricePlusVat = pricePlusVat;
    }

    public double getVat() {
        return vat;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder sb=new StringBuilder("<p>");
        sb.append("IVA:");
        sb.append(getVat());
        sb.append("</p>");
        sb.append("<p>");
        sb.append("Artículo:");
        sb.append(getSubject());
        sb.append("</p>");
        sb.append("<p>");
        sb.append("Precio:");
        sb.append(getBruto());
        sb.append("</p>");
        sb.append("<p>");
        sb.append("Iva calculado:");
        sb.append(getVatIncluded());
        sb.append("</p>");
        sb.append("<p>");
        sb.append("Precio + Iva:");
        sb.append(getPricePlusVat());
        sb.append("</p>");
        sb.append("<p>");
        sb.append("Fechas:");
        sb.append(sdf.format(getDateFrom()));
        sb.append(" / ");
        sb.append(sdf.format(getDateTo()));
        sb.append("</p>");
        return sb.toString();
    }
}
