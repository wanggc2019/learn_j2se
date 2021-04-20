package com.sprigboot.test.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;

@Component
public class RunshService {
    private Boolean working;
    //    private static String templateFilePath = null;
    private static Logger log = LoggerFactory.getLogger(RunshService.class);

    public RunshService() {
        System.out.println("========RUNSHSERVICE========");
        this.working = Boolean.valueOf(false);
    }


    public String runShBySystem(String system) {
        log.info("begin");
        if (this.working.booleanValue()) {
            log.info("working on it, exit!");
            return null;
        }
        String result = null;
        try {
            this.working = Boolean.valueOf(true);
            String templateFilePath = String.format("%s.sh", new Object[] { system });
//            System.err.println("===="+templateFilePath+"=====");
//            templateFilePath===> syn_moni.sh
            String shellpath="/root/lff/clzx/"+templateFilePath;
            result = execCmd("sh " + shellpath,null);
//            String pythonpath = "E:\\PythonCoding\\HelloWorld.py";
//            result = execCmd("python " + pythonpath,null);
//            System.out.println(result);
        }
        catch (Exception e) {
            log.info("failed");
            log.error(e.getMessage());
        }
        finally {
            this.working = Boolean.valueOf(false);
        }
        return  result;
    }

    /**
     * 执行系统命令, 返回执行结果
     *
     * @param cmd 需要执行的命令
     * @param dir 执行命令的子进程的工作目录, null 表示和当前主进程工作目录相同
     */
    public static String execCmd(String cmd, File dir) throws Exception {
        StringBuilder result = new StringBuilder();

        Process process = null;
        BufferedReader bufrIn = null;
        BufferedReader bufrError = null;

        try {
            // 执行命令, 返回一个子进程对象（命令在子进程中执行）
            process = Runtime.getRuntime().exec(cmd, null, dir);

            // 方法阻塞, 等待命令执行完成（成功会返回0）
            process.waitFor();

            // 获取命令执行结果, 有两个结果: 正常的输出 和 错误的输出（PS: 子进程的输出就是主进程的输入）
            bufrIn = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
            bufrError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "UTF-8"));

            // 读取输出
            String line = null;
            while ((line = bufrIn.readLine()) != null) {
                result.append(line).append('\n');
            }
            while ((line = bufrError.readLine()) != null) {
                result.append(line).append('\n');
            }
        } finally {
            closeStream(bufrIn);
            closeStream(bufrError);

            // 销毁子进程
            if (process != null) {
                process.destroy();
            }
        }

        // 返回执行结果
        return result.toString();
    }

    private static void closeStream(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (Exception e) {
                // nothing
            }
        }
    }

}
