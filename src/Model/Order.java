package Model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order extends ItemContainer {
    private Timestamp timestamp;
    private String customerName;
    public Order(List<Item> items1,String customerName,int i)
    {
        items = items1;
        this.customerName = customerName;
        Date date = new Date();
        timestamp = new Timestamp(date.getTime());
        id = i;

    }

    @Override
    public double getTotal() {
        double total = 0.0;
        for(Item i : items)
        {
            total += i.getTotal();
        }
        return (int)Math.round(total);
    }

    public String getCustomerName() {
        return customerName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
    public String getDateInString()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy   h:mm a");
        return sdf.format(timestamp);
    }
    public void generateInvoice(int customerPrice) throws DocumentException, IOException {
        String filePath = "src/invoices/invoiceID"+id+".pdf";
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        Image logoImage = Image.getInstance("pharmacy2.png");
        logoImage.scaleAbsolute(80, 80);
        logoImage.setAbsolutePosition(PageSize.A4.getWidth() - 100, PageSize.A4.getHeight() - 100);
        document.add(logoImage);
        Font pharmacyNameFont = new Font(Font.FontFamily.TIMES_ROMAN, 24, Font.BOLD);
        Paragraph pharmacyNameParagraph = new Paragraph(new Phrase("Vitality Village Pharmacy", pharmacyNameFont));
        pharmacyNameParagraph.setAlignment(Element.ALIGN_CENTER);
        pharmacyNameParagraph.setSpacingBefore(10);
        document.add(pharmacyNameParagraph);
        document.add(new Paragraph("\n"));
        Font invoiceLabelFont = new Font(Font.FontFamily.HELVETICA, 18, Font.ITALIC);
        Paragraph invoiceLabelParagraph = new Paragraph(new Phrase("Invoice", invoiceLabelFont));
        invoiceLabelParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(invoiceLabelParagraph);
        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Invoice ID: " + id));
        document.add(new Paragraph("Date: " + getDateInString()));
        document.add(new Paragraph("Customer Name: " + customerName));
        document.add(new Paragraph("\n"));
        addItemsTable(document, items);
        Paragraph totalParagraph = new Paragraph("Total Price: " + getTotal()+ "rs", FontFactory.getFont(FontFactory.HELVETICA_BOLD));
        totalParagraph.setAlignment(Element.ALIGN_RIGHT);
        document.add(totalParagraph);
        Paragraph customerGivenPriceLabel = new Paragraph("Customer Given Price: " + customerPrice+ "rs",FontFactory.getFont(FontFactory.HELVETICA_BOLD));
        customerGivenPriceLabel.setAlignment(Element.ALIGN_RIGHT);
        document.add(customerGivenPriceLabel);
        double customerRemainingPrice = customerPrice - getTotal();
        Paragraph customerRemainingPriceLabel = new Paragraph("Customer Remaining Price: " + customerRemainingPrice + "rs",FontFactory.getFont(FontFactory.HELVETICA_BOLD));
        customerRemainingPriceLabel.setAlignment(Element.ALIGN_RIGHT);
        document.add(customerRemainingPriceLabel);
        document.add(new Paragraph("\n"));
        Font thankYouFont = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL, BaseColor.BLUE);
        Paragraph thankYouParagraph = new Paragraph("Thank You For Your Purchase", thankYouFont);
        thankYouParagraph.setAlignment(Element.ALIGN_CENTER);
        document.add(thankYouParagraph);

        document.close();


    }

    private void addItemsTable(Document document, List<Item> items) {
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100);
        table.setHeaderRows(1);
        PdfPCell idHeaderCell = new PdfPCell(new Phrase("ID", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        idHeaderCell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(idHeaderCell);
        PdfPCell nameHeaderCell = new PdfPCell(new Phrase("Name", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        nameHeaderCell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(nameHeaderCell);
        PdfPCell priceHeaderCell = new PdfPCell(new Phrase("Price", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        priceHeaderCell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(priceHeaderCell);
        PdfPCell quantityHeaderCell = new PdfPCell(new Phrase("Quantity", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        quantityHeaderCell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(quantityHeaderCell);
        PdfPCell totalItemPriceHeaderCell = new PdfPCell(new Phrase("Total Item Price", FontFactory.getFont(FontFactory.HELVETICA_BOLD)));
        totalItemPriceHeaderCell.setBackgroundColor(BaseColor.GRAY);
        table.addCell(totalItemPriceHeaderCell);
        for (Item item : items) {
            table.addCell(String.valueOf(item.getProduct().getId()));
            table.addCell(item.getProduct().getName());
            table.addCell(String.valueOf(item.getProduct().getPrice()));
            table.addCell(String.valueOf(item.getQuantityOrdered()));

            table.addCell(String.valueOf(item.getTotal()));
        }

        try {
            document.add(table);
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }


    }

}
