package com.AWT;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); // создание буфера обмена
        StringSelection stringSelection = new StringSelection("11"); // строка выбраного текста
        clipboard.setContents(stringSelection, null); // копируем её в буфер обмена

        DataFlavor flavor = DataFlavor.stringFlavor; // тип данных
        if (clipboard.isDataFlavorAvailable(flavor)){ // если буфер обмена не пуст
            System.out.println(clipboard.getData(flavor)); // вывод на экран, значения из буфера обмена
        }
    }
}
