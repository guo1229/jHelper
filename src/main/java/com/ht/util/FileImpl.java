package com.ht.util;



import org.mozilla.intl.chardet.nsDetector;
import org.mozilla.intl.chardet.nsICharsetDetectionObserver;

import java.io.*;

/**
 * �ļ���ص��㷨ʵ��
 */
public class FileImpl {


    /**
     * **************************************************
     * ���·�ʽ����mozilla��jchardet��Ϊ̽�⹤��
     */

    private static boolean found    = false;
    /**
     * �����ȫƥ��ĳ���ַ�������㷨, ������Ա�����ַ���������. ����(��������ļ�)��ֵ��ΪĬ��ֵ null, ��ʱӦ����ѯ����
     */
    private static String  encoding = null;

    /**
     * �����ļ�ͷ�����ж��ļ��ı��뷽ʽ
     *
     * @param fileName ��Ҫ������ļ�
     * @return �����ļ�����
     */
    public static String simpleEncoding(String fileName) {
        int p = 0;
        try (
                BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
        ) {
            p = (bin.read() << 8) + bin.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String code = null;
        switch (p) {
            case 0xefbb:
                code = "UTF-8";
                break;
            case 0xfffe:
                code = "Unicode";
                break;
            case 0xfeff:
                code = "UTF-16BE";
                break;
            default:
                code = "GBK";
        }
        return code;
    }





    /**
     * ����һ���ļ�(File)���󣬼���ļ�����
     *
     * @param file File����ʵ��
     * @return �ļ����룬���ޣ��򷵻�null
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String guestFileEncoding(File file) throws IOException {
        return geestFileEncoding(file, new nsDetector());
    }

    /**
     * ��ȡ�ļ��ı���
     *
     * @param file         File����ʵ��
     * @param languageHint ������ʾ������� eg��1 : Japanese; 2 : Chinese; 3 : Simplified Chinese;
     *                     4 : Traditional Chinese; 5 : Korean; 6 : Dont know (default)
     * @return �ļ����룬eg��UTF-8,GBK,GB2312��ʽ�����ޣ��򷵻�null
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String guestFileEncoding(File file, int languageHint) throws IOException {
        return geestFileEncoding(file, new nsDetector(languageHint));
    }

    /**
     * ��ȡ�ļ��ı���
     *
     * @param path �ļ�·��
     * @return �ļ����룬eg��UTF-8,GBK,GB2312��ʽ�����ޣ��򷵻�null
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String guestFileEncoding(String path) throws IOException {
        return guestFileEncoding(new File(path));
    }

    /**
     * ��ȡ�ļ��ı���
     *
     * @param path         �ļ�·��
     * @param languageHint ������ʾ������� eg��1 : Japanese; 2 : Chinese; 3 : Simplified Chinese;
     *                     4 : Traditional Chinese; 5 : Korean; 6 : Dont know (default)
     * @return �����ļ��ı���
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static String guestFileEncoding(String path, int languageHint) throws FileNotFoundException, IOException {
        return guestFileEncoding(new File(path), languageHint);
    }

    /**
     * ��ȡ�ļ��ı���
     *
     * @param file ��Ҫ�����ļ��ı���
     * @param det  nsDetector
     * @return �����ļ�����
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static String geestFileEncoding(File file, nsDetector det) {
        det.Init(new nsICharsetDetectionObserver() {
            public void Notify(String charset) {
                found = true;
                encoding = charset;
            }
        });
        byte[]  buf     = new byte[1024];
        int     len;
        boolean done    = false;
        boolean isAscii = true;
        try (
                BufferedInputStream imp = new BufferedInputStream(new FileInputStream(file));
        ) {
            while ((len = imp.read(buf, 0, buf.length)) != -1) {
                // Check if the stream is only ascii.
                if (isAscii) {
                    isAscii = det.isAscii(buf, len);
                }

                // DoIt if non-ascii and not done yet.
                if (!isAscii && !done) {
                    done = det.DoIt(buf, len, false);
                }
            }
            det.DataEnd();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (isAscii) {
            encoding = "ASCII";
            found = true;
        }

        if (!found) {
            String prob[] = det.getProbableCharsets();
            if (prob.length > 0) {
                // ��û�з�������£���ȡ��һ�����ܵı���
                encoding = prob[0];
            } else {
                return null;
            }
        }
        return encoding;
    }
}
