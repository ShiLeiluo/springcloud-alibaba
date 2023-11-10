package com.fox.alibaba.test;

import com.aspose.cells.ImageOrPrintOptions;
import com.aspose.cells.ImageType;
import com.aspose.cells.SheetRender;
import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

/**
* @author F1337248 ShiLeiluo
* @date 2023-09-06 18:40
* @version 1.0
*/
public class Excel2Img {
 
    private void convertToImage(String sourcePath, int sheetId, String startPoint, String endPoint) {
        try {
            String resultPath = "C:/Users/F1337248/Desktop/test/test.jpeg";
            System.out.println("resultPath: " + resultPath);
            Workbook workbook = new Workbook(sourcePath);
            Worksheet worksheet = workbook.getWorksheets().get(sheetId);
            String area = startPoint + ":" + endPoint;
            System.out.println("area: " + area);
            // set the startPoint and endPoint
            worksheet.getPageSetup().setPrintArea(area);
            worksheet.getPageSetup().setLeftMargin(1);
            worksheet.getPageSetup().setRightMargin(1);
            worksheet.getPageSetup().setTopMargin(1);
            worksheet.getPageSetup().setBottomMargin(1);
            ImageOrPrintOptions options = new ImageOrPrintOptions();
            options.setOnePagePerSheet(true);
//            options.setImageFormat(ImageFormat.getJpeg());
            options.setImageType(ImageType.JPEG);
            // set the fonts
//            CellsHelper.setFontDir("/usr/share/fonts/chinese/Fonts");

            SheetRender sheetRender = new SheetRender(worksheet, options);
            sheetRender.toImage(sheetId, resultPath);
            System.out.println("Finish Convert Job");
        } catch (Exception error) {
            error.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        String sourcePath = "C:/Users/F1337248/Desktop/test/test.xlsx";
        int sheetId = 0;
        String startPoint = "A1";
        String endPoint = "O96";
        Excel2Img excel2Img = new Excel2Img();
        excel2Img.convertToImage(sourcePath, sheetId, startPoint, endPoint);
    }
}
