package com.manage.Controller;

import com.manage.common.Result;
import com.manage.common.util.FileUtil;
import com.manage.enums.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/21 16:32
 */
@RestController
public class FileController {

    @Autowired
    private FileUtil fileUtil;
    @Autowired
    private Result result;

    @RequestMapping("/up")
    public String upload() {
        return "upload";
    }
    @RequestMapping(value = "/file",method = RequestMethod.POST)
    public Result uploadAndDel(MultipartFile[] file)throws Exception{
        System.out.println(file.length);
            if(file != null){
                for(int i=0;i<file.length;i++){
                String name = file[i].getName();
                //类型
                System.out.println("getname"+name);
                //方法是得到原来的文件名在客户机的文件系统名称
                String originalFilename = file[i].getOriginalFilename();
                System.out.println("originalFilename"+originalFilename);
                //得到后缀
                String suffixn = FileUtil.getSuffixn(originalFilename);
                //根据后缀到指定的文件夹
                String path  = FileUtil.GeneratePath(suffixn);
                //上传
                List<String> strings = fileUtil.addFiles(file[i], path);
                result.success(strings);
                }
                return result;
            }else {
                return this.result.error("文件上传失败");
            }

    }
}
