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
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Image image = new BufferedImage(100,100,BufferedImage.TYPE_INT_ARGB);
        Graphics g = image.getGraphics();
        g.fillOval(0, 0, 100, 100);
        ImageTransferable imageTransferable = new ImageTransferable(image);
        clipboard.setContents(imageTransferable, null);

        DataFlavor flavor = DataFlavor.imageFlavor;
        if (clipboard.isDataFlavorAvailable(flavor)){ // если буфер обмена не пуст
            Image img = (Image) clipboard.getData(flavor);
        }
    }
}

class ImageTransferable implements Transferable{
    Image theImage;
    public ImageTransferable(Image image){
        theImage=image;
    }
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[]{DataFlavor.imageFlavor};
    }

    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        return flavor.equals(DataFlavor.imageFlavor);
    }

    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(DataFlavor.imageFlavor)){
            return theImage;
        }else {
            throw  new UnsupportedFlavorException(flavor);
        }
    }
}
