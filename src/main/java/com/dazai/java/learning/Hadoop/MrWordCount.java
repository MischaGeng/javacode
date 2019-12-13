package com.dazai.java.learning.Hadoop;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.util.GenericOptionsParser;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * @Description:
 *
 * @author MischaGeng
 * @Created Date: 2019/11/09
 * @Since JDK 1.8
 * @Title: MrWordCount
 * @ProjectName javacode
 *
 * @Modified by:
 * @Modified date:
 * @Problem no:
 */
public class MrWordCount {

    private final static String HDFS_SITE_XML = "";
    private final static String CORE_SITE_XML = "";

    private final static String JVM_KRB5_CONF_PARM = "java.security.krb5.conf";
    private final static String JVM_KRB5_CONF_PARM_VALUE = "/etc/krb5.conf";
    private final static String USER_PRINCIPAL = "xxx@XXX";
    private final static String USER_KEYTAB = "XXX";

    public MrWordCount() {
    }

    public static void main(String[] args) throws Exception {

        Configuration conf = new Configuration();

        /**
         * 如果开启Kerberos
         */
//        conf.addResource(new Path(HDFS_SITE_XML));
//        conf.addResource(new Path(CORE_SITE_XML));
//
//        System.setProperty(JVM_KRB5_CONF_PARM, JVM_KRB5_CONF_PARM_VALUE);
//        UserGroupInformation.setConfiguration(conf);
//        //login
//        UserGroupInformation.loginUserFromKeytab(USER_PRINCIPAL, USER_KEYTAB);
//        System.out.println("Kerberos auth OK!");

        //获取参数
        String[] otherArgs = (new GenericOptionsParser(conf, args)).getRemainingArgs();

        if (otherArgs.length < 2) {
            System.out.println();
            System.exit(2);
        }

        Job job = Job.getInstance(conf, "word-count");
        job.setJarByClass(MrWordCount.class);

        // 设置运行时执行map，reduce类
        job.setMapperClass(MrWordCount.TokenizerMapper.class);
        job.setReducerClass(MrWordCount.IntSumReducer.class);
        //设置combiner类，默认不使用，使用时通常和reduce一样
        job.setCombinerClass(MrWordCount.IntSumReducer.class);

        //设置作业的输出类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        FileInputFormat.addInputPath(job, new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job, new Path(otherArgs[1]));

        //提交任务到远程环境上执行
        System.exit(job.waitForCompletion(true) ? 0 : 1);

    }

    public static class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
        private static final IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public TokenizerMapper() {
        }

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException {

            StringTokenizer itr = new StringTokenizer(value.toString(), ",");
            while (itr.hasMoreTokens()) {
                word.set(itr.nextToken());
                //map输出key，value键值对
                context.write(word, one);
            }
        }
    }

    public static class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        private IntWritable result = new IntWritable();

        public IntSumReducer() {
        }

        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
            int sum = 0;
            for (IntWritable val : values) {
                sum += val.get();
            }
            result.set(sum);
            context.write(key, result);
        }
    }

}
