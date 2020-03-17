package hql.use_date_hql;

import java.text.SimpleDateFormat;
import java.util.List;

import entities.Invoice;

public class Main {

	public static void main(String[] args) {

		InvoiceModel invoiceModel = new InvoiceModel();
		List<Invoice> invoices = invoiceModel.findByDate(2017, 12, 8);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

	}

}
