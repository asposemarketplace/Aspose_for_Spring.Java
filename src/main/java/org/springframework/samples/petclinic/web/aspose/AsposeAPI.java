package org.springframework.samples.petclinic.web.aspose;

import aspose.pdf.*;
import aspose.pdf.BorderInfo;
import aspose.pdf.MarginInfo;
import aspose.pdf.Row;
import aspose.pdf.Section;
import aspose.pdf.Table;
import com.aspose.barcode.BarCodeBuilder;
import com.aspose.barcode.BarCodeImageFormat;
import com.aspose.barcode.CodeLocation;
import com.aspose.barcode.Symbology;
import com.aspose.cells.*;
import com.aspose.cells.Color;
import com.aspose.email.MailAddress;
import com.aspose.email.MailMessage;
import com.aspose.email.MailMessageSaveType;
import com.aspose.pdf.TextBuilder;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextParagraph;
import com.aspose.words.*;
import com.aspose.words.Font;
import com.aspose.words.HeaderFooterType;
import com.aspose.words.LoadFormat;
import com.aspose.words.LoadOptions;
import com.aspose.words.Shape;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.model.Vets;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
/*
 * Project Extension Name: Aspose for Spring Java (petclinic)
 *
 * @author: Adeel Ilyas
 * Company: Aspose Pty Ltd.
 *
 * Date: 4/6/2014
 *
 * Detail:
 * This Extension was written to showcase the usage of Aspose APIs for Java
 * (Aspose.Word, Aspose.PDF, Aspose.Cells,Aspose.Email, Aspose Barcode)
 * for Spring, Spring MVC Java Developers.
 */
public class AsposeAPI {
    public static void createAsposeBarCode(String billAmount,ServletOutputStream out, String symbology) {


        BarCodeBuilder bb = new BarCodeBuilder();

        //Set up code text (data to be encoded)
        bb.setCodeText(billAmount);

        //Set up code text color
        bb.setCodeTextColor(java.awt.Color.RED);

        //Set the location of the code text to above the barcode
        bb.setCodeLocation(CodeLocation.Above);

        //Increase the space between code text and barcode to 1 point
        bb.setCodeTextSpace(1.0f);

        //Set the symbology type
        bb.setSymbologyType(Long.valueOf(symbology));

        bb.save(out, BarCodeImageFormat.Png);



    }
    public static void asposeEmail(String toName, String toEmail,
                                   String fromEmail, String subject, String messageText,
                                   ServletOutputStream out) {

        // Create a new instance of MailMessage class
        MailMessage message = new MailMessage();

        // Set subject of the message
        message.setSubject(subject);

        // Set Html body
        message.setBody(messageText);

        message.setDate(Calendar.getInstance().getTime());

        // Set sender information
        message.setFrom(new MailAddress(fromEmail, "Guest", false));

        // Add TO recipients
        message.getTo().add(toEmail);

        // Add CC recipients
        message.getCC().add(fromEmail);

        message.setSender(new MailAddress(fromEmail, "Guest", false));

        message.save(out, MailMessageSaveType.getOutlookMessageFormat());

        // Display Status.
        System.out.println("New Emails created successfully.");

    }
    public static void exportHtmlToWords(ServletOutputStream out,
                                         byte[] bytes) throws Exception {
        try {

            InputStream is = new ByteArrayInputStream(bytes);
            System.out.println(bytes);
            LoadOptions loadOptions = new LoadOptions();
            loadOptions.setLoadFormat(LoadFormat.HTML);

            Document doc = new Document(is,loadOptions);

            doc.save(out, com.aspose.words.SaveFormat.DOC);

        } catch (Exception e) {
            throw new Exception("Aspose: Unable to export to ms word format.. some error occured",e);
        }
    }
    public static void generateOwnersListAsposePDF(ServletOutputStream out,
                                                   Collection<Owner> results,ServletContext context)  {
        // Create PDF document
        Pdf pdf1 = new Pdf();
        // Add a section into the PDF document
        Section sec1 = pdf1.getSections().add();
        //Create an image object in the section
        aspose.pdf.Image img1 = new aspose.pdf.Image(sec1);
        //Set the path of image file
        img1.getImageInfo().setFile(context.getRealPath("resources/images/banner-graphic.png"));
        sec1.getParagraphs().add(img1);

//
        // Add a text paragraph into the section
        Table table = new Table(sec1);
        MarginInfo margin2 = new MarginInfo();
        sec1.getParagraphs().add(table);
        table.setColumnWidths("80 80 100 80 80 80");
        MarginInfo margin = new MarginInfo();
        margin.setLeft(5f);
        margin.setRight(5f);
        margin.setTop(5f);
        margin.setBottom(5f);
        // Set the default cell padding to the MarginInfo object
        table.setDefaultCellPadding(margin);
        table.setDefaultCellBorder(new BorderInfo(
                com.aspose.pdf.BorderSide.All, 0.1F));
        table.setBorder(new BorderInfo(com.aspose.pdf.BorderSide.All, 1F));

        Row row1 = table.getRows().add();

        row1.getCells().add("First Name");
        row1.getCells().add("Last Name");
        row1.getCells().add("Address");
        row1.getCells().add("City");
        row1.getCells().add("Telephone");

        Iterator<Owner> ownerIterator = results.iterator();
        while (ownerIterator.hasNext()) {
            Owner _owner = ownerIterator.next();
            Row rows = table.getRows().add();
            rows.getCells().add(_owner.getFirstName());
            rows.getCells().add(_owner.getLastName());
            rows.getCells().add(_owner.getAddress());
            rows.getCells().add(_owner.getCity());
            rows.getCells().add(_owner.getTelephone());
        }

        // Save the document
        img1 = new aspose.pdf.Image(sec1);
        //Set the path of image file
        img1.getImageInfo().setFile(context.getRealPath("resources/images/aspose/asposeimage.jpg"));
        sec1.getParagraphs().add(img1);

        pdf1.save(out);

    }

    public static void generateOwnersListAsposeWords(ServletOutputStream out,
                                                     Collection<Owner> results,ServletContext context) throws Exception {

        try {

            com.aspose.words.Document doc = new com.aspose.words.Document();

            // DocumentBuilder provides members to easily add content to a
            // document.
            DocumentBuilder builder = new DocumentBuilder(doc);

            Shape shape = builder.insertImage(context.getResourceAsStream("resources/images/banner-graphic.png"));

            shape.setWrapType(WrapType.TOP_BOTTOM);



            shape.setRelativeHorizontalPosition(RelativeHorizontalPosition.PAGE);

            shape.setHorizontalAlignment(HorizontalAlignment.CENTER);



            shape.setRelativeVerticalPosition(RelativeVerticalPosition.PARAGRAPH);

            shape.setVerticalAlignment(VerticalAlignment.TOP);



            Font font = builder.getFont();

            font.setSize(16);

            font.setColor(java.awt.Color.BLUE);

            font.setName("Arial");



            builder.insertParagraph();
            // Write a new paragraph in the document with the text

            builder.insertParagraph();
            builder.writeln("Owners List");
            builder.insertParagraph();
            // Save the document in DOCX format. The format to save as is
            // inferred from the extension of the file name.
            // Aspose.Words supports saving any document in many more formats.

            builder.startTable();
            builder.insertCell();

            // Set height and define the height rule for the header row.
            builder.getRowFormat().setHeight(40.0);
            builder.getRowFormat().setHeightRule(HeightRule.AT_LEAST);

            // Some special features for the header row.
            builder.getCellFormat()
                    .getShading()
                    .setBackgroundPatternColor(
                            new java.awt.Color(198, 217, 241));
            builder.getParagraphFormat()
                    .setAlignment(ParagraphAlignment.CENTER);
            builder.getFont().setSize(16);
            builder.getFont().setName("Arial");
            builder.getFont().setBold(true);

            builder.getCellFormat().setWidth(100.0);
            builder.write("First Name");
            builder.insertCell();
            builder.write("Last Name");
            builder.insertCell();
            builder.write("Address");
            builder.insertCell();
            builder.write("City");
            builder.insertCell();
            builder.write("Telephone");
            builder.endRow();
            // Set features for the other rows and cells.
            builder.getCellFormat().getShading()
                    .setBackgroundPatternColor(java.awt.Color.WHITE);
            builder.getCellFormat().setWidth(100.0);
            builder.getCellFormat().setVerticalAlignment(
                    CellVerticalAlignment.CENTER);

            // Reset height and define a different height rule for table body
            builder.getRowFormat().setHeight(30.0);
            builder.getRowFormat().setHeightRule(HeightRule.AUTO);
            Iterator<Owner> ownerIterator = results.iterator();
            while (ownerIterator.hasNext()) {
                Owner _owner = ownerIterator.next();
                builder.insertCell();
                // Reset font formatting.
                builder.getFont().setSize(12);
                builder.getFont().setBold(false);
                builder.write(_owner.getFirstName());
                builder.insertCell();
                builder.write(_owner.getLastName());
                builder.insertCell();
                builder.write(_owner.getAddress());
                builder.insertCell();
                builder.write(_owner.getCity());
                builder.insertCell();
                builder.write(_owner.getTelephone());
                builder.endRow();
            }
            builder.endTable();
            builder.insertParagraph();
            builder.insertParagraph();
            //Create shape




            shape = builder.insertImage(context.getResourceAsStream("resources/images/aspose/asposeimage.jpg"));

            shape.setWrapType(WrapType.TOP_BOTTOM);



            shape.setRelativeHorizontalPosition(RelativeHorizontalPosition.PAGE);

            shape.setHorizontalAlignment(HorizontalAlignment.CENTER);



            shape.setRelativeVerticalPosition(RelativeVerticalPosition.PARAGRAPH);

            shape.setVerticalAlignment(VerticalAlignment.TOP);

            // Save the document

            doc.save(out, com.aspose.words.SaveFormat.DOC);

        } catch (Exception e) {
            throw new Exception("Aspose: Unable to export to ms word format.. some error occured",e);

        }
    }

    public static void generateOwnersListAsposeCells(ServletOutputStream out,
                                                     Collection<Owner> results, ServletContext context) throws Exception {

        try {

            Workbook workbook = new Workbook();
            // Obtaining the reference of the first worksheet
            Worksheet sheet = workbook.getWorksheets().get(0);

            //Adding a picture at the location of a cell whose row and column indices
            int pictureIndex = sheet.getPictures().add(2,4,context.getResourceAsStream("resources/images/banner-graphic.png"));
            Picture picture = sheet.getPictures().get(pictureIndex);

//Positioning the picture proportional to row height and colum width
            picture.setUpperDeltaX(200);
            picture.setUpperDeltaY(200);


            //Adding a picture at the location of a cell whose row and column indices
            pictureIndex = sheet.getPictures().add(22,4,context.getResourceAsStream("resources/images/aspose/asposeimage.jpg"));
            picture = sheet.getPictures().get(pictureIndex);

//Positioning the picture proportional to row height and colum width
            picture.setUpperDeltaX(200);

            // Name the sheet
            sheet.setName("Owners List");

            com.aspose.cells.Cells cells = sheet.getCells();

            // Setting the values to the cells
            com.aspose.cells.Cell cell = cells.get("F11");
            cell.setValue("First Name");
            cell = cells.get("G11");
            cell.setValue("Last Name");
            cell = cells.get("H11");
            cell.setValue("Address");
            cell = cells.get("I11");
            cell.setValue("City");
            cell = cells.get("J11");
            cell.setValue("Telephone");

            // Create a new style object.
            int styleIdx = workbook.getStyles().add();
            com.aspose.cells.Style style = workbook.getStyles().get(styleIdx);

            // Set the number format.
            style.setNumber(14);

            // Set the font color to red color.
            style.getFont().setColor(com.aspose.cells.Color.getRed());
            style.getFont().setBold(true);
            // Name the style.
            style.setName("Heading");
            com.aspose.cells.Range range = cells.createRange("A1", "E1");
            // Initialize styleflag object.
            StyleFlag flag = new StyleFlag();

            // Set all formatting attributes on.
            flag.setAll(true);

            // Apply the style (described above)to the range.
            range.applyStyle(style, flag);
            style.update();

            Iterator<Owner> ownerIterator = results.iterator();
            int i = 12;
            while (ownerIterator.hasNext()) {
                Owner _owner = ownerIterator.next();
                cell = cells.get("F" + i);
                cell.setValue(_owner.getFirstName());
                cell = cells.get("G" + i);
                cell.setValue(_owner.getLastName());
                cell = cells.get("H" + i);
                cell.setValue(_owner.getAddress());
                cell = cells.get("I" + i);
                cell.setValue(_owner.getCity());
                cell = cells.get("J" + i);
                cell.setValue(_owner.getTelephone());
                i++;
            }

            // Save the document

            workbook.save(out, com.aspose.cells.SaveFormat.XLSX);

        } catch (Exception e) {
            throw new Exception("Aspose: Unable to export to ms excel format.. some error occured",e);
        }
    }

    // /

    // Vets

    public static void generateVetsAsposePDF(ServletOutputStream out, Vets vets,ServletContext context) {
        // Create PDF document
        Pdf pdf1 = new Pdf();
        // Add a section into the PDF document
        Section sec1 = pdf1.getSections().add();


        //Create an image object in the section
        aspose.pdf.Image img1 = new aspose.pdf.Image(sec1);
        //Set the path of image file
        img1.getImageInfo().setFile(context.getRealPath("resources/images/banner-graphic.png"));
        sec1.getParagraphs().add(img1);

        // Add a text paragraph into the section
        Table table = new Table(sec1);
        MarginInfo margin2 = new MarginInfo();
        sec1.getParagraphs().add(table);
        table.setColumnWidths("80 80 100 80 100");
        MarginInfo margin = new MarginInfo();
        margin.setLeft(5f);
        margin.setRight(5f);
        margin.setTop(5f);
        margin.setBottom(5f);
        // Set the default cell padding to the MarginInfo object
        table.setDefaultCellPadding(margin);
        table.setDefaultCellBorder(new BorderInfo(
                com.aspose.pdf.BorderSide.All, 0.1F));
        table.setBorder(new BorderInfo(com.aspose.pdf.BorderSide.All, 1F));

        Row row1 = table.getRows().add();

        row1.getCells().add("First Name");
        row1.getCells().add("Last Name");
        row1.getCells().add("Specialties");
        row1.getCells().add("Days");
        row1.getCells().add("Email");

        Iterator<Vet> vetIterator = vets.getVetList().iterator();
        while (vetIterator.hasNext()) {
            Vet _vet = vetIterator.next();
            Row rows = table.getRows().add();
            rows.getCells().add(_vet.getFirstName());
            rows.getCells().add(_vet.getLastName());

            String specialties = "";
            for (Specialty _specialty : _vet.getSpecialties()) {
                specialties += _specialty.getName() + " ";
            }
            rows.getCells().add(specialties.trim());
            rows.getCells().add(_vet.getDays());
            rows.getCells().add(_vet.getEmail());
        }
        // Save the document
        img1 = new aspose.pdf.Image(sec1);
        //Set the path of image file
        img1.getImageInfo().setFile(context.getRealPath("resources/images/aspose/asposeimage.jpg"));
        sec1.getParagraphs().add(img1);
        // Save the document

        pdf1.save(out);

    }

    public static void generateVetsAsposeWords(ServletOutputStream out,
                                               Vets vets,ServletContext context) throws Exception{

        try {

            com.aspose.words.Document doc = new com.aspose.words.Document();

            // DocumentBuilder provides members to easily add content to a
            // document.
            DocumentBuilder builder = new DocumentBuilder(doc);
            Shape shape = builder.insertImage(context.getResourceAsStream("resources/images/banner-graphic.png"));

            shape.setWrapType(WrapType.TOP_BOTTOM);



            shape.setRelativeHorizontalPosition(RelativeHorizontalPosition.PAGE);

            shape.setHorizontalAlignment(HorizontalAlignment.CENTER);



            shape.setRelativeVerticalPosition(RelativeVerticalPosition.PARAGRAPH);

            shape.setVerticalAlignment(VerticalAlignment.TOP);



            Font font = builder.getFont();

            font.setSize(16);

            font.setColor(java.awt.Color.BLUE);

            font.setName("Arial");



            builder.insertParagraph();
            // Write a new paragraph in the document with the text

            builder.insertParagraph();
            builder.writeln("Veterinarians List");
            builder.insertParagraph();
            // Save the document in DOCX format. The format to save as is
            // inferred from the extension of the file name.
            // Aspose.Words supports saving any document in many more formats.

            builder.startTable();
            builder.insertCell();

            // Set height and define the height rule for the header row.
            builder.getRowFormat().setHeight(40.0);
            builder.getRowFormat().setHeightRule(HeightRule.AT_LEAST);

            // Some special features for the header row.
            builder.getCellFormat()
                    .getShading()
                    .setBackgroundPatternColor(
                            new java.awt.Color(198, 217, 241));
            builder.getParagraphFormat()
                    .setAlignment(ParagraphAlignment.CENTER);
            builder.getFont().setSize(16);
            builder.getFont().setName("Arial");
            builder.getFont().setBold(true);

            builder.getCellFormat().setWidth(100.0);
            builder.write("First Name");
            builder.insertCell();
            builder.write("Last Name");
            builder.insertCell();
            builder.write("Specialties");
            builder.insertCell();
            builder.write("Days");
            builder.insertCell();
            builder.write("Email");
            builder.endRow();
            // Set features for the other rows and cells.
            builder.getCellFormat().getShading()
                    .setBackgroundPatternColor(java.awt.Color.WHITE);
            builder.getCellFormat().setWidth(100.0);
            builder.getCellFormat().setVerticalAlignment(
                    CellVerticalAlignment.CENTER);

            // Reset height and define a different height rule for table body
            builder.getRowFormat().setHeight(30.0);
            builder.getRowFormat().setHeightRule(HeightRule.AUTO);
            Iterator<Vet> vetIterator = vets.getVetList().iterator();
            while (vetIterator.hasNext()) {
                Vet _vet = vetIterator.next();
                builder.insertCell();
                // Reset font formatting.
                builder.getFont().setSize(12);
                builder.getFont().setBold(false);
                builder.write(_vet.getFirstName());
                builder.insertCell();
                builder.write(_vet.getLastName());
                builder.insertCell();
                String specialties = "";
                for (Specialty _specialty : _vet.getSpecialties()) {
                    specialties += _specialty.getName() + " ";
                }
                builder.write(specialties.trim());
                builder.insertCell();
                builder.write(_vet.getDays());
                builder.insertCell();
                builder.write(_vet.getEmail());
                builder.endRow();
            }
            builder.endTable();
            builder.insertParagraph();
            builder.insertParagraph();
            //Create shape




            shape = builder.insertImage(context.getResourceAsStream("resources/images/aspose/asposeimage.jpg"));

            shape.setWrapType(WrapType.TOP_BOTTOM);



            shape.setRelativeHorizontalPosition(RelativeHorizontalPosition.PAGE);

            shape.setHorizontalAlignment(HorizontalAlignment.CENTER);



            shape.setRelativeVerticalPosition(RelativeVerticalPosition.PARAGRAPH);

            shape.setVerticalAlignment(VerticalAlignment.TOP);

            // Save the document

            doc.save(out, com.aspose.words.SaveFormat.DOC);

        } catch (Exception e) {
            throw new Exception("Aspose: Unable to export to ms word format.. some error occured",e);
        }
    }

    public static void generateVetsAsposeCells(ServletOutputStream out,
                                               Vets vets, ServletContext context) throws Exception{

        try {

            Workbook workbook = new Workbook();
            // Obtaining the reference of the first worksheet
            Worksheet sheet = workbook.getWorksheets().get(0);

            //Adding a picture at the location of a cell whose row and column indices
            int pictureIndex = sheet.getPictures().add(2,4,context.getResourceAsStream("resources/images/banner-graphic.png"));
            Picture picture = sheet.getPictures().get(pictureIndex);

//Positioning the picture proportional to row height and colum width
            picture.setUpperDeltaX(200);
            picture.setUpperDeltaY(200);


            //Adding a picture at the location of a cell whose row and column indices
             pictureIndex = sheet.getPictures().add(22,4,context.getResourceAsStream("resources/images/aspose/asposeimage.jpg"));
             picture = sheet.getPictures().get(pictureIndex);

//Positioning the picture proportional to row height and colum width
            picture.setUpperDeltaX(200);
            picture.setUpperDeltaY(200);
            workbook.getWorksheets().setActiveSheetIndex(0);
            // Name the sheet
            sheet.setName("Veterinarians List");

            com.aspose.cells.Cells cells = sheet.getCells();

            // Setting the values to the cells
            com.aspose.cells.Cell cell = cells.get("F11");
            cell.setValue("First Name");
            cell = cells.get("G11");
            cell.setValue("Last Name");
            cell = cells.get("H11");
            cell.setValue("Specialties");
            cell = cells.get("I11");
            cell.setValue("Days");
            cell = cells.get("J11");
            cell.setValue("Email");

            // Create a new style object.
            int styleIdx = workbook.getStyles().add();
            com.aspose.cells.Style style = workbook.getStyles().get(styleIdx);

            // Set the number format.
            style.setNumber(14);

            // Set the font color to red color.
            style.getFont().setColor(com.aspose.cells.Color.getRed());
            style.getFont().setBold(true);
            // Name the style.
            style.setName("Heading");
            com.aspose.cells.Range range = cells.createRange("F11", "J11");
            // Initialize styleflag object.
            StyleFlag flag = new StyleFlag();

            // Set all formatting attributes on.
            flag.setAll(true);

            // Apply the style (described above)to the range.
            range.applyStyle(style, flag);
            style.update();

            int i = 12;
            Iterator<Vet> vetIterator = vets.getVetList().iterator();
            while (vetIterator.hasNext()) {
                Vet _vet = vetIterator.next();
                cell = cells.get("F" + i);
                cell.setValue(_vet.getFirstName());
                cell = cells.get("G" + i);
                cell.setValue(_vet.getLastName());
                cell = cells.get("H" + i);
                String specialties = "";
                for (Specialty _specialty : _vet.getSpecialties()) {
                    specialties += _specialty.getName() + " ";
                }
                cell.setValue(specialties);
                cell = cells.get("H" + i);
                cell.setValue(_vet.getDays());
                cell = cells.get("J" + i);
                cell.setValue(_vet.getEmail());
                i++;
            }

            // Save the document

            workbook.save(out, com.aspose.cells.SaveFormat.XLSX);

        } catch (Exception e) {
            throw new Exception("Aspose: Unable to export to ms excel format.. some error occured",e);
        }
    }
}
