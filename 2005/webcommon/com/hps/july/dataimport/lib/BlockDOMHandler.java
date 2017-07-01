package com.hps.july.dataimport.lib;

import java.util.*;
import java.io.*;
import org.xml.sax.*;
import org.apache.xerces.parsers.*;
import org.w3c.dom.*;
import org.apache.struts.util.*;
import java.lang.reflect.Constructor;
import java.text.MessageFormat;

/**
  * Обработчик блока XML данных типа DOM
*/
public class BlockDOMHandler {

    private Element elmSheet;

public BlockDOMHandler(Document doc, int numberOfSheet) {

    NodeList sheetsList = doc.getElementsByTagName("worksheet");

    for (int i = 0; i < sheetsList.getLength(); i++) {

        Element elmSheetI = (Element) sheetsList.item(i);
        int numI = Integer.parseInt(elmSheetI.getAttribute("number"));

        if (numI == numberOfSheet) {
            elmSheet = elmSheetI;
            return;
        }
    }

}
public String[] getFinish() {
    NodeList finishList = elmSheet.getElementsByTagName("flag_end");
    Element elmfinish = (Element) finishList.item(0);

    NodeList finishCellsList = elmfinish.getElementsByTagName("flag_cell");

    String[] finishCells = new String[2];
    for (int i = 0; i < finishCellsList.getLength(); i++) {
        Element elmCell = (Element) finishCellsList.item(i);
        finishCells[i] = elmCell.getAttribute("column");
    }

    return finishCells;
}
public String getSheetDescription() {
    return elmSheet.getAttribute("description");
}
public String getStartFlagCell() {
    NodeList flagStartList = elmSheet.getElementsByTagName("flag_start");
    Element elmFlagStart = (Element) flagStartList.item(0);
     
    NodeList flagCellList = elmFlagStart.getElementsByTagName("flag_cell");
    return ((Element) flagCellList.item(0)).getAttribute("column");

}
public int getStartRow() {
    NodeList startRowList = elmSheet.getElementsByTagName("row_start");
    Element elmStartRow = (Element) startRowList.item(0);

    return Integer.parseInt(elmStartRow.getAttribute("number"));
}
}
