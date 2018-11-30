package com.hlc.styd.smes.frame.sb.mail;

import lombok.Data;

/**
 * Created by Liang on 2018/11/30.
 */
@Data
public class EmailFileDto {
    private String filename;
    private String filepath;
    private FileType type;  //OOS云存储，fastdfs,本地地址
}


enum FileType {
    Local, FastDfs, Oos
}
