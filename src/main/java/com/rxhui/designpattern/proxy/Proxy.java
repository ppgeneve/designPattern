package com.rxhui.designpattern.proxy;

import java.net.URL;

/**
 * @author ppgeneve
 * @Description: 静态代理
 * @Date 2018/6/12 17:06
 */
interface Image {
    /**
     * 显示图片
     */
    void showImage();
}

class ImageProxy implements Image {
    private HighResolutionImage image;

    public ImageProxy(HighResolutionImage highResolutionImage) {
        this.image = highResolutionImage;
    }

    @Override
    public void showImage() {
        while (!image.isLoad()) {
            try {
                System.out.println("Temp Image: " + image.getWidth() + " " + image.getHeight());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        image.showImage();
    }
}

class HighResolutionImage implements Image{
    private URL imageURL;
    private long startTime;
    private int height;
    private int width;

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public HighResolutionImage(URL imageURL) {
        this.imageURL = imageURL;
        this.startTime = System.currentTimeMillis();
        this.height = 600;
        this.width = 800;
    }

    public boolean isLoad() {
        long endTime = System.currentTimeMillis();
        return  endTime - startTime > 3000;
    }


    @Override
    public void showImage() {
        System.out.println("Real Image: " + imageURL);
    }
}

class ImageViewer {
    public static void main(String[] args) throws Exception {
        String image = "http://image.jpg";
        URL url = new URL(image);
        HighResolutionImage highResolutionImage = new HighResolutionImage(url);
        ImageProxy imageProxy = new ImageProxy(highResolutionImage);
        imageProxy.showImage();
    }
}


