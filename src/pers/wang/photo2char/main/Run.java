package pers.wang.photo2char.main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Run {

	public static void main(String[] args) {

		/**
		 * 创建对象时，也可以不设定参数，有默认参数 bg_alw为-1说明是无背景模式
		 **/

		Photo2Char p2c = new Photo2Char();
		p2c.setBackground(Color.WHITE, 30);
		p2c.setFigure(5, 10, 30);
		// i2f.setFont("宋体",10,Color.BLACK);

		/**
		 * 首先进行图片读取和裁剪，参数设置要在此之前 返回BufferImage对象用于后面的图片操作
		 **/
		BufferedImage bi = p2c.imgRead("C:\\workbench\\wangtemp\\zx", "jpg");

		/**
		 * 根据图片获取图片的像素组
		 **/
		int[][] img = p2c.getImgFig(bi);

		/**
		 * 绘制，保存
		 **/
		BufferedImage bi_new = p2c.drawByImgFig(img);
		// i2f.getCutImg(bi_new);
		p2c.saveImg(bi_new, "JPEG", "C:\\workbench\\wangtemp\\zx" + getTime());

		/**
		 * 根据原图和绘制出的图片，对符号进行上色，笔刷默认为黑色
		 **/
		BufferedImage bi_c = p2c.paintImgFigureColors(bi, bi_new, Color.BLACK);
		p2c.saveImg(bi_c, "JPEG", "C:\\workbench\\wangtemp\\zx_c" + getTime());

	}

	private static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");// 设置日期格式
		String date = df.format(new Date());
		return date;
	}

}
