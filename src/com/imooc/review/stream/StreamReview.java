package com.imooc.review.stream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamReview {
	public static void main(String[] args) throws FileNotFoundException {
		//PrintWriter pw = new PrintWriter(new File("111.txt"));
		StreamReview sr = new StreamReview();
		//sr.testBufferedStream();
		//sr.testInputStream();
		sr.testMarkAndReset();
	}
	
	public void testBufferedStream() {
		try {
			double start = System.currentTimeMillis();
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("file//222.chm"));
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream("file//222o1.chm"));
			int b = 0;
			//int j = 1;
			while((b=bis.read()) != -1) {
				/*if(b <= 15) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString((b & 0xff))+" ");
				if(j++%10 == 0) {
					System.out.println();
				}*/
				bos.write(b);
			}
			bos.flush();
			double end = System.currentTimeMillis();
			bis.close();
			bos.close();
			System.out.println("\nTotle time: " + (end-start)/1000 + "s");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void testInputStream() {
		try {
			double start = System.currentTimeMillis();
			InputStream bis = new FileInputStream("file//222.chm");
			OutputStream bos = new FileOutputStream("file//222o2.chm");
			int b = 0;
			//int j = 1;
			while((b=bis.read()) != -1) {
				/*if(b <= 15) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString((b & 0xff))+" ");
				if(j++%10 == 0) {
					System.out.println();
				}*/
				bos.write(b);
			}
			double end = System.currentTimeMillis();
			bis.close();
			bos.close();
			System.out.println("\nTotle time: " + (end-start)/1000 + "s");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testBufferedReader() {
		try {
			double start = System.currentTimeMillis();
			BufferedReader bf = new BufferedReader(
					new FileReader("file//111.txt"));
			PrintWriter pw = new PrintWriter(
					new File("file//111.txt"));
			int b = 0;
			//int j = 1;
			while((b=bf.read()) != -1) {
				/*if(b <= 15) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString((b & 0xff))+" ");
				if(j++%10 == 0) {
					System.out.println();
				}*/
				pw.write(b);
				pw.flush();
			}
			double end = System.currentTimeMillis();
			bf.close();
			pw.close();
			System.out.println("\nTotle time: " + (end-start)/1000 + "s");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
		public void testMarkAndReset() {
		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream("file//111.txt"));
			int b = 0;
			int j = 1;
			int flag = 5;
			while((b=bis.read()) != -1) {
				if(b <= 0x0f) {
					System.out.print("0");
				}
				if(b == 0x20) {
					bis.mark(10);
				}
				System.out.print(Integer.toHexString((b & 0xff))+" ");
				if(j++%10 == 0) {
					System.out.println();
				}
				if(b == 0x41 && flag > 0) {
					bis.reset();
					flag--;
				}
			}
			bis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
