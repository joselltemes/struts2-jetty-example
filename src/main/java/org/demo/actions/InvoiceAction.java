package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import org.demo.actions.beans.InvoiceBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceAction extends ActionSupport  {

    InvoiceBean invoiceBean;

    @Override
    public String execute() throws Exception {
        System.out.println("execute!!");
        //asignar el valor de iva incluido
        invoiceBean.setVatIncluded(invoiceBean.getVat()* getInvoiceBean().getBruto());
        //asignar el precio con el iva
        invoiceBean.setPricePlusVat(invoiceBean.getVatIncluded()+ invoiceBean.getBruto());
        return SUCCESS;
    }

    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;
    }
    @Override
    public void validate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
            if (invoiceBean.getSubject().isEmpty()) {
                addFieldError( "invoiceBean.subject", "El concepto es obligatorio.");
            }
            else if(invoiceBean.getBruto()<=0){
                addFieldError("invoiceBean.bruto", "El importe no es valido.");
            }
            else if(invoiceBean.getDateFrom()==null || invoiceBean.getDateFrom().getTime()<dateWithoutTime.getTime()){
                addFieldError("invoiceBean.dateFrom", "Debe introducir una fecha actual.");
                System.out.println("error java datefrom"+invoiceBean.getDateFrom());
            }
            else if(invoiceBean.getDateTo()==null || invoiceBean.getDateTo().getTime()<dateWithoutTime.getTime()){
                addFieldError("invoiceBean.dateTo", "Debe introducir una fecha actual.");
            }
            else if(invoiceBean.getDateFrom().getTime()> invoiceBean.getDateTo().getTime()){
                addFieldError("invoiceBean.bruto", "Debe introducir un rango de fechas valido.");
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
