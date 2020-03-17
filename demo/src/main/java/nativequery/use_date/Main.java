package nativequery.use_date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import entities.Invoice;

public class Main {

	public static void main(String[] args) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
		InvoiceModel invoiceModel = new InvoiceModel();

		System.out.println("Today: " + simpleDateFormat.format(new Date()));

		System.out.println("***************** Find By Week *****************");

		System.out.println("Find Invoices by This Week");
		List<Invoice> invoices = invoiceModel.findThisWeek();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("\nFind Invoices by Last Week");
		invoices = invoiceModel.findLastWeek();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("\nFind Invoices by Last 7 Days");
		invoices = invoiceModel.findLast7Days();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("***************** Find By Month *****************");

		System.out.println("Find Invoices by This Month");
		invoices = invoiceModel.findThisMonth();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("\nFind Invoices by Last Month");
		invoices = invoiceModel.findLastMonth();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("\nFind Invoices by Last 30 Days");
		invoices = invoiceModel.findLast30Days();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("***************** Find By Quarter *****************");

		System.out.println("Find Invoices by This Quarter");
		invoices = invoiceModel.findThisQuarter();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("\nFind Invoices by Last Quarter");
		invoices = invoiceModel.findLastQuarter();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("\nFind Invoices by Last 90 Days");
		invoices = invoiceModel.findLast90Days();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("***************** Find By Year *****************");

		System.out.println("Find Invoices by This Year");
		invoices = invoiceModel.findThisYear();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("\nFind Invoices by Last Year");
		invoices = invoiceModel.findLastYear();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

		System.out.println("\nFind Invoices by Last 365 Days");
		invoices = invoiceModel.findLast365Days();
		for (Invoice invoice : invoices) {
			System.out.println("Id: " + invoice.getId());
			System.out.println("Name: " + invoice.getName());
			System.out.println("Date Created: " + simpleDateFormat.format(invoice.getDateCreated()));
			System.out.println("Payment: " + invoice.getPayment());
			System.out.println("============================");
		}

	}

}
