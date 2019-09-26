package com.manage.common.util;


import com.manage.common.config.Config;
import com.manage.common.config.ExcelConfig;
import com.manage.exception.OperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.ObjectInputFilter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/21 14:37
 */
@Component
public class FileUtil {

    @Autowired
    private Config config;
    @Autowired
    private ExcelConfig excelConfig;


    private static final SimpleDateFormat sDateFormat =
            new SimpleDateFormat("yyyyMMddHHmmss");
    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 返回文件(图片)的后缀
     * @param fileName
     * @return
     */
    public static String  getSuffixn(String  fileName){
      String  suffix =fileName.substring(fileName.lastIndexOf("."));
        return suffix;
    }
    /**
     * 生成随机文件名，当前年月日小时分钟秒钟+五位随机数
     * @return
     */
    public  static  String getRandomName(){
            //生成随机5位数
            int  ran = new Random().nextInt(89999)+10000;
            //获得当前日期
            String nowtime = sDateFormat.format(new Date());
            return  nowtime+ran;
    }

    /**
     * 根据后缀  判断路径
     * @param
     * @return
     */
    public  static   String   GeneratePath(String suffer){
            if (".jpg".equals(suffer) || suffer.equals(".png")){
                return PathUtil.getImage();
            }else {
              return  PathUtil.getWord();
            }

    }


    /**
     * 生成随机名称
     */
    public  static  String GenerateRandomName(String name){
        // 获取不重复的随机名
        String ranname = getRandomName();
        // 获取文件的扩展名如png,jpg等
        String suffix = getSuffixn(name);
        //新的名字
        String newname = ranname+suffix;
        return newname;
    }
    /**
     * 创建文件夹，如文件存在work/comm/hh.txt,那么创建work   comm两个文件夹
     * @param targetAddr
     */
    private static void makeDirPath(String targetAddr) {
        String realFileParentPath = PathUtil.getSystem() + targetAddr;
        File dirPath = new File(realFileParentPath);
        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }
    }

    /**
     * 返回带地址为文件随机名称
     * @param file  文件
     * @param path  路径
     * @return
     */
    public static String getPathRanName(MultipartFile file, String path){
        String name = file.getOriginalFilename();
        String s = GenerateRandomName(name);
        makeDirPath(path);
        String  savename=path+s;
        return savename;

    }



    /**
     * 删除文件或 目录下所有文件
     * 当FP是文件时，删除这个文件，当FP是目录是删除这个目录的所有文件
     * @param FP
     */
    public static  void deleteFileOrPath(String FP){
        File fileOrPath = new File(PathUtil.getSystem() + FP);
        //判断是否存在
        if(fileOrPath.exists()){
            //如果path表示的是一个目录则返回true
            if(fileOrPath.isDirectory()){
                //返回某个目录下所有文件和目录的绝对路径
                File files[] = fileOrPath.listFiles();
                for (int i = 0; i < files.length; i++) {
                    files[i].delete();
                }
            }
            fileOrPath.delete();
        }

    }

        public List<String> addFiles(MultipartFile file, String path){
            LinkedList<String> fileu=new LinkedList<String>();
          //  for(MultipartFile file :files){
                if(file .isEmpty()){
                    new OperationException("文件为空");
                }
                String relativeAddr = getPathRanName(file, path);
                // 获取文件要保存到的目标路径
                File dest = new File(PathUtil.getSystem()+relativeAddr);
                logger.debug("current relativeAddr is :" + relativeAddr);
                System.out.println("dest:"+dest);
                try {
                    file.transferTo(dest);

                } catch (IOException e) {
                    logger.error(e.toString());
                    throw  new RuntimeException("存储发生错误:"+e.toString());
                }
                    fileu.addLast(PathUtil.getSystem()+relativeAddr);
           // }
            System.out.println("fileu:"+fileu);
                    return  fileu;
        }


}
