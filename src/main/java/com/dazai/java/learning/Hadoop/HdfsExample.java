package com.dazai.java.learning.Hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.security.UserGroupInformation;
import java.io.File;
import java.io.IOException;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/10/31
 * @Since JDK 1.8
 * @Title: HdfsExample
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class HdfsExample {

    private final static String HDFS_SITE_XML = "";
    private final static String CORE_SITE_XML = "";

    private final static String JVM_KRB5_CONF_PARM = "java.security.krb5.conf";
    private final static String JVM_KRB5_CONF_PARM_VALUE = "/etc/krb5.conf";
    private final static String USER_PRINCIPAL = "xxx@XXX";
    private final static String USER_KEYTAB = "XXX";

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        conf.addResource(new Path(HDFS_SITE_XML));
        conf.addResource(new Path(CORE_SITE_XML));

        //如果开启Kerberos，如果没有开启，可忽略
        //set and check krb5config
        System.setProperty(JVM_KRB5_CONF_PARM, JVM_KRB5_CONF_PARM_VALUE);
        UserGroupInformation.setConfiguration(conf);
        //login
        try {
            UserGroupInformation.loginUserFromKeytab(USER_PRINCIPAL, USER_KEYTAB);
            System.out.println("Kerberos auth OK!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        HdfsExample example = new HdfsExample();
        try {
            FileSystem fileSystem = FileSystem.get(conf);
            //创建目录
            example.createFile(fileSystem, "/tmp");
            //写入数据

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 创建目录
     *
     * @param fs
     * @param path
     */
    private synchronized void createFile(FileSystem fs, String path) {

        Path createPath = new Path(path);

        try {
            if (!fs.exists(createPath)) {
                fs.mkdirs(createPath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private synchronized void writeData(FileSystem fs, String fileName, String dirPath, String content) {

        Path path = new Path(dirPath + File.separator + fileName);

        FSDataOutputStream writeInfos = null;

        try {
            writeInfos = fs.create(path);
            writeInfos.write(content.getBytes());
            writeInfos.hsync();
            System.out.println("success to wriete");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeStream(writeInfos);
        }

    }

}
