package com.AWT;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class IMGclipboard {
    public static void main(String[] args) throws IOException, UnsupportedFlavorException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();// создание буфера обмена
        Image image = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB); // создание картинки
        Graphics g = image.getGraphics(); // графика
        g.fillOval(0, 0, 100, 100); // рисуем овал
        ImageTransferable imageTransferable = new ImageTransferable(image); // наш класс с картинкой
        clipboard.setContents(imageTransferable, null); // копируем в наш буфер обмена

        DataFlavor flavor = DataFlavor.imageFlavor; // тип данных
        if (clipboard.isDataFlavorAvailable(flavor)){ // если буфер обмена не пуст
            Image img = (Image) clipboard.getData(flavor); // вставляем картинку из буфера обмена
        }
    }
}

class ImageTransferable implements Transferable{
    Image theImage; // наша картинка

    public ImageTransferable(Image image){ // коснтруктор
        theImage=image;
    }
    @Override
    public DataFlavor[] getTransferDataFlavors() { // поддерживаемый тип
        return new DataFlavor[]{DataFlavor.imageFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) { // проверка типа
        return flavor.equals(DataFlavor.imageFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException { // вернуть картинку
        if (flavor.equals(DataFlavor.imageFlavor)){
            return theImage;
        }else {
            throw  new UnsupportedFlavorException(flavor);
        }
    }
}
