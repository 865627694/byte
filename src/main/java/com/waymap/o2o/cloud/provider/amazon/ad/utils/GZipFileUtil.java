package com.waymap.o2o.cloud.provider.amazon.ad.utils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipException;

/**
 * @author blue
 * @description .gz工具类
 * @email blue.liu@waymap.cn
 * @date 2019/10/30
 */
public class GZipFileUtil {
    private static void doCompressFile(String inFileName) {
        try {
            System.out.println("Creating the GZIP output stream.");
            String outFileName = inFileName + ".gz";
            GZIPOutputStream out = null;
            try {
                out = new GZIPOutputStream(new FileOutputStream(outFileName));
            } catch (FileNotFoundException e) {
                System.err.println("Could not create file: " + outFileName);
                System.exit(1);
            }
            System.out.println("Opening the input file.");
            FileInputStream in = null;
            try {
                in = new FileInputStream(inFileName);
            } catch (FileNotFoundException e) {
                System.err.println("File not found. " + inFileName);
                System.exit(1);
            }
            System.out.println("Transfering bytes from input file to GZIP Format.");
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            System.out.println("Completing the GZIP file");
            out.finish();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * @MethodName: uncompressGetJson
     * @Description: 亚马逊专用方法，解压.gz文件，获取其中的json字符串
     * @Param: [inputStream, outFileName]
     * @Return: void
     * @Author: blue
     * @Date: 2019/10/29
     **/
    public static String uncompressGetJson(InputStream inputStream) {
        try {
            GZIPInputStream in = new GZIPInputStream(inputStream);
            StringBuffer sb = new StringBuffer();
            byte[] tempbytes = new byte[1024];
            int byteread = 0;
            // 读入多个字节到字节数组中，byteread为一次读入的字节数
            while ((byteread = in.read(tempbytes)) != -1) {
                String str = new String(tempbytes, 0, byteread);
                sb.append(str);
            }
            return sb.toString();
        } catch (ZipException e) {
            System.out.println("解压出现异常：" + e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void doUncompressFile(InputStream inputStream, String outFileName) {
        try {
            GZIPInputStream in = new GZIPInputStream(inputStream);
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(outFileName);
            } catch (FileNotFoundException e) {
                System.err.println("Could not write to file. " + outFileName);
                System.exit(1);
            }
            System.out.println("Transfering bytes from compressed file to the output file.");
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            System.out.println("Closing the file and stream");
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Uncompress the incoming file.
     *
     * @param inFileName Name of the file to be uncompressed
     */
    private static void doUncompressFile(String inFileName) {
        try {
            if (!getExtension(inFileName).equalsIgnoreCase("gz")) {
                System.err.println("File name must have extension of \".gz\"");
                System.exit(1);
            }
            System.out.println("Opening the compressed file.");
            GZIPInputStream in = null;
            try {
                in = new GZIPInputStream(new FileInputStream(inFileName));
            } catch (FileNotFoundException e) {
                System.err.println("File not found. " + inFileName);
                System.exit(1);
            }
            System.out.println("Open the output file.");
            String outFileName = getFileName(inFileName);
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(outFileName);
            } catch (FileNotFoundException e) {
                System.err.println("Could not write to file. " + outFileName);
                System.exit(1);
            }
            System.out.println("Transfering bytes from compressed file to the output file.");
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            System.out.println("Closing the file and stream");
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Used to extract and return the extension of a given file.
     *
     * @param f Incoming file to get the extension of
     * @return <code>String</code> representing the extension of the incoming
     * file.
     */
    public static String getExtension(String f) {
        String ext = "";
        int i = f.lastIndexOf('.');

        if (i > 0 && i < f.length() - 1) {
            ext = f.substring(i + 1);
        }
        return ext;
    }

    /**
     * Used to extract the filename without its extension.
     *
     * @param f Incoming file to get the filename
     * @return <code>String</code> representing the filename without its
     * extension.
     */
    public static String getFileName(String f) {
        String fname = "";
        int i = f.lastIndexOf('.');

        if (i > 0 && i < f.length() - 1) {
            fname = f.substring(0, i);
        }
        return fname;
    }

    public static void main(String[] args) throws Exception {
        String str = "E:\\AUTORUN.INF";
        doCompressFile(str);
//        doUncompressFile("E:\\response.gz");
//        doUncompressFile("E:\\temp.json.gz");
        FileInputStream fileInputStream = new FileInputStream(new File("E:\\temp.json.gz"));
//        doUncompressFile(fileInputStream, "E:\\temp.json");
        System.out.println(uncompressGetJson(fileInputStream));
    }
}
